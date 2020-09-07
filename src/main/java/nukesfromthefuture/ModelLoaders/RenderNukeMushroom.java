package nukesfromthefuture.ModelLoaders;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import nukesfromthefuture.Reference;
import nukesfromthefuture.entity.NukeMushroom;

public class RenderNukeMushroom extends Render {
	private ResourceLocation texture;
	private static final ResourceLocation modelloc = new ResourceLocation(Reference.MOD_ID, "models/nuclearMushroom.obj");
	IModelCustom model;
	public RenderNukeMushroom() {
		model = AdvancedModelLoader.loadModel(modelloc);
		texture = new ResourceLocation(Reference.MOD_ID, "textures/models/mush.png");
	}
	@Override
	public void doRender(Entity e, double par2, double par4, double par6, float par8,
			float par9) {
		// TODO Auto-generated method stub
		if(((NukeMushroom)e).age > 100) {
			this.renderMushroom((NukeMushroom) e, par2, par4, par6, par8, par9);
		}
	}
	public void renderMushroom(NukeMushroom ree, double x, double y, double z, float par1, float par2) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        if(ree.age < 150)
        {
        	//GL11.glTranslatef(0.0F, -60F + ((p_76986_1_.age - 100) * 60 / 50), 0.0F);
        	GL11.glTranslatef(0.0F, ree.height, 0.0F);
        }
        GL11.glScalef(10.0F, 10.0F, 10.0F);
		GL11.glTranslatef((float)x, (float)y,(float) z);
		this.bindTexture(texture);
		model.renderAll();
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		// TODO Auto-generated method stub
		return null;
	}

}
