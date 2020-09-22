package nukesfromthefuture.tileentity.explosion;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.Nukesfromthefuture;

public class TileAntitime extends TileEntity implements ISidedInventory{
	ItemStack[] slot;
	private String customName;
	public TileAntitime() {
		slot = new ItemStack[2];
	}
	public boolean isReady(){
		if(slot[0] != null && slot[1] != null &&
				slot[0].getItem() == Nukesfromthefuture.anti_time_ingot &&
				slot[1].getItem() == Nukesfromthefuture.anti_time_ingot) 
			return true;
		return false;
		}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return slot.length;
	}

	@Override
	public ItemStack getStackInSlot(int ee) {
		// TODO Auto-generated method stub
		return slot[ee];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		// TODO Auto-generated method stub
		if (this.slot[par1] != null)
		{
			ItemStack var3;
			
			if (this.slot[par1].stackSize <= par2)
			{
				var3 = this.slot[par1];
				this.slot[par1] = null;
				return var3;
			}
			else
			{
				var3 = this.slot[par1].splitStack(par2);
				
				if (this.slot[par1].stackSize == 0)
				{
					this.slot[par1] = null;
				}
				
				return var3;
			}
		}
		else
		{
			return null;
		}
	}
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		this.slot = new ItemStack[this.getSizeInventory()];
		
		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbt1 = nbttaglist.getCompoundTagAt(i);
			int j = nbt1.getByte("Slot") & 255;
			
			if (j >= 0 && j < this.slot.length)
			{
				this.slot[j] = ItemStack.loadItemStackFromNBT(nbt1);
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		NBTTagList nbttaglist = new NBTTagList();
		
		for (int i = 0; i < this.slot.length; ++i)
		{
			if (this.slot[i] != null)
			{
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte) i);
				this.slot[i].writeToNBT(nbt1);
				nbttaglist.appendTag(nbt1);
			}
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		if (this.slot[p_70304_1_] != null)
		{
			ItemStack var2 = this.slot[p_70304_1_];
			this.slot[p_70304_1_] = null;
			return var2;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		// TODO Auto-generated method stub
		this.slot[par1] = par2ItemStack;
		
		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
		{
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return this.hasCustomInventoryName() ? this.customName : "container.antiTime";
	}
	public void setCustomName(String name) {
		this.customName = name;
	}
	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return this.customName != null && this.customName.length() > 0;
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
		}
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
		return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		// TODO Auto-generated method stub
		return false;
	}

}
