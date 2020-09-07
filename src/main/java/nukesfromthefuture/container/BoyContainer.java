package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import nukesfromthefuture.tileentity.TileBigBoy;



public class BoyContainer extends Container {
    TileBigBoy OwO;
    public BoyContainer(InventoryPlayer player, TileBigBoy stuff){
        OwO = stuff;

            this.addSlotToContainer(new Slot(stuff, 0, 67, 29));
        this.addSlotToContainer(new Slot(stuff, 1, 67 + 18, 29));


        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++){
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }for(int i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(player,i, 8 + i * 18, 142));
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return OwO.isUseableByPlayer(player);
    }
}
