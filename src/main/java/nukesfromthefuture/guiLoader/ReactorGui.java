package nukesfromthefuture.guiLoader;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.Reference;
import nukesfromthefuture.container.FluidTank;
import nukesfromthefuture.container.NukeReactorContainer;
import nukesfromthefuture.tileentity.TileCore;
import org.lwjgl.opengl.GL11;

public class ReactorGui extends GuiInfoContainer{
    TileCore nukeUwU;
    public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/CoreGUI.png");
    public ReactorGui(InventoryPlayer player, TileCore te){
        super(new NukeReactorContainer(player, te));
        nukeUwU = te;
        this.xSize = 175;
        this.ySize = 186;
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(texture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        int k = (int)nukeUwU.getPowerScaled(67);
        this.drawTexturedModalRect(guiLeft + 152, guiTop + 74 - k, 190, 73 - k, 16, k);

        mc.renderEngine.bindTexture(nukeUwU.tanks[0].getSheet());
        nukeUwU.tanks[0].renderTank(this, guiLeft + 8, guiTop + 74, nukeUwU.tanks[0].getTankType().textureX() * FluidTank.x, nukeUwU.tanks[0].getTankType().textureY() * FluidTank.y, 16, 65);
        mc.renderEngine.bindTexture(nukeUwU.tanks[1].getSheet());
        nukeUwU.tanks[1].renderTank(this, guiLeft + 29, guiTop + 74, nukeUwU.tanks[1].getTankType().textureX() * FluidTank.x, nukeUwU.tanks[1].getTankType().textureY() * FluidTank.y, 16, 65);
    }

    @Override
    public void drawScreen(int mx, int my, float p_73863_3_) {
        super.drawScreen(mx, my, p_73863_3_);
        nukeUwU.tanks[0].renderTankInfo(this, mx, my, guiLeft + 8, guiTop + 9, 16, 65);
        nukeUwU.tanks[1].renderTankInfo(this, mx, my, guiLeft + 29, guiTop + 9, 16, 65);
        this.drawElectricityInfo(this, mx, my, guiLeft + 151, guiTop + 8, 16, 66, nukeUwU.power, nukeUwU.maxPower);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        super.drawGuiContainerForegroundLayer(x, y);
        String name = nukeUwU.hasCustomInventoryName() ? nukeUwU.getInventoryName() : I18n.format(nukeUwU.getInventoryName());
        this.fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 7, 4210752);
    }
}
