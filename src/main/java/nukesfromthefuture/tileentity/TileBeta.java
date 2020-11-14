package nukesfromthefuture.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.items.ItemRod;
import nukesfromthefuture.items.RodTypeHandler.RodType;

public class TileBeta extends TileEntity implements ISidedInventory{
	public ItemStack[] slots;
	public TileBeta() {
		slots = new ItemStack[3];
	}
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int par1) {
		// TODO Auto-generated method stub
		return slots[par1];
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
	public AxisAlignedBB getRenderBoundingBox() {
		return TileEntity.INFINITE_EXTENT_AABB;
	}

	@Override
	public double getMaxRenderDistanceSquared() {
		return 6500D;
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
		return "container.Beta";
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		if(worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
		{
			return false;
		}else{
			return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <=64;
		}	}

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
	public boolean isReady() {
		if(slots[0] != null && slots[1] != null && slots[2] != null && slots[1].getItem() instanceof ItemRod && slots[0].getItem() == Nukesfromthefuture.energy_extractor && slots[2].getItem() == Nukesfromthefuture.energy_extractor)return true;
		return false;
	}
	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		// TODO Auto-generated method stub
		return true;
	}

}
