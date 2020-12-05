package nukesfromthefuture.util;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import net.minecraft.item.ItemStack;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.Reference;
import nukesfromthefuture.handler.FluidRecipeHandler;

public class NEIConfig implements IConfigureNEI{
    @Override
    public void loadConfig() {
        API.registerRecipeHandler(new FluidRecipeHandler());
        API.hideItem(new ItemStack(Nukesfromthefuture.icon));
        API.hideItem(new ItemStack(Nukesfromthefuture.ego_furnace_on));
        API.hideItem(new ItemStack(Nukesfromthefuture.nether_reactor2));
        API.hideItem(new ItemStack(Nukesfromthefuture.reactor_burnt_out));

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
