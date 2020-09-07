package nukesfromthefuture.entity;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.Reference;

public class EntityPizzaCreeper extends EntityMob {
	private int lastActiveTime;
    /** The amount of time since the creeper was close enough to the player to ignite */
    private int timeSinceIgnited;
    private int fuseTime = 30;
    /** Explosion radius for this creeper. */
    private int explosionRadius = 3;
	public EntityPizzaCreeper(World par1) {
		super(par1);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.tasks.addTask(5, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.isImmuneToFire = true;
	}
	public float getCreeperFlashIntensity(float p_70831_1_)
    {
        return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * p_70831_1_) / (float)(this.fuseTime - 2);
    }
	public boolean getPowered() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IAttributeInstance getEntityAttribute(IAttribute p_110148_1_) {
		// TODO Auto-generated method stub
		this.experienceValue = 100000;
		this.setAIMoveSpeed(1);
		return super.getEntityAttribute(p_110148_1_);
	}
	@Override
	protected Item getDropItem() {
		return Nukesfromthefuture.pizza;
	}
	protected String getHurtSound()
    {
        return "nff:pizza.hurt";
    }
	protected String getLivingSound() {
		return Reference.MOD_ID + ":" + "pizzacreep.say";
	}
	protected String getDeathSound() {
		return "nff:pizza.die";
	}
	public boolean isAIEnabled() {
		return true;
	}
}
