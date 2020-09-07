package nukesfromthefuture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.Flood;
import nukesfromthefuture.entity.NukeMushroom;
import nukesfromthefuture.entity.UwUEx;
import nukesfromthefuture.tileentity.TileAgriessor;
import nukesfromthefuture.tileentity.explosion.AgriExplosion;
import nukesfromthefuture.tileentity.explosion.FloodExplosion;

public class Agriessor extends BlockContainer {
	public Agriessor(Material UwU) {
		super(UwU);
		isBlockContainer = true;
	}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileAgriessor();
	}
	@Override
	public boolean isOpaqueCube() {
		// TODO Auto-generated method stub
		return false;
	}
	public int getRenderType() {
		return -1;
	}
	public boolean RenderAsNormalBlock() {
		return false;
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		// TODO Auto-generated method stub

			if(!player.isSneaking() && player.getCurrentEquippedItem().getItem() != null && player.getCurrentEquippedItem().getItem() == Nukesfromthefuture.manual_detonator) {
			igniteboob(world, x, y, z, Nukesfromthefuture.Volcano_strength);
			world.setBlockToAir(x, y, z);
			this.onBlockDestroyedByPlayer(world, x, y, z, 1);
			}
		
		return false;
	}
	private boolean igniteboob(World world, int x, int y, int z, int volcano_strength) {
		// TODO Auto-generated method stub
		int aoc = 0;
		AgriExplosion tsar = new AgriExplosion((int)x, (int)y, (int)z, world, (int) ((volcano_strength + (aoc * aoc)) * 0.8f));
		UwUEx tsarblast = new UwUEx(world, (int)x, (int)y, (int)z, tsar, volcano_strength + (aoc * aoc));
		world.spawnEntityInWorld(tsarblast);
		
		NukeMushroom cloud = new NukeMushroom(world, volcano_strength);
		cloud.posX = x;
		cloud.posY = y;
		cloud.posZ = z;
		world.spawnEntityInWorld(cloud);
		return false;
	}
}
