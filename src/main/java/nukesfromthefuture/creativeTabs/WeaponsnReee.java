package nukesfromthefuture.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nukesfromthefuture.Nukesfromthefuture;

public class WeaponsnReee extends CreativeTabs {

	public WeaponsnReee(String lable) {
		super(lable);
		this.setBackgroundImageName("reee.png");
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(Nukesfromthefuture.POTATO).getItem();
	}

}
