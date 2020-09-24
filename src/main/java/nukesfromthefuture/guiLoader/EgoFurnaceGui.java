package nukesfromthefuture.guiLoader;

import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.container.EgoFurnaceContainer;
import nukesfromthefuture.container.FluidTank;
import nukesfromthefuture.tileentity.TileEgoFurnace;
import org.lwjgl.opengl.GL11;

public class EgoFurnaceGui extends GuiInfoContainer{

    private static ResourceLocation texture = new ResourceLocation("nff:textures/gui/furnish.png");
    private TileEgoFurnace ono;
    public EgoFurnaceGui(TileEgoFurnace te, InventoryPlayer player){
        super(new EgoFurnaceContainer(te, player));
        ono = te;
        xSize = 175;
        ySize = 165;
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(texture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        TileEgoFurnace fs = null;

        if(ono.isInvalid() && ono.getWorldObj().getTileEntity(ono.xCoord, ono.yCoord, ono.zCoord) instanceof TileEgoFurnace)
            fs = (TileEgoFurnace) ono.getWorldObj().getTileEntity(ono.xCoord, ono.yCoord, ono.zCoord);
        else
            fs = ono;
        if(ono.canProcess()) {
            int i = fs.getDiFurnaceProgressScaled(25);
            this.drawTexturedModalRect(guiLeft + 86, guiTop + 29, 183, 42, i, 17);
        }

        if(ono.hasPower() && ono.canProcess()){
            this.drawTexturedModalRect(guiLeft + 63, guiTop + 49, 180, 24, 13, 13);
        }
        if(ono.hasPower()){
            int j = (int)fs.getPowerRemainingScaled(16);
            drawTexturedModalRect(guiLeft + 33, guiTop + 28 + 16 - j, 200, 38 - j, 16, j);
        }
        mc.getTextureManager().bindTexture(ono.tank.getSheet());
        ono.tank.renderTank(this, guiLeft + 8, guiTop + 61, ono.tank.getTankType().textureX() * FluidTank.x, ono.tank.getTankType().textureY() * FluidTank.y, 16, 55);
    }

    @Override
    public void drawScreen(int x, int y, float p_73863_3_) {
        super.drawScreen(x, y, p_73863_3_);
        ono.tank.renderTankInfo(this, x, y, guiLeft + 8, guiTop + 6, 16, 55);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
        String name = ono.hasCustomInventoryName() ? ono.getInventoryName() : I18n.format(ono.getInventoryName());
        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 4, 4210752);
    }
}
