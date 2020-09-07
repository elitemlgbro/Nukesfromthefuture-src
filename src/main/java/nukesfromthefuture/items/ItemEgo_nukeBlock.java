package nukesfromthefuture.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemEgo_nukeBlock extends ItemBlock {

	public ItemEgo_nukeBlock(Block p_i45328_1_) {
		super(p_i45328_1_);
		// TODO Auto-generated constructor stub
	}
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean p_77624_4_) {
		tooltip.add("My actual ego is bigger so be grateful");
	}

}
