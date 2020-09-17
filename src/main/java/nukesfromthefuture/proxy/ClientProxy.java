package nukesfromthefuture.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.Reference;
import nukesfromthefuture.ModelLoaders.BetaLoader;
import nukesfromthefuture.ModelLoaders.BigBoyLoader;
import nukesfromthefuture.ModelLoaders.POTATOLoader;
import nukesfromthefuture.ModelLoaders.POTATONOOKRENDER;
import nukesfromthefuture.ModelLoaders.RenderAntitime;
import nukesfromthefuture.ModelLoaders.RenderAry;
import nukesfromthefuture.ModelLoaders.RenderCraterCoverer;
import nukesfromthefuture.ModelLoaders.RenderEgo_nuke;
import nukesfromthefuture.ModelLoaders.RenderNukeMushroom;
import nukesfromthefuture.ModelLoaders.RenderOlNook;
import nukesfromthefuture.ModelLoaders.RenderPizzaCreeper;
import nukesfromthefuture.ModelLoaders.RenderRadioCreeper;
import nukesfromthefuture.ModelLoaders.RenderReee;
import nukesfromthefuture.ModelLoaders.RenderSingularityNuke;
import nukesfromthefuture.ModelLoaders.RenderSkeppie;
import nukesfromthefuture.ModelLoaders.RenderUnrefinary;
import nukesfromthefuture.ModelLoaders.RenderVolcano;
import nukesfromthefuture.ModelLoaders.SkinnyManLoader;
import nukesfromthefuture.ModelLoaders.SolidifierLoader;
import nukesfromthefuture.ModelLoaders.TrolRender;
import nukesfromthefuture.entity.EntityLight;
import nukesfromthefuture.entity.EntityPOTATO;
import nukesfromthefuture.entity.EntityPizzaCreeper;
import nukesfromthefuture.entity.EntityRadioCreeper;
import nukesfromthefuture.entity.FireUwU;
import nukesfromthefuture.entity.NukeMushroom;
import nukesfromthefuture.entity.RadioactiveSpider;
import nukesfromthefuture.entity.RenderSpiderRad;
import nukesfromthefuture.entity.Skeppy;
import nukesfromthefuture.handler.Guihandle;
import nukesfromthefuture.tileentity.*;
import nukesfromthefuture.tileentity.explosion.TileAntitime;

public class ClientProxy extends CommonProxy{
    /**bunch of rendering crap*/
	public void registerRenders(){
		GameRegistry.registerTileEntity(TileEntityEgo_nuke.class, "tileEgo_nuke");
		if(Nukesfromthefuture.old_ego == false) {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEgo_nuke.class, new RenderEgo_nuke());
		}
        GameRegistry.registerTileEntity(TileEntityUnrefinery.class, "tileUnrefinery");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUnrefinery.class, new RenderUnrefinary());
        GameRegistry.registerTileEntity(TileEntitySingularityNuke.class, "tileSingularity");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySingularityNuke.class, new RenderSingularityNuke());
        RenderingRegistry.registerEntityRenderingHandler(EntityPOTATO.class, new RenderSnowball(Nukesfromthefuture.POTATO));
        GameRegistry.registerTileEntity(TileEntityCraterCoverer.class, "tileCraterCov");
        GameRegistry.registerTileEntity(TileTransMutate.class, "tileMutate");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCraterCoverer.class, new RenderCraterCoverer());
        RenderingRegistry.registerEntityRenderingHandler(NukeMushroom.class, new RenderNukeMushroom());
        GameRegistry.registerTileEntity(TileReactor.class, "tileRee");
        ClientRegistry.bindTileEntitySpecialRenderer(TileReactor.class, new RenderReee());
        RenderingRegistry.registerEntityRenderingHandler(EntityPizzaCreeper.class, new RenderPizzaCreeper());
        GameRegistry.registerTileEntity(TileAntitime.class, "tileAntiTime");
		NetworkRegistry.INSTANCE.registerGuiHandler(Nukesfromthefuture.instance, new Guihandle());
		if(Nukesfromthefuture.old_ego == true) {
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEgo_nuke.class, new RenderOlNook());
		}
		GameRegistry.registerTileEntity(TileNReactor.class, "tileReact");
		RenderingRegistry.registerEntityRenderingHandler(RadioactiveSpider.class, new RenderSpiderRad());
        ClientRegistry.bindTileEntitySpecialRenderer(TileAntitime.class, new RenderAntitime());
        GameRegistry.registerTileEntity(TileBigBoy.class, "TileBigBoy");
        GameRegistry.registerTileEntity(TileCoord.class, "TileCoord");    
        ClientRegistry.bindTileEntitySpecialRenderer(TileBigBoy.class, new BigBoyLoader());
        GameRegistry.registerTileEntity(TileEntitySkinnyMan.class, "TileSkinnyMan");
        GameRegistry.registerTileEntity(TileBeta.class, "TileBeta");
        RenderingRegistry.registerEntityRenderingHandler(FireUwU.class, new RenderSnowball(Nukesfromthefuture.fire));
        ClientRegistry.bindTileEntitySpecialRenderer(TileBeta.class, new BetaLoader());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySkinnyMan.class, new SkinnyManLoader());
        RenderingRegistry.registerEntityRenderingHandler(EntityRadioCreeper.class, new RenderRadioCreeper());
        GameRegistry.registerTileEntity(TilePOTATO.class, "TilePOTATO");
        GameRegistry.registerTileEntity(TileAgriessor.class, "UwU");
        ClientRegistry.bindTileEntitySpecialRenderer(TileAgriessor.class, new RenderAry());
        ClientRegistry.bindTileEntitySpecialRenderer(TilePOTATO.class, new POTATONOOKRENDER());
        GameRegistry.registerTileEntity(TileSolidifier.class, "TileSolidifier");
        GameRegistry.registerTileEntity(TileVolcano.class, "tileVolcano");
        ClientRegistry.bindTileEntitySpecialRenderer(TileVolcano.class, new RenderVolcano());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSolidifier.class, new SolidifierLoader());
        GameRegistry.registerTileEntity(TileTrol.class, "Trol");
        ClientRegistry.bindTileEntitySpecialRenderer(TileTrol.class, new TrolRender());
        RenderingRegistry.registerEntityRenderingHandler(Skeppy.class, new RenderSkeppie());
        RenderingRegistry.registerEntityRenderingHandler(EntityLight.class, new RenderSnowball(Nukesfromthefuture.light));
	}
}
