package nukesfromthefuture.items;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LightningSummon extends Item {
	public LightningSummon() {
		this.setFull3D();
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playa, World world, int x,
			int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
		return super.onItemUse(stack, playa, world, x, y, z, p_77648_7_, p_77648_8_,
				p_77648_9_, p_77648_10_);
	}
	@Override
	public boolean hasEffect(ItemStack p_77636_1_) {
		// TODO Auto-generated method stub
		return true;
	}
}
