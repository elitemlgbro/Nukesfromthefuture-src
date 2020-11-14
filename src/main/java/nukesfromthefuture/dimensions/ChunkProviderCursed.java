package nukesfromthefuture.dimensions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.boime.BiomeRegistry;
import nukesfromthefuture.boime.CursedBiome;
import nukesfromthefuture.entity.EntityPizzaCreeper;

public class ChunkProviderCursed implements IChunkProvider{
	World world;
	private final boolean mapFeaturesOn;
	public static BiomeGenBase biomesForGeneration;
	public ChunkProviderCursed(World worldObj, long seed, boolean b) {
		world = worldObj;
		mapFeaturesOn = b;
	}

	@Override
	public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
		return false;

	}

	@Override
	public Chunk provideChunk(int p_73154_1_, int p_73154_2_) {
		 Chunk a = new Chunk(world, new Block[]{Nukesfromthefuture.trololo}, p_73154_1_, p_73154_2_);

		return a;
	}

	@Override
	public Chunk loadChunk(int p_73158_1_, int p_73158_2_) {

		return null;
	}

	@Override
	public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {

	}

	@Override
	public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
		return false;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return false;
	}

	@Override
	public String makeString() {
		return null;
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
		return null;
	}

	@Override
	public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int p_82695_1_, int p_82695_2_) {

	}

	@Override
	public void saveExtraData() {

	}
}
