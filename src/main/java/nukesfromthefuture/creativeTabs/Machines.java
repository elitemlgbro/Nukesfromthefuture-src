package nukesfromthefuture.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nukesfromthefuture.Nukesfromthefuture;

public class Machines extends CreativeTabs {

	public Machines(String lable) {
		super(lable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(Nukesfromthefuture.unrefinary)).getItem();
	}

}
