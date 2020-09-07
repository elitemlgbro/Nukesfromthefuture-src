package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import nukesfromthefuture.tileentity.TileBeta;

public class BataContainer extends Container{
	TileBeta ono;
	public BataContainer(TileBeta UwU, InventoryPlayer playaaaaaaaaa) {
		ono = UwU;
		this.addSlotToContainer(new Slot(UwU, 0, 24, 20));
		this.addSlotToContainer(new Slot(UwU, 1, 79, 61));
		this.addSlotToContainer(new Slot(UwU, 2, 130, 20));
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				this.addSlotToContainer(new Slot(playaaaaaaaaa, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(playaaaaaaaaa, i, 8 + i * 18, 142));
		}
	}
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		// TODO Auto-generated method stub
		return ono.isUseableByPlayer(player);
	}

}
