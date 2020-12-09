package nukesfromthefuture.ModelLoaders;

import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.packet.NoTEGuiPacket;
import nukesfromthefuture.packet.PacketDispatcher;

import java.util.ArrayList;
import java.util.List;

public class QwQ extends GuiScreen{
	int xSize = 172;
	int ySize = 165;
	public static int explosionSize;
	public int guiLeft;
	public int guiTop;
	List<GuiButton> list = new ArrayList<GuiButton>();
	private final EntityPlayer player;
	public ResourceLocation texture = new ResourceLocation("nff:textures/gui/QwQ.png");
	public QwQ(EntityPlayer playera){
		this.player = playera;
	}

	@Override
	public void initGui() {
		super.initGui();
		list.clear();
		list.add(new GuiButton(0, guiLeft + 131, guiTop + 76, 16, 16, "+"));
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
		fontRendererObj.drawString("Strength: " + explosionSize, guiLeft + 101, guiTop + 76, 0x000000);
		for(GuiButton o : list){
			o.drawButton(Minecraft.getMinecraft(), i, j);
		}
	}
	@Override
	protected void actionPerformed(GuiButton button) {
		if(button.id == 0) {
			mc.getSoundHandler().playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1.0F));
			explosionSize += 5;
			PacketDispatcher.wrapper.sendToServer(new NoTEGuiPacket(1, explosionSize));
		}
		super.actionPerformed(button);
	}
}
