package nukesfromthefuture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class VertiSlab extends Block {
    public VertiSlab(Material mat){
        super(mat);
        setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}
