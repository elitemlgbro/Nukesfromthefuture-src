package nukesfromthefuture.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class FireUwU extends EntityThrowable {

	public FireUwU(World p_i1776_1_) {
		super(p_i1776_1_);
		// TODO Auto-generated constructor stub
	}
	public FireUwU(World p_77660_1_, EntityLivingBase p_77660_2_) {
		super(p_77660_1_, p_77660_2_); 
	}

	public FireUwU(World p_i1781_1_, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_) {
		super(p_i1781_1_, p_i1781_2_, p_i1781_4_, p_i1781_6_);
	}
	@Override
	protected void onImpact(MovingObjectPosition Uwu) {
		// TODO Auto-generated method stub
		if (Uwu.entityHit != null)
        {
            Uwu.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 5.0F);
        }
		worldObj.setBlock((int)posX, (int)posY, (int)posZ, Blocks.fire);
	}

	

}
