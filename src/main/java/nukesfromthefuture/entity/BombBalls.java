package nukesfromthefuture.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import nukesfromthefuture.ModelLoaders.QwQ;
import nukesfromthefuture.Nukesfromthefuture;

public class
BombBalls extends EntityThrowable {
	public EntityPlayer player;
	public BombBalls(World p_i1776_1_) {
		super(p_i1776_1_);
		// TODO Auto-generated constructor stub
	}
	public BombBalls(World p_77660_1_, EntityLivingBase p_77660_2_) {
		super(p_77660_1_, p_77660_2_);
	}

	public BombBalls(World p_i1781_1_, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_) {
		super(p_i1781_1_, p_i1781_2_, p_i1781_4_, p_i1781_6_);
	}
	@Override
	protected void onImpact(MovingObjectPosition Uwu) {
		
		if (Uwu.entityHit != null)
        {
            Uwu.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 5.0F);
        }
		if(!worldObj.isRemote){
			worldObj.createExplosion(this, posX, posY, posZ, 10.0F, true);
			this.setDead();
		}


	}



}
