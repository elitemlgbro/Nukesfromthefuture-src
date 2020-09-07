package nukesfromthefuture.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.NukeMushroom;
import nukesfromthefuture.interfaces.IBomb;
import nukesfromthefuture.tileentity.TileEntityCraterCoverer;
import nukesfromthefuture.tileentity.TileEntityEgo_nuke;
import nukesfromthefuture.tileentity.explosion.CoverBlast;

public class CraterCoverer extends BlockContainer implements IBomb{

	private boolean keepInventory = false;
	private final Random field_149933_a = new Random();

	public CraterCoverer() {
		super(Material.iron);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntityCraterCoverer();
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override 
	public boolean renderAsNormalBlock() {
		return false;
	}
	@Override
	public int getRenderType() {
		return -1;
	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int w, float px, float py, float pz) {
		if(world.isRemote) {
			player.openGui(Nukesfromthefuture.instance, 2, world, x, y, z);
		}else if(!player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.manual_detonator) {
			TileEntityCraterCoverer entity = (TileEntityCraterCoverer)world.getTileEntity(x, y, z);
			if(entity.isReady()) {
				this.onBlockDestroyedByPlayer(world, x, y, z, w);
				this.igniteBomb(world, x, y, z, Nukesfromthefuture.coverStrength);
				world.setBlockToAir(x, y, z);
			}
		}
		return super.onBlockActivated(world, x, y, z, player, w, px, py, pz);
		
	}
	public boolean igniteBomb(World world, int x, int y, int z, int rad) {
		if(!world.isRemote) {
			CoverBlast entity = new CoverBlast(world);
			entity.posX = x;
			entity.posY = y;
			entity.posZ = z;
			entity.destructionRange = Nukesfromthefuture.coverStrength;
			entity.speed = Nukesfromthefuture.coverSpeed;
			world.spawnEntityInWorld(entity);
			
			NukeMushroom cloud = new NukeMushroom(world, rad);
			cloud.posX = x;
			cloud.posY = y;
			cloud.posZ = z;
			world.spawnEntityInWorld(cloud);
		}
		return false;
		
	}
	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
    {
        if (!keepInventory )
        {
        	TileEntityCraterCoverer tileentityfurnace = (TileEntityCraterCoverer)p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);

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

	@Override
	public void explode(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		TileEntityCraterCoverer owo = (TileEntityCraterCoverer) world.getTileEntity(x, y, z);
		if(owo.isReady()) {
			this.onBlockDestroyedByPlayer(world, x, y, z, 1);
		owo.clearSlots();
		world.setBlockToAir(x, y, z);
		this.igniteBomb(world, x, y, z, Nukesfromthefuture.coverStrength);
		}
	}
	
}
