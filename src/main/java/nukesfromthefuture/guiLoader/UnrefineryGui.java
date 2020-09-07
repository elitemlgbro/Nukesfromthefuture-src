package nukesfromthefuture.guiLoader;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.Reference;
import nukesfromthefuture.container.UnRefineryContainer;
import nukesfromthefuture.tileentity.TileEntityUnrefinery;

public class UnrefineryGui extends GuiInfoContainer{
	public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/UnRefinery.png");
	public UnrefineryGui(InventoryPlayer UwU, TileEntityUnrefinery OwO) {
		super(new UnRefineryContainer(UwU, OwO));
		this.xSize = 176;
		this.ySize = 165;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float uh, int uhhh, int uhhhh) {
		// TODO Auto-generated method stub
		this.drawDefaultBackground();
		mc.getMinecraft().getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
