package nukesfromthefuture.guiLoader;

import net.minecraft.client.resources.I18n;
import nukesfromthefuture.Spaghetti;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.container.FluidTank;
import nukesfromthefuture.container.VolcanoContainer;
import nukesfromthefuture.tileentity.TileVolcano;
@Spaghetti(value = "aaaaaaaaa")
public class VolcanoGui extends GuiInfoContainer{

	public TileVolcano ono;
	public ResourceLocation texture = new ResourceLocation("nff:textures/gui/volcano.png");
	public VolcanoGui(InventoryPlayer playa, TileVolcano te) {
		super(new VolcanoContainer(playa, te));
		ono = te;
		xSize = 176;
		ySize = 187;
	}
	@Override
	public void drawScreen(int x, int y, float p_73863_3_) {
		// TODO Auto-generated method stub
		super.drawScreen(x, y, p_73863_3_);

		ono.tank.renderTankInfo(this, x, y, guiLeft + 146, guiTop + 53 - 48, 16, 48);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		if(ono.isReady()) {
			this.drawTexturedModalRect(guiLeft + 68, guiTop + 36, 181, 29, 32, 11);
			this.drawTexturedModalRect(guiLeft + 85, guiTop + 7, 179, 55, 60, 23);
		}
		
		
		mc.getMinecraft().getTextureManager().bindTexture(ono.tank.getSheet());
		ono.tank.renderTank(this, guiLeft + 146, guiTop + 54, ono.tank.getTankType().textureX() * FluidTank.x, ono.tank.getTankType().textureY() * FluidTank.y, 16, 48);

	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
		String name = ono.hasCustomInventoryName() ? ono.getInventoryName() : I18n.format(ono.getInventoryName());
		fontRendererObj.drawString(name, (xSize / 2 - fontRendererObj.getStringWidth(name) / 2) - 40, 4, 4210752);
	}
}
