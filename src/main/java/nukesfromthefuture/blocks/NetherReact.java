package nukesfromthefuture.blocks;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import nukesfromthefuture.tileentity.TileNReactor;

public class NetherReact extends BlockContainer {
    public NetherReact(Material UmU){
        super(UmU);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        TileNReactor entity = (TileNReactor) world.getTileEntity(x, y, z);
        if(world.isRemote) {
            if (!player.isSneaking()) {
                if (!entity.isValid()) {
                    player.addChatComponentMessage(new ChatComponentText("structure not correctly set up"));
                } else if (entity.isValid()) {
                    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.YELLOW + "Activated successfully"));
                    entity.buildSpire(world, x, y, z);
                    entity.spawnEntites(world);
                    entity.replaceBlocks(world, x, y, z);
                }
            }
        }
        return super.onBlockActivated(world, x, y, z, player, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileNReactor();
    }
}
