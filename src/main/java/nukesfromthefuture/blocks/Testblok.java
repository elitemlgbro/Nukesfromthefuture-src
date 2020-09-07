package nukesfromthefuture.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class Testblok extends Block{

	public Testblok() {
		super(Material.anvil);
		// TODO Auto-generated constructor stub
	}
	@SideOnly(Side.CLIENT)
	IIcon top;
	IIcon bottom;
	IIcon sideo;
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.top = register.registerIcon("nff:ono");
		this.sideo = register.registerIcon("nff:ahh");
		this.bottom = register.registerIcon("nff:trololo");
		this.blockIcon = register.registerIcon("nff:lilBoy");
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
	public boolean isOpaqueCube() {
		return false;
	}
}
