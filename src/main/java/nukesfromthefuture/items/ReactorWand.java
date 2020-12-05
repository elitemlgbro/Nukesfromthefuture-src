package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nukesfromthefuture.tileentity.NuclearReactorStructure;

public class ReactorWand extends Item {
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if(!world.isRemote && !player.isSneaking()){
            NuclearReactorStructure.setStructure(world, x, y + 4, z);
        }
        return true;
    }
}
