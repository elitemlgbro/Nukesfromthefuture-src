package nukesfromthefuture.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class Timefissurelog extends Block {

	public Timefissurelog(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
		this.setStepSound(soundTypeWood);
		this.setHardness(2.0F);
	}
	@SideOnly(Side.CLIENT)
	IIcon top;
	IIcon bottom;
	IIcon sideo;
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.top = register.registerIcon("nff:TimfissureLog_Top");
		this.sideo = register.registerIcon("nff:TimfissureLog");
		this.bottom = register.registerIcon("nff:TimfissureLog_Top");
		this.blockIcon = register.registerIcon("nff:TimfissureLog");
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
}
