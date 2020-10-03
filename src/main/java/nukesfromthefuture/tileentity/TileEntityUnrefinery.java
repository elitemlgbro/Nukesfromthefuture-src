package nukesfromthefuture.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.container.FluidTank;
import nukesfromthefuture.handler.FluidTypeHandler;
import nukesfromthefuture.interfaces.IFluidAcceptor;
import nukesfromthefuture.interfaces.IFluidContainer;
import nukesfromthefuture.interfaces.IFluidSource;

import java.util.List;

public class TileEntityUnrefinery extends TileEntity implements ISidedInventory, IFluidContainer, IFluidAcceptor, IFluidSource{
	public ItemStack slots[];
	public static FluidTank tanks[];
	public TileEntityUnrefinery(){
		slots = new ItemStack[4];
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
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO Auto-generated method stub
		
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
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaxFluidFill(FluidTypeHandler.FluidType type) {
		return 0;
	}

	@Override
	public void fillFluidInit(FluidTypeHandler.FluidType type) {

	}

	@Override
	public void fillFluid(int x, int y, int z, boolean newTact, FluidTypeHandler.FluidType type) {

	}

	@Override
	public boolean getTact() {
		return false;
	}

	@Override
	public List<IFluidAcceptor> getFluidList(FluidTypeHandler.FluidType type) {
		return null;
	}

	@Override
	public void clearFluidList(FluidTypeHandler.FluidType type) {

	}

	@Override
	public void setFillstate(int fill, int index) {

	}

	@Override
	public void setFluidFill(int fill, FluidTypeHandler.FluidType type) {

	}

	@Override
	public void setType(FluidTypeHandler.FluidType type, int index) {

	}

	@Override
	public List<FluidTank> getTanks() {
		return null;
	}

	@Override
	public int getFluidFill(FluidTypeHandler.FluidType type) {
		return 0;
	}
}
