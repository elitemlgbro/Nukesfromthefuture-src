package nukesfromthefuture.tileentity;

import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;

public class NuclearReactorStructure {
    //can some1 please explain to me why the hell I'm using parameter annotations
    /**and I thought it was hard to setup the nether reactor's structure *laughs in -0 brain cells* hahahahah HAHAHAHAH
     * @param world The minecraft world that u must call using da tileEntity
     * @param x The x coordnate. Must be called using the tile entity
     * @param y The y coord. Must again be called using the tile entity
     * @param z I'm not gonna say it again*/
    public static boolean isValid(World world, int x, int y, int z){
        if(world.getBlock(x, y - 3, z) == Nukesfromthefuture.nuclear_stabilizer &&
           world.getBlock(x, y + 3, z) == Nukesfromthefuture.nuclear_stabilizer &&
           world.getBlock(x + 1, y + 3, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x + 1, y - 3, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x - 1, y + 3, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x - 1, y - 3, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y + 3, z + 1) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y + 3, z - 1) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y - 3, z + 1) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y - 3, z - 1) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x + 2, y + 3, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x - 2, y + 3, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x + 2, y - 3, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x - 2, y - 3, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y + 3, z + 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y + 3, z - 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y - 3, z + 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y - 3, z - 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x + 2, y + 2, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x + 2, y + 1, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x - 2, y + 1, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x + 2, y, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x + 2, y - 1, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x + 2, y - 2, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x - 2, y + 2, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x - 2, y - 1, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x - 2, y, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x - 2, y - 1, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x - 2, y - 2, z) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y + 2, z + 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y + 1, z + 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y, z + 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y - 1, z + 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y - 2, z + 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y + 2, z - 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y + 1, z - 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y, z - 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y - 1, z - 2) == Nukesfromthefuture.energy_coils &&
           world.getBlock(x, y - 2, z - 2) == Nukesfromthefuture.energy_coils
        ) return true;
        return false;
    }
    public static void setStructure(World world, int x, int y, int z){
                    world.setBlock(x, y, z, Nukesfromthefuture.nuclear_core, 0, 3);
                    world.setBlock(x, y - 3, z, Nukesfromthefuture.nuclear_stabilizer, 0, 3);
                    world.setBlock(x, y + 3, z, Nukesfromthefuture.nuclear_stabilizer, 0, 3);
                    world.setBlock(x + 1, y + 3, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x + 1, y - 3, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x - 1, y + 3, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x - 1, y - 3, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y + 3, z + 1, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y + 3, z - 1, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y - 3, z + 1, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y - 3, z - 1, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x + 2, y + 3, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x - 2, y + 3, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x + 2, y - 3, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x - 2, y - 3, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y + 3, z + 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y + 3, z - 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y - 3, z + 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y - 3, z - 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x + 2, y + 2, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x + 2, y + 1, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x + 2, y, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x - 2, y + 1, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x + 2, y - 1, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x + 2, y - 2, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x - 2, y + 2, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x - 2, y - 1, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x - 2, y, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x - 2, y - 1, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x - 2, y - 2, z, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y + 2, z + 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y + 1, z + 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y, z + 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y - 1, z + 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y - 2, z + 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y + 2, z - 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y + 1, z - 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y, z - 2, Nukesfromthefuture.energy_coils, 0, 3);
                    world.setBlock(x, y - 1, z - 2, Nukesfromthefuture.energy_coils, 0 ,3);
                    world.setBlock(x, y - 2, z - 2, Nukesfromthefuture.energy_coils, 0, 3);

    }
}
