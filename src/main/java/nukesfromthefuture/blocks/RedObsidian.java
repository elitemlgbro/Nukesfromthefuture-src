package nukesfromthefuture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class RedObsidian extends Block{
    public RedObsidian(Material iron) {
        super(iron);
    }

    @Override
    public MapColor getMapColor(int p_149728_1_) {
        return MapColor.redColor;
    }
}
