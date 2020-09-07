package nukesfromthefuture.ModelLoaders;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class QwQ extends GuiScreen{
	int xSize = 172;
	int ySize = 165;
	public ResourceLocation texture = new ResourceLocation("nff:textures/gui/QwQ.png");
	
	@Override
	public void drawBackground(int p_146278_1_) {
		// TODO Auto-generated method stub
		this.drawDefaultBackground();
		mc.getMinecraft().getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(xSize, ySize, 0, 0, width, height);
	}
	@Override
	public void initGui() {
		GuiButton button_plus = new GuiButton(0, 27, 79, "-"); 
		buttonList.add(button_plus);
	}
}
