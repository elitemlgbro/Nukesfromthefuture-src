package nukesfromthefuture;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import nukesfromthefuture.blocks.Blockego_nuke;
import nukesfromthefuture.entity.EntityEgoBlast;
import nukesfromthefuture.tileentity.TileEntityEgo_nuke;

public class ModEventHandler {
	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
if(event.entity instanceof Entity && event.source == NffDamageSource.POTATOKill) {
			
			for(Object o : event.entity.worldObj.playerEntities) {
				EntityPlayer player = (EntityPlayer)o;
				
					player.triggerAchievement(Nukesfromthefuture.POTATOKill);
				
			}
		
		}
	}


	
}
