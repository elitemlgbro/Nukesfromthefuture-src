package nukesfromthefuture.ModelLoaders;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.Reference;
import nukesfromthefuture.entity.EntityCreeperPig;
import nukesfromthefuture.entity.EntityPizzaCreeper;
import org.lwjgl.opengl.GL11;
@SideOnly(Side.CLIENT)
public class RenderPigCreep extends RenderLiving {
     ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/creep_pig.png");
    public RenderPigCreep() {
        super(new ModelPig(), 0.5F);
    }


    public ResourceLocation getEntityTexture(EntityCreeperPig a){
        return texture;
    }
    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntityCreeperPig) p_110775_1_);
    }

}
