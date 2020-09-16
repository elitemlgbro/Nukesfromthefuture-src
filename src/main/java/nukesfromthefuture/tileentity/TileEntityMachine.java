package nukesfromthefuture.tileentity;

import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.packet.NBTPacket;
import nukesfromthefuture.packet.PacketDispatcher;

public abstract class TileEntityMachine extends TileEntity implements ISidedInventory{
    public ItemStack slots[];

    public String customName;

    public TileEntityMachine(int siz){
        slots = new ItemStack[siz];
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
    public void networkPack(NBTTagCompound nbt, int range){
        if(!worldObj.isRemote)
            PacketDispatcher.wrapper.sendToAllAround(new NBTPacket(nbt, xCoord, yCoord, zCoord), new NetworkRegistry.TargetPoint(this.worldObj.provider.dimensionId, xCoord, yCoord, zCoord, range));
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
    public void networkUnpack(NBTTagCompound nbt){}
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
        return this.hasCustomInventoryName() ? this.customName : getName();
    }
    public abstract String getName();

    @Override
    public boolean hasCustomInventoryName() {
        return this.customName != null && this.customName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    public void setCustomName(String name) {
        this.customName = name;
    }
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        if(worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }else{
            return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <=128;
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
