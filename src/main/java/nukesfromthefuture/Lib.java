package nukesfromthefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import nukesfromthefuture.handler.FluidTypeHandler.FluidType;
import nukesfromthefuture.interfaces.IBatteryItem;
import nukesfromthefuture.interfaces.IFluidAcceptor;
import nukesfromthefuture.interfaces.IFluidSource;
import nukesfromthefuture.tileentity.TileEntitySingularityNuke;

public class Lib {
	static Random rand = new Random();

	public static List<String> book1 = new ArrayList<String>();
	public static List<String> book2 = new ArrayList<String>();
	public static List<String> book3 = new ArrayList<String>();
	public static List<String> book4 = new ArrayList<String>();
	public static List<String> book5 = new ArrayList<String>();

	
	public static String elite_mlgbro = "f2c88fbc-c055-409a-949d-98269b420254";
	public static String sour = "525f951b-4253-4620-8a99-1ef20d3e0820";
	public static String schrabidium = "4b7b45e7-cc2d-498e-8e15-323dd9488370";
	public static List<String> superuser = new ArrayList<String>();
	
	public static void initBooks() {
		
	}
	
	public static boolean checkArmor(EntityPlayer player, Item helmet, Item plate, Item legs, Item boots) {
		
		if(player.inventory.armorInventory[0] != null && 
				player.inventory.armorInventory[0].getItem() == boots && 
				player.inventory.armorInventory[1] != null && 
				player.inventory.armorInventory[1].getItem() == legs && 
				player.inventory.armorInventory[2] != null && 
				player.inventory.armorInventory[2].getItem() == plate && 
				player.inventory.armorInventory[3] != null && 
				player.inventory.armorInventory[3].getItem() == helmet)
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean checkArmorPiece(EntityPlayer player, Item armor, int slot)
	{
		if(player.inventory.armorInventory[slot] != null &&
				player.inventory.armorInventory[slot].getItem() == armor) 
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean checkArmorNull(EntityPlayer player, int slot)
	{
		if(player.inventory.armorInventory[slot] == null) 
		{
			return true;
		}
		
		return false;
	}
	public static long chargeTEFromItems(ItemStack[] slots, int index, long power, long maxPower) {

		if(slots[index] != null && slots[index].getItem() == Nukesfromthefuture.infinite_battery)
		{
			return maxPower;
		}



		if(slots[index] != null && slots[index].getItem() instanceof IBatteryItem) {

			IBatteryItem battery = (IBatteryItem) slots[index].getItem();

			long batCharge = battery.getCharge(slots[index]);
			long batRate = battery.getDischargeRate();

			//in hHe
			long toDischarge = Math.min(Math.min((maxPower - power), batRate), batCharge);

			battery.dischargeBattery(slots[index], toDischarge);
			power += toDischarge;
		}

		return power;
	}
	public static void damageSuit(EntityPlayer player, int slot, int amount) {
		
		if(player.inventory.armorInventory[slot] == null)
			return;
		
		int j = player.inventory.armorInventory[slot].getItemDamage();
		player.inventory.armorInventory[slot].setItemDamage(j += amount);

		if(player.inventory.armorInventory[slot].getItemDamage() >= player.inventory.armorInventory[slot].getMaxDamage())
		{
			player.inventory.armorInventory[slot] = null;
		}
	}
	
	//radDura: Radiation duration in seconds
	//radLevel: Radiation level (0 = I)
	//maskDura: Radiation duration when wearing gasmask
	//maskLevel: Radiation level when wearing gasmask
	/*public static void applyRadiation(Entity e, int radDura, int radLevel, int maskDura, int maskLevel) {
		
		if(!(e instanceof EntityLivingBase))
			return;
		
		if(radDura == 0)
			return;
		
		EntityLivingBase entity = (EntityLivingBase)e;
		
		if(entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			
			if(checkForHazmat(player))
				return;
			
			if(checkForGasMask(player)) {
				
				if(maskDura == 0)
					return;
				
				entity.addPotionEffect(new PotionEffect(HbmPotion.radiation.id, maskDura * 20, maskLevel));
				return;
			}
		}
		
		entity.addPotionEffect(new PotionEffect(HbmPotion.radiation.id, radDura * 20, radLevel));
	}*/
	
	
	
	public static boolean checkForFaraday(EntityPlayer player) {
		
		ItemStack[] armor = player.inventory.armorInventory;
		
		if(armor[0] == null || armor[1] == null || armor[2] == null || armor[3] == null) return false;
		
		if(isFaradayArmor(armor[0].getItem()) &&
				isFaradayArmor(armor[1].getItem()) &&
				isFaradayArmor(armor[2].getItem()) &&
				isFaradayArmor(armor[3].getItem()))
			return true;
		
		return false;
	}
	public static long chargeItemsFromTE(ItemStack[] slots, int index, long power, long maxPower) {

		if(slots[index] != null && slots[index].getItem() instanceof IBatteryItem) {

			IBatteryItem battery = (IBatteryItem) slots[index].getItem();

			long batMax = battery.getMaxCharge();
			long batCharge = battery.getCharge(slots[index]);
			long batRate = battery.getChargeRate();

			//in hHE
			long toCharge = Math.min(Math.min(power, batRate), batMax - batCharge);

			power -= toCharge;

			battery.chargeBattery(slots[index], toCharge);


		}

		return power;
	}
	public static final String[] metals = new String[] {
			"chainmail",
			"iron",
			"silver",
			"gold",
			"platinum",
			"tin",
			"lead",
			"schrabidium",
			"euphemium",
			"steel",
			"titanium",
			"alloy",
			"copper",
			"bronze",
			"electrum",
			"t45",
			"hazmat", //also count because rubber is insulating
			"rubber"
	};
	
	public static boolean isFaradayArmor(Item item) {
		
		String name = item.getUnlocalizedName();
		
		for(String metal : metals) {
			
			if(name.toLowerCase().contains(metal))
				return true;
		}
		
		return false;
	}
	
	
	
	public static boolean checkForHeld(EntityPlayer player, Item item) {
		
		if(player.getHeldItem() == null)
			return false;
		
		return player.getHeldItem().getItem() == item;
	}
	
	
	
	//////  //////  //////  //////  //////  ////        //////  //////  //////
	//      //  //  //        //    //      //  //      //      //      //    
	////    //////  /////     //    ////    ////        ////    //  //  //  //
	//      //  //     //     //    //      //  //      //      //  //  //  //
	//////  //  //  /////     //    //////  //  //      //////  //////  //////

	
	

	public static EntityPlayer getClosestPlayerForSound(World world, double x, double y, double z, double radius) {
		double d4 = -1.0D;
		EntityPlayer entity = null;

		for (int i = 0; i < world.loadedEntityList.size(); ++i) {
				Entity entityplayer1 = (Entity)world.loadedEntityList.get(i);

				if (entityplayer1.isEntityAlive() && entityplayer1 instanceof EntityPlayer) {
					double d5 = entityplayer1.getDistanceSq(x, y, z);
					double d6 = radius;

					if ((radius < 0.0D || d5 < d6 * d6) && (d4 == -1.0D || d5 < d4)) {
						d4 = d5;
						entity = (EntityPlayer)entityplayer1;
					}
			}
		}

		return entity;
	}

	

	
	
	public static MovingObjectPosition rayTrace(EntityPlayer player, double d, float f) {
        Vec3 vec3 = getPosition(f, player);
        vec3.yCoord += player.eyeHeight;
        Vec3 vec31 = player.getLook(f);
        Vec3 vec32 = vec3.addVector(vec31.xCoord * d, vec31.yCoord * d, vec31.zCoord * d);
        return player.worldObj.func_147447_a(vec3, vec32, false, false, true);
	}
	
    public static Vec3 getPosition(float par1, EntityPlayer player) {
        if (par1 == 1.0F)
        {
            return Vec3.createVectorHelper(player.posX, player.posY + (player.getEyeHeight() - player.getDefaultEyeHeight()), player.posZ);
        }
        else
        {
            double d0 = player.prevPosX + (player.posX - player.prevPosX) * par1;
            double d1 = player.prevPosY + (player.posY - player.prevPosY) * par1 + (player.getEyeHeight() - player.getDefaultEyeHeight());
            double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * par1;
            return Vec3.createVectorHelper(d0, d1, d2);
        }
    }
	
	public static List<int[]> getBlockPosInPath(int x, int y, int z, int length, Vec3 vec0) {
		List<int[]> list = new ArrayList<int[]>();
		
		for(int i = 0; i <= length; i++) {
			list.add(new int[] { (int)(x + (vec0.xCoord * i)), y, (int)(z + (vec0.zCoord * i)), i });
		}
		
		return list;
	}
	
	public static String getShortNumber(long l) {

		if(l >= Math.pow(10, 18)) {
			double res = l / Math.pow(10, 18);
			res = Math.round(res * 100.0) / 100.0;
			return res + "E";
		}
		if(l >= Math.pow(10, 15)) {
			double res = l / Math.pow(10, 15);
			res = Math.round(res * 100.0) / 100.0;
			return res + "P";
		}
		if(l >= Math.pow(10, 12)) {
			double res = l / Math.pow(10, 12);
			res = Math.round(res * 100.0) / 100.0;
			return res + "T";
		}
		if(l >= Math.pow(10, 9)) {
			double res = l / Math.pow(10, 9);
			res = Math.round(res * 100.0) / 100.0;
			return res + "G";
		}
		if(l >= Math.pow(10, 6)) {
			double res = l / Math.pow(10, 6);
			res = Math.round(res * 100.0) / 100.0;
			return res + "M";
		}
		if(l >= Math.pow(10, 3)) {
			double res = l / Math.pow(10, 3);
			res = Math.round(res * 100.0) / 100.0;
			return res + "k";
		}
		
		return Long.toString(l);
	}
	
	
	
	
	
	public static boolean isArrayEmpty(Object[] array) {
		if(array == null)
			return true;
		if(array.length == 0)
			return true;
		
		boolean flag = true;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null)
				flag = false;
		}
		
		return flag;
	}
	
