package nukesfromthefuture.ModelLoaders;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import nukesfromthefuture.Reference;

public class BetaLoader extends TileEntitySpecialRenderer{
	public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/models/beta.png");
	public ResourceLocation modelloc = new ResourceLocation(Reference.MOD_ID, "models/beta.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(modelloc);
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z,
			float p_147500_8_) {
		TileEntity te2 = (TileEntity) te;
		bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y + 0.5, z + 0.5);
		GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_CULL_FACE);
		switch(te.getBlockMetadata())
		{
		case 2:
			GL11.glRotatef(180, 0F, 1F, 0F); break;
		case 4:
			GL11.glRotatef(270, 0F, 1F, 0F); break;
		case 3:
			GL11.glRotatef(0, 0F, 1F, 0F); break;
		case 5:
			GL11.glRotatef(90, 0F, 1F, 0F); break;
		}
		model.renderAll();
		GL11.glPopMatrix();
	}

}
