package nukesfromthefuture.items;

import java.util.List;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import nukesfromthefuture.Lib;
import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.model.ModelClock;

public class ArmorModel extends ItemArmor{
	@SideOnly(Side.CLIENT)

	private ModelClock modelClock;
	
	

	public ArmorModel(ArmorMaterial armorMaterial, int renderIndex, int armorType) {
		super(armorMaterial, renderIndex, armorType);
	}

	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
		
		if (this == Nukesfromthefuture.my_cape) {
			return armorType == 1;
		}
		if (this == Nukesfromthefuture.Sour_cape) {
			return armorType == 1;
		}
		if(this == Nukesfromthefuture.schrabidium_cape) {
			return armorType == 1;
		}
		if(this == Nukesfromthefuture.creep_cape) {
			return armorType == 1;
		}
		
		return armorType == 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		
		
		if (this == Nukesfromthefuture.my_cape) {
			if (armorSlot == 1) {
				if (this.modelClock == null) {
					this.modelClock = new ModelClock();
				}
				return this.modelClock;
			}
			
		}
		if(this == Nukesfromthefuture.Sour_cape) {
			if(armorSlot == 1) {
			if(this.modelClock == null) {
				this.modelClock = new ModelClock();
			}
			return this.modelClock;
			}
		}
		if(this == Nukesfromthefuture.schrabidium_cape) {
			if(armorSlot == 1) {
				if(this.modelClock == null) {
					this.modelClock = new ModelClock();
				}
				return this.modelClock;
			}
		}
		if(this == Nukesfromthefuture.creep_cape) {
			if(armorSlot == 1) {
				if(this.modelClock == null) {
					this.modelClock = new ModelClock();
				}
				return this.modelClock;
			}
		}
		return null;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		
		if (stack.getItem() == Nukesfromthefuture.my_cape && entity instanceof EntityPlayer && ((EntityPlayer)entity).getUniqueID().toString().equals(Lib.elite_mlgbro)) {
			
				return "nff:textures/models/CapesPlsDontLook/CapeElite.png";
			
		}
		if(stack.getItem() == Nukesfromthefuture.Sour_cape && entity instanceof EntityPlayer && ((EntityPlayer)entity).getUniqueID().toString().equals(Lib.sour)) {
			return "nff:textures/models/CapesPlsDontLook/CapeSour.png";
		}
		if(stack.getItem() == Nukesfromthefuture.schrabidium_cape && entity instanceof EntityPlayer && ((EntityPlayer)entity).getUniqueID().toString().equals(Lib.schrabidium)) {
			return "nff:textures/models/CapesPlsDontLook/CapeSchrabidium.png";
		}
		if(stack.getItem() == Nukesfromthefuture.creep_cape) {
			return "nff:textures/models/CapesPlsDontLook/v.png";
		}
		return "nff:textures/models/CapesPlsDontLook/CapeUnknown.png";
	}
	
    

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool) {

		
		if (itemstack.getItem() == Nukesfromthefuture.my_cape) {
			list.add("Only works for Elite_mlgbro");
		}
		if(itemstack.getItem() == Nukesfromthefuture.Sour_cape) {
			list.add("Only works for some1sour");
		}
		if(itemstack.getItem() == Nukesfromthefuture.schrabidium_cape) {
			list.add("Only works for Schrabidium");
		}
		if(itemstack.getItem() == Nukesfromthefuture.creep_cape) {
			list.add("works for everyone");
		}
		
		
	}
}
