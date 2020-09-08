package nukesfromthefuture.potion;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;

import java.lang.reflect.Field;

public class NftfPotion extends Potion {
    public static NftfPotion contamination;
    protected NftfPotion(int id, boolean isBad, int color) {
        super(id, isBad, color);
    }

    public static void init(){
        contamination = registerPotion(69, true, 0x16FF22, "nftfpotion.radiation", 1, 0);
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
    public int getStatusIconIndex() {
        return super.getStatusIconIndex();
    }
}
