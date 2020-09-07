package nukesfromthefuture.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import nukesfromthefuture.Nukesfromthefuture;

public class ItemCooked_POTATO extends ItemFood {

	public ItemCooked_POTATO() {
		super(20, 5.0F, true);
		if(Nukesfromthefuture.POTATOtofries == true) {
			this.setTextureName("nff:fries");
		}else if(Nukesfromthefuture.POTATOtofries == false){
			this.setTextureName("nff:Cooked_POTATO");
		}
	}
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
		if(Nukesfromthefuture.POTATOtofries == true) {
			stack.setStackDisplayName(EnumChatFormatting.YELLOW + "French fries");
			list.add("Straight from McDonalds");
		}else if(Nukesfromthefuture.POTATOtofries == false){
			stack.setStackDisplayName(EnumChatFormatting.RED + "Cooked POTATO");
			list.add("But it had a face on it");
			list.add("YOU MURDERER!!!!!!!!!!!!!");
		}
	}

}
