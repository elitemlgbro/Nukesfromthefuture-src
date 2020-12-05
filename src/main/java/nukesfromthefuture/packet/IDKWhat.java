package nukesfromthefuture.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.tileentity.TileCore;

public class IDKWhat implements IMessage {
    int x;
    int y;
    int z;
    int value;
    int index;
    public IDKWhat(int x, int y, int z, int value, int id){
        this.x = x;
        this.y = y;
        this.z = z;
        this.value = value;
        this.index = id;
    }
    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        value = buf.readInt();
        index = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(value);
        buf.writeInt(index);
    }
    public static class IDKWhatHandler implements IMessageHandler<IDKWhat, IMessage>{

        @Override
        public IMessage onMessage(IDKWhat message, MessageContext ctx) {
            try{
                TileEntity te = Minecraft.getMinecraft().theWorld.getTileEntity(message.x, message.y, message.z);
                if(te instanceof TileCore){
                    TileCore core = (TileCore) te;

                }
            } catch(Exception x){}
            return null;
        }
    }
}
