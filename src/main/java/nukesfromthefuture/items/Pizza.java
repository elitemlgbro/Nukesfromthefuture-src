package nukesfromthefuture.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class Pizza extends ItemFood {

	public Pizza(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		// TODO Auto-generated constructor stub
	}
	public void addInformation(ItemStack poopoo, EntityPlayer player, List tooltip, boolean p_77624_4_) {
		tooltip.add("A complimentary gift from papa elite's pizza");
		tooltip.add("order now at 1800-666-666");
		poopoo.setStackDisplayName(EnumChatFormatting.AQUA + "Pizza");
	}

}
