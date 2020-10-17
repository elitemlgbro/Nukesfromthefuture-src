package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import nukesfromthefuture.tileentity.TileDeathBomb;

public class DeathinumContainer extends Container {
    public TileDeathBomb tdb;
    public DeathinumContainer(InventoryPlayer player, TileDeathBomb te){
        tdb = te;
        this.addSlotToContainer(new Slot(te, 0, 71, 13));
        this.addSlotToContainer(new Slot(te, 1, 71, 61));

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++){
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for(int i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
        }
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
                if (!this.mergeItemStack(current, 2, 38, true))
                    return null;
            } else {
                // From Player Inventory to TE Inventory
                if (!this.mergeItemStack(current, 0, 2, false))
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

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tdb.isUseableByPlayer(player);
    }
}
