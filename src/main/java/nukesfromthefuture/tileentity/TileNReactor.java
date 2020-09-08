package nukesfromthefuture.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class TileNReactor extends TileEntity{
    public boolean isValid(){
        if(worldObj.getBlock(this.xCoord, this.yCoord - 1, this.zCoord) == Blocks.cobblestone &&
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
}
