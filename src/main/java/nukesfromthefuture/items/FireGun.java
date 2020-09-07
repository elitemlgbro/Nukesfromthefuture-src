package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nukesfromthefuture.entity.FireUwU;

public class FireGun extends Item {
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer playa) {
	// TODO Auto-generated method stub
		if(!world.isRemote) {
		world.spawnEntityInWorld(new FireUwU(world, playa));
		}
		return stack;
	}
}
