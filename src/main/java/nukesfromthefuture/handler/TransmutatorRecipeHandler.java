package nukesfromthefuture.handler;

import codechicken.nei.recipe.TemplateRecipeHandler;

public class TransmutatorRecipeHandler extends TemplateRecipeHandler {
    @Override
    public String getGuiTexture() {
        return "nff:textures/gui/transmutate.png";
    }

    @Override
    public String getRecipeName() {
        return "deathinum cookbook";
    }

}
