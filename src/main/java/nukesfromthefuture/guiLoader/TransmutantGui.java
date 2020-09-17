package nukesfromthefuture.guiLoader;

import net.minecraft.block.BlockFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.container.TransmutateContainer;
import nukesfromthefuture.tileentity.TileTransMutate;
import org.lwjgl.opengl.GL11;

public class TransmutantGui extends GuiInfoContainer{
    private TileTransMutate stuff;
    ResourceLocation texture = new ResourceLocation("nff:textures/gui/transmutate.png");
    int xSize = 175;
    int ySize = 165;
    public TransmutantGui(InventoryPlayer player, TileTransMutate UmU){
        super(new TransmutateContainer(player, UmU));
        stuff = UmU;


    }

    @Override
    public void drawScreen(int x, int y, float p_73863_3_) {
        super.drawScreen(x, y, p_73863_3_);
        this.drawElectricityInfo(this, x, y, guiLeft + 10, guiTop + 9, 16, 50, stuff.power, stuff.maxPowa);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int x, int y) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(texture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        int k = (int)stuff.getPowerScaled(51);

        this.drawTexturedModalRect(guiLeft + 10, guiTop + 59 - k, 194, 97 - k, 16, k);
        if(stuff.isProssesing()){
            int j = stuff.getProgressScaled(64);
            this.drawTexturedModalRect(guiLeft + 60, guiTop + 42, 183, 16, j, 27);
        }
    }
}
