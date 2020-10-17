package nukesfromthefuture.blocks;

import java.util.Random;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.Blast;
import nukesfromthefuture.entity.NukeMushroom;
import nukesfromthefuture.interfaces.IBomb;
import nukesfromthefuture.tileentity.TileEntitySingularityNuke;

public class BlockSingularityNuke extends BlockContainer implements IBomb {
	public int aoc = 0;
	private final Random field_149933_a = new Random();
	private static boolean keepInventory = false;
	
	public BlockSingularityNuke() {
		super(Material.iron);
	
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	public int getRenderType() {
		return -1;
	}
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntitySingularityNuke();
	}
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int w, float px, float py, float pz) {
		
			 if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.componetTeleporter) {
				 TileEntitySingularityNuke UmU = (TileEntitySingularityNuke) world.getTileEntity(x, y, z);
				 if(UmU != null) {
			 FMLNetworkHandler.openGui(player, Nukesfromthefuture.instance, Nukesfromthefuture.QwQ, world, x, y, z);
			 return true;
				 }
			 }
		  else if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.manual_detonator) {
				TileEntitySingularityNuke entity = (TileEntitySingularityNuke) world.getTileEntity(x, y, z);
				if(entity.dna())
				{
	        		this.onBlockDestroyedByPlayer(world, x, y, z, 1);
	            	entity.clearSlots();
	            	world.setBlockToAir(x, y, z);
	            	igniteBomb(world, x, y, z, Nukesfromthefuture.colliderStrength);
	            	
				}
		 
			
		 }
		return super.onBlockActivated(world, x, y, z, player, w, px, py, pz);
		 
	 }
	private boolean igniteBomb(World world, int x, int y, int z, int colliderStrength) {
		if(!world.isRemote) {
			/**REEEEEEEEEE*/
			world.spawnEntityInWorld(Blast.statFac(world, Nukesfromthefuture.Boystrength, x, y, z));
			NukeMushroom cloud = new NukeMushroom(world, colliderStrength);
			cloud.posX = x;
			cloud.posY = y;
			cloud.scale = 1000;
			cloud.posZ= z;
			cloud.maxAge = colliderStrength;
			world.spawnEntityInWorld(cloud);
		}
		return false;
		
	}
	@Override
	public void explode(World world, int x, int y, int z) {
		TileEntitySingularityNuke entity = (TileEntitySingularityNuke) world.getTileEntity(x, y, z);
            if (entity.dna()) {
                this.onBlockDestroyedByPlayer(world, x, y, z, 1);
                world.setBlockToAir(x, y, z);
                igniteBomb(world, x, y, z, Nukesfromthefuture.colliderStrength);


            }

	}
	@Override
	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
    {
        if (!keepInventory )
        {
        	TileEntitySingularityNuke tileentityfurnace = (TileEntitySingularityNuke)p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);

            if (tileentityfurnace != null)
            {
                for (int i1 = 0; i1 < tileentityfurnace.getSizeInventory(); ++i1)
                {
                    ItemStack itemstack = tileentityfurnace.getStackInSlot(i1);

                    if (itemstack != null)
                    {
                        float f = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int j1 = this.field_149933_a.nextInt(21) + 10;

                            if (j1 > itemstack.stackSize)
                            {
                                j1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(p_149749_1_, p_149749_2_ + f, p_149749_3_ + f1, p_149749_4_ + f2, new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (float)this.field_149933_a.nextGaussian() * f3;
                            entityitem.motionY = (float)this.field_149933_a.nextGaussian() * f3 + 0.2F;
                            entityitem.motionZ = (float)this.field_149933_a.nextGaussian() * f3;
                            p_149749_1_.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
            }
        }

        super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
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
