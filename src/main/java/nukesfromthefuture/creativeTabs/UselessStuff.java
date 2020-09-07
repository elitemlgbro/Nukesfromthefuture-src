package nukesfromthefuture.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nukesfromthefuture.Nukesfromthefuture;

public class UselessStuff extends CreativeTabs {

	public UselessStuff(String lable) {
		super(lable);
		this.setBackgroundImageName("UwU.png");
	}

	@Override
	public Item getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(Nukesfromthefuture.trololo)).getItem();
	}

}
