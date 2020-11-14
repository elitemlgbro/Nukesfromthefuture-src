package nukesfromthefuture.guiLoader;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.Reference;
import nukesfromthefuture.container.FluidTank;
import nukesfromthefuture.container.UnRefineryContainer;
import nukesfromthefuture.tileentity.TileEntityUnrefinery;

public class UnrefineryGui extends GuiInfoContainer{
	TileEntityUnrefinery a;
	public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/UnRefinery.png");
	public UnrefineryGui(InventoryPlayer UwU, TileEntityUnrefinery OwO) {
		super(new UnRefineryContainer(UwU, OwO));
		a = OwO;
		this.xSize = 176;
		this.ySize = 165;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawScreen(int x, int y, float f) {
		super.drawScreen(x, y, f);
		a.tanks[0].renderTankInfo(this, x, y, guiLeft + 9, guiTop + 45 - 40, 16, 40);
		a.tanks[1].renderTankInfo(this, x, y, guiLeft + 75, guiTop + 49 - 44, 16, 44);
		a.tanks[2].renderTankInfo(this, x, y, guiLeft + 100, guiTop + 49 - 44, 16, 44);
		a.tanks[3].renderTankInfo(this, x, y, guiLeft + 125, guiTop + 49 - 44, 16, 44);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float uh, int uhhh, int uhhhh) {
		// TODO Auto-generated method stub
		this.drawDefaultBackground();
		mc.getMinecraft().getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		mc.renderEngine.bindTexture(a.tanks[0].getSheet());
		a.tanks[0].renderTank(this, guiLeft + 9, guiTop + 45, a.tanks[0].getTankType().textureX() * FluidTank.x, a.tanks[0].getTankType().textureY() * FluidTank.y, 16, 40);
		mc.renderEngine.bindTexture(a.tanks[1].getSheet());
		a.tanks[1].renderTank(this, guiLeft + 75, guiTop + 49, a.tanks[1].getTankType().textureX() * FluidTank.x, a.tanks[1].getTankType().textureY() * FluidTank.y, 16, 44);
		mc.renderEngine.bindTexture(a.tanks[2].getSheet());
		a.tanks[2].renderTank(this, guiLeft + 100, guiTop + 49, a.tanks[2].getTankType().textureX() * FluidTank.x, a.tanks[2].getTankType().textureY() * FluidTank.y, 16, 44);
		mc.renderEngine.bindTexture(a.tanks[3].getSheet());
		a.tanks[3].renderTank(this, guiLeft + 125, guiTop + 49, a.tanks[3].getTankType().textureX() * FluidTank.x, a.tanks[3].getTankType().textureY() * FluidTank.y, 16, 44);
	}

}
