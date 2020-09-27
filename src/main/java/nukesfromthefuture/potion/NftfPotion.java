package nukesfromthefuture.potion;

import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.NffDamageSource;
import nukesfromthefuture.util.RadUtil;

import java.lang.reflect.Field;

public class NftfPotion extends Potion {
    public static NftfPotion contamination;
    public static NftfPotion mutation;
    public static NftfPotion lead_poisioning;
    public NftfPotion(int id, boolean isBad, int color) {
        super(id, isBad, color);
    }

    public static void init(){
        contamination = registerPotion(80, true, 0x16FF22, "potion.radiation", 1, 0);
        mutation = registerPotion(81, false, 0x000000, "potion.mutation", 3, 1);
        lead_poisioning = registerPotion(82, true, 0x404040, "potion.lead_poision", 0, 0);
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
            RadUtil.applyRadData(entity, (float)(level + 1F) * 0.05F);
        } else if(this == lead_poisioning){
            entity.attackEntityFrom(NffDamageSource.lead_poisioning, 1);
        }
    }

    @Override
    public boolean isReady(int i, int j) {
        if(this == contamination){
            return true;
        }else if(this == lead_poisioning){
            return true;
        }
        return false;
    }
}
