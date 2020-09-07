package nukesfromthefuture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.tileentity.TileSolidifier;

public class Solidifier extends BlockContainer {
	public Solidifier(Material uwu) {
		super(uwu);
		this.isBlockContainer = true;
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	public int getRenderType() {
		return -1;
	}
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileSolidifier();
	}
}
