package nukesfromthefuture.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.potion.NftfPotion;

import java.util.Random;

public class Waste extends Block {
	public Waste(Material mat, boolean tick) {
		super(mat);
	    this.setTickRandomly(tick);
	    setHardness(0.5F);
	    setResistance(1.0F);
	}
	public void onEntityWalking(World p_149724_1_, int p_149724_2_, int p_149724_3_, int p_149724_4_, Entity entity)
    {
    	if (entity instanceof EntityLivingBase && this == Nukesfromthefuture.waste) {

    		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(NftfPotion.contamination.id, 30 * 20, 2));
    	}
    	
    	
    }
	@SideOnly(Side.CLIENT)
	IIcon top;
	IIcon bottom;
	IIcon sideo;
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	    if(this == Nukesfromthefuture.waste) {
            this.top = register.registerIcon("nff:grass_top");
            this.sideo = register.registerIcon("nff:grass_side");
            this.bottom = register.registerIcon("nff:dirt");
            this.blockIcon = register.registerIcon("nff:grass_side");
        }if(this == Nukesfromthefuture.waste_wood){
	        this.top = register.registerIcon("nff:waste_trunk_top");
	        this.bottom = register.registerIcon("nff:waste_trunk_top");
	        this.sideo = register.registerIcon("nff:waste_trunk");
	        this.blockIcon = register.registerIcon("nff:waste_trunk");
        }
	}
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		if(side == 0)
			return bottom;
		if(side == 1)
			return top;
		if(side == 2 || side == 3)
			return blockIcon;
		if(side == 4 || side == 5)
			return sideo;
		
		return null;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
	{
		super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);

		if (this == Nukesfromthefuture.waste)
		{
			p_149734_1_.spawnParticle("townaura", p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 1.1F, p_149734_4_ + p_149734_5_.nextFloat(), 0.0D, 0.0D, 0.0D);
		}

	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random p_149674_5_) {
		for(int i = 0; i < 10; i++) {
			if (world.getBlock(x, y + i, z) == Blocks.log || world.getBlock(x, y + i, z) == Blocks.log2){
				world.setBlock(x, y + i, z, Nukesfromthefuture.waste_wood);
			}

		}
		for(int i = 0; i < 14; i++) {
			if (world.getBlock(x, y + i, z) == Blocks.leaves2 || world.getBlock(x, y + i, z) == Blocks.leaves) {
				world.setBlockToAir(x, y + i, z);

			}
		}
	}

	@Override
	public boolean isWood(IBlockAccess world, int x, int y, int z) {
		if(this == Nukesfromthefuture.waste_wood)
			return true;
		return false;
	}
	//what the hell is this!?
	@Override
	public boolean isFertile(World world, int x, int y, int z) {
		return this == Nukesfromthefuture.waste ? true : false;
	}
}
