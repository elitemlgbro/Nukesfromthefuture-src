package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import nukesfromthefuture.tileentity.TileEntityUnrefinery;

public class UnRefineryContainer extends Container{
	public TileEntityUnrefinery OwO;
	public UnRefineryContainer(InventoryPlayer invplayer, TileEntityUnrefinery UwU) {
		OwO = UwU;
		this.addSlotToContainer(new Slot(UwU, 0, 9, 52));
		this.addSlotToContainer(new Slot(UwU, 1, 75, 52));
		this.addSlotToContainer(new Slot(UwU, 2, 100, 52));
		this.addSlotToContainer(new Slot(UwU, 3, 125, 52));
		this.addSlotToContainer(new Slot(UwU, 4, 27, 52));
		this.addSlotToContainer(new Slot(UwU, 5, 153, 7));
		this.addSlotToContainer(new Slot(UwU, 6, 153, 7 + 18));
		this.addSlotToContainer(new Slot(UwU, 7, 153, 7 + 36));
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				this.addSlotToContainer(new Slot(invplayer, j + i * 9 + 9, 9 + j * 18, 81 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(invplayer, i, 9 + i * 18, 139));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		// TODO Auto-generated method stub
		return OwO.isUseableByPlayer(player);
	}
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int uh) {
		ItemStack previous = null;
		Slot slot = (Slot) this.inventorySlots.get(uh);

		if (slot != null && slot.getHasStack()) {
			ItemStack current = slot.getStack();
			previous = current.copy();

			if (uh < 2) {
				// From TE Inventory to Player Inventory
				if (!this.mergeItemStack(current, 8, 44, true))
					return null;
			} else {
				// From Player Inventory to TE Inventory
				if (!this.mergeItemStack(current, 0, 8, false))
					return null;
			}

			if (current.stackSize == 0)
				slot.putStack((ItemStack) null);
			else
				slot.onSlotChanged();

			if (current.stackSize == previous.stackSize)
				return null;
			slot.onPickupFromSlot(player, current);
		}
		return previous;
	}
}
