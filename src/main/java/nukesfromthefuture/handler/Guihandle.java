package nukesfromthefuture.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.ModelLoaders.QwQ;
import nukesfromthefuture.container.*;
import nukesfromthefuture.guiLoader.*;
import nukesfromthefuture.tileentity.*;
import nukesfromthefuture.tileentity.explosion.TileAntitime;

public class Guihandle implements IGuiHandler {
	public static final int MOD_TILE_ENTITY_GUI = 0;
	public static final int SINGULARITY = 1;
	public static final int OWO = 2;
	public static final int Yeeee = 3;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
TileEntity entity = world.getTileEntity(x, y, z);
if(entity != null ) {
	switch(ID)
	{
	case Nukesfromthefuture.guiID_nuke_boy:
	{
		if(entity instanceof TileEntityEgo_nuke)
		{
			return new EgoNukeContainer(player.inventory, (TileEntityEgo_nuke) entity);
		}
		return null;
	}
	case Nukesfromthefuture.QwQ:
	{
		if(entity instanceof TileEntitySingularityNuke)
		{
			return new SingularityNukeContainer(player.inventory, (TileEntitySingularityNuke) entity);
		}
		return null;
	}
	case Nukesfromthefuture.ee:
	{
		if(entity instanceof TileEntityUnrefinery)
		{
			return new UnRefineryContainer(player.inventory, (TileEntityUnrefinery) entity);
		}
		return null;
	}case Nukesfromthefuture.UvU:
	{
		if(entity instanceof TilePOTATO)
		{
			return new POTATOContainer(player.inventory, (TilePOTATO) entity);
		}
		return null;
	}case 6:
	{
		if(entity instanceof TileAntitime)
		{
			return new AntiContainer(player.inventory, (TileAntitime) entity);
		}
		return null;
	}case 7:
	{
		if(entity instanceof TileVolcano)
		{
			return new VolcanoContainer(player.inventory, (TileVolcano) entity);
		}
		return null;
	}case 8:
	{
		if(entity instanceof TileBeta)
		{
			return new BataContainer((TileBeta) entity, player.inventory);
		}
		return null;
	}case 9:{
		if(entity instanceof TileTrol) {
			return new TrolContainer((TileTrol) entity, player.inventory);
		}
		return null;
	}case 10:{
		if(entity instanceof TileBigBoy){
			return new BoyContainer(player.inventory, (TileBigBoy) entity);
		}
		return null;
	}case 11:{
		if(entity instanceof TileTransMutate){
			return new TransmutateContainer(player.inventory, (TileTransMutate) entity);
		}
		return null;
	}case 12:{
		if(entity instanceof TileEntitySkinnyMan){
			return new ManContainer(player.inventory, (TileEntitySkinnyMan) entity);
		}
		return null;
	}case 13:{
		if(entity instanceof TileEgoFurnace){
			return new EgoFurnaceContainer((TileEgoFurnace) entity, player.inventory);
		}
		return null;
	} case 14:{
		if(entity instanceof TileDeathBomb){
			return new DeathinumContainer(player.inventory, (TileDeathBomb) entity);
		}
		return null;
	} case 15: {
		if(entity instanceof TileCore){
			return new NukeReactorContainer(player.inventory, (TileCore) entity);
		}
		return null;
	}
		

	
		}
	
	}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null ) {
			switch(ID)
			{
			case Nukesfromthefuture.guiID_nuke_boy:
			{
				if(entity instanceof TileEntityEgo_nuke)
				{
					return new BlockGuiWindow(player.inventory, (TileEntityEgo_nuke) entity);
				}
				return null;
			}
			case Nukesfromthefuture.QwQ:
			{
				if(entity instanceof TileEntitySingularityNuke)
				{
					return new GuiSingularityNuke(player.inventory, (TileEntitySingularityNuke) entity);
				}
				return null;
			}
			case Nukesfromthefuture.ee:
			{
				if(entity instanceof TileEntityUnrefinery)
				{
					return new UnrefineryGui(player.inventory, (TileEntityUnrefinery) entity);
				}
				return null;
			}
			case Nukesfromthefuture.UvU:
			{
				if(entity instanceof TilePOTATO)
				{
					return new POTATOGui(player.inventory, (TilePOTATO) entity);
				}
				return null;
			}case 6:
			{
				if(entity instanceof TileAntitime)
				{
					return new AntiGui(player.inventory, (TileAntitime) entity);
				}
				return null;
			}case 7:
			{
				if(entity instanceof TileVolcano)
				{
					return new VolcanoGui(player.inventory, (TileVolcano) entity);
				}
				return null;
			}case 8:
			{
				if(entity instanceof TileBeta)
				{
					return new BetaGui((TileBeta) entity, player.inventory);
				}
				return null;
			}case 9:
			{
				if(entity instanceof TileTrol) {
					return new TrolGui((TileTrol) entity, player.inventory);
				}
				return null;
			}case 10:{
				if(entity instanceof TileBigBoy){
					return new BoyGui(player.inventory, (TileBigBoy) entity);
				}
				return null;
			}case 11:{
				if(entity instanceof TileTransMutate){
					return new TransmutantGui(player.inventory, (TileTransMutate) entity);
				}
				return null;
			}case 12:{
				if(entity instanceof TileEntitySkinnyMan){
					return new ManGui(player.inventory, (TileEntitySkinnyMan) entity);
				}
				return null;
			}case 13:{
				if(entity instanceof TileEgoFurnace){
					return new EgoFurnaceGui((TileEgoFurnace) entity, player.inventory);
				}
				return null;
			} case 14:{
				if(entity instanceof TileDeathBomb){
					return new DeathinumGui(player.inventory, (TileDeathBomb)entity);
				}
				return null;
			} case 15: {
				if(entity instanceof TileCore){
					return new ReactorGui(player.inventory, (TileCore) entity);
				}
				return null;
			}
		
				}
			
			} else {
			switch (ID) {
				case 4:
						return new QwQ(player);

			}
		}
		return null;
		}
}

