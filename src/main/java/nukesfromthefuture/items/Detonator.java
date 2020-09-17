package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import nukesfromthefuture.interfaces.IBomb;

import java.util.List;

public class Detonator extends Item{
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
        list.add("Yes, remote detonators are now a thing in this mod.");
        list.add("Shift-click to set position");
        list.add("Right-click to detonate");
        if(stack.getTagCompound() == null){
            list.add("No position set :(");
        }else{
            list.add("Position set at: " + stack.stackTagCompound.getInteger("x") + ", " + stack.stackTagCompound.getInteger("y") + ", " + stack.stackTagCompound.getInteger("y"));
        }
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (stack.stackTagCompound == null) {
            stack.stackTagCompound = new NBTTagCompound();
        }
        if (player.isSneaking()) {
            stack.stackTagCompound.setInteger("x", x);
            stack.stackTagCompound.setInteger("y", y);
            stack.stackTagCompound.setInteger("z", z);

            if (world.isRemote) {
                player.addChatMessage(new ChatComponentText("Position set!"));

            }
            world.playSoundAtEntity(player, "nff:famous.tech.boop", 2.0F, 1.0F);
            return true;
        }
        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if(stack.stackTagCompound == null){
            player.addChatComponentMessage(new ChatComponentText("ERR: 404 U FORGOT TO SET THE POSITION"));
        }else
            {int x = stack.stackTagCompound.getInteger("x");
            int y = stack.stackTagCompound.getInteger("y");
            int z = stack.stackTagCompound.getInteger("z");

            if(world.getBlock(x, y, z) instanceof IBomb)
            {
                world.playSoundAtEntity(player, "nff:famous.tech.beep", 2.0F, 1.0F);
                if(!world.isRemote)
                {
                    ((IBomb)world.getBlock(x, y, z)).explode(world, x, y, z);


                }
                if(world.isRemote)
                {
                    player.addChatMessage(new ChatComponentText("DETONATED >:)!"));
                }
            } else {
                if(world.isRemote)
                {
                    player.addChatMessage(new ChatComponentText("Err: Target out of range or is useless"));
                }
            }
        }

        return stack;
    }
}
