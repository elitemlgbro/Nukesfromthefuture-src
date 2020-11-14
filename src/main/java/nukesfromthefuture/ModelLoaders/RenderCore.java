package nukesfromthefuture.ModelLoaders;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import nukesfromthefuture.Reference;
import nukesfromthefuture.tileentity.TileCore;
import org.lwjgl.opengl.GL11;

public class RenderCore extends TileEntitySpecialRenderer {
    public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/models/core.png");
    public ResourceLocation modelLoc = new ResourceLocation(Reference.MOD_ID, "models/core.obj");
    IModelCustom model = AdvancedModelLoader.loadModel(modelLoc);
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        TileCore te2 = (TileCore) te;
        bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);
        GL11.glRotated(te2.prevRot + (te2.rotation - te2.prevRot) * f, 0, 1, 0);
        GL11.glColor3ub((byte)((0xFF0000) >> 16), (byte)((0x00FF00) >> 8), (byte)((0x0000FF) >> 0));
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        model.renderAll();
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glPopMatrix();
    }
}
