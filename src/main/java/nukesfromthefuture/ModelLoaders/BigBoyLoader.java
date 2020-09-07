package nukesfromthefuture.ModelLoaders;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import nukesfromthefuture.Reference;
import nukesfromthefuture.tileentity.TileBigBoy;

public class BigBoyLoader extends TileEntitySpecialRenderer{
	public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/models/FatMan.png");
	public ResourceLocation modelLoc = new ResourceLocation(Reference.MOD_ID, "models/FatMan.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(modelLoc);
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z,
			float p_147500_8_) {
		// TODO Auto-generated method stub
		TileBigBoy te2 = (TileBigBoy) te;
		GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y, z + 0.5D);
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

        bindTexture(texture);
        model.renderAll();

        GL11.glPopMatrix();
    }

	

}
