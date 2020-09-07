package nukesfromthefuture.blocks;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.EntityEgoBlast;
import nukesfromthefuture.entity.NukeMushroom;
import nukesfromthefuture.entity.TrolBlast;
import nukesfromthefuture.interfaces.IBomb;
import nukesfromthefuture.tileentity.TileEntityEgo_nuke;
import nukesfromthefuture.tileentity.TileTrol;
import nukesfromthefuture.tileentity.explosion.EgoNukeExplosion;
import nukesfromthefuture.tileentity.explosion.TrololoExplosion;

public class Trol extends BlockContainer implements IBomb{
	public static int aoc = 0;
	public Trol(Material uwu) {
		super(uwu);
	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int w, float px, float py, float pz)
    {
    	if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.manual_detonator) {
			TileTrol entity = (TileTrol) world.getTileEntity(x, y, z);
			if(entity.isReady())
			{
        		this.onBlockDestroyedByPlayer(world, x, y, z, 1);
            	world.setBlockToAir(x, y, z);
            	igniteTestBomb(world, x, y, z, Nukesfromthefuture.egoNukeStrength);
			}
    	}else if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.componetTeleporter) {
    		player.openGui(Nukesfromthefuture.instance, 9, world, x, y, z);
    	}
    	return super.onBlockActivated(world, x, y, z, player, w, px, py, pz);
    }
    
    private boolean igniteTestBomb(World world, int x, int y, int z, int rad) {
		// TODO Auto-generated method stub
    	if (!world.isRemote)
		{
    		TrololoExplosion tsar = new TrololoExplosion((int)x, (int)y, (int)z, world, (int) ((Nukesfromthefuture.trol_strength + (aoc * aoc)) * 0.8f));
			TrolBlast tsarblast = new TrolBlast(world, (int)x, (int)y, (int)z, tsar, Nukesfromthefuture.trol_strength + (aoc * aoc));
			world.spawnEntityInWorld(tsarblast);
			
			NukeMushroom cloud = new NukeMushroom(world, rad);
			cloud.posX = x;
			cloud.posY = y;
			cloud.posZ = z;
			world.spawnEntityInWorld(cloud);
    		
    	}
    	
		return false;
	}
    public boolean isOpaqueCube() {
    	return false;
    }
    public int getRenderType() {
    	return -1;
    }
    public boolean renderAsNormalBlock() {
    	return false;
    }
	@Override
	public void explode(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		TileTrol entity = (TileTrol) world.getTileEntity(x, y, z);
		//if (world.isBlockIndirectlyGettingPowered(x, y, z))
        {
        	if(entity.isReady())
        	{
        		this.onBlockDestroyedByPlayer(world, x, y, z, 1);
            	world.setBlockToAir(x, y, z);
            	igniteTestBomb(world, x, y, z, Nukesfromthefuture.trol_strength);
        	}
        }
	}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileTrol();
	}
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
		int i = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		
		if(i == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if(i == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(i == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		if(i == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
	}
}
