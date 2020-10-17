package nukesfromthefuture;

import net.minecraft.init.Blocks;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.ChunkProviderServer;

import java.util.Map;

public class ContaminationWorldHandler {
    public static void handleWorldDestruction(World world) {

        if(!(world instanceof WorldServer))
            return;

        WorldServer serv = (WorldServer)world;

        RadSaveData data = RadSaveData.getData(serv);
        ChunkProviderServer provider = (ChunkProviderServer) serv.getChunkProvider();

        int count = 50;//MainRegistry.worldRad;
        int threshold = 5;//MainRegistry.worldRadThreshold;

        Object[] entries = data.contamination.entrySet().toArray();

        if(entries.length == 0)
            return;

        Map.Entry<ChunkCoordIntPair, Float> randEnt = (Map.Entry<ChunkCoordIntPair, Float>) entries[world.rand.nextInt(entries.length)];

        ChunkCoordIntPair coords = randEnt.getKey();

        for(int i = 0; i < 1; i++) {


            if(randEnt == null || randEnt.getValue() < threshold)
                continue;

            if(provider.chunkExists(coords.chunkXPos, coords.chunkZPos)) {

                for(int a = 0; a < 16; a ++) {
                    for(int b = 0; b < 16; b ++) {

                        if(world.rand.nextInt(3) != 0)
                            continue;

                        int x = coords.getCenterXPos() - 8 + a;
                        int z = coords.getCenterZPosition() - 8 + b;
                        int y = world.getHeightValue(x, z) - world.rand.nextInt(2);

                        if(world.getBlock(x, y, z) == Blocks.grass) {
                            world.setBlock(x, y, z, Blocks.dirt);
                        } else if(world.getBlock(x, y, z) == Blocks.tallgrass) {
                            world.setBlock(x, y, z, Blocks.air);
                        } else if(world.getBlock(x, y, z) == Blocks.leaves) {
                            world.setBlock(x, y, z, Blocks.air);
                        } else if(world.getBlock(x, y, z) == Blocks.leaves2) {
                            world.setBlock(x, y, z, Blocks.air);
                        }
                    }
                }
            }
        }
    }
}
