package nukesfromthefuture.packet;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import nukesfromthefuture.Reference;

public class PacketDispatcher {
	//Mark 1 Packet Sending Device
		public static final SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

		public static final void registerPackets()
		{
			int i = 0;
			wrapper.registerMessage(TEFluidPacket.Handler.class, TEFluidPacket.class, i++, Side.CLIENT);
			wrapper.registerMessage(AuxParticlePacket.Handler.class, AuxParticlePacket.class, i++, Side.CLIENT);
		}
}
