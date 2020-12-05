package nukesfromthefuture.blocks;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.tileentity.TileCore;

public class NuclearReactCore extends BlockContainer {
    public NuclearReactCore(Material p_i45394_1_) {
        super(p_i45394_1_);
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
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        TileCore core = (TileCore) world.getTileEntity(x, y, z);
        if(!player.isSneaking()){
            if(core.isStructureCorrect()){
                FMLNetworkHandler.openGui(player, Nukesfromthefuture.instance, 15, world, x, y, z);
            }else if(!core.isStructureCorrect()){
                if(world.isRemote){
                    player.addChatComponentMessage(new ChatComponentText("Structure incorrect"));
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileCore();
    }

}
