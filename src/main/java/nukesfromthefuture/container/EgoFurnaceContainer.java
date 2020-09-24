package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import nukesfromthefuture.tileentity.TileEgoFurnace;

public class EgoFurnaceContainer extends Container {
    TileEgoFurnace eFurnace;
    public EgoFurnaceContainer(TileEgoFurnace UwU, InventoryPlayer player){
        eFurnace = UwU;
        addSlotToContainer(new Slot(UwU, 0, 8, 64));
        addSlotToContainer(new Slot(UwU, 1, 26, 64));
        addSlotToContainer(new Slot(UwU, 2, 33, 28));
        addSlotToContainer(new Slot(UwU, 3, 62, 20));
        addSlotToContainer(new SlotFurnace(player.player, UwU, 4, 118, 29));

        for(int period = 0; period < 3; period++){
            for(int group = 0; group < 9; group++){
                addSlotToContainer(new Slot(player, group + period * 9 + 9, 8 + group * 18, 84 + period * 18));
            }
        }for(int UmU = 0; UmU < 9; UmU++){
            addSlotToContainer(new Slot(player, UmU, 8 + UmU * 18, 142));
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return eFurnace.isUseableByPlayer(player);
    }

}
