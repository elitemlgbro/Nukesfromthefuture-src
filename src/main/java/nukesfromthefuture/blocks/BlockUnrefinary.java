package nukesfromthefuture.blocks;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.tileentity.TileEntityUnrefinery;

public class BlockUnrefinary extends BlockContainer {
	public BlockUnrefinary() {
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntityUnrefinery();
	}
	@Override
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public int getRenderType(){
        return -1;
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int w, float px, float py, float pz) {
	    if(world.isRemote){
	        return true;
        }else if(!player.isSneaking()) {
    	FMLNetworkHandler.openGui(player, Nukesfromthefuture.instance, 3, world, x, y, z);
    	return true;
    	}else{
	        return false;
        }

    }
}
