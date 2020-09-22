package nukesfromthefuture.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.Nukesfromthefuture;

public class TilePOTATO extends TileEntity implements ISidedInventory {
	public ItemStack[] Slot;
	public TilePOTATO() {
		Slot = new ItemStack[5];
	}
	public boolean isReady() {
		// TODO Auto-generated method stub
		if(Slot[0] != null && Slot[1] != null && Slot[2] != null && Slot[3] != null && Slot[4] != null &&
				Slot[0].getItem() == Nukesfromthefuture.POTATO &&
				Slot[1].getItem() == Nukesfromthefuture.energy_extractor && 
				Slot[2].getItem() == Nukesfromthefuture.energy_extractor &&
				Slot[3].getItem() == Nukesfromthefuture.energy_extractor &&
				Slot[4].getItem() == Nukesfromthefuture.energy_extractor) {
			return true;
		}
		return false;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return Slot.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		// TODO Auto-generated method stub
		return Slot[i];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		// TODO Auto-generated method stub
		if (this.Slot[par1] != null)
		{
			ItemStack var3;
			
			if (this.Slot[par1].stackSize <= par2)
			{
				var3 = this.Slot[par1];
				this.Slot[par1] = null;
				return var3;
			}
			else
			{
				var3 = this.Slot[par1].splitStack(par2);
				
				if (this.Slot[par1].stackSize == 0)
				{
					this.Slot[par1] = null;
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
		this.Slot = new ItemStack[this.getSizeInventory()];
		
		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbt1 = nbttaglist.getCompoundTagAt(i);
			int j = nbt1.getByte("Slot") & 255;
			
			if (j >= 0 && j < this.Slot.length)
			{
				this.Slot[j] = ItemStack.loadItemStackFromNBT(nbt1);
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		NBTTagList nbttaglist = new NBTTagList();
		
		for (int i = 0; i < this.Slot.length; ++i)
		{
			if (this.Slot[i] != null)
			{
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte) i);
				this.Slot[i].writeToNBT(nbt1);
				nbttaglist.appendTag(nbt1);
			}
		}
	}
	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		if (this.Slot[p_70304_1_] != null)
		{
			ItemStack var2 = this.Slot[p_70304_1_];
			this.Slot[p_70304_1_] = null;
			return var2;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO Auto-generated method stub
		this.Slot[p_70299_1_] = p_70299_2_;
		
		if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
		{
			p_70299_2_.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return "POTATO Nuke";
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
	public boolean isUseableByPlayer(EntityPlayer playa) {
		// TODO Auto-generated method stub
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : playa.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
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
