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
import nukesfromthefuture.entity.Blast;
import nukesfromthefuture.entity.NukeMushroom;
import nukesfromthefuture.entity.TrolBlast;
import nukesfromthefuture.interfaces.IBomb;
import nukesfromthefuture.tileentity.TileBeta;
import nukesfromthefuture.tileentity.explosion.Advanced;
import nukesfromthefuture.tileentity.explosion.TrololoExplosion;

public class TheBeta extends BlockContainer implements IBomb {
	public TheBeta(Material uwu) {
		super(uwu);
	}
	@Override
	public boolean isOpaqueCube() {
		// TODO Auto-generated method stub
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
			EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		TileBeta entity = (TileBeta) world.getTileEntity(x, y, z);
		if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.manual_detonator) {
			if(entity.isReady()) {
		world.setBlockToAir(x, y, z);
		this.IgniteBoob(x, y, z, world, Nukesfromthefuture.beta_strength);
		this.onBlockDestroyedByPlayer(world, x, y, z, 1);
			}
		}else if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.componetTeleporter) {
			player.openGui(Nukesfromthefuture.instance, 8, world, x, y, z);
		}
		
		return false;	
	}
	public boolean IgniteBoob(int posX, int posY, int posZ, World world, int re) {
		if (!world.isRemote)
		{
		 Blast entity = new Blast(world);
			entity.posX = posX;
			entity.posY = posY;
			entity.posZ = posZ;
			entity.destructionRange = re;
			entity.speed = Nukesfromthefuture.Boyspeed;
			entity.coefficient = 1.0F;
    		world.spawnEntityInWorld(entity);
    	}
		return false;	
	}
	@Override
	public void explode(World world, int x, int y, int z) {
		//TODO Auto-generated method stub
		TileBeta entity = (TileBeta) world.getTileEntity(x, y, z);
		if(entity.isReady()) {
			this.IgniteBoob(x, y, z, world, Nukesfromthefuture.beta_strength);
			world.setBlockToAir(x, y, z);
		}
	}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileBeta();
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
