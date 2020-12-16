package nukesfromthefuture.gen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.boime.BiomeRegistry;
import nukesfromthefuture.tileentity.NuclearReactorStructure;

import java.util.Random;

public class WorldGenInactiveReactor extends WorldGenerator {
    //I don't know if I did this right and I don't wanna know
    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {

            int i = rand.nextInt(1);
                //thank my bad thinking skills I added that function in the reactor structure class
        Block below = world.getBlock(x, y - 1, z);
        Block above = world.getBlock(x, y + 1, z);
            if(i == 0 && above == Blocks.air && below == Nukesfromthefuture.waste) {
                NuclearReactorStructure.setStructure(world, x, y + 4, z);
                //used to prevent the core from generating. I cannot delete the setBlock line for the core in NuclearReactorStructure because it is being shared with the reactor wand
                world.setBlockToAir(x, y + 4, z);
                //makes it actually look broken
                world.setBlockToAir(x, (y + 4) + 3, z);
                world.setBlockToAir(x, (y + 4) - 3, z - 2);
                world.setBlockToAir(x - 2, (y + 4) - 1, z);
                world.setBlockToAir(x, (y + 4) - 1, z - 2);
                world.setBlockToAir(x + 2, (y + 4)+ 2, z);

            }
            if(Nukesfromthefuture.developer_mode) {
                System.out.println("broken reactor successfully spawned at: " + x + ", " + y + ", " + z);
            }
        return true;
    }
}
