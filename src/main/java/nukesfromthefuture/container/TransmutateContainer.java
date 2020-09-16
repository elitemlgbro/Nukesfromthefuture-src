package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import nukesfromthefuture.tileentity.TileTransMutate;

public class TransmutateContainer extends Container {
    TileTransMutate te;
    public TransmutateContainer(InventoryPlayer player, TileTransMutate entity){
        te = entity;
        this.addSlotToContainer(new Slot(entity,0, 41, 47));
        this.addSlotToContainer(new Slot(entity, 1, 10, 62));
        this.addSlotToContainer(new Slot(entity, 2, 129, 47));

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++)
            {
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int i = 0; i < 9; i++)
        {
            this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return te.isUseableByPlayer(player);
    }
}
