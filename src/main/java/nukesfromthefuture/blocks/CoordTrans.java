package nukesfromthefuture.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.items.CoordCache;
import nukesfromthefuture.tileentity.TileCoord;

public class CoordTrans extends Block implements ITileEntityProvider {

	public CoordTrans(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}
	@SideOnly(Side.CLIENT)
	@Override
	public boolean onBlockActivated(World world, int p_149727_2_, int p_149727_3_, int p_149727_4_,
			EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		// TODO Auto-generated method stub
		ItemStack stack = player.getCurrentEquippedItem(); 
		if(stack != null) {
			if(stack.getItem() instanceof CoordCache) {
				if(stack.getItem().hasEffect(stack)) {
					TileCoord te = (TileCoord) world.getTileEntity(p_149727_2_, p_149727_3_, p_149727_4_);
					te.addEntry("lol", stack);
					player.addChatMessage(new ChatComponentText("cooridnates successfully stores inside block"));
					
				}
			}
		}else {
			
		}
		return true;
	}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileCoord();
	}

}