	public static ItemStack carefulCopy(ItemStack stack) {
		if(stack == null)
			return null;
		else
			return stack.copy();
	}
	
	public static boolean isObstructed(World world, double x, double y, double z, double a, double b, double c) {
		
		MovingObjectPosition pos = world.rayTraceBlocks(Vec3.createVectorHelper(x, y, z), Vec3.createVectorHelper(a, b, c));
		
		return pos != null;
	}
	
	public static int getFirstNullIndex(int start, Object[] array) {
		for(int i = start; i < array.length; i++) {
			if(array[i] == null)
				return i;
		}
		return -1;
	}
	public static void transmitFluid(int x, int y, int z, boolean newTact, IFluidSource that, World worldObj, FluidType type) {
		Block block = worldObj.getBlock(x, y, z);
		TileEntity tileentity = worldObj.getTileEntity(x, y, z);
		
		//Chemplant
		
		
		
		if(tileentity == that)
			tileentity = null;
		
		
			
		
		
		if(tileentity instanceof IFluidAcceptor && newTact && !(tileentity instanceof TileEntitySingularityNuke && ((TileEntitySingularityNuke)tileentity).dna())
				&& ((IFluidAcceptor)tileentity).getMaxFluidFill(type) > 0 && ((IFluidAcceptor)tileentity).getMaxFluidFill(type) - ((IFluidAcceptor)tileentity).getFluidFill(type) > 0)
		{
			that.getFluidList(type).add((IFluidAcceptor)tileentity);
		}
		
		if(!newTact)
		{
			int size = that.getFluidList(type).size();
			if(size > 0)
			{
				int part = that.getFluidFill(type) / size;
				for(IFluidAcceptor consume : that.getFluidList(type))
				{
					if(consume.getFluidFill(type) < consume.getMaxFluidFill(type))
					{
						if(consume.getMaxFluidFill(type) - consume.getFluidFill(type) >= part)
						{
							that.setFluidFill(that.getFluidFill(type)-part, type);
							consume.setFluidFill(consume.getFluidFill(type) + part, type);
						} else {
							that.setFluidFill(that.getFluidFill(type) - (consume.getMaxFluidFill(type) - consume.getFluidFill(type)), type);
							consume.setFluidFill(consume.getMaxFluidFill(type), type);
						}
					}
				}
			}
			that.clearFluidList(type);
		}
	}
	
}
