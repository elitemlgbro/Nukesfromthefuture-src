package nukesfromthefuture;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import nukesfromthefuture.handler.FluidTypeHandler.FluidType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import nukesfromthefuture.container.FluidContainer;
import nukesfromthefuture.container.FluidContainerRegistry;

public class MachineRecipes {
	public MachineRecipes() {

	}

	public static MachineRecipes instance() {
		return new MachineRecipes();
	}

	public Map<Object, Object> getFluidContainers() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		for(FluidContainer con : FluidContainerRegistry.allContainers) {
			if(con != null) {
				ItemStack fluid = new ItemStack(Nukesfromthefuture.fluid_icon, 1, Arrays.asList(FluidType.values()).indexOf(con.type));
				fluid.stackTagCompound = new NBTTagCompound();
				fluid.stackTagCompound.setInteger("fill", con.content);
				map.put(fluid, con.fullContainer);
			}
		}
		
		return map;
	}
}
