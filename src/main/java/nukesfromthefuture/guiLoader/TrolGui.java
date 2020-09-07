package nukesfromthefuture.guiLoader;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.container.FluidTank;
import nukesfromthefuture.container.TrolContainer;
import nukesfromthefuture.tileentity.TileTrol;

public class TrolGui extends GuiInfoContainer{
	public ResourceLocation texture = new ResourceLocation("nff:textures/gui/trol.png");
	TileTrol UwU;
	public TrolGui(TileTrol trol, InventoryPlayer player) {
		super(new TrolContainer(trol, player));
		// TODO Auto-generated constructor stub
		UwU = trol;
		this.xSize = 175;
		this.ySize = 165;
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		// TODO Auto-generated method stub
		super.drawGuiContainerForegroundLayer(x, y);
		String lols = UwU.hasCustomInventoryName() ? UwU.getInventoryName() : I18n.format(UwU.getInventoryName());
		this.fontRendererObj.drawString(lols, xSize / 2 - this.fontRendererObj.getStringWidth(lols) / 2, 4, 4210752);
	}
	@Override
	public void drawScreen(int x, int y, float p_73863_3_) {
		// TODO Auto-generated method stub
		super.drawScreen(x, y, p_73863_3_);
		UwU.tank.renderTankInfo(this, x, y, guiLeft + 152, guiTop + 7, 16, 55);
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		mc.getMinecraft().getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		mc.getMinecraft().getTextureManager().bindTexture(UwU.tank.getSheet());
		UwU.tank.renderTank(this, guiLeft + 152, guiTop + 7 + 55, UwU.tank.getTankType().textureX() * FluidTank.x, UwU.tank.getTankType().textureY() * FluidTank.y, 16, 55);
	}

}
