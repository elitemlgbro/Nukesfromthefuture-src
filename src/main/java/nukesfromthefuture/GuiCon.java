package nukesfromthefuture;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class GuiCon extends GuiConfig {

	public static final List<IConfigElement> element = new ArrayList<IConfigElement>();
	public static final List<IConfigElement> getList(){
		return element;
	}
	public GuiCon(GuiScreen parentScreen) {
		super(parentScreen, getList(), Reference.MOD_ID, false, false, "config/nff.cfg");
		Nukesfromthefuture.config.save();
	}


}
