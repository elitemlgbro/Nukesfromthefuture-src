package nukesfromthefuture.tileentity;


import cpw.mods.fml.common.network.NetworkRegistry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.blocks.EgoFurnace;
import nukesfromthefuture.container.FluidTank;
import nukesfromthefuture.handler.FluidTypeHandler.*;
import nukesfromthefuture.interfaces.AuxElectricityPacket;
import nukesfromthefuture.interfaces.IFluidAcceptor;
import nukesfromthefuture.interfaces.IFluidContainer;
import nukesfromthefuture.packet.AuxGaugePacket;
import nukesfromthefuture.packet.PacketDispatcher;

import java.util.ArrayList;
import java.util.List;

public class TileEgoFurnace extends TileEntity implements ISidedInventory, IFluidContainer, IFluidAcceptor{
    private ItemStack slots[];
    public FluidTank tank;
    public int dualCookTime;
    public long power;
    public static final long maxPower = 100000;
    public static final int processingSpeed = 100;

    private static final int[] slots_top = new int[] {1};
    private static final int[] slots_bottom = new int[] {2, 0};
    private static final int[] slots_side = new int[] {0};

    private String customName;

    public TileEgoFurnace() {
        slots = new ItemStack[5];
        tank = new FluidTank(FluidType.egonium, 160000, 0);
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
        return this.hasCustomInventoryName() ? this.customName : "container.ego_furnace";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return this.customName != null && this.customName.length() > 0;
    }

    public void setCustomName(String name) {
        this.customName = name;
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

    //You scrubs aren't needed for anything (right now)
    @Override
    public void openInventory() {}
    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {


        return false;
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
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList list = nbt.getTagList("items", 10);

        this.power = nbt.getLong("powerTime");
        this.dualCookTime = nbt.getInteger("cookTime");
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

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setLong("powerTime", power);
        nbt.setInteger("cookTime", dualCookTime);
        NBTTagList list = new NBTTagList();

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
    public int[] getAccessibleSlotsFromSide(int p_94128_1_)
    {
        return p_94128_1_ == 0 ? slots_bottom : (p_94128_1_ == 1 ? slots_top : slots_side);
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemStack, int j) {
        return this.isItemValidForSlot(i, itemStack);
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemStack, int j) {


        return false;
    }

    public int getDiFurnaceProgressScaled(int i) {
        return (dualCookTime * i) / processingSpeed;
    }

    public long getPowerRemainingScaled(long i) {
        return (power * i) / maxPower;
    }

    public boolean hasPower() {
        return power > 0;
    }

    public boolean isProcessing() {
        return this.dualCookTime > 0;
    }

    public boolean canProcess() {
        if(slots[3] == null)
        {
            return false;
        }
        ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[3]);

        if(itemStack == null)
        {
            return false;
        }
        if(tank.getFill() <= 50000){
            return false;
        }
        if(slots[4] == null)
        {
            return true;
        }

        if(!slots[4].isItemEqual(itemStack)) {
            return false;
        }

        if(slots[4].stackSize < getInventoryStackLimit() && slots[3].stackSize < slots[3].getMaxStackSize()) {
            return true;
        }else{
            return slots[4].stackSize < itemStack.getMaxStackSize();
        }
    }

    private void processItem() {
        if(canProcess()) {
            ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[3]);

            if(slots[4] == null)
            {
                slots[4] = itemStack.copy();
            }else if(slots[4].isItemEqual(itemStack)) {
                slots[4].stackSize += itemStack.stackSize;
            }
            slots[3].stackSize--;
            if(slots[3].stackSize <= 0){
                slots[3] = null;
            }
        }
    }
    public static int getItemPower(ItemStack slot){
        if(slot == null){
            return 0;
        }else{
            Item item = slot.getItem();
            if(item == Nukesfromthefuture.canned_radiation) return 3000;
            if(item == Items.coal) return 200;
            if(item == Item.getItemFromBlock(Blocks.coal_block)) return 2000;
            if(item == Items.lava_bucket) return 2500;
            if(item == Item.getItemFromBlock(Blocks.log) || item == Item.getItemFromBlock(Blocks.log2)) return 75;
            return 0;
        }
    }
    public boolean hasItemPower(ItemStack slot){
        if(getItemPower(slot) > 0) return true;
        return false;
    }
    @Override
    public void updateEntity() {
        this.hasPower();
        boolean flag1 = false;
        if (this.hasItemPower(this.slots[2])
                && this.power <= (TileEgoFurnace.maxPower - TileEgoFurnace.getItemPower(this.slots[2]))) {
            this.power += getItemPower(this.slots[2]);
            if (this.slots[2] != null) {
                flag1 = true;
                this.slots[2].stackSize--;
                if (this.slots[2].stackSize == 0) {
                    this.slots[2] = this.slots[2].getItem().getContainerItem(this.slots[2]);
                }
            }
        }
        if(!worldObj.isRemote)
        {
            if(hasPower() && canProcess())
            {
                dualCookTime++;

                power -= 50;

                if(this.dualCookTime == TileEgoFurnace.processingSpeed)
                {
                    this.dualCookTime = 0;
                    this.processItem();
                    flag1 = true;
                }
            }else{
                dualCookTime = 0;
            }

            boolean trigger = true;

            if(hasPower() && canProcess() && this.dualCookTime == 0)
            {
                trigger = false;
            }
            if (this.slots[2] != null && this.slots[2].getItem() == Nukesfromthefuture.my_ego) {

                this.power = maxPower;
            }
            if(trigger)
            {
                flag1 = true;
                EgoFurnace.updateBlockState(this.dualCookTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }


            PacketDispatcher.wrapper.sendToAllAround(new AuxElectricityPacket(xCoord, yCoord, zCoord, power), new NetworkRegistry.TargetPoint(worldObj.provider.dimensionId, xCoord, yCoord, zCoord, 50));
            PacketDispatcher.wrapper.sendToAllAround(new AuxGaugePacket(xCoord, yCoord, zCoord, dualCookTime, 0), new NetworkRegistry.TargetPoint(worldObj.provider.dimensionId, xCoord, yCoord, zCoord, 50));
            tank.loadTank(0, 1, slots);
            tank.updateTank(xCoord, yCoord, zCoord, worldObj.provider.dimensionId);
        }


        if(flag1)
        {
            this.markDirty();
        }
    }


    @Override
    public int getMaxFluidFill(FluidType type) {
        return type.getName().equals(tank.getTankType().getName()) ? tank.getMaxFill() : 0;
    }

    @Override
    public void setFillstate(int fill, int index) {
        tank.setFill(fill);
    }

    @Override
    public void setFluidFill(int fill, FluidType type) {
        if(type.getName().equals(tank.getTankType().getName())){
            tank.setFill(fill);
        }
    }

    @Override
    public void setType(FluidType type, int index) {
        tank.setTankType(type);
    }

    @Override
    public List<FluidTank> getTanks() {
        List<FluidTank> list = new ArrayList();
        list.add(tank);
        return list;
    }

    @Override
    public int getFluidFill(FluidType type) {
        return type.getName().equals(tank.getTankType().getName()) ? tank.getFill() : 0;
    }
}
