package nukesfromthefuture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.tileentity.TileUnnamed;

public class UnnamedReactor extends BlockContainer{
    public UnnamedReactor(Material mat){
        super(mat);
    }
    public boolean isOpaqueCube(){
        return false;
    }
    public int getRenderType(){
        return -1;
    }
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileUnnamed();
    }
}
