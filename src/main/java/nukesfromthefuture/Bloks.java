package nukesfromthefuture;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Bloks extends CreativeTabs {

	public Bloks(String reee) {
		super(reee);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(Item.getItemFromBlock(Nukesfromthefuture.waste)).getItem();
	}

}
