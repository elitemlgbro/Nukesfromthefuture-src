package nukesfromthefuture.util;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import net.minecraft.item.ItemStack;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.Reference;

public class NEIStuff implements IConfigureNEI{
    @Override
    public void loadConfig() {
        API.hideItem(new ItemStack(Nukesfromthefuture.icon));
    }

    @Override
    public String getName() {
        return "NEI plugin for Nff";
    }

    @Override
    public String getVersion() {
        return Reference.version;
    }
}
