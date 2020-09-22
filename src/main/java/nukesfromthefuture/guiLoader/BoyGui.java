package nukesfromthefuture.guiLoader;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.container.BoyContainer;
import nukesfromthefuture.tileentity.TileBigBoy;

public class BoyGui extends GuiInfoContainer {
    public int xSize = 175;
    public int ySize = 163;
    TileBigBoy UwU;
    public ResourceLocation texture = new ResourceLocation("nff:textures/gui/Boy.png");
    public BoyGui(InventoryPlayer player, TileBigBoy stuff) {
        super(new BoyContainer(player, stuff));
        UwU = stuff;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
        String name = UwU.hasCustomInventoryName() ? UwU.getInventoryName() : I18n.format(UwU.getInventoryName());
        this.fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 7, 4210752);
    }
}
