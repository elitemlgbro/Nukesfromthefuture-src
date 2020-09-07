package nukesfromthefuture.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import nukesfromthefuture.tileentity.explosion.TileAntitime;

public class AntiContainer extends Container{
	TileAntitime te;
	public AntiContainer(InventoryPlayer player, TileAntitime UwU) {
		te = UwU;
		this.addSlotToContainer(new Slot(UwU, 0, 38, 43));
		this.addSlotToContainer(new Slot(UwU, 1, 120, 42));
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
		}
	}
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		// TODO Auto-generated method stub
		return te.isUseableByPlayer(p_75145_1_);
	}

}
