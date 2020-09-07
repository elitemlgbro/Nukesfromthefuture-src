package nukesfromthefuture.ModelLoaders;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import nukesfromthefuture.Reference;
import nukesfromthefuture.tileentity.TileEntitySingularityNuke;

public class RenderSingularityNuke extends TileEntitySpecialRenderer {
	ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/models/singularity_nuke.png");
	ResourceLocation modelLocation = new ResourceLocation(Reference.MOD_ID, "models/singularity_nuke.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(modelLocation);
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ,
			float p_147500_8_) {
		TileEntitySingularityNuke te2 = (TileEntitySingularityNuke) te;
		bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5D, posY + 0.5D, posZ + 0.5D);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_CULL_FACE);
		switch(te.getBlockMetadata()) {
		case 2:
			GL11.glRotated(90F, 0F, 1F, 0F); break;
		case 4:
			GL11.glRotated(180F, 0F, 1F, 0F); break;
		case 3:
			GL11.glRotated(270F, 0F, 1F, 0F); break;
		case 5:
			GL11.glRotated(0F, 0F, 1F, 0F); break;
		}
		model.renderAll();
		GL11.glPopMatrix();
		
	}

}
