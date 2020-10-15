package nukesfromthefuture.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.interfaces.IBatteryItem;

import java.util.ArrayList;
import java.util.List;

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
