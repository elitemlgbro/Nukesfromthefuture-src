package nukesfromthefuture.ModelLoaders;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import nukesfromthefuture.Reference;
import nukesfromthefuture.tileentity.TileAgriessor;

public class RenderAry extends TileEntitySpecialRenderer{
	public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/models/Agri.png");
	public ResourceLocation modelloc = new ResourceLocation(Reference.MOD_ID, "models/UwUs.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(modelloc);
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z,
			float p_147500_8_) {
		// TODO Auto-generated method stub
		TileAgriessor te2 = (TileAgriessor) te;
		bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y + 0.5, z + 0.5);
		GL11.glPushMatrix();
		GL11.glPopMatrix();
		model.renderAll();
		GL11.glPopMatrix();
	}

}
