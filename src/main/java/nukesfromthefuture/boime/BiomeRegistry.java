package nukesfromthefuture.boime;



import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeRegistry {
	public static BiomeGenBase cursedBiome;

	public static void mainRegistry() {
		init();
		register();
	}
	public static void init() {
		cursedBiome = new Wasteland(147).setBiomeName("wasteland").setTemperatureRainfall(3.0F, 1F);
	}
	public static void register() {
		BiomeDictionary.registerBiomeType(cursedBiome, Type.WASTELAND, Type.MOUNTAIN);
		BiomeManager.addSpawnBiome(cursedBiome);
	BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(cursedBiome, 100));
	}
}
