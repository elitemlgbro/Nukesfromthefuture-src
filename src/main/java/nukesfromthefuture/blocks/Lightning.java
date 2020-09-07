package nukesfromthefuture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class Lightning extends Block {
	public Lightning() {
		super(Material.tnt);
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
		return super.onBlockActivated(world, x, y, z, p_149727_5_, p_149727_6_, p_149727_7_,
				p_149727_8_, p_149727_9_);
	}
	
}
