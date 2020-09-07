package nukesfromthefuture.blocks;

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
import nukesfromthefuture.entity.BoyBlast;
import nukesfromthefuture.entity.ManBlast;
import nukesfromthefuture.entity.NukeMushroom;
import nukesfromthefuture.interfaces.IBomb;
import nukesfromthefuture.tileentity.TileBigBoy;
import nukesfromthefuture.tileentity.TileEntitySkinnyMan;
import nukesfromthefuture.tileentity.explosion.ExplosionMan;
import nukesfromthefuture.tileentity.explosion.ManExplosion;

public class SkinnyMan extends BlockContainer implements IBomb{
	public int aoc = 0;
	public SkinnyMan() {
		super(Material.circuits);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntitySkinnyMan();
	}
	public boolean renderAsNormalBlock() {
		return false;
	}
	public int getRenderType() {
		return -1;
	}
	public boolean isOpaqueCube() {
		return false;
	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.manual_detonator) {
			TileEntitySkinnyMan entity = (TileEntitySkinnyMan) world.getTileEntity(x, y, z);
			if(entity.isReady()) {
				this.onBlockDestroyedByPlayer(world, x, y, z, 1);
				world.setBlockToAir(x, y, z);
				igniteBomb(world, x, y, z, Nukesfromthefuture.Manbuff);
			}
		}
		return false;
	}

	private boolean igniteBomb(World world, int x, int y, int z, int manbuff) {
		// TODO Auto-generated method stub
		if (!world.isRemote){
			ManExplosion tsar = new ManExplosion((int)x, (int)y, (int)z, world, (int) ((Nukesfromthefuture.Boystrength + (aoc * aoc)) * 0.8f));
			ManBlast tsarblast = new ManBlast(world, (int)x, (int)y, (int)z, tsar, Nukesfromthefuture.Boystrength + (aoc * aoc));
			world.spawnEntityInWorld(tsarblast);
			
			NukeMushroom cloud = new NukeMushroom(world, manbuff);
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
		TileEntitySkinnyMan entity = (TileEntitySkinnyMan) world.getTileEntity(x, y, z);
		//if (world.isBlockIndirectlyGettingPowered(x, y, z))
        {
        	if(entity.isReady())
        	{
        		this.onBlockDestroyedByPlayer(world, x, y, z, 1);
            	world.setBlockToAir(x, y, z);
            	igniteBomb(world, x, y, z, Nukesfromthefuture.Manbuff);
        	}
        }
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
