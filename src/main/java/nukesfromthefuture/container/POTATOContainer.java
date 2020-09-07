package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.tileentity.TilePOTATO;

public class POTATOContainer extends Container{
	TilePOTATO te2;
	public POTATOContainer(InventoryPlayer invplaya, TilePOTATO POTATO) {
		te2 = POTATO;
		
		this.addSlotToContainer(new Slot(POTATO, 0, 80, 34));
		this.addSlotToContainer(new Slot(POTATO, 1, 26, 7));
		this.addSlotToContainer(new Slot(POTATO, 2, 26, 62));
		this.addSlotToContainer(new Slot(POTATO, 3, 133, 7));
		this.addSlotToContainer(new Slot(POTATO, 4, 133, 62));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++)
			{
				this.addSlotToContainer(new Slot(invplaya, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(invplaya, i, 8 + i * 18, 142));
		}
	}
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		// TODO Auto-generated method stub
		return te2.isUseableByPlayer(p_75145_1_);
	}
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		ItemStack previous = null;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < 5) {
	            // From TE Inventory to Player Inventory
	            if (!this.mergeItemStack(current, 5, 41, true))
	                return null;
	        } else {
	            // From Player Inventory to TE Inventory
	            if (!this.mergeItemStack(current, 0, 5, false))
	                return null;
	        }

	        if (current.stackSize == 0)
	            slot.putStack((ItemStack) null);
	        else
	            slot.onSlotChanged();

	        if (current.stackSize == previous.stackSize)
	            return null;
	        slot.onPickupFromSlot(playerIn, current);
	    }
	    return previous; 
	}

}
