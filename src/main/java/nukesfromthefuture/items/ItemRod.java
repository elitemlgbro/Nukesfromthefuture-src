package nukesfromthefuture.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.handler.FluidTypeHandler.FluidType;
import nukesfromthefuture.items.RodTypeHandler.RodType;

public class ItemRod extends Item{
	IIcon overlay;
	public ItemRod() {
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tabs, List list) {
		// TODO Auto-generated method stub
		for(int i = 1; i < RodType.values().length; i++)
		list.add(new ItemStack(item, 1, i));
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		// TODO Auto-generated method stub
		String s = ("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
        String s1 = ("" + StatCollector.translateToLocal(RodType.getEnum(stack.getItemDamage()).getUnlocalizedName())).trim();

        if (s1 != null)
        {
            s = s + " " + s1;
        }

        return s;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_) {
		// TODO Auto-generated method stub
		return p_77618_2_ == 1 ? this.overlay : super.getIconFromDamageForRenderPass(p_77618_1_, p_77618_2_);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		// TODO Auto-generated method stub
		super.registerIcons(register);
		if(this == Nukesfromthefuture.rod)
	overlay = register.registerIcon("nff:rod_overlay");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int p_82790_2_) {
		// TODO Auto-generated method stub
		
		if (p_82790_2_ == 0)
        {
            return 16777215;
        }
        else
        {
            int j = RodType.getEnum(stack.getItemDamage()).getCOLOR();

            if (j < 0)
            {
                j = 16777215;
            }

            return j;
        }	}
}
