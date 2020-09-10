package nukesfromthefuture.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.blocks.NetherReact;

public class TileNReactor extends TileEntity{
    public int age = 0;
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
        for(int j = 0; j < 11; j++){
            for (int i = 0; i < 11; i++){
                world.setBlock((x - 5) + i, y - 2, (z - 5) + j, Blocks.netherrack);
                world.setBlock(x + 6, (y - 2) + i, (z - 5) + j, Blocks.netherrack);
                world.setBlock(x - 6, (y - 2) + i, (z - 5) + j, Blocks.netherrack);
                world.setBlock((x - 5) + j, (y - 2) + i, z + 6, Blocks.netherrack);
                world.setBlock((x - 5) + j, (y - 2) + i, z - 6, Blocks.netherrack);
            }
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
    @SideOnly(Side.CLIENT)
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
    public boolean Activated(){
        if(worldObj.getBlock(xCoord, yCoord, zCoord) == Nukesfromthefuture.nether_reactor2) return true;
        return false;
    }

    @Override
    public void updateEntity() {


        if(this.Activated()) {
            age ++;
            if (age == 1000) {
                worldObj.setBlock(xCoord, yCoord - 1, zCoord, Blocks.obsidian);
                worldObj.setBlock(xCoord + 1, yCoord - 1, zCoord, Blocks.obsidian);
                worldObj.setBlock(xCoord - 1, yCoord - 1, zCoord, Blocks.obsidian);
                worldObj.setBlock(xCoord, yCoord - 1, zCoord + 1, Blocks.obsidian);
                worldObj.setBlock(xCoord, yCoord - 1, zCoord - 1, Blocks.obsidian);
                worldObj.setBlock(xCoord + 1, yCoord, zCoord + 1, Blocks.obsidian);
                worldObj.setBlock(xCoord + 1, yCoord, zCoord - 1, Blocks.obsidian);
                worldObj.setBlock(xCoord - 1, yCoord, zCoord + 1, Blocks.obsidian);
                worldObj.setBlock(xCoord - 1, yCoord, zCoord - 1, Blocks.obsidian);
                worldObj.setBlock(xCoord, yCoord + 1, zCoord, Blocks.obsidian);
                worldObj.setBlock(xCoord + 1, yCoord + 1, zCoord, Blocks.obsidian);
                worldObj.setBlock(xCoord - 1, yCoord + 1, zCoord, Blocks.obsidian);
                worldObj.setBlock(xCoord, yCoord + 1, zCoord + 1, Blocks.obsidian);
                worldObj.setBlock(xCoord, yCoord + 1, zCoord - 1, Blocks.obsidian);

            }

            if(age == 200){
                worldObj.setBlock(xCoord + 1, yCoord - 1, zCoord + 1, Nukesfromthefuture.red_obsidian);
                worldObj.setBlock(xCoord + 1, yCoord - 1, zCoord - 1, Nukesfromthefuture.red_obsidian);
                worldObj.setBlock(xCoord - 1, yCoord - 1, zCoord + 1, Nukesfromthefuture.red_obsidian);
                worldObj.setBlock(xCoord - 1, yCoord - 1, zCoord - 1, Nukesfromthefuture.red_obsidian);
            }
            if(age == 1100){
                worldObj.setBlock(xCoord + 1, yCoord - 1, zCoord + 1, Blocks.obsidian);
                worldObj.setBlock(xCoord + 1, yCoord - 1, zCoord - 1, Blocks.obsidian);
                worldObj.setBlock(xCoord - 1, yCoord - 1, zCoord + 1, Blocks.obsidian);
                worldObj.setBlock(xCoord - 1, yCoord - 1, zCoord - 1, Blocks.obsidian);
                worldObj.setBlock(xCoord, yCoord, zCoord, Nukesfromthefuture.reactor_burnt_out);
            }
        }
    }
}
