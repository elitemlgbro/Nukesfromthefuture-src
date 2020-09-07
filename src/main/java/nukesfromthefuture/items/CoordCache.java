package nukesfromthefuture.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class CoordCache extends Item {
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		if(!player.isSneaking()){
			if(stack.getTagCompound() == null) {
				stack.setTagCompound(new NBTTagCompound());
			}
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("dim", player.dimension);
			nbt.setInteger("posX", x);
			nbt.setInteger("posY", y);
			nbt.setInteger("posZ", z);
			stack.getTagCompound().setTag("coords", nbt);
			stack.setStackDisplayName(EnumChatFormatting.DARK_BLUE + "coord cache");
		}
		return false;
	}
	@Override
	public ItemStack onItemRightClick(ItemStack uwu, World p_77659_2_, EntityPlayer player) {
		if(player.isSneaking()){
			if(uwu.getTagCompound() != null) {
				uwu.getTagCompound().removeTag("coords");
			}
		}
		return uwu;
	}
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
		if(stack.getTagCompound() != null) {
		if(stack.getTagCompound().hasKey("coords")) {
			NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("coords");
			int dim = nbt.getInteger("dim");
			int posX = nbt.getInteger("posX");
			int posY = nbt.getInteger("posY");
			int posZ = nbt.getInteger("posZ");
			list.add("dim: " + dim + " X: " + posX + " Y: " + posY + " Z: " + posZ);
			}
		}
	}
	public boolean hasEffect(ItemStack stack)
    {
		if(stack.getTagCompound() != null) {
			return stack.getTagCompound().hasKey("coords");
		}
        return false;
    }
}
