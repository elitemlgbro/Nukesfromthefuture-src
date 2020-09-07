
package nukesfromthefuture.entity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import nukesfromthefuture.NffDamageSource;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.tileentity.explosion.ColliderExplosion;
import nukesfromthefuture.tileentity.explosion.EgoNukeExplosion;

public class EntityColliderBlast extends Entity
{
	public ColliderExplosion	hoool = null;
	public int		radiu;
	public int			time		= 0;
	
	public EntityColliderBlast(World par1World)
	{
		super(par1World);
		ignoreFrustumCheck = true;
	}
	
	public EntityColliderBlast(World par1World, float x, float y, float z, ColliderExplosion hool, int rad)
	{
		super(par1World);
		ignoreFrustumCheck = true;
		hoool = hool;
		radiu = rad;
		motionX = Math.sqrt(radiu - Nukesfromthefuture.colliderStrength) / 10;
		setPosition(x, y, z);
	}
	
	public EntityColliderBlast(World par1World, double x, double y, double z, float rad)
	{
		super(par1World);
		ignoreFrustumCheck = true;
		radiu = (int) rad;
		motionX = Math.sqrt(rad - Nukesfromthefuture.colliderStrength) / 10;
		setPosition(x, y, z);
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		if (worldObj.rand.nextInt(10) == 0)
		{
			worldObj.playSoundAtEntity(this, "ambient.weather.thunder", 10.0F, 0.50F);
			if(rand.nextInt(5) == 0)
	        	this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 10000.0F, 0.8F + this.rand.nextFloat() * 0.2F);
		}
		
		ticksExisted++;
		
		if (!worldObj.isRemote)
		{
			if (hoool == null && ticksExisted > 1200) setDead();
			if (ticksExisted % 20 == 0) updateEntityList();
			if (ticksExisted < 1200 && ticksExisted % 5 == 0) pushAndHurtEntities();
			for (int i = 0; i < Nukesfromthefuture.colliderSpeed * 2; i++)
			{
				if (hoool != null)
				{
					hoool.update(this);
					/*if (tsar.update())
					{
						tsar = null;
					}*/
				}
				else
				{
					return;
				}
			}
		}
	}
	
	List<Entity> entitylist = new ArrayList<Entity>();
	
	public void updateEntityList()
	{
		entitylist.clear();
		double ldist = radiu*radiu;
		for (int i = 0; i < worldObj.loadedEntityList.size(); i++)
		{
			Entity e = (Entity) worldObj.loadedEntityList.get(i);
			double dist = e.getDistanceSq(posX,posY,posZ);
			if (dist < ldist)
			{
				if ((e instanceof EntityPlayer && ((EntityPlayer) e).capabilities.isCreativeMode) || e instanceof EntityColliderBlast || e == this) continue;
				entitylist.add(e);
			}
		}
	}
	
	public void pushAndHurtEntities()
	{
		int radius = radiu * Nukesfromthefuture.colliderStrength * 1;
		if (radius > 80) radius = 80;
		int var3 = MathHelper.floor_double(posX - radius - 1.0D);
		int var4 = MathHelper.floor_double(posX + radius + 1.0D);
		int var5 = MathHelper.floor_double(posY - radius - 1.0D);
		int var28 = MathHelper.floor_double(posY + radius + 1.0D);
		int var7 = MathHelper.floor_double(posZ - radius - 1.0D);
		int var29 = MathHelper.floor_double(posZ + radius + 1.0D);
		List var9 = worldObj.getEntitiesWithinAABBExcludingEntity(this, AxisAlignedBB.getBoundingBox(var3, var5, var7, var4, var28, var29));
		Vec3 var30 = Vec3.createVectorHelper(posX, posY, posZ);
		
		for (int var11 = 0; var11 < var9.size(); ++var11)
		{
			Entity var31 = (Entity) var9.get(var11);
			double var13 = var31.getDistance(posX, posY, posZ) / radius;
			
			if (var13 <= 1.0D)
			{
				double var15 = var31.posX - posX;
				double var17 = var31.posY + var31.getEyeHeight() - posY;
				double var19 = var31.posZ - posZ;
				double var33 = MathHelper.sqrt_double(var15 * var15 + var17 * var17 + var19 * var19);
				
				if (var33 != 0.0D)
				{
					var15 /= var33;
					var17 /= var33;
					var19 /= var33;
					if (!(var31 instanceof EntityColliderBlast) && !(var31 instanceof EntityEgoBlast))
					{
						if (var31 instanceof EntityFallingBlock) var31.setDead();
						else
						{
							if (var31 instanceof EntityPlayer && ((EntityPlayer) var31).capabilities.isCreativeMode) continue;
							var31.attackEntityFrom(NffDamageSource.nuclearblast, 16 * radius);
							var31.motionX -= var15 * 8;
							var31.motionY -= var17 * 8;
							var31.motionZ -= var19 * 8;
						}
					}
				}
			}
		}
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		motionX = nbt.getFloat("size");
		radiu = (int) nbt.getFloat("radius");
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setFloat("size", (float) motionX);
		nbt.setFloat("radius", (float) radiu);
	}
	
	@Override
	public int getBrightnessForRender(float par1)
	{
		return 1000;
	}
	
	@Override
	public float getBrightness(float par1)
	{
		return 1000F;
	}
	
	@Override
	public boolean isInRangeToRenderDist(double par1)
	{
		return true;
	}
	
	@Override
	protected void entityInit()
	{
		
	}
	
	public EntityColliderBlast setTime()
	{
		ticksExisted = 920;
		return this;
	}

	public static Entity statFac(World worldObj, int explosionRadius, double posX, double posY, double posZ) {
		// TODO Auto-generated method stub
		
		
		if(explosionRadius == 0)
			explosionRadius = 25;
		
		explosionRadius *= 2;
		
		EntityColliderBlast mk4 = new EntityColliderBlast(worldObj);
		mk4.radiu = (int)(explosionRadius);
		mk4.time = (int)Math.ceil(100000 / mk4.radiu);
		mk4.setPosition(posX, posY, posZ);
		mk4.radiu = mk4.radiu / 2;
		return mk4;
	}
}
