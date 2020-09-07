package nukesfromthefuture.ModelLoaders;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import nukesfromthefuture.Reference;
import nukesfromthefuture.tileentity.TileEntityUnrefinery;

public class RenderUnrefinary extends TileEntitySpecialRenderer {
	ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/models/unrefinery.png");
	ResourceLocation objModelLocation = new ResourceLocation(Reference.MOD_ID, "models/unrefinery.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(objModelLocation);
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ,
			float p_147500_8_) {
		TileEntityUnrefinery te2 = (TileEntityUnrefinery) te;
		bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5, posY + 0.5, posZ + 0.5);
		GL11.glPushMatrix();
		model.renderAll();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
