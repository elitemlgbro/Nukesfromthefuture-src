package nukesfromthefuture.entity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.tileentity.explosion.ExplosionMan;
import nukesfromthefuture.tileentity.explosion.ManExplosion;

public class ManBlast extends Entity{
	public ManExplosion	hoool = null;
	public double		radius;
	public int			time		= 0;
	
	public ManBlast(World par1World)
	{
		super(par1World);
		ignoreFrustumCheck = true;
	}
	
	public ManBlast(World par1World, float x, float y, float z, ManExplosion hool, int rad)
	{
		super(par1World);
		ignoreFrustumCheck = true;
		hoool = hool;
		radius = rad;
		motionX = Math.sqrt(radius - Nukesfromthefuture.Manbuff) / 10;
		setPosition(x, y, z);
	}
	
	public ManBlast(World par1World, double x, double y, double z, float rad)
	{
		super(par1World);
		ignoreFrustumCheck = true;
		radius = rad;
		motionX = Math.sqrt(rad - Nukesfromthefuture.Manbuff) / 10;
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
			for (int i = 0; i < Nukesfromthefuture.Boyspeed * 2; i++)
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
		double ldist = radius*radius;
		for (int i = 0; i < worldObj.loadedEntityList.size(); i++)
		{
			Entity e = (Entity) worldObj.loadedEntityList.get(i);
			double dist = e.getDistanceSq(posX,posY,posZ);
			if (dist < ldist)
			{
				if ((e instanceof EntityPlayer && ((EntityPlayer) e).capabilities.isCreativeMode) || e instanceof BoyBlast || e == this) continue;
				entitylist.add(e);
			}
		}
	}
	
	public void pushAndHurtEntities()
	{
		List<Entity> remove = new ArrayList<Entity>();
		float invrad = 1.0f / (float) radius;
		for (Entity e : entitylist)
		{
			if (e.isDead || e.isEntityInvulnerable())
			{
				remove.add(e);
				continue;
			}
			float dx = (float) (e.posX - posX);
			float dy = (float) (e.posY - posY);
			float dz = (float) (e.posZ - posZ);
			float dist = MathHelper.sqrt_float(dx * dx + dy * dy + dz * dz);
			float rsqrt = 1.0f / (dist + 0.0001f);
			dx *= rsqrt;
			dy *= rsqrt;
			dz *= rsqrt;
		}
		for (Entity e : remove)
		{
			entitylist.remove(e);
		}
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		motionX = nbt.getFloat("size");
		radius = nbt.getFloat("radius");
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setFloat("size", (float) motionX);
		nbt.setFloat("radius", (float) radius);
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
	
	public ManBlast setTime()
	{
		ticksExisted = 920;
		return this;
	}
}
