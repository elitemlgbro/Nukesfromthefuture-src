package nukesfromthefuture.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import nukesfromthefuture.Nukesfromthefuture;

public class TileEntityEgo_nuke extends TileEntity implements ISidedInventory{
	private ItemStack[]	slots;
	public TileEntityEgo_nuke() {
		slots = new ItemStack[3];
	}
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int parWuteverNamingParametersTheProperWayIsUseless) {
		// TODO Auto-generated method stub
		return slots[parWuteverNamingParametersTheProperWayIsUseless];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.slots[par1] != null)
		{
			ItemStack var3;
			
			if (this.slots[par1].stackSize <= par2)
			{
				var3 = this.slots[par1];
				this.slots[par1] = null;
				return var3;
			}
			else
			{
				var3 = this.slots[par1].splitStack(par2);
				
				if (this.slots[par1].stackSize == 0)
				{
					this.slots[par1] = null;
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
		this.slots = new ItemStack[this.getSizeInventory()];
		
		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbt1 = nbttaglist.getCompoundTagAt(i);
			int j = nbt1.getByte("Slot") & 255;
			
			if (j >= 0 && j < this.slots.length)
			{
				this.slots[j] = ItemStack.loadItemStackFromNBT(nbt1);
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		NBTTagList nbttaglist = new NBTTagList();
		
		for (int i = 0; i < this.slots.length; ++i)
		{
			if (this.slots[i] != null)
			{
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(nbt1);
				nbttaglist.appendTag(nbt1);
			}
		}
	}
	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		// TODO Auto-generated method stub
		if (this.slots[par1] != null)
		{
			ItemStack var2 = this.slots[par1];
			this.slots[par1] = null;
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
		this.slots[par1] = par2ItemStack;
		
		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
		{
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}
	
	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return "Ego nuke";
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
	//we ain't need these scrubs
	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
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
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}
	//but we do need these
	

	

	public void clearSlots() {
		for(int i = 0; i < slots.length; i++)
		{
			slots[i] = null;
		}
		
	}

	public boolean isReady() {
			
		if(slots[0] != null && slots[1] != null && slots[2] != null)
			if(slots[0].getItem() == Nukesfromthefuture.ego_ingot && 
			slots[1].getItem() == Nukesfromthefuture.poorly_drawn_fuse && 
			slots[2].getItem() == Nukesfromthefuture.my_ego) {
		return true;
			}
		return false;
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
	public boolean canInsertItem(int par1, ItemStack stack, int p_102007_3_) {
		// TODO Auto-generated method stub
		return this.isItemValidForSlot(par1, stack);
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		// TODO Auto-generated method stub
		return false;
	}
	
}