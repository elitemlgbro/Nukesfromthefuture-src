package nukesfromthefuture.ModelLoaders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import nukesfromthefuture.tileentity.TileUnnamed;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;

public class UnnamedLoader extends TileEntitySpecialRenderer{
    public ResourceLocation texture = new ResourceLocation("nff:textures/models/reactorWithoutName.png");
    public ResourceLocation modelloc = new ResourceLocation("nff:models/UnnamedReactor.obj");
    IModelCustom model = AdvancedModelLoader.loadModel(modelloc);
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float p_147500_8_) {
        TileUnnamed te2 = (TileUnnamed) te;
        this.bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y + 0.5, z + 0.5);
        GL11.glEnable(GL_CULL_FACE);
        GL11.glEnable(GL_LIGHTING);
        model.renderAll();
        GL11.glPopMatrix();
    }
}
