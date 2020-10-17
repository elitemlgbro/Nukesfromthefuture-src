package nukesfromthefuture.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import nukesfromthefuture.Nukesfromthefuture;

public class TileDeathBomb extends TileEntity implements ISidedInventory {
    public ItemStack[] slots;
    public TileDeathBomb(){
        slots = new ItemStack[2];
    }
    public AxisAlignedBB getRenderBoundingBox(){
        return TileEntity.INFINITE_EXTENT_AABB;
    }
    public double getMaxRenderDistanceSquared(){
        return 6500D;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }
    public boolean isReady(){
        if (slots[0] != null && slots[1] != null && slots[0].getItem() == Nukesfromthefuture.deathinum_core && slots[1].getItem() == Nukesfromthefuture.microRadioBullet)return true;
        return false;

    }
    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
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
    public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);
        NBTTagList list = nbt.getTagList("items", 10);
        slots = new ItemStack[this.getSizeInventory()];
        for(int i = 0; i < list.tagCount(); i++){
            NBTTagCompound nbt1 = list.getCompoundTagAt(i);
            int j = nbt1.getByte("slots");
            if(j >= 0 && j < slots.length){
                slots[j] = ItemStack.loadItemStackFromNBT(nbt1);
            }

        }
    }
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        NBTTagList list = new NBTTagList();
        for(int i = 0; i < slots.length; i++){
            if(slots[i] != null){
                NBTTagCompound nbt1 = new NBTTagCompound();
                nbt1.setByte("slots", (byte)i);
                slots[i].writeToNBT(nbt1);
                list.appendTag(nbt1);
            }
        }
        nbt.setTag("items", list);
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

    @Override
    public String getInventoryName() {
        return "container.deathinum_bomb";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        if(worldObj.getTileEntity(xCoord, yCoord, zCoord) != this){
            return false;
        } else{
            return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
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
}
