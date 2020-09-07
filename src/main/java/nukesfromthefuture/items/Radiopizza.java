package nukesfromthefuture.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class Radiopizza extends ItemFood {

	public Radiopizza(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		// TODO Auto-generated constructor stub
	}
	public void addInformation(ItemStack stack, EntityPlayer playa, List list, boolean p_77624_4_) {
		list.add("mmmmmmmmmmm radioactive pizza");
		list.add("call your doctor if you're getting");
		list.add("nuclear diarrhea or feel cancerous");
		list.add("we are not responsible");
		stack.setStackDisplayName(EnumChatFormatting.GREEN + "Radioactive pizza");
	}

}
