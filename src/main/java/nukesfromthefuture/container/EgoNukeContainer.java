package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.items.ItemEgo_ingot;
import nukesfromthefuture.items.ItemMyEgo;
import nukesfromthefuture.items.ItemPoorlyDrawnFuse;
import nukesfromthefuture.tileentity.TileEntityEgo_nuke;

public class EgoNukeContainer extends Container{
	private TileEntityEgo_nuke entity;
	public EgoNukeContainer(InventoryPlayer playerInv, TileEntityEgo_nuke te) {
		entity = te;
		this.addSlotToContainer(new Slotnff(te, 0, 41, 40,  1, Nukesfromthefuture.ego_ingot));
		this.addSlotToContainer(new Slotnff(te, 1, 77, 40, 1, Nukesfromthefuture.poorly_drawn_fuse));
		this.addSlotToContainer(new Slotnff(te, 2, 117, 40, 1, Nukesfromthefuture.my_ego));
		
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 9 + j * 18, 93 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(playerInv, i, 9 + i * 18, 151));
		}
		
	}
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return entity.isUseableByPlayer(player);
		
	}
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		ItemStack previous = null;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < 3) {
	            // From TE Inventory to Player Inventory
	            if (!this.mergeItemStack(current, 3, 39, true))
	                return null;
	        } else {
	            // From Player Inventory to TE Inventory
	            if (!this.mergeItemStack(current, 0, 3, false))
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
