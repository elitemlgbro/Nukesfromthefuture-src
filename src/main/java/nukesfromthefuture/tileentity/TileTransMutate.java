package nukesfromthefuture.tileentity;

import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.Lib;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.interfaces.AuxElectricityPacket;
import nukesfromthefuture.interfaces.IConsumer;
import nukesfromthefuture.packet.PacketDispatcher;


import java.util.ArrayList;
import java.util.List;

public class TileTransMutate extends TileEntity implements ISidedInventory, IConsumer{
    public ItemStack slots[];
    public long power;
    public int process = 0;
    public static final int processSpeed = 1000;
    List<IConsumer> list = new ArrayList();
    public static final long maxPowa = 10000L;
    public TileTransMutate(){
        slots = new ItemStack[3];
    }
    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }
    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return slots[i];
    }

    @Override
    public void updateEntity() {
        power = Lib.chargeTEFromItems(slots, 1, power, maxPowa);
        if(isReady()){
            process();
        }else{
            process = 0;
        }
        if(!worldObj.isRemote){
            PacketDispatcher.wrapper.sendToAllAround(new AuxElectricityPacket(xCoord, yCoord, zCoord, power), new NetworkRegistry.TargetPoint(worldObj.provider.dimensionId, xCoord, yCoord, zCoord, 50));

        }
    }
    public int getProgressScaled(int i) {
        return (process * i) / processSpeed;
    }
    @Override
    public ItemStack decrStackSize(int i, int j) {
        if(slots[i] != null)
        {
            if(slots[i].stackSize <= j)
            {
                ItemStack itemStack = slots[i];
                slots[i] = null;
                return itemStack;
            }
            ItemStack itemStack1 = slots[i].splitStack(j);
            if (slots[i].stackSize == 0)
            {
                slots[i] = null;
            }

            return itemStack1;
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if(slots[i] != null)
        {
            ItemStack itemStack = slots[i];
            slots[i] = null;
            return itemStack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        slots[i] = itemStack;
        if(itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }
    public boolean isReady(){
        if(slots[0] != null && slots[0].getItem() == Nukesfromthefuture.ego_ingot && power >= 5000) return true;
        return false;
    }
    public void process(){
        process ++;

        if(process >= processSpeed){
            process = 0;
            power = 0;
            slots[0].stackSize --;
            if(slots[0].stackSize <= 0)
                slots[0] = null;

            if(slots[2] == null){
                slots[2] = new ItemStack(Nukesfromthefuture.deathinum_ingot);
            }else{
                slots[2].stackSize ++;
            }
        worldObj.playSoundEffect(xCoord, yCoord, zCoord, "mob.ghast.scream", 10000F, 0.8F + this.worldObj.rand.nextFloat() * 0.2F);
        }
    }


    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        process = nbt.getInteger("pro");
        NBTTagList list = nbt.getTagList("items", 10);
        power = nbt.getLong("power");


        slots = new ItemStack[getSizeInventory()];
        for(int i = 0; i < list.tagCount(); i++)
        {
            NBTTagCompound nbt1 = list.getCompoundTagAt(i);
            byte b0 = nbt1.getByte("slot");
            if(b0 >= 0 && b0 < slots.length)
            {
                slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
            }
        }
    }
    public boolean isProssesing(){
        if(process > 0) return true;
        return false;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList list = new NBTTagList();
        nbt.setInteger("pro", process);
        nbt.setLong("power", power);
        for(int i = 0; i < slots.length; i++)
        {
            if(slots[i] != null)
            {
                NBTTagCompound nbt1 = new NBTTagCompound();
                nbt1.setByte("slot", (byte)i);
                slots[i].writeToNBT(nbt1);
                list.appendTag(nbt1);
            }
        }
        nbt.setTag("items", list);
    }

    @Override
    public String getInventoryName() {
        return "container.Transmutator";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }
    public long getPowerScaled(long i) {
        return (power * i) / maxPowa;
    }
    public boolean hasPower() {

        return power >= getPowerRequired();
    }

    public int getPowerRequired() {

        return (int) (maxPowa * 0.75);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        if(worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }else{
            return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <=64;
        }
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return false;
    }







    @Override
    public void setPower(long i) {
        power = i;
    }

    @Override
    public long getPower() {
        return power;
    }

    @Override
    public long getMaxPower() {
        return maxPowa;
    }

}
