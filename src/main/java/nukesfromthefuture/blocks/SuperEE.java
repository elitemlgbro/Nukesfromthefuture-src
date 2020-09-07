package nukesfromthefuture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.Flood;
import nukesfromthefuture.entity.LavaBlast;
import nukesfromthefuture.entity.NukeMushroom;
import nukesfromthefuture.tileentity.TileEntitySingularityNuke;
import nukesfromthefuture.tileentity.TileVolcano;
import nukesfromthefuture.tileentity.explosion.FloodExplosion;
import nukesfromthefuture.tileentity.explosion.Supervolcano;

public class SuperEE extends BlockContainer {
	public SuperEE(Material UwU) {
		super(UwU);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileVolcano();
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
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer playa, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		// TODO Auto-generated method stub
		TileVolcano entity =(TileVolcano)world.getTileEntity(x, y, z) ;
		if(!playa.isSneaking() && playa.getCurrentEquippedItem() != null && playa.getCurrentEquippedItem().getItem() == Nukesfromthefuture.manual_detonator) {
			if(entity.isReady()) {
		world.setBlockToAir(x, y, z);
		this.onBlockDestroyedByPlayer(world, x, y, z, 0);
		ignite_boob(world, x, y, z, Nukesfromthefuture.Volcano_strength);
			}
		}else if(!playa.isSneaking() && playa.getCurrentEquippedItem() != null && playa.getCurrentEquippedItem().getItem() == Nukesfromthefuture.componetTeleporter) {
			 TileVolcano UmU = (TileVolcano) world.getTileEntity(x, y, z);
			 if(UmU != null) {
				 playa.openGui(Nukesfromthefuture.instance, 7, world, x, y, z);
				 return true;
			 }
		}
		return super.onBlockActivated(world, x, y, z, playa, p_149727_6_, p_149727_7_,
				p_149727_8_, p_149727_9_);
	}
	private boolean ignite_boob(World world, int x, int y, int z, int flood_strength) {
		if (!world.isRemote)
		{
			
			int aoc = 0;
    		Supervolcano tsar = new Supervolcano((int)x, (int)y, (int)z, world, (int) ((Nukesfromthefuture.Volcano_strength + (aoc * aoc)) * 0.8f));
			LavaBlast tsarblast = new LavaBlast(world, (int)x, (int)y, (int)z, tsar, Nukesfromthefuture.Volcano_strength + (aoc * aoc));
			world.spawnEntityInWorld(tsarblast);
			
			NukeMushroom cloud = new NukeMushroom(world, flood_strength);
			cloud.posX = x;
			cloud.posY = y;
			cloud.posZ = z;
			world.spawnEntityInWorld(cloud);
		}
		return false;
	}
}
