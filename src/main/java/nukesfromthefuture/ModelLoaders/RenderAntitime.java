package nukesfromthefuture.ModelLoaders;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import nukesfromthefuture.Reference;
import nukesfromthefuture.tileentity.explosion.TileAntitime;

public class RenderAntitime extends TileEntitySpecialRenderer{
	public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/models/Antitime.png");
	public ResourceLocation objLoc = new ResourceLocation(Reference.MOD_ID, "models/Antitime.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(objLoc);
	@Override
	public void renderTileEntityAt(TileEntity namingParsRUseless, double x, double y, double z,
			float p_147500_8_) {
		// TODO Auto-generated method stub
		TileAntitime te2 = (TileAntitime) namingParsRUseless;
		bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y + 0.5, z + 0.5);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_CULL_FACE);
		switch(namingParsRUseless.getBlockMetadata()) {
		case 2:
			GL11.glRotated(90F, 0F, 1F, 0F);break;
		case 4:
			GL11.glRotated(180F, 0F, 1F, 0F);break;
		case 3:
			GL11.glRotated(270F, 0F, 1F, 0F); break;
		case 5:
			GL11.glRotated(0F, 0F, 1F, 0F);
		}
		model.renderAll();
		GL11.glPopMatrix();
	}

}
