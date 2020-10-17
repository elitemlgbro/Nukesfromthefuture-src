package nukesfromthefuture.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import nukesfromthefuture.entity.EntityPOTATO;

public class ItemPOTATO extends Item{

	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
		p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!p_77659_2_.isRemote) {
		p_77659_2_.spawnEntityInWorld(new EntityPOTATO(p_77659_2_, p_77659_3_));
		}

		if(!p_77659_3_.capabilities.isCreativeMode){
			-- p_77659_1_.stackSize;
		}
		return p_77659_1_;
    }
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean useless) {
		stack.setStackDisplayName(EnumChatFormatting.GOLD + "POTATO");
		tooltip.add("WORSHIP DA POTATO!!!!");
		tooltip.add("IT IS LEGENDARY!");
	}

}
