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

public class EntityEgoBlast extends Entity
{
	public EgoNukeExplosion	hoool = null;
	public int		radis;
	public int			time		= 0;
	
	public EntityEgoBlast(World par1World)
	{
		super(par1World);
		ignoreFrustumCheck = true;
	}
	
	public EntityEgoBlast(World par1World, float x, float y, float z, EgoNukeExplosion hool, int rad)
	{
		super(par1World);
		ignoreFrustumCheck = true;
		hoool = hool;
		radis = rad;
		motionX = Math.sqrt(radis - Nukesfromthefuture.egoNukeStrength) / 10;
		setPosition(x, y, z);
	}
	
	public EntityEgoBlast(World par1World, double x, double y, double z, float rad)
	{
		super(par1World);
		ignoreFrustumCheck = true;
		radis = (int) rad;
		motionX = Math.sqrt(rad - Nukesfromthefuture.egoNukeStrength) / 10;
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
			for (int i = 0; i < Nukesfromthefuture.egoNukeSpeed * 2; i++)
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
		double ldist = radis*radis;
		for (int i = 0; i < worldObj.loadedEntityList.size(); i++)
		{
			Entity e = (Entity) worldObj.loadedEntityList.get(i);
			double dist = e.getDistanceSq(posX,posY,posZ);
			if (dist < ldist)
			{
				if ((e instanceof EntityPlayer && ((EntityPlayer) e).capabilities.isCreativeMode) || e instanceof EntityEgoBlast || e == this) continue;
				entitylist.add(e);
			}
		}
	}
	
	public void pushAndHurtEntities()
	{
		int radius = radis * Nukesfromthefuture.egoNukeStrength * 1;
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
					if (!(var31 instanceof EntityEgoBlast) && !(var31 instanceof EntityEgoBlast))
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
		radis = (int) nbt.getFloat("radius");
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setFloat("size", (float) motionX);
		nbt.setFloat("radius", (float) radis);
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
	
	public EntityEgoBlast setTime()
	{
		ticksExisted = 920;
		return this;
	}
}