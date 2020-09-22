package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import nukesfromthefuture.tileentity.TileEntitySkinnyMan;


public class ManContainer extends Container{
    TileEntitySkinnyMan QwQ;
    public ManContainer(InventoryPlayer playa, TileEntitySkinnyMan UwU){
        QwQ = UwU;
        addSlotToContainer(new Slot(UwU, 0, 83, 33));
        addSlotToContainer(new Slot(UwU, 1, 101, 33));

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++){
                addSlotToContainer(new Slot(playa, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for(int i = 0; i < 9; i++){
            addSlotToContainer(new Slot(playa, i, 8 + i * 18, 142));
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return QwQ.isUseableByPlayer(player);
    }
}
