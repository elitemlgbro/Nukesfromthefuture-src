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
import nukesfromthefuture.entity.EntityEgoBlast;
import nukesfromthefuture.entity.NukeMushroom;
import nukesfromthefuture.entity.TimeBlast;
import nukesfromthefuture.interfaces.IBomb;
import nukesfromthefuture.tileentity.TileEntityEgo_nuke;
import nukesfromthefuture.tileentity.explosion.AntiExplosion;
import nukesfromthefuture.tileentity.explosion.EgoNukeExplosion;
import nukesfromthefuture.tileentity.explosion.TileAntitime;

public class Antitime extends BlockContainer implements IBomb {
	public int aoc = 0;
	public Antitime() {
		super(Material.anvil);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileAntitime();
	}
	public boolean isOpaqueCube() {
		return false;
	}
	public boolean renderAsNormalBlock() {
		return false;
	}
	public int getRenderType() {
		return -1;
	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int w, float px, float py, float pz) {
		if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.manual_detonator) {
			TileAntitime entity = (TileAntitime) world.getTileEntity(x, y, z);
			if(entity.isReady()) {
				this.onBlockDestroyedByPlayer(world, x, y, z, 1);
				this.igniteBomb(world, x, y, z, Nukesfromthefuture.antitimebuff);
				world.setBlockToAir(x, y, z);
				
			}
		}
		if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.componetTeleporter) {
			player.openGui(Nukesfromthefuture.instance, 6, world, x, y, z);
		}
		return super.onBlockActivated(world, x, y, z, player, w, px, py, pz);
	}
	public boolean igniteBomb(World world, int x, int y, int z, int rad) {
		if (!world.isRemote)
		{
    		AntiExplosion tsar = new AntiExplosion((int)x, (int)y, (int)z, world, (int) ((Nukesfromthefuture.antitimebuff + (aoc * aoc)) * 0.8f));
			TimeBlast tsarblast = new TimeBlast(world, (int)x, (int)y, (int)z, tsar, Nukesfromthefuture.antitimebuff + (aoc * aoc));
			world.spawnEntityInWorld(tsarblast);
			
			NukeMushroom cloud = new NukeMushroom(world, rad);
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
		TileAntitime entity = (TileAntitime) world.getTileEntity(x, y, z);
		//if (world.isBlockIndirectlyGettingPowered(x, y, z))
        {
        	if(entity.isReady())
        	{
        		this.onBlockDestroyedByPlayer(world, x, y, z, 1);
    
            	world.setBlockToAir(x, y, z);
            	igniteBomb(world, x, y, z, Nukesfromthefuture.antitimebuff);
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
