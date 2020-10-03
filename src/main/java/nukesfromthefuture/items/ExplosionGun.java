package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.BombBalls;

import java.util.List;

public class ExplosionGun extends Item {
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!player.isSneaking()) {
			if(!world.isRemote) {
		world.spawnEntityInWorld(new BombBalls(world, player));
			}
		}
		if(player.isSneaking() && world.isRemote) {
		player.openGui(Nukesfromthefuture.instance,4, world, 0, 0, 0);
		}
		return stack;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean useless) {
		list.add("HI!! I'm Derrick Bum!");
		list.add("You can say goodbye to your friend's terrible builds");
		list.add("with all-new EXPLOSION GUN!!!");
		list.add("Just look at how it makes this structure look better.");
		list.add("                                   ");
		list.add("BANG(*followed by a BOOM*) BANG(*followed by a BOOM*) BANG(*followed by a BOOM*)");
	}
}
