package nukesfromthefuture.container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import nukesfromthefuture.Spaghetti;
@Spaghetti("everything")
public class Slotnff extends Slot{
	public boolean slotLocked = false;
	int maxStack = 64;
	Item limit;
	Block blok;
	/**
	 *The mod's slot system
	 *lets slots only allow specific Items
	 *
	 *soooo, I have a message to items that don't belong in the slot
	 * GO AWAY SCRUBS, UR NOT ALLOWED IN DIS SLOT
	 * @param maxStacks the item stack size limit
	 * @param only this will allow only a specific item in a slot*
	  **/
	
	public Slotnff(IInventory inv, int id, int x, int y, int maxStacks,Item item) {
		super(inv, id, x, y);
		maxStack = maxStacks;
		limit = item;
	}
	public Slotnff(IInventory inv, int id, int x, int y, int maxStacks,Block blokk) {
		super(inv, id, x, y);
		maxStack = maxStacks;
		blok = blokk;
	}
	
	@Override 
	public boolean canTakeStack(EntityPlayer p_82869_1_)
    {
        return !slotLocked;
    }
	@Override
	public boolean isItemValid(ItemStack item)
    {
		if(item.getItem() == null) return false;
		if(slotLocked) return false;
		boolean itemOnly = item.getItem() == limit;
		boolean blokOnly = item.getItem() == Item.getItemFromBlock(blok);
		if(itemOnly || blokOnly) return true;
		return false;
    }
	public int getSlotStackLimit()
    {
        return maxStack;
    }
}
