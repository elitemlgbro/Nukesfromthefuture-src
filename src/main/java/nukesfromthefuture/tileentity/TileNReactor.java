package nukesfromthefuture.tileentity;

import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;

public class TileNReactor extends TileEntity{
    public boolean isValid(){
        if(worldObj.getBlock(xCoord, yCoord - 1, zCoord) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord + 1, yCoord - 1, zCoord) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord - 1, yCoord - 1, zCoord) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord, yCoord - 1, zCoord + 1) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord, yCoord - 1, zCoord - 1) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord + 1, yCoord - 1, zCoord + 1) == Blocks.gold_block &&
                worldObj.getBlock(xCoord + 1, yCoord - 1, zCoord - 1) == Blocks.gold_block &&
                worldObj.getBlock(xCoord - 1, yCoord - 1, zCoord + 1) == Blocks.gold_block &&
                worldObj.getBlock(xCoord - 1, yCoord - 1, zCoord - 1) == Blocks.gold_block &&
                worldObj.getBlock(xCoord + 1, yCoord, zCoord + 1) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord + 1, yCoord, zCoord - 1) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord - 1, yCoord, zCoord + 1) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord -1, yCoord, zCoord - 1) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord, yCoord + 1, zCoord) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord + 1, yCoord + 1, zCoord) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord - 1, yCoord + 1, zCoord) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord, yCoord + 1, zCoord + 1) == Blocks.cobblestone &&
                worldObj.getBlock(xCoord, yCoord + 1, zCoord - 1) == Blocks.cobblestone) return true;
        return false;
    }

    public void buildSpire(World world, int x, int y, int z) {
        for (int i = 0; i < 20; i++) {
            world.setBlock(x + i, y - 2, z + 20, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 19, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 18, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 17, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 16, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 15, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 14, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 13, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 12, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 11, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 10, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 9, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 8, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 7, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 6, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 5, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 4, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 3, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 2, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z + 1, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 20, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 19, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 18, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 17, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 16, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 15, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 14, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 13, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 12, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 11, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 10, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 9, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 8, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 7, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 6, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 5, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 4, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 3, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 2, Blocks.netherrack);
            world.setBlock(x + i, y - 2, z - 1, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 20, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 19, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 18, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 17, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 16, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 15, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 14, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 13, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 12, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 11, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 10, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 9, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 8, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 7, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 6, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 5, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 4, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 3, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 2, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z + 1, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 20, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 19, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 18, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 17, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 16, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 15, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 14, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 13, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 12, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 11, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 10, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 9, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 8, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 7, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 6, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 5, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 4, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 3, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 2, Blocks.netherrack);
            world.setBlock(x - i, y - 2, z - 1, Blocks.netherrack);
            world.setBlock(x, y - 2, z, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 20, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 19, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 18, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 17, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 16, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 15, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 14, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 13, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 12, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 11, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 10, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 9, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 8, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 7, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 6, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 5, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 4, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 3, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 2, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z + 1, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 20, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 19, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 18, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 17, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 16, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 15, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 14, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 13, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 12, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 11, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 10, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 9, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 8, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 7, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 6, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 5, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 4, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 3, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 2, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z - 1, Blocks.netherrack);
            world.setBlock(x + 20, (y - 2) + i, z, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 20, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 19, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 18, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 17, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 16, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 15, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 14, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 13, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 12, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 11, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 10, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 9, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 8, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 7, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 6, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 5, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 4, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 3, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 2, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z + 1, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 20, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 19, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 18, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 17, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 16, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 15, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 14, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 13, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 12, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 11, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 10, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 9, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 8, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 7, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 6, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 5, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 4, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 3, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 2, Blocks.netherrack);
            world.setBlock(x - 20, (y - 2) + i, z - 1, Blocks.netherrack);

        }

    }
    public void spawnEntites(World world){

        world.spawnEntityInWorld(new EntityPigZombie(world));
        world.spawnEntityInWorld(new EntityPigZombie(world));
        world.spawnEntityInWorld(new EntityPigZombie(world));
        world.spawnEntityInWorld(new EntityPigZombie(world));
        world.spawnEntityInWorld(new EntityPigZombie(world));
        world.spawnEntityInWorld(new EntityPigZombie(world));
        world.spawnEntityInWorld(new EntityPigZombie(world));
        world.spawnEntityInWorld(new EntityPigZombie(world));
        world.spawnEntityInWorld(new EntityPigZombie(world));
        world.spawnEntityInWorld(new EntityPigZombie(world));
        world.spawnEntityInWorld(new EntityPigZombie(world));
        world.spawnEntityInWorld(new EntityPigZombie(world));world.spawnEntityInWorld(new EntityPigZombie(world));

    }
    public void replaceBlocks(World world, int x, int y, int z){
        world.setBlock(x, y - 1, z, Nukesfromthefuture.red_obsidian);
        world.setBlock(x + 1, y - 1, z, Nukesfromthefuture.red_obsidian);
        world.setBlock(x - 1, y - 1, z, Nukesfromthefuture.red_obsidian);
        world.setBlock(x, y - 1, z + 1, Nukesfromthefuture.red_obsidian);
        world.setBlock(x, y - 1, z - 1, Nukesfromthefuture.red_obsidian);
        world.setBlock(x + 1, y, z + 1, Nukesfromthefuture.red_obsidian);
        world.setBlock(x + 1, y, z - 1, Nukesfromthefuture.red_obsidian);
        world.setBlock(x - 1, y, z + 1, Nukesfromthefuture.red_obsidian);
        world.setBlock(x - 1, y, z - 1, Nukesfromthefuture.red_obsidian);
        world.setBlock(x, y + 1, z, Nukesfromthefuture.red_obsidian);
        world.setBlock(x + 1, y + 1, z, Nukesfromthefuture.red_obsidian);
        world.setBlock(x - 1, y + 1, z, Nukesfromthefuture.red_obsidian);
        world.setBlock(x, y + 1, z + 1, Nukesfromthefuture.red_obsidian);
        world.setBlock(x, y + 1, z - 1, Nukesfromthefuture.red_obsidian);
        world.setBlockToAir(x, y, z);
        world.setBlock(x, y, z, Nukesfromthefuture.nether_reactor2);

    }
}
