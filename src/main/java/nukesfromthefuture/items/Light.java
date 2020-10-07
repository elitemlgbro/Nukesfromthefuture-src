package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nukesfromthefuture.entity.EntityLight;
import nukesfromthefuture.entity.EntityPOTATO;

public class Light extends Item {
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if(!player.isSneaking()) {
			if (!world.isRemote) {
				world.spawnEntityInWorld(new EntityLight(world, player));
			}
		}
		return stack;
    
	
	}
}
