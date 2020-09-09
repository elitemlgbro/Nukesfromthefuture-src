package nukesfromthefuture.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.entity.EntityColliderBlast;
import nukesfromthefuture.tileentity.explosion.ColliderExplosion;

public class Test extends CommandBase{
    World worldObj;
    ColliderExplosion stuff;
    int x;
    int y;
    int z;
    @Override
    public String getCommandName() {
        return "detonateSingularity";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/" + getCommandName();
    }

    @Override
    public void processCommand(ICommandSender uh, String[] p_71515_2_) {
        uh.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "Succ-essfully detonated"));
        worldObj.spawnEntityInWorld(new EntityColliderBlast(worldObj, x, y, z, stuff, Nukesfromthefuture.colliderStrength));
    }
}
