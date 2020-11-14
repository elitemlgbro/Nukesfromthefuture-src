package nukesfromthefuture.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;
import nukesfromthefuture.ModelLoaders.*;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.Reference;
import nukesfromthefuture.entity.*;
import nukesfromthefuture.handler.Guihandle;
import nukesfromthefuture.tileentity.*;
import nukesfromthefuture.tileentity.explosion.TileAntitime;

public class ClientProxy extends CommonProxy{
    /**bunch of rendering crap*/
	public void registerRenders(){
		GameRegistry.registerTileEntity(TileEntityEgo_nuke.class, "tileEgo_nuke");
		if(!Nukesfromthefuture.old_ego) {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEgo_nuke.class, new RenderEgo_nuke());
		}
        GameRegistry.registerTileEntity(TileEntityUnrefinery.class, "tileUnrefinery");
        GameRegistry.registerTileEntity(TileEntitySingularityNuke.class, "tileSingularity");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySingularityNuke.class, new RenderSingularityNuke());
        RenderingRegistry.registerEntityRenderingHandler(EntityPOTATO.class, new RenderSnowball(Nukesfromthefuture.POTATO));
        GameRegistry.registerTileEntity(TileEntityCraterCoverer.class, "tileCraterCov");
        GameRegistry.registerTileEntity(TileTransMutate.class, "tileMutate");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUnrefinery.class, new RenderUnrefinary());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCraterCoverer.class, new RenderCraterCoverer());
        RenderingRegistry.registerEntityRenderingHandler(NukeMushroom.class, new RenderNukeMushroom());
        GameRegistry.registerTileEntity(TileReactor.class, "tileRee");
        RenderingRegistry.registerEntityRenderingHandler(FalloutRain.class, new RenderFallout());
        ClientRegistry.bindTileEntitySpecialRenderer(TileReactor.class, new RenderReee());
        GameRegistry.registerTileEntity(TileEgoFurnace.class, "furnaces_ego");
        RenderingRegistry.registerEntityRenderingHandler(EntityPizzaCreeper.class, new RenderPizzaCreeper());
        GameRegistry.registerTileEntity(TileAntitime.class, "tileAntiTime");
		NetworkRegistry.INSTANCE.registerGuiHandler(Nukesfromthefuture.instance, new Guihandle());
		if(Nukesfromthefuture.old_ego) {
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEgo_nuke.class, new RenderOlNook());
		}
		GameRegistry.registerTileEntity(TileDeathBomb.class, "tiledeathbomb");
		ClientRegistry.bindTileEntitySpecialRenderer(TileDeathBomb.class, new RenderDeathBomb());
		GameRegistry.registerTileEntity(TileUnnamed.class, "tileUnnamed");
		ClientRegistry.bindTileEntitySpecialRenderer(TileUnnamed.class, new UnnamedLoader());
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
        GameRegistry.registerTileEntity(TileCore.class, "TileCore");
        ClientRegistry.bindTileEntitySpecialRenderer(TileCore.class, new RenderCore());
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
        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperPig.class, new RenderPigCreep());
        RenderingRegistry.registerEntityRenderingHandler(Skeppy.class, new RenderSkeppie());
        RenderingRegistry.registerEntityRenderingHandler(EntityLight.class, new RenderSnowball(Nukesfromthefuture.light));
	}
}
