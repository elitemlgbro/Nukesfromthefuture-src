package nukesfromthefuture.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.RadSaveData;
import nukesfromthefuture.tileentity.explosion.ExplosionRay;
import nukesfromthefuture.tileentity.explosion.Generic;
import org.apache.logging.log4j.Level;


public class Blast extends Entity{
	//Strength of the blast
	public int strength;
	//How many rays should be created
	public int count;
	//How many rays are calculated per tick
	public int speed;
	public int length;

	public boolean fallout = true;
	private int falloutAdd = 0;

	ExplosionRay explosion;

	public Blast(World p_i1582_1_) {
		super(p_i1582_1_);
	}

	public Blast(World world, int strength, int count, int speed, int length) {
		super(world);
		this.strength = strength;
		this.count = count;
		this.speed = speed;
		this.length = length;
	}

	@Override
	public void onUpdate() {

		if(strength == 0) {
			this.setDead();
			return;
		}

		if(!worldObj.isRemote && fallout && explosion != null) {
			RadSaveData data = RadSaveData.getData(worldObj);

			//float radMax = (float) (length / 2F * Math.pow(length, 2) / 35F);
			float radMax = Math.min((float) (length / 2F * Math.pow(length, 1.5) / 35F), 15000);
			//System.out.println(radMax);
			float rad = radMax / 4F;
			data.incrementRad(worldObj, (int)this.posX, (int)this.posZ, rad, radMax);
		}

		this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0F, 0.8F + this.rand.nextFloat() * 0.2F);
		if(rand.nextInt(5) == 0)
			this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 10000.0F, 0.8F + this.rand.nextFloat() * 0.2F);

		Generic.dealDamage(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ, this.length * 2);

		if(explosion == null) {
			explosion = new ExplosionRay(worldObj, (int)this.posX, (int)this.posY, (int)this.posZ, this.strength, this.count, this.speed, this.length);

			//MainRegistry.logger.info("START: " + System.currentTimeMillis());

			/*if(!worldObj.isRemote)
				for(int x = (int) (posX - 1); x <= (int) (posX + 1); x++)
					for(int y = (int) (posY - 1); y <= (int) (posY + 1); y++)
						for(int z = (int) (posZ - 1); z <= (int) (posZ + 1); z++)
							worldObj.setBlock(x, y, z, Blocks.air);*/
		}

		//if(explosion.getStoredSize() < count / length) {
		if(!explosion.isAusf3Complete) {
			//if(!worldObj.isRemote)
			//MainRegistry.logger.info(explosion.getStoredSize() + " / " + count / length);
			//explosion.collectTip(speed * 10);
			explosion.collectTipMk4_5(speed * 10);
		} else if(explosion.getStoredSize() > 0) {
			//if(!worldObj.isRemote)
			//MainRegistry.logger.info(explosion.getProgress() + " / " + count / length);
			explosion.processTip(Nukesfromthefuture.mk4);
		} else if(fallout) {

			//MainRegistry.logger.info("STOP: " + System.currentTimeMillis());

			FalloutRain fallout = new FalloutRain(this.worldObj);
			fallout.posX = this.posX;
			fallout.posY = this.posY;
			fallout.posZ = this.posZ;
			fallout.setScale((int)(this.length * 1.8 + falloutAdd) * 100 / 100);

			this.worldObj.spawnEntityInWorld(fallout);

			this.setDead();
		} else {
			this.setDead();
		}
	}

	@Override
	protected void entityInit() {

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt) {

		/*strength = nbt.getInteger("strength");
		count = nbt.getInteger("count");
		speed = nbt.getInteger("speed");
		length = nbt.getInteger("length");
		fallout = nbt.getBoolean("fallout");
		falloutAdd = nbt.getInteger("falloutAdd");*/

		//TODO: implement NBT functionality for MK4 explosion logic
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt) { }

	public static Blast statFac(World world, int r, double x, double y, double z) {

		if(r == 0)
			r = 25;

		r *= 2;

		Blast mk4 = new Blast(world);
		mk4.strength = (int)(r);
		mk4.count = (int)(4 * Math.PI * Math.pow(mk4.strength, 2) * 25);
		mk4.speed = (int)Math.ceil(100000 / mk4.strength);
		mk4.setPosition(x, y, z);
		mk4.length = mk4.strength / 2;
		return mk4;
	}

	public static Blast statFacExperimental(World world, int r, double x, double y, double z) {

		if(!world.isRemote)
			Nukesfromthefuture.logger.log(Level.INFO, "[NUKE] Initialized eX explosion at " + x + " / " + y + " / " + z + " with strength " + r + "!");

		r *= 2;

		Blast mk4 = new Blast(world);
		mk4.strength = (int)(r);
		mk4.count = (int)(4 * Math.PI * Math.pow(mk4.strength, 2) * 25);
		mk4.speed = (int)Math.ceil(100000 / mk4.strength);
		mk4.setPosition(x, y, z);
		mk4.length = mk4.strength / 2;
		return mk4;
	}

	public static Blast statFacNoRad(World world, int r, double x, double y, double z) {

		if(!world.isRemote)
			Nukesfromthefuture.logger.log(Level.INFO, "[NUKE] Initialized nR explosion at " + x + " / " + y + " / " + z + " with strength " + r + "!");

		r *= 2;

		Blast mk4 = new Blast(world);
		mk4.strength = (int)(r);
		mk4.count = (int)(4 * Math.PI * Math.pow(mk4.strength, 2) * 25);
		mk4.speed = (int)Math.ceil(100000 / mk4.strength);
		mk4.setPosition(x, y, z);
		mk4.length = mk4.strength / 2;
		mk4.fallout = false;
		return mk4;
	}

	public Blast moreFallout(int fallout) {
		falloutAdd = fallout;
		return this;
	}
}
