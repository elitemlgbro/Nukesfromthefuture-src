package nukesfromthefuture.tileentity.explosion;

import org.apache.logging.log4j.Level;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.EntityEgoBlast;

public class CoverBlast extends Entity {
	
	public int age = 0;
	public int destructionRange = 0;
	public int wasteRange = 0;
	public CoverExplosion exp;

	public int speed = 1;
	public float coefficient = 1;
	public float coefficient2 = 1;
	public boolean did = false;
	public boolean did2 = false;
	public boolean waste = true;

	public CoverBlast(World p_i1582_1_) {
		super(p_i1582_1_);
	}

    @Override
	public void onUpdate() {
        super.onUpdate();
        	
        if(!this.did)
        {
        	if(this.waste)
        	{
            	exp = new CoverExplosion((int)this.posX, (int)this.posY, (int)this.posZ, this.worldObj, this.destructionRange, this.coefficient, 0);
        		
        	} else {
            	
        	}
        	
        	this.did = true;
        }
        
        speed = 160;
        
        boolean flag = false;
        boolean flag3 = false;
        
        for(int i = 0; i < this.speed; i++)
        {
        	if(waste) {
        		flag = exp.update(this);
     
        		
        		if(flag3) {
        			this.setDead();
        		}
        	
        	}
        }
        	
        if(!flag)
        {
        	this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0F, 0.8F + this.rand.nextFloat() * 0.2F);
        	
        } else {
			if (!did2 && waste) {
				


				
				did2 = true;
        	}
        }
        
        age++;
    }

	@Override
	protected void entityInit() {
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		
	}
}
