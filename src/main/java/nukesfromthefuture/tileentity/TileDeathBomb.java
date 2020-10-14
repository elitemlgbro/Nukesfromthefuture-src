package nukesfromthefuture.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileDeathBomb extends TileEntity {
    public AxisAlignedBB getRenderBoundingBox(){
        return TileEntity.INFINITE_EXTENT_AABB;
    }
    public double getMaxRenderDistanceSquared(){
        return 6500D;
    }
}
