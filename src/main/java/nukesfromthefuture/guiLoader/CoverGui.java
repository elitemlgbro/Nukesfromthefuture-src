package nukesfromthefuture.guiLoader;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.Reference;
import nukesfromthefuture.container.CraterCovererContainer;
import nukesfromthefuture.tileentity.TileEntityCraterCoverer;

public class CoverGui extends GuiInfoContainer {
	private static ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/OwO.png");
	private TileEntityCraterCoverer diFurnace;

	public CoverGui(InventoryPlayer invPlayer, TileEntityCraterCoverer tedf) {
		super(new CraterCovererContainer(invPlayer, tedf));
		diFurnace = tedf;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float f) {
		super.drawScreen(mouseX, mouseY, f);

		
		
		
		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		
		
		
	
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	

	


	}
}
