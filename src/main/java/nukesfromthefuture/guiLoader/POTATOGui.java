package nukesfromthefuture.guiLoader;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.container.POTATOContainer;
import nukesfromthefuture.tileentity.TileEntitySingularityNuke;
import nukesfromthefuture.tileentity.TilePOTATO;

public class POTATOGui extends GuiInfoContainer{
	public static ResourceLocation texture = new ResourceLocation("nff:textures/gui/POTATONOOK.png");
	int xSize = 175;
	int ySize = 165;
	public POTATOGui(InventoryPlayer playerinv, TilePOTATO te) {
		super(new POTATOContainer(playerinv, te));
		
 	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		this.drawDefaultBackground();
		mc.getMinecraft().getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
