package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.BombBalls;

public class ExplosionGun extends Item {
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!player.isSneaking()) {
			if(world.isRemote) {
		world.spawnEntityInWorld(new BombBalls(world, player));
			}
		}
		if(player.isSneaking()) {
		player.openGui(Nukesfromthefuture.instance,4, world, (int)player.posX,(int) player.posY,(int) player.posZ);
		}
		return stack;
	}
}
