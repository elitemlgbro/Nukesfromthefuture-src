package nukesfromthefuture.ModelLoaders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import nukesfromthefuture.Reference;
import nukesfromthefuture.tileentity.TileDeathBomb;
import org.lwjgl.opengl.GL11;

public class RenderDeathBomb extends TileEntitySpecialRenderer {
    public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/models/deathinum_bomb.png");
    public ResourceLocation modelloc = new ResourceLocation(Reference.MOD_ID, "models/deathinum_bomb.obj");
    IModelCustom model = AdvancedModelLoader.loadModel(modelloc);
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        TileDeathBomb te2 = (TileDeathBomb) te;
        this.bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y + 0.5, z + 0.5);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_CULL_FACE);
        model.renderAll();
        GL11.glPopMatrix();
    }
}
