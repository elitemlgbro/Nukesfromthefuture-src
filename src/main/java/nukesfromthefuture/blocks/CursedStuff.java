package nukesfromthefuture.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class CursedStuff extends Block {
    @SideOnly(Side.CLIENT)
    public IIcon side;
    public IIcon top;
    public IIcon bottom;
    public CursedStuff(Material mat){
        super(mat);
    }

    @Override
    public IIcon getIcon(int i, int j) {
        if(i == 1){
            return top;
        }
        if(i == 2 || i == 3 || i == 5 || i ==4){
            return side;
        }
        if(i == 0){
            return bottom;
        }
        return null;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        bottom = iconRegister.registerIcon("dirt");
        top = iconRegister.registerIcon("diamond_block");
        side = iconRegister.registerIcon("nff:diamond_grass_s");
    }
}
