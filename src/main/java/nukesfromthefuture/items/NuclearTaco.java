package nukesfromthefuture.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nukesfromthefuture.NffDamageSource;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.Mk3Explosion;

public class NuclearTaco extends ItemFood{
    /**Darn u Taco Bell*/
    public NuclearTaco(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
        super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        player.attackEntityFrom(NffDamageSource.nuke_diarrhea, 1);
        Mk3Explosion entity = new Mk3Explosion(world);
        entity.posX = player.posX;
        entity.posY = player.posY;
        entity.posZ = player.posZ;
        entity.destructionRange = Nukesfromthefuture.Boystrength;
        entity.speed = Nukesfromthefuture.colliderSpeed;
        world.spawnEntityInWorld(entity);

    }
}
