package nukesfromthefuture;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import nukesfromthefuture.blocks.Blockego_nuke;
import nukesfromthefuture.entity.AuxSavedData;
import nukesfromthefuture.entity.EntityEgoBlast;
import nukesfromthefuture.entity.EntityPizzaCreeper;
import nukesfromthefuture.packet.PacketDispatcher;
import nukesfromthefuture.packet.RadSurveyPacket;
import nukesfromthefuture.tileentity.TileEntityEgo_nuke;
import nukesfromthefuture.util.RadUtil;

import java.util.ArrayList;
import java.util.List;

public class ModEventHandler {
	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		event.entityLiving.getEntityData().setFloat("hfr_radiation", 0);

		if(event.entity instanceof Entity && event.source == NffDamageSource.POTATOKill) {
			
			for(Object o : event.entity.worldObj.playerEntities) {
				EntityPlayer player = (EntityPlayer)o;
				
					player.triggerAchievement(Nukesfromthefuture.POTATOKill);
				
			}
		
		}
	}

	@SubscribeEvent
	public void worldTick(WorldTickEvent event){
		if(event.world != null && !event.world.isRemote && Nukesfromthefuture.enableRad) {

			int thunder = AuxSavedData.getThunder(event.world);

			if(thunder > 0)
				AuxSavedData.setThunder(event.world, thunder - 1);

			if(!event.world.loadedEntityList.isEmpty()) {

				RadiationSavedData data = RadiationSavedData.getData(event.world);

				if(data.worldObj == null) {
					data.worldObj = event.world;
				}

				for(Object o : event.world.playerEntities) {

					if(o instanceof EntityPlayerMP) {
						EntityPlayerMP player = (EntityPlayerMP)o;
						PacketDispatcher.wrapper.sendTo(new RadSurveyPacket(player.getEntityData().getFloat("hfr_radiation")), player);
					}
				}

				if(event.world.getTotalWorldTime() % 20 == 0 && event.phase == TickEvent.Phase.START) {
					data.updateSystem();
				}

				List<Object> oList = new ArrayList<Object>();
				oList.addAll(event.world.loadedEntityList);

				for(Object e : oList) {
					if(e instanceof EntityLivingBase) {

						//effect for radiation
						EntityLivingBase entity = (EntityLivingBase) e;

						if(event.world.getTotalWorldTime() % 20 == 0) {

							Chunk chunk = entity.worldObj.getChunkFromBlockCoords((int)entity.posX, (int)entity.posZ);
							float rad = data.getRadNumFromCoord(chunk.xPosition, chunk.zPosition);

							if(event.world.provider.isHellWorld && Nukesfromthefuture.hellrad > 0 && rad < Nukesfromthefuture.hellrad)
								rad = Nukesfromthefuture.hellrad;

							if(rad > 0) {
								RadUtil.applyRadData(entity, rad / 2);
							}

							if(entity.worldObj.isRaining() && Nukesfromthefuture.cont > 0 && AuxSavedData.getThunder(entity.worldObj) > 0 &&
									entity.worldObj.canBlockSeeTheSky(MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY), MathHelper.floor_double(entity.posZ))) {

								RadUtil.applyRadData(entity, Nukesfromthefuture.cont * 0.005F);
							}
						}

						float eRad = entity.getEntityData().getFloat("hfr_radiation");

						if(entity instanceof EntityPizzaCreeper && eRad >= 200 && entity.getHealth() > 0) {

							if(event.world.rand.nextInt(3) == 0 ) {
								EntityPizzaCreeper creep = new EntityPizzaCreeper(event.world);
								creep.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);

								if(!entity.isDead)
									if(!event.world.isRemote)
										event.world.spawnEntityInWorld(creep);
								entity.setDead();
							} else {
								entity.attackEntityFrom(NffDamageSource.radiation_sickness, 100F);
							}
							continue;

						} else if(entity instanceof EntityCow && !(entity instanceof EntityMooshroom) && eRad >= 50) {
							EntityMooshroom creep = new EntityMooshroom(event.world);
							creep.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);

							if(!entity.isDead)
								if(!event.world.isRemote)
									event.world.spawnEntityInWorld(creep);
							entity.setDead();
							continue;

						} else if(entity instanceof EntityVillager && eRad >= 500) {
							EntityZombie creep = new EntityZombie(event.world);
							creep.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);

							if(!entity.isDead)
								if(!event.world.isRemote)
									event.world.spawnEntityInWorld(creep);
							entity.setDead();
							continue;
						}

						if(eRad < 200 || entity instanceof EntityMooshroom || entity instanceof EntityZombie || entity instanceof EntitySkeleton)
							continue;

						if(eRad > 2500)
							entity.getEntityData().setFloat("hfr_radiation", 2500);

						if(entity instanceof EntityPlayer && ((EntityPlayer)entity).capabilities.isCreativeMode)
							continue;

						if(eRad >= 1000) {
							if(entity.attackEntityFrom(NffDamageSource.radiation_sickness, entity.getMaxHealth() * 100)) {
								entity.getEntityData().setFloat("hfr_radiation", 0);


							}

							//.attackEntityFrom ensures the recentlyHit var is set to enable drops.
							//if the attack is canceled, then nothing will drop.
							//that's what you get for trying to cheat death
							entity.setHealth(0);

						} else if(eRad >= 800) {
							if(event.world.rand.nextInt(300) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 5 * 30, 0));
							if(event.world.rand.nextInt(300) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10 * 20, 2));
							if(event.world.rand.nextInt(300) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 10 * 20, 2));
							if(event.world.rand.nextInt(500) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.poison.id, 3 * 20, 2));
							if(event.world.rand.nextInt(700) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.wither.id, 3 * 20, 1));
							if(event.world.rand.nextInt(300) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.hunger.id, 5 * 20, 3));

						} else if(eRad >= 600) {
							if(event.world.rand.nextInt(300) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 5 * 30, 0));
							if(event.world.rand.nextInt(300) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10 * 20, 2));
							if(event.world.rand.nextInt(300) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 10 * 20, 2));
							if(event.world.rand.nextInt(500) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.poison.id, 3 * 20, 1));
							if(event.world.rand.nextInt(300) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.hunger.id, 3 * 20, 3));

						} else if(eRad >= 400) {
							if(event.world.rand.nextInt(300) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 5 * 30, 0));
							if(event.world.rand.nextInt(500) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 5 * 20, 0));
							if(event.world.rand.nextInt(300) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 5 * 20, 1));
							if(event.world.rand.nextInt(500) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.hunger.id, 3 * 20, 2));

						} else if(eRad >= 200) {
							if(event.world.rand.nextInt(300) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 5 * 20, 0));
							if(event.world.rand.nextInt(500) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 5 * 20, 0));
							if(event.world.rand.nextInt(700) == 0)
								entity.addPotionEffect(new PotionEffect(Potion.hunger.id, 3 * 20, 2));

							if(entity instanceof EntityPlayer)
								((EntityPlayer)entity).triggerAchievement(Nukesfromthefuture.yay_rad);
						}
					}
				}
			}
		}
		if(event.phase == TickEvent.Phase.START) {
			RadiationWorldHandler.handleWorldDestruction(event.world);
		}
	}


	
}
