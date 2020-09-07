package nukesfromthefuture.ModelLoaders;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.Reference;
import nukesfromthefuture.entity.EntityPizzaCreeper;
import nukesfromthefuture.entity.Skeppy;

public class RenderSkeppie extends RenderLiving{
	 private static final ResourceLocation cowTextures = new ResourceLocation(Reference.MOD_ID, "textures/entity/uhh.png");

	    public RenderSkeppie()
	    {
	        super(new ModelBiped(), 2.0F);
	    }

	    /**
	     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	     */
	    protected ResourceLocation getEntityTexture(Skeppy p_110775_1_)
	    {
	        return cowTextures;
	    }

	    /**
	     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	     */
	    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	    {
	        return this.getEntityTexture((Skeppy)p_110775_1_);
	    }


}
