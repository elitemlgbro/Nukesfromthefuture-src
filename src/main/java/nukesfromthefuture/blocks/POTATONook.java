package nukesfromthefuture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.EntityEgoBlast;
import nukesfromthefuture.entity.NukeMushroom;
import nukesfromthefuture.entity.POTATOBLAST;
import nukesfromthefuture.interfaces.IBomb;
import nukesfromthefuture.tileentity.TileEntityEgo_nuke;
import nukesfromthefuture.tileentity.TilePOTATO;
import nukesfromthefuture.tileentity.explosion.EgoNukeExplosion;
import nukesfromthefuture.tileentity.explosion.POTATOEXPLOSION;

public class POTATONook extends BlockContainer implements IBomb {
	public int aoc = 0;
	public POTATONook(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}
	public boolean renderAsNormalBlock() {
		return false;
	}
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TilePOTATO();
	}
	public int getRenderType() {
		return -1;
	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int w, float px, float py, float pz)
    {
		if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.manual_detonator) {
			TilePOTATO entity = (TilePOTATO) world.getTileEntity(x, y, z);
			if(entity.isReady())
			{
        		this.onBlockDestroyedByPlayer(world, x, y, z, 1); 
            	world.setBlockToAir(x, y, z);
            	igniteTestBomb(world, x, y, z, Nukesfromthefuture.POTATOSTRENGTH);
			}
    	}
		if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.componetTeleporter) {
			player.openGui(Nukesfromthefuture.instance, Nukesfromthefuture.UvU, world, x, y, z);
		}
    	return super.onBlockActivated(world, x, y, z, player, w, px, py, pz);
    }
	private boolean igniteTestBomb(World world, int x, int y, int z, int pOTATOSTRENGTH) {
		// TODO Auto-generated method stub
		if (!world.isRemote)
		{
    		POTATOEXPLOSION tsar = new POTATOEXPLOSION((int)x, (int)y, (int)z, world, (int) ((Nukesfromthefuture.POTATOSTRENGTH + (aoc * aoc)) * 0.8f));
			POTATOBLAST tsarblast = new POTATOBLAST(world, (int)x, (int)y, (int)z, tsar, Nukesfromthefuture.POTATOSTRENGTH + (aoc * aoc));
			world.spawnEntityInWorld(tsarblast);
			
			NukeMushroom cloud = new NukeMushroom(world, pOTATOSTRENGTH);
			cloud.posX = x;
			cloud.posY = y;
			cloud.posZ = z;
			world.spawnEntityInWorld(cloud);
		}
		return false;
	}
	@Override
	public void explode(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		TileEntityEgo_nuke entity = (TileEntityEgo_nuke) world.getTileEntity(x, y, z);
		if (world.isBlockIndirectlyGettingPowered(x, y, z))
        {
        	if(entity.isReady())
        	{
        		this.onBlockDestroyedByPlayer(world, x, y, z, 1);
            	entity.clearSlots();
            	world.setBlockToAir(x, y, z);
            	igniteTestBomb(world, x, y, z, Nukesfromthefuture.POTATOSTRENGTH);
        	}
        }
	}
}
