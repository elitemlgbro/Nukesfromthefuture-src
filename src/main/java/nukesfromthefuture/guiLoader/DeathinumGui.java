package nukesfromthefuture.guiLoader;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.Reference;
import nukesfromthefuture.container.DeathinumContainer;
import nukesfromthefuture.tileentity.TileDeathBomb;
import org.lwjgl.opengl.GL11;

public class DeathinumGui extends GuiInfoContainer{
    TileDeathBomb UmU;
    public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/deathinum_gui.png");
    public DeathinumGui(InventoryPlayer player, TileDeathBomb te){
        super(new DeathinumContainer(player, te));
        this.xSize = 175;
        this.ySize = 165;
        UmU = te;
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(texture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
