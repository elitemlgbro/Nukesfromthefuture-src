package nukesfromthefuture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.tileentity.TileReactor;

public class Reactor extends BlockContainer {

	public Reactor(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileReactor();
	}
	public boolean isOpaqueCube() {
		return false;
	}
	public int getRenderType() {
		return -1;
	}
	public boolean renderAsNormalBlock() {
		return false;
	}
}
