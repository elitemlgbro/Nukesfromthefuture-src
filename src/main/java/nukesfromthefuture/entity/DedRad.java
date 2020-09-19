package nukesfromthefuture.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import nukesfromthefuture.util.RadUtil;

import java.util.List;

public class DedRad {
    /**
     * Adds radiation to entities in an AoE
     * @param world
     * @param x
     * @param y
     * @param z
     * @param outer The least amount of radiation received on the very edge of the AoE
     * @param inner The greatest amount of radiation received on the very center of the AoE
     * @param radius
     */
    public static void doRadiation(World world, double x, double y, double z, float outer, float inner, double radius) {

        List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius));

        for(EntityLivingBase entity : entities) {

            Vec3 vec = Vec3.createVectorHelper(x - entity.posX, y - entity.posY, z - entity.posZ);

            double dist = vec.lengthVector();

            if(dist > radius)
                continue;

            double interpolation = 1 - (dist / radius);
            float rad = (float) (outer + (inner - outer) * interpolation);

            RadUtil.applyRadData(entity, rad);
        }
    }
}
