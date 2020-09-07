package nukesfromthefuture.ModelLoaders;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.Reference;
import nukesfromthefuture.entity.EntityPOTATO;
import scala.tools.nsc.interpreter.IMain.Factory;

public class POTATOLoader extends Render {
	
	ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/items/POTATO.png");
	
	public POTATOLoader() {
		
	}
	public void RenderPOTATO(EntityPOTATO potato, double par2, double par4, double par6, float par8,
			float par9) {
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)par2, (float)par4, (float)par6);
		GL11.glRotatef(par9 + 0.0F, (float)par2,(float) par4, (float)par6);
		GL11.glRotatef(par9 + 0.0F, (float)par2, (float)par4, (float)par6);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		float var20 = 0.05625F;
		GL11.glScalef(var20, var20, var20);
		GL11.glPopMatrix();
		Tessellator var10 = Tessellator.instance;
		var10.addVertexWithUV(par2, par4, par6, par8, par9);
	}
	@Override
	public void doRender(Entity par1, double par2, double par4, double par6, float par8,
			float par9) {
		// TODO Auto-generated method stub
		this.RenderPOTATO((EntityPOTATO)par1, par2, par4, par6, par8, par9);
	}
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	}