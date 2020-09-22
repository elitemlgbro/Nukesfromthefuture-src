package nukesfromthefuture.guiLoader;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.container.ManContainer;
import nukesfromthefuture.tileentity.TileEntitySkinnyMan;
import org.lwjgl.opengl.GL11;

public class ManGui extends GuiInfoContainer{
    public ResourceLocation texture = new ResourceLocation("nff:textures/gui/manGui.png");
    TileEntitySkinnyMan QwQ;
    int xSize = 175;
    int ySize = 165;
    public ManGui(InventoryPlayer player, TileEntitySkinnyMan UwU){
        super(new ManContainer(player, UwU));
        QwQ = UwU;
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(texture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
        String name = QwQ.hasCustomInventoryName() ? QwQ.getInventoryName() : I18n.format(QwQ.getInventoryName());
        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 7, 4210752);
    }
}
