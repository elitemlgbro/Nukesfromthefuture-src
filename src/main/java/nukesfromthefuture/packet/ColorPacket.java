package nukesfromthefuture.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.tileentity.TileCore;

public class ColorPacket implements IMessage {
    public int x;
    public int y;
    public int z;
    public int id;
    public int value;
    public ColorPacket(){

    }
    public ColorPacket(int x, int y, int z, int id, int value){
        this.x = x;
        this.y = y;
        this.z = z;
        this.id = id;
        this.value = value;
    }
    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        value = buf.readInt();
        id = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(id);
        buf.writeInt(value);
    }
    public static class Handler implements IMessageHandler<ColorPacket, IMessage>{

        @Override
        public IMessage onMessage(ColorPacket m, MessageContext ctx) {

            TileEntity te = Minecraft.getMinecraft().theWorld.getTileEntity(m.x, m.y, m.z);
            try{
                if(te instanceof TileCore){
                    if(m.id == 0){
                        ((TileCore) te).red = m.value;
                    } if(m.id == 1){
                        ((TileCore) te).blue = m.value;
                    } if(m.id == 2){
                        ((TileCore) te).green = m.value;
                    }
                }
            }catch(Exception a){}
            return null;
        }
    }
}
