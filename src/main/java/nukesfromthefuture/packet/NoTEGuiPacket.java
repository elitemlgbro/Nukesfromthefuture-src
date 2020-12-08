package nukesfromthefuture.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import nukesfromthefuture.ModelLoaders.QwQ;
import nukesfromthefuture.Nukesfromthefuture;

public class NoTEGuiPacket implements IMessage {
    int operator;
    int value;
    public NoTEGuiPacket(){

    }
    public NoTEGuiPacket(int operator, int value){
        this.operator = operator;
        this.value = value;
    }
    @Override
    public void fromBytes(ByteBuf buf) {
        operator = buf.readInt();
        value = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(operator);
        buf.writeInt(value);
    }
    public static class Handler implements IMessageHandler<NoTEGuiPacket, IMessage>{

        @Override
        public IMessage onMessage(NoTEGuiPacket message, MessageContext ctx) {
            try{
                EntityPlayer player = ctx.getServerHandler().playerEntity;
                ItemStack stack = player.getHeldItem();

                if(stack != null && stack.getItem() == Nukesfromthefuture.opposite_o_succ){
                    if(!stack.hasTagCompound())
                        stack.stackTagCompound = new NBTTagCompound();
                    int strength = stack.stackTagCompound.getInteger("boomPower");
                    if(message.operator == 1){
                        message.value = QwQ.explosionSize;
                        stack.stackTagCompound.setInteger("boomPower", QwQ.explosionSize);
                    }

                }
            }catch(Exception e){}
            return null;
        }
    }
}
