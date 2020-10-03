package nukesfromthefuture.ModelLoaders;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class QwQ extends GuiScreen{
	int xSize = 172;
	int ySize = 165;
	public static GuiTextField explosionSize;
	public int guiLeft;
	public int guiTop;
	List<GuiButton> list = new ArrayList<GuiButton>();
	private final EntityPlayer player;
	public ResourceLocation texture = new ResourceLocation("nff:textures/gui/QwQ.png");
	public QwQ(EntityPlayer playera){
		player = playera;
		this.allowUserInput = true;
	}

	@Override
	public void initGui() {
		super.initGui();
		org.lwjgl.input.Keyboard.enableRepeatEvents(true);
		explosionSize = new GuiTextField(fontRendererObj, guiLeft + 50, guiTop + 50, 20, 20);
		explosionSize.setTextColor(1);
		explosionSize.setDisabledTextColour(0);
		explosionSize.setEnableBackgroundDrawing(false);
		explosionSize.setEnabled(true);
		guiLeft = (this.width - xSize) / 2;
		guiTop = (this.height - ySize) / 2;

	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}



	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		this.drawDefaultBackground();
		this.drawGuiContainerBackgroundLayer(p_73863_3_, p_73863_1_, p_73863_2_);
	}


	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		// TODO Auto-generated method stub
		this.drawDefaultBackground();
		mc.getMinecraft().getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		explosionSize.drawTextBox();
	}
}
