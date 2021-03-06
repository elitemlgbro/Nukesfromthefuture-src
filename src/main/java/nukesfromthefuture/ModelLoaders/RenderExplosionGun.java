package nukesfromthefuture.ModelLoaders;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import nukesfromthefuture.model.ExplosionGunModel;
import org.lwjgl.opengl.GL11;

public class RenderExplosionGun implements IItemRenderer{
    public ExplosionGunModel model;

    public RenderExplosionGun(){
        model = new ExplosionGunModel();
    }
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch(type) {
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
            case ENTITY:
                return true;
            default: return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        float f = 0;
        switch(type) {
            case EQUIPPED_FIRST_PERSON:
                GL11.glRotatef(70F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(-50F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(-0.6F, -0.9F, 0.2F);
            case EQUIPPED:
            case ENTITY:
            default:
                if ((Entity) data[1] instanceof EntityPlayer)
                    f = ((EntityPlayer) data[1]).getItemInUseDuration();
                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("nff:textures/models/ExplosionGun.png"));
                GL11.glPushMatrix();
                model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
                GL11.glScalef(0.75F, 0.75F, 0.75F);
                GL11.glTranslatef(0.5F, 0.0F, 0.0F);
                GL11.glPopMatrix(); break;
        }
    }
}
