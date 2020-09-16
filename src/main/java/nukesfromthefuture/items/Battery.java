package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import nukesfromthefuture.Lib;
import nukesfromthefuture.interfaces.IBatteryItem;

import java.util.List;

public class Battery extends Item implements IBatteryItem{
    private long maxCharge;
    private long chargeRate;
    private long dischargeRate;

    public Battery(long dura, long chargeRate, long dischargeRate) {
        this.maxCharge = dura;
        this.chargeRate = chargeRate;
        this.dischargeRate = dischargeRate;
    }

    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool)
    {
        long charge = maxCharge;
        if(itemstack.hasTagCompound())
            charge = getCharge(itemstack);


            String charge1 = Lib.getShortNumber((charge * 100) / this.maxCharge);
            list.add("Charge: " + charge1 + "%");
            list.add("(" + Lib.getShortNumber(charge) + "/" + Lib.getShortNumber(maxCharge) + "HE)");

        list.add("Charge rate: " + Lib.getShortNumber(chargeRate) + "HE/t");
        list.add("Discharge rate: " + Lib.getShortNumber(dischargeRate) + "HE/t");
    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {





        return EnumRarity.common;
    }

    public void chargeBattery(ItemStack stack, long i) {
        if(stack.getItem() instanceof Battery) {
            if(stack.hasTagCompound()) {
                stack.stackTagCompound.setLong("charge", stack.stackTagCompound.getLong("charge") + i);
            } else {
                stack.stackTagCompound = new NBTTagCompound();
                stack.stackTagCompound.setLong("charge", i);
            }
        }
    }

    public void setCharge(ItemStack stack, long i) {
        if(stack.getItem() instanceof Battery) {
            if(stack.hasTagCompound()) {
                stack.stackTagCompound.setLong("charge", i);
            } else {
                stack.stackTagCompound = new NBTTagCompound();
                stack.stackTagCompound.setLong("charge", i);
            }
        }
    }

    public void dischargeBattery(ItemStack stack, long i) {
        if(stack.getItem() instanceof Battery) {
            if(stack.hasTagCompound()) {
                stack.stackTagCompound.setLong("charge", stack.stackTagCompound.getLong("charge") - i);
            } else {
                stack.stackTagCompound = new NBTTagCompound();
                stack.stackTagCompound.setLong("charge", this.maxCharge - i);
            }
        }
    }

    public long getCharge(ItemStack stack) {
        if(stack.getItem() instanceof Battery) {
            if(stack.hasTagCompound()) {
                return stack.stackTagCompound.getLong("charge");
            } else {
                stack.stackTagCompound = new NBTTagCompound();
                stack.stackTagCompound.setLong("charge", ((Battery)stack.getItem()).maxCharge);
                return stack.stackTagCompound.getLong("charge");
            }
        }

        return 0;
    }

    public long getMaxCharge() {
        return maxCharge;
    }

    public long getChargeRate() {
        return chargeRate;
    }

    public long getDischargeRate() {
        return dischargeRate;
    }

    public static ItemStack getEmptyBattery(Item item) {

        if(item instanceof Battery) {
            ItemStack stack = new ItemStack(item);
            stack.stackTagCompound = new NBTTagCompound();
            stack.stackTagCompound.setLong("charge", 0);
            return stack.copy();
        }

        return null;
    }

    public static ItemStack getFullBattery(Item item) {

        if(item instanceof Battery) {
            ItemStack stack = new ItemStack(item);
            stack.stackTagCompound = new NBTTagCompound();
            stack.stackTagCompound.setLong("charge", ((Battery)item).getMaxCharge());
            return stack.copy();
        }

        return null;
    }

    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    public double getDurabilityForDisplay(ItemStack stack)
    {
        return 1D - (double)getCharge(stack) / (double)getMaxCharge();
    }
}
