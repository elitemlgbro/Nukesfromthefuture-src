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

	@Override
	public void displayAllReleventItems(List list) {
		super.displayAllReleventItems(list);
		List<ItemStack> bat = new ArrayList();
		for(Object o : list){
			if(o instanceof ItemStack){
				ItemStack stack = (ItemStack) o;
				if(stack.getItem() instanceof IBatteryItem){
					bat.add(stack);
				}
			}
		}
		for(ItemStack stack : bat) {

			if(!(stack.getItem() instanceof IBatteryItem)) //shouldn't happen but just to make sure
				continue;

			IBatteryItem battery = (IBatteryItem) stack.getItem();

			ItemStack empty = stack.copy();
			ItemStack full = stack.copy();

			battery.setCharge(empty, 0);
			battery.setCharge(full, battery.getMaxCharge());

			int index = list.indexOf(stack);

			list.remove(index);
			list.add(index, full);

			//do not list empty versions of SU batteries
			if(battery.getChargeRate() > 0)
				list.add(index, empty);
		}
	}
}
