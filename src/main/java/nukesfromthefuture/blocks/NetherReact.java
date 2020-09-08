package nukesfromthefuture.blocks;


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
        if(!entity.isValid()){
            player.addChatComponentMessage(new ChatComponentText("structure not correctly set up"));
        }else if (entity.isValid()){
            player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Activated successfully"));
        }
        return super.onBlockActivated(world, x, y, z, player, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileNReactor();
    }
}
