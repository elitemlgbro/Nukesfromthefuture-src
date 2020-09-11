package nukesfromthefuture.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.blocks.NetherReact;

import java.util.ArrayList;
import java.util.List;

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
        for(int j = 0; j < 12; j++){
            for (int i = 0; i < 12; i++){
                world.setBlock((x - 5) + i, y - 2, (z - 5) + j, Blocks.netherrack);
                world.setBlock(x + 6, (y - 2) + i, (z - 5) + j, Blocks.netherrack);
                world.setBlock(x - 6, (y - 2) + i, (z - 5) + j, Blocks.netherrack);
                world.setBlock((x - 5) + j, (y - 2) + i, z + 6, Blocks.netherrack);
                world.setBlock((x - 5) + j, (y - 2) + i, z - 6, Blocks.netherrack);
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

    EntityPigZombie entity = new EntityPigZombie(worldObj);
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
                if (age == 5) {
                    entity.setPosition(xCoord + 4, yCoord - 1, zCoord);
                    worldObj.spawnEntityInWorld(entity);
                }
                if (age == 7) {
                    entity.setPosition(xCoord + 4, yCoord - 1, zCoord - 3);
                    worldObj.spawnEntityInWorld(entity);
                }
                if (age == 10 || age == 20 || age == 31) {
                    entity.setPosition(xCoord - 4, yCoord - 1, zCoord + 3);
                    worldObj.spawnEntityInWorld(entity);



                    for (int i = 0; i < 11; i++) {
                        for (int j = 0; j < 11; j++) {
                            EntityItem sthuff = new EntityItem(worldObj, (xCoord - 5)+ i, yCoord - 1, (zCoord - 5) + j, new ItemStack(Items.blaze_rod));
                            EntityItem more = new EntityItem(worldObj, (xCoord - 5) + i, yCoord - 1, (zCoord - 5) + j, new ItemStack(Items.record_11));
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
