package nukesfromthefuture.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ClickBob extends Block {
	@SideOnly(Side.CLIENT)
	
	IIcon top;
	IIcon bottom;
	IIcon sideo;
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.top = register.registerIcon("nff:tnt_top");
		this.sideo = register.registerIcon("nff:tnt_side");
		this.bottom = register.registerIcon("nff:tnt_bottom");
		this.blockIcon = register.registerIcon("nff:tnt_side");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		if(side == 0)
			return bottom;
		if(side == 1)
			return top;
		if(side == 2 || side == 3)
			return blockIcon;
		if(side == 4 || side == 5)
			return sideo;
		
		return null;
	}
	
	
	public ClickBob(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int uhh, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		world.createExplosion(player, x, y, z, 1000F, true);
		return super.onBlockActivated(world, x, y, z, player, uhh, p_149727_7_,
				p_149727_8_, p_149727_9_);
	}

}
