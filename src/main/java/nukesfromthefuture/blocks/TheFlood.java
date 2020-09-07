package nukesfromthefuture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.Flood;
import nukesfromthefuture.entity.NukeMushroom;
import nukesfromthefuture.entity.TimeBlast;
import nukesfromthefuture.tileentity.explosion.AntiExplosion;
import nukesfromthefuture.tileentity.explosion.FloodExplosion;

public class TheFlood extends Block {
	public int aoc = 0;
	public TheFlood() {
		super(Material.iron);
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer playa, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		// TODO Auto-generated method stub
		world.setBlockToAir(x, y, z);
		this.onBlockDestroyedByPlayer(world, x, y, z, 0);
		ignite_boob(world, x, y, z, Nukesfromthefuture.flood_strength);
		return super.onBlockActivated(world, x, y, z, playa, p_149727_6_, p_149727_7_,
				p_149727_8_, p_149727_9_);
	}
	private boolean ignite_boob(World world, int x, int y, int z, int flood_strength) {
		if (!world.isRemote)
		{
    		FloodExplosion tsar = new FloodExplosion((int)x, (int)y, (int)z, world, (int) ((Nukesfromthefuture.flood_strength + (aoc * aoc)) * 0.8f));
			Flood tsarblast = new Flood(world, (int)x, (int)y, (int)z, tsar, Nukesfromthefuture.flood_strength + (aoc * aoc));
			world.spawnEntityInWorld(tsarblast);
			
			NukeMushroom cloud = new NukeMushroom(world, flood_strength);
			cloud.posX = x;
			cloud.posY = y;
			cloud.posZ = z;
			world.spawnEntityInWorld(cloud);
		}
		return false;
	}
}
