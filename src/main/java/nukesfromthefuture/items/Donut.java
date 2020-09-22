package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import java.util.List;

public class Donut extends ItemFood{
    public Donut(int p_i45340_1_,float uhhh, boolean p_i45340_2_) {
        super(p_i45340_1_, uhhh, p_i45340_2_);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
        list.add("Yas");
        list.add("I spelled donut wrong");
    }
}
