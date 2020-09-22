package nukesfromthefuture.guiLoader;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.container.BataContainer;
import nukesfromthefuture.tileentity.TileBeta;

public class BetaGui extends GuiInfoContainer{
	public ResourceLocation texture = new ResourceLocation("nff:textures/gui/beta.png");
	TileBeta UmU;
	public BetaGui(TileBeta UwU, InventoryPlayer player) {
		super(new BataContainer(UwU, player));
		// TODO Auto-generated constructor stub
		this.xSize = 175;
		this.ySize = 165;
		UmU = UwU;
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float p_73863_3_) {
		// TODO Auto-generated method stub
		super.drawScreen(mouseX, mouseY, p_73863_3_);
		String text[] = {
			"All types of fuel rods are allowed in this slot.",
			"FOR NOW"
		};
		this.drawCustomInfoStat(mouseX, mouseY, guiLeft + 78, guiTop + 60, 18, 18, guiLeft + 78 + 22, guiTop + 60, text);
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		mc.getMinecraft().getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
		String name = UmU.hasCustomInventoryName() ? UmU.getInventoryName() : I18n.format(UmU.getInventoryName());
		fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 7, 4210752);
	}
}
