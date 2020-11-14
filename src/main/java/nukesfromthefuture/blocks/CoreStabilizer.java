package nukesfromthefuture.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CoreStabilizer extends Block {
    public CoreStabilizer(Material mat){
        super(mat);
    }
    @SideOnly(Side.CLIENT)
    IIcon top;
    @SideOnly(Side.CLIENT)
    IIcon sides;

    @Override
    public IIcon getIcon(int side, int meta) {
        return side == 1 && meta == 0 ? top : (side == meta ? top : sides);
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        top = register.registerIcon("nff:stablizer_barrel");
        sides = register.registerIcon("nff:stabilizer_side");
     }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
        int i = BlockPistonBase.determineOrientation(world, x, y, z, player);

        world.setBlockMetadataWithNotify(x, y, z, i, 2);
    }
}
