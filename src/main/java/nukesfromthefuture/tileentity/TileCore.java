package nukesfromthefuture.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileCore extends TileEntity {
    public float prevRot;
    public float rotation;
    public float rise;
    public float prevRis;
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return TileEntity.INFINITE_EXTENT_AABB;
    }

    @Override
    public double getMaxRenderDistanceSquared() {
        return 6500D;
    }
    public boolean isStructureCorrect(){
        return NuclearReactorStructure.isValid(worldObj, xCoord, yCoord, zCoord);
    }
    @Override
    public void updateEntity() {
        super.updateEntity();
        this.prevRot = this.rotation;



            this.rotation += 15F;

            if(this.rotation >= 360) {
                this.rotation -= 360;
                this.prevRot -= 360;
            }
        this.prevRis = this.rise;

            this.rise += 0.125F;
            if(this.rise >= 1.5){
                this.rise -= 0.125;
                this.prevRis -=0.125;
            }
    }
}
