package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ShuPizza extends ItemFood {

	public ShuPizza(int par1, float p_i45339_2_, boolean p_i45339_3_) {
		super(par1, p_i45339_2_, p_i45339_3_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
		list.add("A warcrime!");
		list.add("NOT JUST TO JAPAN BUT TO THE REST OF HUMANITY AS WELL!! D:X");
	}
}
