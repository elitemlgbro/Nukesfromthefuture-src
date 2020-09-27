package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import nukesfromthefuture.potion.NftfPotion;

public class LeadFood extends ItemFood{
    public LeadFood(int hunger, float saturation, boolean canFeedToWolves){
        super(hunger, saturation, canFeedToWolves);
    }

    @Override
    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(NftfPotion.lead_poisioning.id, 30 * 20, 0));
    }
}
