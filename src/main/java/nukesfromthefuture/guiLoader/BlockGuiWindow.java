package nukesfromthefuture.guiLoader;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import nukesfromthefuture.Reference;
import nukesfromthefuture.container.EgoNukeContainer;
import nukesfromthefuture.tileentity.TileEntityEgo_nuke;

public class BlockGuiWindow extends GuiInfoContainer {
	private Minecraft mc = Minecraft.getMinecraft();
	private TileEntityEgo_nuke uwu;
	public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/ego_nuke.png");
    public BlockGuiWindow(InventoryPlayer playerInv, TileEntityEgo_nuke te) {
        super(new EgoNukeContainer(playerInv, te)); 
        this.xSize = 178;
        this.ySize = 179;
        uwu = te;
    }
    @Override
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
    	// TODO Auto-generated method stub
    	GL11.glPushMatrix();
    	GL11.glPopMatrix();
    	super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
    }
    @Override
    public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    	GL11.glColor3f(1.0F, 1.0F, 1.0F);
    	int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
    	this.drawDefaultBackground();
    	mc.renderEngine.bindTexture(texture);
    	this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
    @Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.uwu.hasCustomInventoryName() ? this.uwu.getInventoryName() : I18n.format(this.uwu.getInventoryName());
		GL11.glPushMatrix();
		GL11.glPopMatrix();
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
	}
}