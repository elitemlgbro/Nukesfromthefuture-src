package nukesfromthefuture.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.Reference;

public class RenderSpiderRad extends RenderLiving{
	public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/radio_spider.png");
	public RenderSpiderRad() {
		super(new ModelSpider(), 1.0F);
		// TODO Auto-generated constructor stub
	}

	protected ResourceLocation getEntityTexture(RadioactiveSpider p_110775_1_) {
		// TODO Auto-generated method stub
		return texture;
	}
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		// TODO Auto-generated method stub
		return this.getEntityTexture((RadioactiveSpider)p_110775_1_);
	}

}
