package nukesfromthefuture.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPigZombie;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;



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
        //YAS, I did this all in my head *laughs in no brain cells*
        if(!world.isRemote) {
            for (int j = 0; j < 12; j++) {
                for (int i = 0; i < 12; i++) {
                    world.setBlock((x - 5) + i, y - 2, (z - 5) + j, Blocks.netherrack);
                    world.setBlock(x + 6, (y - 2) + i, (z - 5) + j, Blocks.netherrack);
                    world.setBlock(x - 6, (y - 2) + i, (z - 5) + j, Blocks.netherrack);
                    world.setBlock((x - 5) + j, (y - 2) + i, z + 6, Blocks.netherrack);
                    world.setBlock((x - 5) + j, y + 26, z + 6, Blocks.nether_brick_fence);
                    world.setBlock((x + 5) + j, y + 26, z + 6, Blocks.nether_brick_fence);
                    world.setBlock((x - 5) + j, (y - 2) + i, z - 6, Blocks.netherrack);
                    for(int l = 0; l < 13; l++) {
                        for (int k = 0; k < 13; k++) {
                            world.setBlock((x - 6) + k, y + 10, (z - 6) + l, Blocks.netherrack);
                            world.setBlock((x - 6) + k,y + 25, (z - 6) + l, Blocks.nether_brick);
                        }
                    }
                    for(int p = 0; p < 14; p++) {
                        for (int n = 0; n < 14; n++) {
                            for (int o = 0; o < 7; o++) {
                                world.setBlock((x - 3) + o, (y + 11) + p, z + 3, Blocks.nether_brick);
                                world.setBlock(x + 3, (y + 11) + p, (z - 3) + o, Blocks.nether_brick);
                                world.setBlock((x - 3) + o, (y + 11) + p, z - 3, Blocks.nether_brick);
                                world.setBlock(x - 3, (y + 11) + p, (z - 3) + o, Blocks.nether_brick);
                            }
                        }
                    }
                }
            }
        }

    }
    @Deprecated
    public void spawnEntites(World world){
        if(!world.isRemote) {
            EntityPigZombie entity = new EntityPigZombie(world);
            entity.setPosition(xCoord + 4, yCoord - 1, zCoord);
            world.spawnEntityInWorld(entity);
            world.spawnEntityInWorld(entity);
            world.spawnEntityInWorld(entity);
            world.spawnEntityInWorld(entity);
            world.spawnEntityInWorld(entity);


        }
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
            if(!worldObj.isRemote) {
                if (age == 200) {
                    EntityPigZombie entity = new EntityPigZombie(worldObj);
                    entity.setPosition(xCoord + 4, yCoord - 1, zCoord);
                    worldObj.spawnEntityInWorld(entity);

                }
                if (age == 214) {
                    EntityPigZombie entity = new EntityPigZombie(worldObj);
                    entity.setPosition(xCoord + 4, yCoord - 1, zCoord - 3);
                    worldObj.spawnEntityInWorld(entity);
                }
                if (age == 50 || age == 100 || age == 150) {
                    EntityPigZombie entity = new EntityPigZombie(worldObj);
                    entity.setPosition(xCoord - 4, yCoord - 1, zCoord + 3);
                    worldObj.spawnEntityInWorld(entity);
                }
                if (age == 20) {
                    for (int i = 0; i < 11; i++) {
                        for (int j = 0; j < 11; j++) {
                            EntityItem sthuff = new EntityItem(worldObj, (xCoord - 5) + i, yCoord - 1, (zCoord - 5) + j, new ItemStack(Items.blaze_rod));
                            EntityItem more = new EntityItem(worldObj, (xCoord - 5) + i, yCoord - 1, (zCoord - 5) + j, new ItemStack(Items.melon));
                            EntityItem egos = new EntityItem(worldObj, (xCoord - 5) + i, yCoord - 1, (zCoord - 5) + j, new ItemStack(Nukesfromthefuture.my_ego));
                            EntityItem test = new EntityItem(worldObj, (xCoord - 5) + i, yCoord - 1, (zCoord - 5) + j, new ItemStack(Items.nether_star));
                            worldObj.spawnEntityInWorld(test);
                            worldObj.spawnEntityInWorld(sthuff);
                            worldObj.spawnEntityInWorld(more);
                            worldObj.spawnEntityInWorld(egos);

                        }

                    }
                }
            }




        }
    }

}
