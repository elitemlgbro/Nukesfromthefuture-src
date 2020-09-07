package nukesfromthefuture.dimensions;

import net.minecraft.world.WorldProviderHell;
import net.minecraftforge.common.DimensionManager;

public class DimRegistry {
	
	public static final int DimID = -2;
	public static void mainRegistry() {
		registerDimension();
	}
	public static void registerDimension() {
		DimensionManager.registerProviderType(DimID, WorldProviderCursed.class, false);
		DimensionManager.registerDimension(DimID, DimID);
	}
}
