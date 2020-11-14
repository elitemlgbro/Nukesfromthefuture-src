package nukesfromthefuture.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import nukesfromthefuture.Lib;
import nukesfromthefuture.container.FluidTank;
import nukesfromthefuture.handler.FluidTypeHandler;
import nukesfromthefuture.interfaces.IFluidAcceptor;
import nukesfromthefuture.interfaces.IFluidContainer;
import nukesfromthefuture.interfaces.IFluidSource;

import java.util.ArrayList;
import java.util.List;

public class TileEntityUnrefinery extends TileEntity implements ISidedInventory, IFluidContainer, IFluidAcceptor, IFluidSource{
	public ItemStack slots[];
	public FluidTank[] tanks;
	public TileEntityUnrefinery(){
		slots = new ItemStack[8];
		tanks = new FluidTank[4];
		tanks[0] = new FluidTank(FluidTypeHandler.FluidType.unstable_plutonium, 256000, 0);
		tanks[1] = new FluidTank(FluidTypeHandler.FluidType.BLACK_HOLE_FUEL, 32000, 1);
		tanks[2] = new FluidTank(FluidTypeHandler.FluidType.ANTITIME, 32000, 2);
		tanks[3] = new FluidTank(FluidTypeHandler.FluidType.egonium, 32000, 3);
	}
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO Auto-generated method stub
		return slots[p_70301_1_];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
        slots[i] = itemStack;
        if(itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return "Container.unrefinery";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if(!worldObj.isRemote){
			tanks[0].loadTank(0, 4, slots);
			tanks[1].unloadTank(1, 5, slots);
			tanks[2].unloadTank(2, 6, slots);
			tanks[3].unloadTank(3, 7, slots);
			int ho = 50;
			int nt = 25;
			int lo = 25;
			int pe = 10;
			if(tanks[0].getFill() >= 100 &&
					tanks[1].getFill() + ho <= tanks[1].getMaxFill() &&
					tanks[2].getFill() + nt <= tanks[2].getMaxFill() &&
					tanks[3].getFill() + lo <= tanks[3].getMaxFill()) {

				tanks[0].setFill(tanks[0].getFill() - 100);
				tanks[1].setFill(tanks[1].getFill() + ho);
				tanks[2].setFill(tanks[2].getFill() + nt);
				tanks[3].setFill(tanks[3].getFill() + lo);


			}
			for(int i = 0; i < tanks.length; i++){
				tanks[i].updateTank(xCoord, yCoord, zCoord, worldObj.provider.dimensionId);
			}
		}
	}

	@Override
    public AxisAlignedBB getRenderBoundingBox() {
        return TileEntity.INFINITE_EXTENT_AABB;
    }

    @Override
    public double getMaxRenderDistanceSquared() {
        return 1650D;
    }

    @Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tanks[0].writeToNBT(tag, "unstable");
		tanks[1].writeToNBT(tag, "UwU");
		tanks[2].writeToNBT(tag, "OwO");
		tanks[3].writeToNBT(tag, "QwQ");
		NBTTagList list = new NBTTagList();
		for(int i = 0; i < slots.length; i++){
			if(slots[i] != null){
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("slots", (byte)i);
				slots[i].writeToNBT(nbt1);
				list.appendTag(nbt1);
			}
		}
		tag.setTag("items", list);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		NBTTagList list = tag.getTagList("items", 10);
		tanks[0].readFromNBT(tag, "unstable");
		tanks[1].readFromNBT(tag, "UwU");
		tanks[2].readFromNBT(tag, "OwO");
		tanks[3].readFromNBT(tag, "QwQ");
		slots = new ItemStack[getSizeInventory()];
		for(int i = 0; i < list.tagCount(); i++){
			NBTTagCompound tag1 = list.getCompoundTagAt(i);
			int j = tag1.getByte("slots");
			if(j >= 0 && j < slots.length){
				slots[j] = ItemStack.loadItemStackFromNBT(tag1);
			}

		}
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getMaxFluidFill(FluidTypeHandler.FluidType type) {
		if(type.getName().equals(tanks[0].getTankType().getName())){
		    return tanks[0].getMaxFill();
        } else if (type.getName().equals(tanks[1].getTankType().getName())){
		    return tanks[1].getMaxFill();
        }else if(type.getName().equals(tanks[2].getTankType().getName())){
		    return tanks[2].getMaxFill();
        }else if(type.getName().equals(tanks[3].getTankType().getName())){
		    return tanks[3].getMaxFill();
        } else{
		    return 0;
        }
	}

	@Override
	public void fillFluidInit(FluidTypeHandler.FluidType type) {
		fillFluid(xCoord + 1, yCoord, zCoord, getTact(), type);
		fillFluid(xCoord, yCoord, zCoord + 1, getTact(), type);
		fillFluid(xCoord, yCoord - 1, zCoord, getTact(), type);
		fillFluid(xCoord, yCoord + 1, zCoord, getTact(), type);
		fillFluid(xCoord - 1, yCoord, zCoord, getTact(), type);
		fillFluid(xCoord, yCoord, zCoord - 1, getTact(), type);

	}

	@Override
	public void fillFluid(int x, int y, int z, boolean newTact, FluidTypeHandler.FluidType type) {
		Lib.transmitFluid(x, y, z, newTact, this, worldObj, type);
	}

	@Override
	public boolean getTact() {
		return true;
	}

	@Override
	public List<IFluidAcceptor> getFluidList(FluidTypeHandler.FluidType type) {
		List<IFluidAcceptor> list = new ArrayList();
		return list;
	}

	@Override
	public void clearFluidList(FluidTypeHandler.FluidType type) {

	}

	@Override
	public void setFillstate(int fill, int index) {
		if(index < 4 && tanks[index] != null){
			tanks[index].setFill(fill);
		}
	}

	@Override
	public void setFluidFill(int fill, FluidTypeHandler.FluidType type) {
		if(type.getName().equals(tanks[0].getTankType().getName())){
			tanks[0].setFill(fill);
		} else if(type.getName().equals(tanks[1].getTankType().getName())){
			tanks[1].setFill(fill);
		}else if(type.getName().equals(tanks[2].getTankType().getName())){
			tanks[2].setFill(fill);
		}else if(type.getName().equals(tanks[3].getTankType().getName())){
			tanks[3].setFill(fill);
		}
	}

	@Override
	public void setType(FluidTypeHandler.FluidType type, int index) {
        if(index < 4 && tanks[index] != null){
            tanks[index].setTankType(type);
        }
	}

	@Override
	public List<FluidTank> getTanks() {
	    List<FluidTank> list = new ArrayList();
	    list.add(tanks[0]);
	    list.add(tanks[1]);
	    list.add(tanks[2]);
	    list.add(tanks[3]);
		return list;
	}

	@Override
	public int getFluidFill(FluidTypeHandler.FluidType type) {
		if(type.getName().equals(tanks[0].getTankType().getName())){
		    return tanks[0].getFill();
        } else if(type.getName().equals(tanks[1].getTankType().getName())){
		    return tanks[1].getFill();
        }else if(type.getName().equals(tanks[2].getTankType().getName())){
		    return tanks[2].getFill();
        }else if(type.getName().equals(tanks[3].getTankType().getName())){
		    return tanks[3].getFill();
        }else{
		    return 0;
        }
	}
}
