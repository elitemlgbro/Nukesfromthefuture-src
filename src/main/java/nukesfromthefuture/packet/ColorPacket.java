package nukesfromthefuture.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.interfaces.IColorIndicator;

public class ColorPacket implements IMessage {
    //Version two of the color packet
    public int x;
    public int y;
    public int z;
    public float red;
    public float green;
    public float blue;
    public ColorPacket(){

    }
    public ColorPacket(int x, int y, int z, float red, float blue, float green){
        this.x = x;
        this.y = y;
        this.z = z;
        this.red = red;
        this.blue = blue;
        this.green = green;
    }
    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        red = buf.readFloat();
        blue = buf.readFloat();
        green = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeFloat(red);
        buf.writeFloat(blue);
        buf.writeFloat(green);
    }
    public static class Handler implements IMessageHandler<ColorPacket, IMessage>{

        @Override
        @SideOnly(Side.CLIENT)
        public IMessage onMessage(ColorPacket m, MessageContext ctx) {

            TileEntity te = Minecraft.getMinecraft().theWorld.getTileEntity(m.x, m.y, m.z);
            try{
                if(te != null && te instanceof IColorIndicator){
                    IColorIndicator color = (IColorIndicator)te;
                    color.setRed(m.red);
                    color.setBlue(m.blue);
                    color.setGreen(m.green);
                }
            }catch(Exception a){}
            return null;
        }
    }
}
