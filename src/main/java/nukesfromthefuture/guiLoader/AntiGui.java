package nukesfromthefuture.guiLoader;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.container.AntiContainer;
import nukesfromthefuture.tileentity.explosion.TileAntitime;

public class AntiGui extends GuiInfoContainer{
	public ResourceLocation texture = new ResourceLocation("nff:textures/gui/AntiTime.png");
	String[] lol = new String[] {"IT'S NOT A CLOCK"
			, " BECAUSE IT'S ANTITIME!!!!"};
	int xSize = 175;
	int ySize = 165;
	public AntiGui(InventoryPlayer UmU, TileAntitime UwU) {
		super(new AntiContainer(UmU, UwU));
		// TODO Auto-generated constructor stub
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float f) {
		// TODO Auto-generated method stub
		super.drawScreen(mouseX, mouseY, f);
		this.drawCustomInfoStat(mouseX, mouseY, guiLeft + 65, guiTop + 15, 38, 39, guiLeft + 104, guiTop + 54, lol);
		
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		this.drawDefaultBackground();
		mc.getMinecraft().getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
