package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import nukesfromthefuture.tileentity.TileEntityUnrefinery;

public class UnRefineryContainer extends Container{
	public TileEntityUnrefinery OwO;
	public UnRefineryContainer(InventoryPlayer invplayer, TileEntityUnrefinery UwU) {
		OwO = UwU;
		this.addSlotToContainer(new Slot(UwU, 0, 9, 52));
		this.addSlotToContainer(new Slot(UwU, 1, 75, 52));
		this.addSlotToContainer(new Slot(UwU, 2, 100, 52));
		this.addSlotToContainer(new Slot(UwU, 3, 125, 52));
		
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

}
