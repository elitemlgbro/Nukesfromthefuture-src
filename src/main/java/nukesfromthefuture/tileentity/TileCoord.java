package nukesfromthefuture.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.CoordEntry;

public class TileCoord extends TileEntity {
	List<CoordEntry> teleports = new ArrayList<CoordEntry>();
	
	public void addEntry(String name, ItemStack lol) {
		NBTTagCompound nbt = (NBTTagCompound) lol.getTagCompound().getTag("coords");
		int dim = nbt.getInteger("dim");
		int posX = nbt.getInteger("posX");
		int posY = nbt.getInteger("posY");
		int posZ = nbt.getInteger("posZ");
		teleports.add(new CoordEntry(name, dim, posX, posY, posZ));
	}
	public CoordEntry getEntry(int i) {
		if(i < teleports.size()) {
			return teleports.get(i);
		}
		return null;
	}

	public void deleteEntry(int i) {
		if(i < teleports.size()) {
			teleports.remove(i);
		}
	}
	@Override
	public void readFromNBT(NBTTagCompound comp) { 
		teleports = new ArrayList<CoordEntry>();
		NBTTagList entryList = (NBTTagList) comp.getTag("lols");
		for(int i = 0; i < entryList.tagCount(); i++) {
			NBTTagCompound lol = entryList.getCompoundTagAt(i);
			CoordEntry entry = CoordEntry.readEntryFromNBT(lol);
			teleports.add(entry);
		}
		super.readFromNBT(comp);
	}
	@Override
	public void writeToNBT(NBTTagCompound comp) {
		// TODO Auto-generated method stub
		super.writeToNBT(comp);
		NBTTagList entryList = new NBTTagList();
		for(CoordEntry entry : teleports) {
			NBTTagCompound lol = new NBTTagCompound();
			entry.writeEntryToNBT(lol);
			entryList.appendTag(lol);
		}
		comp.setTag("lols", entryList);
	}
}
