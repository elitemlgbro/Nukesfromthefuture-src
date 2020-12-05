package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import nukesfromthefuture.tileentity.TileCore;

public class NukeReactorContainer extends Container {
    TileCore nukeUwU;
    public NukeReactorContainer(InventoryPlayer player, TileCore te){
        nukeUwU = te;
        //|                 |
        //|  Coolant Input  |
        //v                 v
        this.addSlotToContainer(new Slot(te, 0, 8, 78));
        //|                |
        //| Uranium Input  |
        //v                v
        this.addSlotToContainer(new Slot(te, 1, 29, 78));
        //coolant output
        this.addSlotToContainer(new Slot(te, 2, 49, 11));
        //uranium output
        this.addSlotToContainer(new Slot(te, 3, 49, 68));
        this.addSlotToContainer(new Slot(te, 4, 115, 23));
        this.addSlotToContainer(new Slot(te, 5, 115, 61));
        this.addSlotToContainer(new Slot(te, 6, 152, 78));

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++){
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 100 + i * 18));
            }
        }
        for(int i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 158));
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return nukeUwU.isUseableByPlayer(player);
    }
}
