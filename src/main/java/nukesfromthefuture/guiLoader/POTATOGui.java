package nukesfromthefuture.guiLoader;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.container.POTATOContainer;
import nukesfromthefuture.tileentity.TileEntitySingularityNuke;
import nukesfromthefuture.tileentity.TilePOTATO;
import org.lwjgl.opengl.GL11;

public class POTATOGui extends GuiInfoContainer{
	TilePOTATO UvU;
	public static ResourceLocation texture = new ResourceLocation("nff:textures/gui/POTATONOOK.png");
	int xSize = 175;
	int ySize = 165;
	public POTATOGui(InventoryPlayer playerinv, TilePOTATO te) {
		super(new POTATOContainer(playerinv, te));
		UvU = te;
 	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getMinecraft().getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
		String name = UvU.hasCustomInventoryName() ? UvU.getInventoryName() : I18n.format(UvU.getInventoryName());
		fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 7, 4210752);
	}
}
