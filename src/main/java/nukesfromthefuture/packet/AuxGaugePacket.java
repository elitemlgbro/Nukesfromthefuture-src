package nukesfromthefuture.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import nukesfromthefuture.tileentity.TileEgoFurnace;

public class AuxGaugePacket implements IMessage {
    int x;
    int y;
    int z;
    int value;
    int id;

    public AuxGaugePacket()
    {

    }

    public AuxGaugePacket(int x, int y, int z, int value, int id)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.value = value;
        this.id = id;
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
        buf.writeInt(value);
        buf.writeInt(id);
    }
    public static class Handler implements IMessageHandler<AuxGaugePacket, IMessage> {
        @Override
        @SideOnly(Side.CLIENT)
        public IMessage onMessage(AuxGaugePacket m, MessageContext ctx) {
            try {
                TileEntity te = Minecraft.getMinecraft().theWorld.getTileEntity(m.x, m.y, m.z);
                if (te instanceof TileEgoFurnace) {
                    TileEgoFurnace furn = (TileEgoFurnace)te;

                    if(m.id == 0)
                        furn.dualCookTime = m.value;
                }
            } catch (Exception x) {}
            return null;
        }
    }
}
