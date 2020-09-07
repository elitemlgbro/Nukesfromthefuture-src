package nukesfromthefuture.container;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.ItemFluidIdentifier;
import nukesfromthefuture.guiLoader.GuiInfoContainer;
import nukesfromthefuture.handler.FluidTypeHandler.FluidType;
import nukesfromthefuture.packet.PacketDispatcher;
import nukesfromthefuture.packet.TEFluidPacket;

public class FluidTank {
	FluidType type;
	int fluid;
	int maxFluid;
	public int index;
	public static int x = 16;
	public static int y = 100;
	
	public FluidTank(FluidType type, int maxFluid, int index) {
		this.type = type;
		this.maxFluid = maxFluid;
		this.index = index;
	}
	
	public void setFill(int i) {
		fluid = i;
	}
	
	public void setTankType(FluidType type) {
		
		if(this.type.name().equals(type.name()))
			return;
		
		this.type = type;
		this.setFill(0);
	}
	
	public FluidType getTankType() {
		
		return type;
	}
	
	public int getFill() {
		return fluid;
	}
	
	public int getMaxFill() {
		return maxFluid;
	}
	
	public int changeTankSize(int size) {
		maxFluid = size;
		
		if(fluid > maxFluid) {
			int dif = fluid - maxFluid;
			fluid = maxFluid;
			return dif;
		}
			
		return 0;
	}
	
	//Called on TE update
	public void updateTank(int x, int y, int z, int dim) {

		PacketDispatcher.wrapper.sendToAllAround(new TEFluidPacket(x, y, z, fluid, index, type), new TargetPoint(dim, x, y, z, 100));
	}
	
	//Fills tank from canisters
	public void loadTank(int in, int out, ItemStack[] slots) {
		
		FluidType inType = FluidType.None;
		if(slots[in] != null) {
			inType = FluidContainerRegistry.getFluidType(slots[in]);
			
		
			
			if(FluidContainerRegistry.getFluidContent(slots[in], type) <= 0)
				return;
		} else {
			return;
		}
		
		if(slots[in] != null && inType.name().equals(type.name()) && fluid + FluidContainerRegistry.getFluidContent(slots[in], type) <= maxFluid) {
			if(slots[out] == null) {
				fluid += FluidContainerRegistry.getFluidContent(slots[in], type);
				slots[out] = FluidContainerRegistry.getEmptyContainer(slots[in]);
				slots[in].stackSize--;
				if(slots[in].stackSize <= 0)
					slots[in] = null;
			} else if(slots[out] != null && slots[out].getItem() == FluidContainerRegistry.getEmptyContainer(slots[in]).getItem() && slots[out].stackSize < slots[out].getMaxStackSize()) {
				fluid += FluidContainerRegistry.getFluidContent(slots[in], type);
				slots[in].stackSize--;
				if(slots[in].stackSize <= 0)
					slots[in] = null;
				slots[out].stackSize++;
			}
		}
	}
	
	//Fills canisters from tank
	public void unloadTank(int in, int out, ItemStack[] slots) {

		
			
			
			
	
	}
	
	//Changes tank type
	public void setType(int in, int out, ItemStack[] slots) {
		
		if(slots[in] != null && slots[out] == null && slots[in].getItem() instanceof ItemFluidIdentifier) {
			FluidType newType = ItemFluidIdentifier.getType(slots[in].copy());
			if(!type.name().equals(newType.name())) {
				type = newType;
				slots[out] = slots[in].copy();
				slots[in] = null;
				fluid = 0;
			}
		}
	}
	
	//Used in the GUI rendering, renders correct fluid type in container with progress
	public void renderTank(GuiContainer gui, int x, int y, int tx, int ty, int width, int height) {
		
		int i = (fluid * height) / maxFluid;
		gui.drawTexturedModalRect(x, y - i, tx, ty - i, width, i);
	}

	public void renderTankInfo(GuiContainer gui, int mouseX, int mouseY, int x, int y, int width, int height) {
		if(gui instanceof GuiInfoContainer)
			renderTankInfo((GuiInfoContainer)gui, mouseX, mouseY, x, y, width, height);
	}
	
	public void renderTankInfo(GuiInfoContainer gui, int mouseX, int mouseY, int x, int y, int width, int height) {
		if(x <= mouseX && x + width > mouseX && y < mouseY && y + height >= mouseY)
			gui.drawFluidInfo(new String[] { I18n.format(this.type.getUnlocalizedName()), fluid + "/" + maxFluid + "mB" }, mouseX, mouseY);
	}
	
	public ResourceLocation getSheet() {
		return new ResourceLocation("nff:textures/gui/fluids" + this.type.getSheetID() + ".png");
	}

	//Called by TE to save fillstate
	public void writeToNBT(NBTTagCompound nbt, String s) {
		nbt.setInteger(s, fluid);
		nbt.setInteger(s + "_max", maxFluid);
		nbt.setString(s + "_type", type.getName());
	}
	
	//Called by TE to load fillstate
	public void readFromNBT(NBTTagCompound nbt, String s) {
		fluid = nbt.getInteger(s);
		int max = nbt.getInteger(s + "_max");
		if(max > 0)
			maxFluid = nbt.getInteger(s + "_max");
		type = FluidType.getEnum(nbt.getInteger(s + "_type"));
		if(type.name().equals(FluidType.None.name()))
			type = FluidType.getEnumFromName(nbt.getString(s + "_type"));
	}
}
