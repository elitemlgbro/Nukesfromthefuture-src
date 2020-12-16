package nukesfromthefuture.dimensions;

import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import nukesfromthefuture.boime.BiomeRegistry;

public class WorldProviderCursed extends WorldProvider{
	@Override
	protected void registerWorldChunkManager() {
		// TODO Auto-generated method stub
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeRegistry.cursedBiome, dimensionId);
		this.dimensionId = DimRegistry.DimID;
	}
	@Override
	public IChunkProvider createChunkGenerator() {
		// TODO Auto-generated method stub
		return new ChunkProviderCursed(worldObj, true);
	}
	@Override
	public String getDimensionName() {
		// TODO Auto-generated method stub
		return "the cursed dimension";
	}
	public boolean canRespawnHere()
    {
        return false;
    }

}
