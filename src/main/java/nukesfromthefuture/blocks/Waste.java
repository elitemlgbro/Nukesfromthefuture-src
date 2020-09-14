package nukesfromthefuture.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.potion.NftfPotion;

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

    		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(NftfPotion.contamination.id, 15 * 20, 5));
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
}
