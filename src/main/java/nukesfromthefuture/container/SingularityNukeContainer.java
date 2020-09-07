package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.items.Blak_whole;
import nukesfromthefuture.items.ItemFluidTank;
import nukesfromthefuture.items.ItemPoorlyDrawnFuse;
import nukesfromthefuture.items.Magnet;
import nukesfromthefuture.tileentity.TileEntityEgo_nuke;
import nukesfromthefuture.tileentity.TileEntitySingularityNuke;

public class SingularityNukeContainer extends Container {
	public TileEntitySingularityNuke owo;
	public SingularityNukeContainer(InventoryPlayer playerInv, TileEntitySingularityNuke te) {
		owo = te;
		addSlotToContainer(new Slotnff(te, 0, 35, 18, 1, Nukesfromthefuture.black_hole));
		addSlotToContainer(new Slotnff(te, 1, 35, 58, 1, Nukesfromthefuture.black_hole));
		addSlotToContainer(new Slotnff(te, 2, 77, 37, 1, Nukesfromthefuture.singularity_magnet));
		addSlotToContainer(new Slotnff(te, 3, 119, 18, 1, Nukesfromthefuture.black_hole));
		addSlotToContainer(new Slotnff(te, 4, 119, 58, 1, Nukesfromthefuture.black_hole));
		this.addSlotToContainer(new Slotnff(te, 5, 147, 58, 64, Nukesfromthefuture.fluid_barrel_full));
		this.addSlotToContainer(new SlotMachineOutput(te, 6, 7, 30));


		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 6 + j * 18, 83 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(playerInv, i, 6 + i * 18, 141));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		// TODO Auto-generated method stub
		return owo.isUseableByPlayer(player);
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
