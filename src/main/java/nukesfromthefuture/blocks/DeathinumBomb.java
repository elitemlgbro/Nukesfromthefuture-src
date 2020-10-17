package nukesfromthefuture.blocks;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.Blast;
import nukesfromthefuture.interfaces.IBomb;
import nukesfromthefuture.tileentity.TileDeathBomb;

public class DeathinumBomb extends BlockContainer implements IBomb {
    public DeathinumBomb(Material mat){
        super(mat);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileDeathBomb();
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
        if(world.isRemote){
            return true;
        }
        if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.manual_detonator){
            TileDeathBomb entity = (TileDeathBomb) world.getTileEntity(x, y, z);
            if(entity.isReady()){
                world.setBlockToAir(x, y, z);
                igniteBomb(world, x, y, z);
            }
        }
        if(!player.isSneaking()){
            FMLNetworkHandler.openGui(player, Nukesfromthefuture.instance, 14, world, x, y, z);
            return true;
        }
        return false;
    }
    public boolean igniteBomb(World world, int x, int y, int z){
        if(!world.isRemote){
            world.spawnEntityInWorld(Blast.statFac(world,Nukesfromthefuture.deathinum_strength, x, y, z));
        }
        return false;
    }
    @Override
    public void explode(World world, int x, int y, int z) {
        TileDeathBomb entity = (TileDeathBomb) world.getTileEntity(x, y, z);
        if(entity.isReady()){
            world.setBlockToAir(x, y, z);
            world.spawnEntityInWorld(Blast.statFac(world, Nukesfromthefuture.deathinum_strength, x, y, z));
        }
    }
}
