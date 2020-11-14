package nukesfromthefuture.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityCreeperPig extends EntityAnimal {
    public EntityCreeperPig(World p_i1681_1_) {
        super(p_i1681_1_);
        this.setSize(0.9F, 0.9F);
        this.tasks.addTask(0, new EntityAILookIdle(this));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIPanic(this, 0.75F));
        this.tasks.addTask(3, new EntityAIMate(this, 0.65F));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 5F));
        this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityPig.class, 7.0F, 7.0F, 7.0D));
        this.tasks.addTask(6, new EntityAIFollowParent(this, 0.65D));
    }

    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(17);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5F);
    }

    @Override
    protected String getLivingSound() {
        return "mob.pig.say";
    }
    protected String getHurtSound(){
        return "mob.creeper.say";
    }
    protected String getDeathSound(){
        return "mob.pig.death";
    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_) {
        return new EntityCreeperPig(worldObj);
    }
}
