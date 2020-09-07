package nukesfromthefuture;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class CoordEntry {
	private String name;
	private int x, y, z;
	private int dimension;
	public CoordEntry(String name, int x, int y, int z, int dimension) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
		this.dimension = dimension;
	}
	public String getName() {
		return name;
	}
	public int getDimension() {
		return dimension;
	}
	public int getPos(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}
	public void writeEntryToNBT(NBTTagCompound lol) {
		lol.setString("name", name);
		lol.setInteger("dim", dimension);
		lol.setInteger("x", x);
		lol.setInteger("y", y);
		lol.setInteger("z", z);
	}
	public static CoordEntry readEntryFromNBT(NBTTagCompound lol) {
		return new CoordEntry(lol.getString("name"), lol.getInteger("dim"), lol.getInteger("x"), lol.getInteger("y"), lol.getInteger("z"));
	}
}
