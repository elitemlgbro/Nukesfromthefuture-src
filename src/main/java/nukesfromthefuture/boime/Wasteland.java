package nukesfromthefuture.boime;

import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.EntityCreeperPig;
import nukesfromthefuture.entity.EntityRadioCreeper;
import nukesfromthefuture.gen.DedTreeGen;

import java.util.Random;

public class Wasteland extends BiomeGenBase{
	private static World worldObj;
	Random random;
	//WHAT MONSTROSITY DID I CREATE THIS TIME!?
	public Wasteland(int p_i1971_1_) {
		super(p_i1971_1_);
		// TODO Auto-generated constructor stub
		this.topBlock = Nukesfromthefuture.waste;
		this.fillerBlock = Blocks.dirt;
		this.setColor(0x007F0E);
		this.theBiomeDecorator.sandPerChunk = 2;
		this.theBiomeDecorator.bigMushroomsPerChunk = 1;
		this.theBiomeDecorator.treesPerChunk = 8;
		this.waterColorMultiplier = 0x027C00;
		this.getBiomeGrassColor(0xFF11390, 0xFF1139, 0xFF1139);
		this.enableRain = true;
 		this.theBiomeDecorator.deadBushPerChunk = 3;
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityMooshroom.class, 9, 1, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCreeperPig.class, 3, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityRadioCreeper.class, 5, 1, 4));
	}
	@Override
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x027C00;
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
		return new DedTreeGen(false, 6, 0, 7, false);
	}
}
