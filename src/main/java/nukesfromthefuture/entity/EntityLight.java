package nukesfromthefuture.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;

public class EntityLight extends EntityThrowable{
	public double x = posX;
	public double y = posY;
	public double z = posZ;
	public EntityLight(World p_i1582_1_) {
		super(p_i1582_1_);
	}

	public EntityLight(World p_77660_1_, EntityLivingBase p_77660_2_) {
		super(p_77660_1_, p_77660_2_); 
	}

	public EntityLight(World p_i1781_1_, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_) {
		super(p_i1781_1_, p_i1781_2_, p_i1781_4_, p_i1781_6_);
	}

	@Override
	public void onImpact(MovingObjectPosition p_70184_1_) {
		// TODO Auto-generated method stub
		World world = worldObj;
		if (p_70184_1_.entityHit != null) {
			p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 10.0F);



		}
		worldObj.spawnEntityInWorld(new EntityLightningBolt(worldObj, posX, posY, posZ));
		if(!worldObj.isRemote) {
			this.setDead();

		}
	}
	public static void RegisterEntity(boolean uhh) {
		EntityRegistry.registerModEntity(EntityPOTATO.class, "POTATO", 0, new Nukesfromthefuture(), 2, 35, uhh = true);
	}
}
