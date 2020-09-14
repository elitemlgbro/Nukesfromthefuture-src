package nukesfromthefuture.potion;

import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.util.RadUtil;

import java.lang.reflect.Field;

public class NftfPotion extends Potion {
    public static NftfPotion contamination;
    public static NftfPotion mutation;
    public NftfPotion(int id, boolean isBad, int color) {
        super(id, isBad, color);
    }

    public static void init(){
        contamination = registerPotion(80, true, 0x16FF22, "potion.radiation", 1, 0);
        mutation = registerPotion(81, false, 0x000000, "potion.mutation", 3, 1);
    }
    public static NftfPotion registerPotion(int id, boolean isBad, int color, String name, int x, int y) {

        if (id >= Potion.potionTypes.length) {

            Potion[] newArray = new Potion[Math.max(256, id)];
            System.arraycopy(Potion.potionTypes, 0, newArray, 0, Potion.potionTypes.length);

            Field field = ReflectionHelper.findField(Potion.class, new String[] { "field_76425_a", "potionTypes" });
            field.setAccessible(true);

            try {

                Field modfield = Field.class.getDeclaredField("modifiers");
                modfield.setAccessible(true);
                modfield.setInt(field, field.getModifiers() & 0xFFFFFFEF);
                field.set(null, newArray);

            } catch (Exception e) {

            }
        }

        NftfPotion effect = new NftfPotion(id, isBad, color);
        effect.setPotionName(name);
        effect.setIconIndex(x, y);

        return effect;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getStatusIconIndex() {
        ResourceLocation loc = new ResourceLocation("nff","textures/gui/icon.png");
        Minecraft.getMinecraft().renderEngine.bindTexture(loc);
        return super.getStatusIconIndex();
    }
    public void performEffect(EntityLivingBase entity, int level){
        if(this == contamination){
            RadUtil.applyRadData(entity, level);
        }
    }
}
