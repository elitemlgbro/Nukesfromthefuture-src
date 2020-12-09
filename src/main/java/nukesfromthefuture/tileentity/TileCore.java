package nukesfromthefuture.tileentity;

import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import nukesfromthefuture.Lib;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.RadSaveData;
import nukesfromthefuture.container.FluidTank;
import nukesfromthefuture.entity.Mk3Explosion;
import nukesfromthefuture.handler.FluidTypeHandler.*;
import nukesfromthefuture.interfaces.*;
import nukesfromthefuture.items.ItemFluidTank;
import nukesfromthefuture.packet.ColorPacket;
import nukesfromthefuture.packet.PacketDispatcher;

import java.util.ArrayList;
import java.util.List;

public class TileCore extends TileEntity implements ISidedInventory, ISource, IFluidContainer, IFluidAcceptor, IColorIndicator {
    public float prevRot;
    public float rotation;
    public float rise;
    public float prevRis;
    public float blue = 1.0F;
    public float red = 1.0F;
    public float green = 1.0F;
    public long power;
    public long maxPower = 100000;
    //used so that the warning chat message doesn't show up literally every fucking tick, may be replaced
    public int age;
    public ItemStack slots[];
    public FluidTank tanks[];

    public TileCore(){
        slots = new ItemStack[7];
        tanks = new FluidTank[2];
        tanks[0] = new FluidTank(FluidType.COOLANT, 64000, 0);
        tanks[1] = new FluidTank(FluidType.URANIUM, 80000, 1);

    }
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return TileEntity.INFINITE_EXTENT_AABB;
    }

    @Override
    public double getMaxRenderDistanceSquared() {
        return 6500D;
    }
    public boolean isStructureCorrect(){
        return NuclearReactorStructure.isValid(worldObj, xCoord, yCoord, zCoord);
    }
    @Override
    public void updateEntity() {
        super.updateEntity();
        if(!worldObj.isRemote){
            tanks[0].loadTank(0, 2, slots);
            tanks[1].loadTank(1, 3, slots);
            for(int i = 0; i < 2; i++){
                tanks[i].updateTank(xCoord, yCoord, zCoord, worldObj.provider.dimensionId);
            }
            if(tanks[0].getFill() > 32000 && tanks[1].getFill() >= 20000 && isActive()){
                red = 0.2F;
                blue = 0.1F;
                green = 1.0F;
            }

            if(tanks[0].getFill() <= 32000 && tanks[1].getFill() >= 20000 && isActive()){
                red = 1.0F;
                green = 0.8F;
                blue = 0.1F;
            }
            if(tanks[0].getFill() <= 24000 && tanks[1].getFill() >= 20000 && isActive()){
                age ++;
                red = 1.0F;
                green = 0.1F;
                blue = 0.1F;
                if(age == 1)
                Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BOLD + "" + EnumChatFormatting.RED + "[Warning]" + EnumChatFormatting.RESET + "Reactor is unstable! Explosion Iminate!!"));
            }
            if(tanks[0].getFill() < 16000 && tanks[1].getFill() >= 20000 && isActive()){
                Mk3Explosion meltdown = new Mk3Explosion(worldObj);
                meltdown.posX = xCoord;
                meltdown.posY = yCoord;
                meltdown.posZ = zCoord;
                meltdown.destructionRange = 90;
                meltdown.waste = true;
                meltdown.speed = 20;
                worldObj.spawnEntityInWorld(meltdown);
            }
            if(isActive() && tanks[1].getFill() >= 20000 && tanks[0].getFill() > 14000){
                RadSaveData data = RadSaveData.getData(worldObj);
                data.incrementRad(worldObj, xCoord, yCoord, 50, 100 * 4);
                power += 1000;
                tanks[1].setFill(tanks[1].getFill() - 50);
                tanks[0].setFill(tanks[0].getFill() - 20);
            }
            if(power >= maxPower){
                power = maxPower;
            }

            power = Lib.chargeItemsFromTE(slots, 6, power, maxPower);
            PacketDispatcher.wrapper.sendToAllAround(new AuxElectricityPacket(xCoord, yCoord, zCoord, power), new NetworkRegistry.TargetPoint(worldObj.provider.dimensionId, xCoord, yCoord, zCoord, 100));
            //I don't know if these are neccecary and I don't care
            PacketDispatcher.wrapper.sendToAllAround(new ColorPacket(xCoord, yCoord, zCoord, red, blue, green), new NetworkRegistry.TargetPoint(worldObj.provider.dimensionId, xCoord, yCoord, zCoord, 50));
        }
        if(tanks[0].getFill() > 32000 && tanks[1].getFill() >= 20000 && isActive()){
            red = 0.2F;
            blue = 0.1F;
            green = 1.0F;
        }

        if(tanks[0].getFill() <= 32000 && tanks[1].getFill() >= 20000 && isActive()){
            red = 1.0F;
            green = 0.8F;
            blue = 0.1F;
        }
        if(tanks[0].getFill() <= 24000 && tanks[1].getFill() >= 20000 && isActive()){
            red = 1.0F;
            green = 0.1F;
            blue = 0.1F;
        }
        this.prevRot = this.rotation;



            this.rotation += 15F;

            if(this.rotation >= 360) {
                this.rotation -= 360;
                this.prevRot -= 360;
            }
        this.prevRis = this.rise;

            this.rise += 0.125F;
            if(this.rise >= 1.5){
                this.rise -= 0.125;
                this.prevRis -=0.125;
            }
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    public boolean isActive(){
        if(slots[4] != null && slots[5] != null && slots[4].getItem() == Nukesfromthefuture.poorly_drawn_fuse && slots[5].getItem() == Nukesfromthefuture.microRadioBullet)
            return true;
        return false;
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
    public long getPowerScaled(long i){
            return (power * i) / maxPower;
    }
    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if(slots[i] != null){
            ItemStack stack = slots[i];
            slots[i] = null;
            return stack;
        }else{
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack) {
        slots[i] = stack;
        if(stack != null && stack.stackSize > getInventoryStackLimit()){
            stack.stackSize = getInventoryStackLimit();
        }

    }

    @Override
    public String getInventoryName() {
        return "container.reactor";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return getInventoryName() != null ? true : false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList list = nbt.getTagList("items", 0);
        slots = new ItemStack[getSizeInventory()];
            tanks[0].readFromNBT(nbt, "contents");
            tanks[1].readFromNBT(nbt, "contentss");
        power = nbt.getLong("power");
        red = nbt.getFloat("red");
        blue = nbt.getFloat("blue");
        green = nbt.getFloat("green");
        for(int i = 0; i < list.tagCount(); i++){
            NBTTagCompound nbt1 = list.getCompoundTagAt(i);
            byte b0 = nbt1.getByte("slots");
            if(b0 >= 0 && b0 < slots.length){
                slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
            }
        }
    }
    @Override
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        NBTTagList list = new NBTTagList();
            tanks[0].writeToNBT(nbt, "contents");
            tanks[1].writeToNBT(nbt, "contentss");
        nbt.setLong("power", power);
        nbt.setFloat("red", red);
        nbt.setFloat("blue", blue);
        nbt.setFloat("green", green);
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
    public boolean isItemValidForSlot(int i, ItemStack j) {
        if(i == 0 || i == 1 && j.getItem() instanceof ItemFluidTank){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void ffgeuaInit() {

    }

    @Override
    public void ffgeua(int x, int y, int z, boolean newTact) {

    }

    @Override
    public boolean getTact() {
        return true;
    }

    @Override
    public long getSPower() {
        return power;
    }

    @Override
    public void setSPower(long i) {
        power = i;
    }

    @Override
    public List<IConsumer> getList() {
        return null;
    }

    @Override
    public void clearList() {

    }

    @Override
    public int getMaxFluidFill(FluidType type) {
        if(type.name().equals(tanks[0].getTankType().getName())){
            return tanks[0].getMaxFill();
        }else if(type.name().equals(tanks[1].getTankType().getName())) {
            return tanks[1].getMaxFill();
        }else {
            return 0;
        }
    }

    @Override
    public void setFillstate(int fill, int index) {
        if(index == tanks[0].index){
            tanks[0].setFill(fill);
        } else if (index == tanks[1].index){
            tanks[1].setFill(fill);
        }

    }

    @Override
    public void setFluidFill(int fill, FluidType type) {
        if(type.name().equals(tanks[0].getTankType().getName())){
            tanks[0].setFill(fill);
        } else if(type.name().equals(tanks[1].getTankType().getName())){
            tanks[1].setFill(fill);

        }
    }

    @Override
    public void setType(FluidType type, int index) {
        if(index == tanks[0].index){
            tanks[0].setTankType(type);
        } else if(index == tanks[1].index){
            tanks[1].setTankType(type);
        }
    }

    @Override
    public List<FluidTank> getTanks() {
        List<FluidTank> list = new ArrayList<FluidTank>();
        list.add(tanks[0]);
        list.add(tanks[1]);
        return list;
    }

    @Override
    public int getFluidFill(FluidType type) {
        if(type.name().equals(tanks[0].getTankType().getName())){
            return tanks[0].getFill();
        } else if(type.name().equals(tanks[1].getTankType().getName())){
            return tanks[1].getFill();
        }
            return 0;

    }

    @Override
    public float getRed() {
        return red;
    }

    @Override
    public float getBlue() {
        return blue;
    }

    @Override
    public float getGreen() {
        return green;
    }

    @Override
    public void setRed(float i) {
        red = i;
    }

    @Override
    public void setBlue(float i) {
        blue = i;
    }

    @Override
    public void setGreen(float i) {
        green = i;
    }
}
