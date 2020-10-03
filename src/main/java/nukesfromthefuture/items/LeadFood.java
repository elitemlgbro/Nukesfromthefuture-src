package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import nukesfromthefuture.potion.NftfPotion;

import java.util.List;

public class LeadFood extends ItemFood{
    public LeadFood(int hunger, float saturation, boolean canFeedToWolves){
        super(hunger, saturation, canFeedToWolves);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
        list.add("This is 100% edible.");
        list.add("Totally not likely to cause lead poisioning.");
        list.add("You won't have to go to the doctor over this, either way,");
        list.add("ur still not gonna have your money back");
    }

    @Override
    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(NftfPotion.lead_poisioning.id, 30 * 20, 0));
    }
}
