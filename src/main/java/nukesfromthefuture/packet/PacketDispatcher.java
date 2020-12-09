package nukesfromthefuture.packet;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import nukesfromthefuture.Reference;
import nukesfromthefuture.interfaces.AuxElectricityPacket;

public class PacketDispatcher {
	//Mark 1 Packet Sending Device
		public static final SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

		public static final void registerPackets()
		{
			int i = 0;
			wrapper.registerMessage(TEFluidPacket.Handler.class, TEFluidPacket.class, i++, Side.CLIENT);
			wrapper.registerMessage(AuxParticlePacket.Handler.class, AuxParticlePacket.class, i++, Side.CLIENT);
			wrapper.registerMessage(AuxElectricityPacket.Handler.class, AuxElectricityPacket.class, i++, Side.CLIENT);
			wrapper.registerMessage(RadSurveyPacket.Handler.class, RadSurveyPacket.class, i++, Side.CLIENT);
			wrapper.registerMessage(AuxGaugePacket.Handler.class, AuxGaugePacket.class, i++, Side.CLIENT);
			wrapper.registerMessage(IDKWhat.IDKWhatHandler.class, IDKWhat.class, i++, Side.CLIENT);
			wrapper.registerMessage(ColorPacket.Handler.class, ColorPacket.class, i++, Side.CLIENT);
			wrapper.registerMessage(NoTEGuiPacket.Handler.class, NoTEGuiPacket.class, i++, Side.SERVER);
		}
}
