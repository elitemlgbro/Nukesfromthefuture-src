package nukesfromthefuture.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import nukesfromthefuture.Nukesfromthefuture;

public class BlockLore extends ItemBlock {

	public BlockLore(Block p_i45328_1_) {
		super(p_i45328_1_);
		// TODO Auto-generated constructor stub
	}
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean p_77624_4_) {
		if(this.field_150939_a == Nukesfromthefuture.singularity_nuke) {
			tooltip.add("you may be asking:");
			tooltip.add("\"but elite, a particle collider\"");
			tooltip.add(" advanced enough to move singularties");
			tooltip.add("which are manifolds with an");
			tooltip.add("undefined state of space-time?");
			tooltip.add("how is this possible?''");
			tooltip.add("Here is a detailed but long answer:");
			tooltip.add("IT'S A NUKE!! And I have no idea");
		}
		if(this.field_150939_a == Nukesfromthefuture.craterCoverer) {
			tooltip.add("Hide the evidence of your explosoion.");
			tooltip.add(EnumChatFormatting.STRIKETHROUGH + "may build a tower around the explosion");
		}
		if(this.field_150939_a == Nukesfromthefuture.antiTime) {
			tooltip.add("A parodox in a nuke...");
			tooltip.add("I don't feel fine");
		}
		if(this.field_150939_a == Nukesfromthefuture.the_beta) {
			tooltip.add("I didn't have to copy and change HBM's homework");
			tooltip.add("                       ");
			tooltip.add("BUT I WANTED TO");
		}
	}
	

}
