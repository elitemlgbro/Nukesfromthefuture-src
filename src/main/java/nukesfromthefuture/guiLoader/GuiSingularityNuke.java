package nukesfromthefuture.guiLoader;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.Reference;
import nukesfromthefuture.container.FluidTank;
import nukesfromthefuture.container.SingularityNukeContainer;
import nukesfromthefuture.tileentity.TileEntitySingularityNuke;

public class GuiSingularityNuke extends GuiInfoContainer {
	public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/singularity_nuke.png");
	public TileEntitySingularityNuke ono;
	public GuiSingularityNuke(InventoryPlayer playerinv, TileEntitySingularityNuke te) {
		super(new SingularityNukeContainer(playerinv, te));
		ono = te;
		this.xSize = 171;
		this.ySize = 165;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float p_146976_1_, int x, int y) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);


		mc = Minecraft.getMinecraft();
		
		mc.getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		if(ono.dna()) {
			this.drawTexturedModalRect(guiLeft + 52, guiTop + 11, 173, 2, 66, 66);
		}
		
		mc.getMinecraft().getTextureManager().bindTexture(ono.tank.getSheet());
		ono.tank.renderTank(this, guiLeft + 147, guiTop + 54, ono.tank.getTankType().textureX() * FluidTank.x, ono.tank.getTankType().textureY() * FluidTank.y, 16, 47);

	}
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {

		super.drawGuiContainerForegroundLayer(x, y);
		String name = this.ono.hasCustomInventoryName() ? this.ono.getInventoryName() : I18n.format(this.ono.getInventoryName());
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 4, 4210752);

	}
	@Override
	public void drawScreen(int x, int y, float f) {
		// TODO Auto-generated method stub
		super.drawScreen(x, y, f);
		ono.tank.renderTankInfo(this, x, y, guiLeft + 147, guiTop + 53 - 48, 16, 48);


	}
}
