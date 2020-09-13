package nukesfromthefuture.boime;



import net.minecraft.init.Blocks;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
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
		cursedBiome = new CursedBiome(147).setBiomeName("cursed_biome").setColor(0xFF1139).setTemperatureRainfall(3.0F, 1F);
	}
	public static void register() {
	BiomeDictionary.registerBiomeType(cursedBiome, Type.FOREST);
	BiomeManager.addSpawnBiome(cursedBiome);
	BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(cursedBiome, 1));
	}
}
