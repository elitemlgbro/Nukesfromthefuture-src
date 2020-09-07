package nukesfromthefuture.gen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import nukesfromthefuture.Nukesfromthefuture;

public class NffOreGeneration implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		}
	    }
		public void generateNether(World woorld, Random rrand, int x, int z) {
			
		}
		public void generateOverworld(World woorld, Random rrand, int x, int z) {
			generateOre(Nukesfromthefuture.copper_ore, woorld, rrand, x, z, 2, 7, 11, 0, 50, Blocks.stone);
			generateOre(Nukesfromthefuture.ego_ore, woorld, rrand, x, z, 1, 5, 10, 0, 70, Blocks.stone);
			generateOre(Nukesfromthefuture.plutonium_ore, woorld, rrand, x, z, 1, 5, 10, 0, 40, Blocks.stone);
			generateOre(Nukesfromthefuture.Deathinum_ore, woorld, rrand, x, z, 1, 2, 10, 0, 40, Blocks.stone);
		}
		public void generateEnd(World woorld, Random rrand, int x, int z) {
			
		}
		public void generateOre(Block block, World world, Random rand, int ChunkX, int ChunkZ, int minVienSize,
				int maxVienSize, int chance, int minY, int maxY, Block generateIn) {
			int vienSize = minVienSize + rand.nextInt(maxVienSize - minVienSize);
			int heightRange = maxY - minY;
			WorldGenMinable gen = new WorldGenMinable(block, vienSize, generateIn);
			for(int i = 0; i < chance; i++) {
				int xRand = ChunkX * 16 + rand.nextInt(16);
				int yRand = rand.nextInt(heightRange) + minY;
				int zRand = ChunkZ * 16 + rand.nextInt(16);
				gen.generate(world, rand, xRand, yRand, zRand);
			}
		}
}
