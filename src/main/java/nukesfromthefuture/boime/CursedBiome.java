package nukesfromthefuture.boime;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import nukesfromthefuture.Nukesfromthefuture;

import java.util.Random;

public class CursedBiome extends BiomeGenBase{
	private static World worldObj;
	Random random;
	public CursedBiome(int p_i1971_1_) {
		super(p_i1971_1_);
		// TODO Auto-generated constructor stub
		this.topBlock = Nukesfromthefuture.trololo;
		this.fillerBlock = Nukesfromthefuture.Deathinum_ore;
		this.getBiomeGrassColor(0xFF11390, 0xFF1139, 0xFF1139);
		this.enableRain = true;

	}

	
}
