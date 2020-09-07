package nukesfromthefuture.boime;

import net.minecraft.world.biome.BiomeGenBase;
import nukesfromthefuture.Nukesfromthefuture;

public class CursedBiome extends BiomeGenBase{

	public CursedBiome(int p_i1971_1_) {
		super(p_i1971_1_);
		// TODO Auto-generated constructor stub
		this.topBlock = Nukesfromthefuture.trololo;
		this.fillerBlock = Nukesfromthefuture.Deathinum_ore;
		this.getBiomeGrassColor(0xFF11390, 0xFF1139, 0xFF1139);
		this.enableRain = true;
	}
	
}
