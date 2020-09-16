package nukesfromthefuture.blocks;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.tileentity.TileTransMutate;

public class Transmutator extends BlockContainer {
	public Transmutator(Material uhhh) {
		super(uhhh);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileTransMutate();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if(world.isRemote){
			return true;
		}else if(!player.isSneaking()){
			TileTransMutate tileentityfurnace = (TileTransMutate) world.getTileEntity(x, y, z);

			if (tileentityfurnace != null)
			{
 				FMLNetworkHandler.openGui(player, Nukesfromthefuture.instance, 11, world, x, y, z);
 			}
 			return true;
		}else{
			return false;
		}
	}
}
