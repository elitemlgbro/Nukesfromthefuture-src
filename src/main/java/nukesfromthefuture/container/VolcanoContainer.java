package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import nukesfromthefuture.tileentity.TileVolcano;

public class VolcanoContainer extends Container{
	public TileVolcano UwU;
	public VolcanoContainer(InventoryPlayer player, TileVolcano te) {
		UwU = te;
		this.addSlotToContainer(new Slot(te, 0, 74, 63));
		this.addSlotToContainer(new Slot(te, 1, 146, 59));
		this.addSlotToContainer(new SlotMachineOutput(te, 2, 146, 77));
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 100 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(player, i, 8 + i * 18, 158));
		}
	}
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		// TODO Auto-generated method stub
		return UwU.isUseableByPlayer(player);
	}

}
