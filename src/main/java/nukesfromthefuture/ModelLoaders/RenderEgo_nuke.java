package nukesfromthefuture.ModelLoaders;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import nukesfromthefuture.Reference;
import nukesfromthefuture.tileentity.TileEntityEgo_nuke;

public class RenderEgo_nuke extends TileEntitySpecialRenderer {
	ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/models/blimp.png");
	ResourceLocation objModelLocation = new ResourceLocation(Reference.MOD_ID, "models/blimp.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(objModelLocation);
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ,
			float timeSinceLastTick) {
		TileEntityEgo_nuke te2 = (TileEntityEgo_nuke) te;
		bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5, posY + 0.5, posZ + 0.5);
		 GL11.glEnable(GL11.GL_LIGHTING);
	        GL11.glEnable(GL11.GL_CULL_FACE);
			switch(te.getBlockMetadata())
			{
			case 2:
				GL11.glRotatef(90, 0F, 1F, 0F); break;
			case 4:
				GL11.glRotatef(180, 0F, 1F, 0F); break;
			case 3:
				GL11.glRotatef(270, 0F, 1F, 0F); break;
			case 5:
				GL11.glRotatef(0, 0F, 1F, 0F); break;
			}
		model.renderAll();
		GL11.glPopMatrix();
	}

}
