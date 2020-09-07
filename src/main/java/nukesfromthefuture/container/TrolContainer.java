package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import nukesfromthefuture.tileentity.TileTrol;

public class TrolContainer extends Container{
	TileTrol UmU;
	public TrolContainer(TileTrol UwU, InventoryPlayer player) {
		UmU = UwU;
		this.addSlotToContainer(new Slot(UwU, 0, 19, 15));
		this.addSlotToContainer(new Slot(UwU, 1, 19, 33));
		this.addSlotToContainer(new Slot(UwU, 2, 134, 65));
		this.addSlotToContainer(new Slot(UwU, 3, 152, 65));
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}for(int k = 0; k < 9; k++) {
			this.addSlotToContainer(new Slot(player, k, 8 + k * 18, 142));
		}

	}
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		// TODO Auto-generated method stub
		return UmU.isUseableByPlayer(p_75145_1_);
	}

}
