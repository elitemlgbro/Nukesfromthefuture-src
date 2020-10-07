package nukesfromthefuture;



import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.Achievement;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import nukesfromthefuture.blocks.*;
import nukesfromthefuture.boime.BiomeRegistry;
import nukesfromthefuture.command.Test;
import nukesfromthefuture.container.FluidContainer;
import nukesfromthefuture.container.FluidContainerRegistry;
import nukesfromthefuture.creativeTabs.Food;
import nukesfromthefuture.creativeTabs.Machines;
import nukesfromthefuture.creativeTabs.Resources;
import nukesfromthefuture.creativeTabs.UselessStuff;
import nukesfromthefuture.creativeTabs.WeaponsnReee;
import nukesfromthefuture.dimensions.DimRegistry;
import nukesfromthefuture.entity.*;
import nukesfromthefuture.gen.NffOreGeneration;
import nukesfromthefuture.handler.FluidTypeHandler.FluidType;
import nukesfromthefuture.items.*;
import nukesfromthefuture.packet.PacketDispatcher;
import nukesfromthefuture.potion.NftfPotion;
import nukesfromthefuture.proxy.CommonProxy;
import org.apache.logging.log4j.Logger;



@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.version, canBeDeactivated = true, guiFactory = Reference.GUIFACT)
public class Nukesfromthefuture{
	public static Configuration config;
	public static int mk4 = 1024;
	public static Item obese_man;
	public static Block trololo;
	public static Item black_hole;
	public static Item singularity_magnet;
	public static Item POTATO;
	public static Item Cooked_POTATO;
	public static Block ego_nuke;
	public static Block ego_ore;
	public static Item ego_ingot;
	public static Block waste;
	public static Block nether_reactor2;
	public static Block the_flood;
	public static Block ego_furnace;
	public static Block time_fissures;
	public static Item radioCake;
	public static Block the_beta;
	public static Block unrefinary;
	public static Block ego_furnace_on;
	public static Item poorly_drawn_fuse;
	public static Item my_ego;
	public static final int guiID_nuke_boy = 0;
	public static final int QwQ = 1;
	public static Block antiTime;
	public static Block singularity_nuke;
	public static Block big_boy;
	public static Block POTATO_nuke;
	public static Block liquifier;
	public static Block superVolcano;
	public static Block skinny_man;
	public static Block craterCoverer;
	public static Block lightning;
	public static Item componetTeleporter;
	public static Item empty_rod;
	public static Item rod;
	public static Item manual_detonator;
	public static Block plutonium_ore;
	public static Item pizza;
	public static Item hydrolic_press;
	public static Item unstable_plutonium_ingot;
	public static Item plutonium_ingot;
	public static Item spawn;
	/**I HATE U SUSHI*/
	public static Item sushi_pizza;
	public static Item copper_wire;
	public static Block radioactive_cake;	
	public static Block radioactive_pizza;
	public static Block tut_block;
	public static Item coppa;
	public static Item fluid_identifier;
	public static Block time_fissure_log;
	public static Item schrabidium_cape;
	public static Block agri_essor;
	public static Block POTATOblock;
	public static Block UwU;
	public static Block anime_nuke;
	public static Block solidifier;
	public static Item creep_cape;
	public static Item light;
	public static Item plutoniuml;
	public static Block curse_portal;
	public static Item lightning_summon;
	public static Item energy_extractor;
	public static Block trololo_nuke;
	public static Item uranium_atom;
	public static Item canned_radiation;
	public static Achievement ego_explod;
	public static Block coord_transporteer;
	public static Block ego_block;
	public static Item my_cape;
	public static Item detonator;
	public static Item real_radioactive_pizza;
	public static Block test_blok;
	public static Block transmutator;
	public static Achievement lost_achievement;
	public static Item fire_gun;
	public static Block cursed_ore;
	public static Block Deathinum_ore;
	public static Block earthinum_ore;
	public static File UmU = new File("config/nukesfromthefuture.cfg");
	public static Item opposite_o_succ;
	public static Block marsinum_ore;
	public static Block Saturninum_ore;
	public static Item Sour_cape;
	public static Achievement POTATOKill;
	public static Item copper_ingot;
	public static final int UvU = 5;
	public static Item atom_knife;
	public static Item energizer;
	public static Block copper_ore;
	public static Block clickable_bomb;
	public static Item anti_time_ingot;
	public static boolean old_ego;
	public static Item deathinum_ingot;
	public static int trol_strength;
	public static boolean skeppy_enabled;
	public static int egoNukeStrength;
	public static int egoNukeSpeed;
	public static boolean elevation = true;
	public static Block nether_reactor;
	public static Item battery;
	public static int colliderStrength;
	public static int colliderSpeed;
	public static Item lead_tank;
	public static Item liquid_radiation;
	public static Block waste_wood;
	public static int antitimebuff;
	public static Achievement uDed;
	public static Block red_obsidian;
	public static int flood_strength;
	public static int antitimespeed;
	public static int coverStrength;
	public static Item fluid_barrel_empty;
	public static Item fluid_barrel_full;
	public static Item infinite_battery;
	public static Item coord_cache;
	public static int cont;
	public static Item lighter;
	public static int fogRad;
	public static Achievement yay_rad;
	public static int trol_speed;
	public static Item antimatter;
	public static Item deathinum_sword;
	public static int Boystrength;
	public static int beta_strength;
	public static Item deathinum_pick;
	public static Block reactor_burnt_out;
	public static Item fire;
	public static int Volcano_strength;
	public static int Boyspeed;
	public static float hellrad;
	public static Item fluid_icon;
	public static Item lead_food;
	public static Item donut;
	public static Item mentos_fo_lava;
	public static boolean POTATOtofries;
	public static int Manbuff;
	public static boolean enableRad;
	public static int POTATOSTRENGTH;
	public static int POTATOSPEED;
	public static int Manspeed;
	public static int rain;
	public static int coverSpeed;
	public static final int ee = 3;
	public static boolean coverExposed;
	private static final String CATEGORY_NUKE = "explosionsize";

	public static final Item.ToolMaterial deathinumTools = EnumHelper.addToolMaterial("deathinum" ,999999999, 999999999, 9999999999F, 99999999999999F, 1000);
	@Instance
	public static Nukesfromthefuture instance = new Nukesfromthefuture();
	
	
	@SidedProxy(clientSide = Reference.Client_Proxy_Class, serverSide = Reference.Server_Proxy_Class)
	public static CommonProxy proxy;

	public static Logger logger;
	@EventHandler

	public void preInit(FMLPreInitializationEvent event) {
		if(logger == null)
			event.getModLog();
		//-_- all that code for a config file
		config = new Configuration(UmU);
		config.load();
		
		FMLCommonHandler.instance().bus().register(new ModEventHandler());
		rain = config.get("explosionsize", "aaaaa", 0).getInt();
		hellrad = config.get("explosionsize", "hellrad", 10).getInt() * 0.1F;
		cont = config.get("explosionsize", "cont", 0).getInt();
		enableRad = config.get("explosionsize", "enableRad", true).getBoolean(true);
		fogRad = config.get("explosionsize", "fogRad", 200).getInt();
		old_ego = config.get("hiddenblocks", "oldEgoNukeEnabled", false).getBoolean(false);
		flood_strength = config.get("explosionsize", "flood_Strength", 100).getInt();
		beta_strength = config.get("explosionsize", "betastrength", 230).getInt();
		skeppy_enabled = config.getBoolean("skeppy_enabled", "hiddenblocks", false, "eeeeeeeeeeee");
		trol_speed = config.getInt("TrollSpeed", "explosionsize", 12, 0, 1000000000, "The speed of the trololo nuke explosion");
		trol_strength = config.getInt("TrollStrength", "explosionsize", 100, 0, 100000000, "The strength of the troolololo nuke");
		egoNukeStrength = config.get("explosionsize", "egoNukeStrength", 300).getInt();
		egoNukeSpeed = config.get("explosionsize", "egoNukeSpeed", 8).getInt();
		POTATOtofries = config.getBoolean("POTATOtofries", "explosionsize", false, "turns Cooked POTATO to fries");
		elevation = config.get("explosionsize", "elevation", true).getBoolean(true);
		trololo_nuke = new Trol(Material.anvil).setBlockName("Trololo_nuke").setCreativeTab(nffreee).setHardness(50F).setBlockTextureName("nff:trol");
		Manbuff = config.get("explosionsize", "manbuff", 100).getInt();
		POTATOSTRENGTH = config.getInt("Ps", "explosionsize", 250, 0, 10000, "POTATO");
		POTATOSPEED = config.get("explosionsize", "PSS", 12).getInt();
		Property propFalloutRange = config.get(CATEGORY_NUKE, "6.02_blastSpeedNew", 1024);
		mk4 = propFalloutRange.getInt();    
		config.setCategoryComment("hiddenblocks", "uhhhhh u didn't see anything");
		Manspeed = config.get("explosionsize", "manspeed", 12).getInt();
		colliderStrength = config.get("explosionsize", "colliderStrength", 150).getInt();
		colliderSpeed = config.get("explosionsize", "colliderSpeed", 12).getInt();
		coverStrength = config.get("explosionsize", "coverstrength", 90).getInt();
		coverSpeed = config.get("explosionsize", "coverspeed", 12).getInt();
		antitimebuff = config.get("explosionsize", "antitimebuff", 200).getInt();
		Boystrength = config.get("explosionsize", "Boybuff", 140).getInt();
		Volcano_strength = config.get("explosionsize", "VolcanoStrength", 150).getInt();
		Boyspeed = config.get("explosionsize", "Boyspeed", 12).getInt();
		antitimespeed = config.get("explosionsize", "antitimespeed", 30).getInt();
		coverExposed = config.get("hiddenblocks", "crasherExposed", false).getBoolean(false);
		config.save();
		//uhhhhhhh
		lead_food = new LeadFood(2, 1.0F, false).setUnlocalizedName("lead_nugget").setCreativeTab(food).setTextureName("nff:nugget");
		infinite_battery = new Item().setUnlocalizedName("battery_creative").setCreativeTab(machines).setMaxStackSize(1).setTextureName("nff:batinf");
		energizer = new Battery(100, 100, 10).setUnlocalizedName("benergizer").setCreativeTab(machines).setTextureName("nff:energizer");
		battery = new Battery(10000, 1000, 100).setUnlocalizedName("battery").setCreativeTab(machines).setTextureName("nff:batr").setMaxStackSize(1);
		donut = new Donut(10, 5, false).setUnlocalizedName("donut").setTextureName("nff:donut").setCreativeTab(food);
        reactor_burnt_out = new BurntOut(Material.iron).setBlockName("burnt_out_reactor").setBlockUnbreakable().setBlockTextureName("nff:nrc3");
		detonator = new Detonator().setUnlocalizedName("detonator").setCreativeTab(machines).setTextureName("nff:detonator");
		nether_reactor2 = new NetherReact(Material.iron).setBlockName("nether_reactor2").setBlockUnbreakable().setBlockTextureName("nff:nrc2");
		red_obsidian = new RedObsidian(Material.iron).setCreativeTab(bloks).setBlockName("red_obsidian").setBlockTextureName("nff:glowingobsidian").setStepSound(Block.soundTypeMetal).setBlockUnbreakable().setLightLevel(1.0F);
        nether_reactor = new NetherReact(Material.iron).setCreativeTab(machines).setBlockName("nether_reactor").setHardness(1.0F).setBlockTextureName("nff:nrc1");
		waste_wood = new Waste(Material.wood, true).setBlockName("waste_wood").setCreativeTab(bloks).setHardness(0.8F).setResistance(1.0F).setStepSound(Block.soundTypeWood);
		deathinum_pick = new PickDeathinum(deathinumTools).setUnlocalizedName("deathinum_pickaxe").setCreativeTab(nffreee).setTextureName("nff:deathinum_pick");
		deathinum_sword = new DeathinumSword(deathinumTools).setUnlocalizedName("Deathinum_sword").setCreativeTab(nffreee).setTextureName("nff:deathinum_sword");
		deathinum_ingot = new Item().setUnlocalizedName("deathinum_ingot").setCreativeTab(resources).setTextureName("nff:deathinum");
		uranium_atom = new Item().setUnlocalizedName("uranium-atom").setCreativeTab(resources).setTextureName("nff:atom");
		atom_knife = new Item().setUnlocalizedName("atom_knife").setCreativeTab(machines).setTextureName("nff:splitter");
		lighter = new Item().setUnlocalizedName("lighter").setCreativeTab(machines).setTextureName("nff:lighter");
		mentos_fo_lava = new Item().setUnlocalizedName("mentos_fo_lava").setCreativeTab(food);
		fluid_identifier = new ItemFluidIdentifier().setUnlocalizedName("fluid_identifier").setMaxStackSize(1).setCreativeTab(machines).setTextureName("nff:fluid_identifier");
		fluid_icon = new ItemFluidIcon().setUnlocalizedName("fluid_icon").setCreativeTab(null).setTextureName("nff:fluid_icon");
		anti_time_ingot = new Item().setUnlocalizedName("antitime_ingot").setCreativeTab(resources).setTextureName("nff:anti_time");
		singularity_magnet = new Magnet().setUnlocalizedName("singularity_magnet").setCreativeTab(machines).setTextureName("nff:magnet");
		energy_extractor = new EnergyExtractor().setUnlocalizedName("energy_extractor").setCreativeTab(machines).setTextureName("nff:energy_extractor");
		ego_furnace = new EgoFurnace(false).setBlockName("egonium_furnace").setCreativeTab(machines).setStepSound(Block.soundTypeStone);
		ego_furnace_on = new EgoFurnace(true).setBlockName("egonium_furnace_on").setHardness(2.0F).setStepSound(Block.soundTypeStone);
		opposite_o_succ = new ExplosionGun().setUnlocalizedName("explosion_gun").setCreativeTab(nffreee);
		canned_radiation = new CannedRad(5, 10, false).setUnlocalizedName("canned_radiation").setCreativeTab(food).setTextureName("nff:canned_radiation");
		anime_nuke = new AniNuke().setBlockName("Anime_nuke").setCreativeTab(nffreee).setHardness(100);
		agri_essor = new Agriessor(Material.rock).setBlockName("Agri-essor").setCreativeTab(nffreee).setHardness(60F).setStepSound(Block.soundTypeAnvil);
		UwU = new UwU(Material.clay).setBlockName("UwU").setCreativeTab(bloks);
		fire = new Fire().setUnlocalizedName("fire").setTextureName("nff:fireUwU");
		fire_gun = new FireGun().setUnlocalizedName("flamethrower").setCreativeTab(nffreee).setTextureName("nff:fireGun");
		the_flood = new TheFlood().setBlockName("the_flood").setCreativeTab(nffreee);
		coppa = new Coppa().setUnlocalizedName("coppa").setCreativeTab(resources).setTextureName("nff:coppea");
		the_beta = new TheBeta(Material.iron).setBlockName("The_Beta").setCreativeTab(nffreee).setBlockTextureName("nff:beta").setHardness(3.0F);
		plutoniuml = new PlutoL().setUnlocalizedName("Liquified_plutonoim").setTextureName("nff:plutia").setCreativeTab(resources);
		antimatter = new AntiMatter().setUnlocalizedName("AntiMat").setCreativeTab(resources).setTextureName("nff:antimatter");
		light = new Light().setUnlocalizedName("Light").setCreativeTab(nffreee).setTextureName("nff:light");
		lightning = new Lightning().setBlockName("Lightning_summoner").setCreativeTab(machines).setBlockTextureName("nff:lightlol");
		creep_cape = new ArmorModel(ArmorMaterial.DIAMOND, 3, 1).setUnlocalizedName("creep_cape").setCreativeTab(uselessStuff).setTextureName("nff:v");
		waste = new Waste(Material.grass, true).setBlockName("waste").setCreativeTab(resources).setStepSound(Block.soundTypeGrass);
		tut_block = new TutBlock(Material.clay).setBlockName("Wtut_block").setCreativeTab(bloks).setHardness(5.0F);
		coord_transporteer = new CoordTrans(Material.iron).setBlockName("Coord_transporter").setBlockTextureName("nff:coord_transport").setCreativeTab(machines);
		obese_man = new Itemobese_man().setUnlocalizedName("obese_man").setTextureName("nff:obese_man").setCreativeTab(uselessStuff);
		trololo = new BlockTrololo().setBlockName("trololo").setBlockTextureName("nff:trololo").setCreativeTab(uselessStuff);
		test_blok = new Testblok().setBlockName("TestBlock").setCreativeTab(uselessStuff);
		Deathinum_ore = new Deathinum(Material.iron).setBlockName("deathinum_Ore").setCreativeTab(resources).setHardness(30F).setBlockTextureName("nff:deathinum").setHardness(2.5F).setResistance(1.0F).setStepSound(Block.soundTypeGrass);
		curse_portal = new CursePort().setBlockName("cuss_portal").setBlockUnbreakable();
		lightning_summon = new LightningSummon().setUnlocalizedName("summon_light").setTextureName("nff:lightning").setCreativeTab(nffreee);
		clickable_bomb = new ClickBob(Material.tnt).setBlockName("clickable_bomb").setCreativeTab(nffreee);
		schrabidium_cape = new ArmorModel(ArmorMaterial.DIAMOND, 2, 1).setUnlocalizedName("schrabidium_cape").setCreativeTab(uselessStuff).setTextureName("nff:cape_unknown");
		Sour_cape = new ArmorModel(ArmorMaterial.DIAMOND, 0, 1).setUnlocalizedName("SourCape").setCreativeTab(uselessStuff).setTextureName("nff:cape_unknown");
		my_cape = new ArmorModel(ArmorMaterial.DIAMOND, 1, 1).setUnlocalizedName("my_cape").setCreativeTab(uselessStuff).setTextureName("nff:cape_unknown");
		POTATOblock = new POTATOBLOCK(Material.tnt).setBlockName("POTATOblock").setCreativeTab(uselessStuff).setBlockTextureName("nff:POTATOBLOCK");
		radioCake = new ItemReed(radioactive_cake).setUnlocalizedName("RadCake").setTextureName("nff:radcak").setCreativeTab(food);
		radioactive_cake = new RadioactiveCake().setBlockName("Radioactive_cake").setCreativeTab(food).setBlockTextureName("nff:radiocak").setStepSound(Block.soundTypeCloth);
		POTATO_nuke = new POTATONook(Material.anvil).setBlockName("POTATO_Nuke").setCreativeTab(nffreee).setBlockTextureName("nff:POTATONOOK");
		POTATO = new ItemPOTATO().setUnlocalizedName("POTATO").setTextureName("nff:POTATO").setCreativeTab(nffreee);
		Cooked_POTATO = new ItemCooked_POTATO().setUnlocalizedName("Coooked_POTATO").setCreativeTab(food);                                           
		pizza = new Pizza(20, 5.0F, true).setUnlocalizedName("Pizza").setCreativeTab(food).setTextureName("nff:pizza");
		sushi_pizza = new ShuPizza(8, 3.0F, false).setUnlocalizedName("Shushi_Pizza").setCreativeTab(food).setTextureName("nff:shuPizza").setTextureName("nff:shuPizza");
		real_radioactive_pizza = new Radiopizza(6, 1.0F, false).setUnlocalizedName("radioactive_pizza").setCreativeTab(food).setTextureName("nff:pizzaradio");
		//nukes                    
		coord_cache = new CoordCache().setUnlocalizedName("coord_cache").setCreativeTab(machines).setTextureName("nff:coord_cache");
		singularity_nuke = new BlockSingularityNuke().setBlockName("singularity_nuke").setCreativeTab(nffreee).setBlockTextureName("nff:singularity_nuke");
		big_boy = new BigBoy(Material.anvil).setBlockName("big_boy").setBlockTextureName("nff:fatMan").setCreativeTab(nffreee);
		skinny_man = new SkinnyMan().setBlockName("skinny_man").setBlockTextureName("nff:lilBoy").setCreativeTab(nffreee);
		craterCoverer = new CraterCoverer().setBlockName("craterCoverer").setBlockTextureName("nff:craterCove");
		antiTime = new Antitime().setBlockName("AntiTimeNuke").setCreativeTab(nffreee).setBlockTextureName("nff:AntiTime");  
		//........0-0 more wot
		EntityRegistry.registerModEntity(EntityLight.class, "LightningSummon", 50, this, 100000, 1000000000, true);
		ego_nuke = new Blockego_nuke(Material.anvil, guiID_nuke_boy).setBlockName("ego_nuke").setBlockTextureName("nff:blimp").setCreativeTab(nffreee);
		//resources
		rod = new ItemRod().setUnlocalizedName("fuel_rod").setCreativeTab(resources).setContainerItem(empty_rod).setTextureName("nff:rod_empty");
		empty_rod = new Item().setUnlocalizedName("empty_rod").setTextureName("nff:rod_empty").setCreativeTab(resources);
		fluid_barrel_empty = new Item().setUnlocalizedName("fluid_barrel_empty").setTextureName("nff:fluid_barrel").setCreativeTab(resources);
		fluid_barrel_full = new ItemFluidTank().setUnlocalizedName("fluid_barrel_full").setContainerItem(fluid_barrel_empty).setCreativeTab(resources).setTextureName("nff:fluid_barrel");
		black_hole = new Blak_whole().setUnlocalizedName("black_hole").setCreativeTab(nffreee).setTextureName("nff:black_hole");
		marsinum_ore = new Mars().setBlockName("Marsinum_ore").setCreativeTab(resources).setHardness(25).setBlockTextureName("nff:marsinum");
		ego_block = new EgoBlock(Material.iron).setBlockName("Ego_block").setCreativeTab(resources).setBlockTextureName("nff:ego_block").setHardness(5.0F);
		unstable_plutonium_ingot = new UnstableIngot().setUnlocalizedName("Unstable_plutonium_ingot").setCreativeTab(resources).setTextureName("nff:unstable");
		plutonium_ingot = new PlutoniumIngot().setUnlocalizedName("plutonium_ingot").setCreativeTab(resources).setTextureName("nff:pluto");
		copper_wire = new CopperWire().setUnlocalizedName("copper_wire").setCreativeTab(resources).setTextureName("nff:coppa");
		copper_ingot = new CopperIngot().setUnlocalizedName("Copper_ingot").setCreativeTab(resources).setTextureName("nff:copper_ingot");
		copper_ore = new Copperore(Material.iron).setBlockName("CopperOre").setBlockTextureName("nff:copper").setCreativeTab(resources).setHardness(3.0F);
		ego_ore = new Blockego_ore().setBlockName("ego_ore").setBlockTextureName("nff:element_not_on_p_table_ore").setCreativeTab(resources);
		ego_ingot = new ItemEgo_ingot().setUnlocalizedName("ego_ingot").setTextureName("nff:ego_ingot").setCreativeTab(resources);
		plutonium_ore = new PlutoniumOre(Material.iron).setBlockName("PlutoniumOre").setBlockTextureName("nff:pluto_ore").setCreativeTab(resources);
		//machines
		BiomeRegistry.init();
		superVolcano = new SuperEE(Material.iron).setBlockName("Super_volcano").setHardness(50F).setCreativeTab(nffreee).setBlockTextureName("nff:volcano");
		solidifier = new Solidifier(Material.iron).setBlockName("Solidifier").setCreativeTab(machines).setBlockTextureName("nff:unclassified");
		liquifier = new Liquifier(Material.rock).setBlockName("liquifier").setCreativeTab(machines).setBlockTextureName("nff:liquifier");
		hydrolic_press = new HydrolicPress().setUnlocalizedName("Hydrolic_press").setCreativeTab(machines).setTextureName("nff:Hydra");
		transmutator = new Transmutator(Material.iron).setBlockName("AntiTimeTransmutator").setCreativeTab(machines).setBlockTextureName("nff:poorlydrawn");
		manual_detonator = new ManualDetonator().setUnlocalizedName("manual_detonator").setCreativeTab(machines).setTextureName("nff:suicideDetonator");
		componetTeleporter = new ComponetTeleporter().setUnlocalizedName("componet_teleporter").setCreativeTab(machines).setTextureName("nff:componetlol");
		unrefinary = new BlockUnrefinary().setBlockName("unrefinary").setBlockTextureName("nff:unrefinery").setCreativeTab(machines);
		poorly_drawn_fuse = new ItemPoorlyDrawnFuse().setUnlocalizedName("poorly_drawn_fuse").setTextureName("nff:poorly_drawn_fuse").setCreativeTab(machines);
		my_ego = new ItemMyEgo().setUnlocalizedName("my_ego").setTextureName("nff:my_ego").setCreativeTab(resources);
		radioactive_pizza = new Reactor(Material.iron).setBlockName("reactor").setCreativeTab(machines).setBlockTextureName("nff:unclassified");
		time_fissure_log = new Timefissurelog(Material.anvil).setBlockName("TimeFissureLog");
		time_fissures = new Timefissure(Material.anvil).setBlockName("TimeFissure").setBlockTextureName("nff:lol");
		//these aren't organized at all, i wuz too lazy
		GameRegistry.registerItem(obese_man, obese_man.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pizza, pizza.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(creep_cape, creep_cape.getUnlocalizedName().substring(5));
		MinecraftForge.TERRAIN_GEN_BUS.register(new ModEventHandler());
		MinecraftForge.ORE_GEN_BUS.register(new ModEventHandler());
		MinecraftForge.EVENT_BUS.register(new ModEventHandler());
		GameRegistry.registerBlock(trololo, trololo.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(POTATO, POTATO.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(plutoniuml, plutoniuml.getUnlocalizedName());
		BiomeRegistry.register();
		EntityRegistry.registerModEntity(FalloutRain.class, "fallout", 53, this, 10000, 1, true);
		GameRegistry.registerItem(mentos_fo_lava, mentos_fo_lava.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(componetTeleporter, componetTeleporter.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(red_obsidian, red_obsidian.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Cooked_POTATO, Cooked_POTATO.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ego_nuke, ItemEgo_nukeBlock.class, ego_nuke.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ego_ore, ego_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(nether_reactor2, nether_reactor2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(antiTime, BlockLore.class, antiTime.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(uranium_atom, uranium_atom.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(copper_ore, copper_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(energy_extractor, energy_extractor.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(anti_time_ingot, anti_time_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(atom_knife, atom_knife.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(deathinum_ingot, deathinum_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(donut, donut.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lead_food, lead_food.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fluid_identifier, fluid_identifier.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(time_fissure_log, time_fissure_log.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(liquifier, liquifier.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(schrabidium_cape, schrabidium_cape.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(trololo_nuke, trololo_nuke.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(energizer, energizer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(battery, battery.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(infinite_battery, infinite_battery.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ego_ingot, ego_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(unrefinary, unrefinary.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(coppa, coppa.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(coord_cache, coord_cache.getUnlocalizedName().substring(5));
		EntityRegistry.registerModEntity(BombBalls.class, "bomb_balls", 51, this, 1000000000, 1, true);
		GameRegistry.registerItem(opposite_o_succ, opposite_o_succ.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fluid_barrel_empty, fluid_barrel_empty.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fluid_barrel_full, fluid_barrel_full.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(radioCake, radioCake.getUnlocalizedName().substring(5));
		DimRegistry.mainRegistry();
		GameRegistry.registerItem(canned_radiation, canned_radiation.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(UwU, UwU.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(singularity_magnet, singularity_magnet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(black_hole, black_hole.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fire, fire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tut_block, tut_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(superVolcano, superVolcano.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(marsinum_ore, marsinum_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(poorly_drawn_fuse, poorly_drawn_fuse.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(my_ego, my_ego.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(empty_rod, empty_rod.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(rod, rod.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ego_furnace, ego_furnace.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ego_furnace_on, ego_furnace_on.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(light, light.getUnlocalizedName());
		GameRegistry.registerBlock(curse_portal, curse_portal.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(nether_reactor, nether_reactor.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(reactor_burnt_out, reactor_burnt_out.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(clickable_bomb, clickable_bomb.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(POTATOblock, POTATOblock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ego_block, ego_block.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Sour_cape, Sour_cape.getUnlocalizedName().substring(5));
		EntityRegistry.registerGlobalEntityID(RadioactiveSpider.class, "RadioSpider", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x04FF00);
		GameRegistry.registerItem(lightning_summon, lightning_summon.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(plutonium_ingot, plutonium_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(Deathinum_ore, Deathinum_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(coord_transporteer, coord_transporteer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_ingot, copper_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(agri_essor, agri_essor.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(transmutator, transmutator.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(waste, waste.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(waste_wood, waste_wood.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fire_gun, fire_gun.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(POTATO_nuke, POTATO_nuke.getUnlocalizedName().substring(5));
		PacketDispatcher.registerPackets();
        NftfPotion.init();
		GameRegistry.registerItem(deathinum_sword, deathinum_sword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(deathinum_pick, deathinum_pick.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(radioactive_cake, radioactive_cake.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(the_flood, the_flood.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(radioactive_pizza, radioactive_pizza.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(big_boy, big_boy.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_wire, copper_wire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(the_beta, BlockLore.class, the_beta.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(time_fissures, time_fissures.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(unstable_plutonium_ingot, unstable_plutonium_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(test_blok, test_blok.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(my_cape, my_cape.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(lightning, lightning.getUnlocalizedName());
		GameRegistry.registerBlock(singularity_nuke, BlockLore.class, singularity_nuke.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(hydrolic_press, hydrolic_press.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(skinny_man, skinny_man.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sushi_pizza, sushi_pizza.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(real_radioactive_pizza, real_radioactive_pizza.getUnlocalizedName().substring(5));
		if(Nukesfromthefuture.coverExposed) {
			GameRegistry.registerBlock(craterCoverer, BlockLore.class, craterCoverer.getUnlocalizedName().substring(5));
		}
		if(Nukesfromthefuture.skeppy_enabled) {
		EntityRegistry.registerGlobalEntityID(Skeppy.class, "skepp", EntityRegistry.findGlobalUniqueEntityId(), 0xFF0004, 0xFFE100);
		}
		GameRegistry.registerBlock(solidifier, solidifier.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(plutonium_ore, plutonium_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(manual_detonator, manual_detonator.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(detonator, detonator.getUnlocalizedName().substring(5));
		EntityRegistry.registerModEntity(EntityPOTATO.class, "EPOTATO", 0 , this, 100000, 1, true);
		EntityRegistry.registerModEntity(NukeMushroom.class, "nooclear_mushroom", 54, this, 1000000, 1, true);
		EntityRegistry.addSpawn(EntityPizzaCreeper.class, 100, 1, 15, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills,
				BiomeGenBase.desert, BiomeGenBase.beach, BiomeGenBase.forest, BiomeGenBase.jungle, BiomeGenBase.swampland);
		EntityRegistry.addSpawn(EntityPizzaCreeper.class, 100000, 10, 40, EnumCreatureType.monster, BiomeGenBase.hell);
		EntityRegistry.registerModEntity(NukeMushroom.class, "NookMushroom", 1, this, 100000, 1, true);
		EntityRegistry.registerGlobalEntityID(EntityPizzaCreeper.class, "PizzaCreeper", EntityRegistry.findGlobalUniqueEntityId(), 0x07d215, 0xe50c0c);
		OreDictionary.registerOre("EgoOre", ego_ore);
		GameRegistry.registerItem(antimatter, antimatter.getUnlocalizedName());
		OreDictionary.registerOre("PlutoniumOre", plutonium_ore);
		GameRegistry.registerItem(lighter, lighter.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("copper_ore", copper_ore);
		GameRegistry.registerWorldGenerator(new NffOreGeneration(), 0);
		EntityRegistry.registerGlobalEntityID(EntityRadioCreeper.class, "radioactive_pizza_creeper", EntityRegistry.findGlobalUniqueEntityId(), 0x1000FF, 0x00FF19);
		EntityRegistry.registerModEntity(FireUwU.class, "fire", EntityRegistry.findGlobalUniqueEntityId(), this, 100000, 100, true);
	}
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		ICommandManager commandManager = MinecraftServer.getServer().getCommandManager();
		ServerCommandManager serverCommandManager = ((ServerCommandManager) commandManager);
		addCommands(serverCommandManager);
	}
	public void addCommands(ServerCommandManager register){
		register.registerCommand(new Test());
	}
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.registerRenders();
		GameRegistry.addSmelting(POTATO, new ItemStack(Cooked_POTATO), 100000000000000.0F);
		GameRegistry.addRecipe(new ItemStack(ego_nuke), new Object[] {"www",
																	  "wew",
																	  "www", 'w', ego_ingot, 'e', my_ego});
		
		GameRegistry.addRecipe(new ItemStack(copper_wire), new Object [] {" p ",
				                                                          " c ",
				                                                          "   ", 'p', hydrolic_press, 'c', copper_ingot});
		
		GameRegistry.addRecipe(new ItemStack(manual_detonator), new Object[] {"   ",
				                                                              "crc",
				                                                              "   ", 'r', Items.redstone, 'c', copper_wire});					
		POTATOKill = new Achievement("achievement.POTATOKill", "POTATOKill", 0, 0, POTATO, null).registerStat().initIndependentStat().setSpecial();
		yay_rad = new Achievement("achievement.radiation", "achievement.radiation", 2, 0, canned_radiation, null).initIndependentStat().registerStat();
		uDed = new Achievement("achievement.ouch_radiation", "axhievement.ouchRadiation", 2, 2, Items.skull, yay_rad).setSpecial().registerStat();
		ego_explod = new Achievement("achievement.ego_armed", "You arm the ego nuke OwO", 0, 2, ego_nuke, null).registerStat().initIndependentStat().setSpecial();
		AchievementPage.registerAchievementPage(new AchievementPage("Future Nukes", new Achievement[] {POTATOKill, ego_explod, yay_rad, uDed}));
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(Items.lava_bucket),
				new ItemStack(Items.bucket), FluidType.LAVA, 500));
		for(int i = 1; i < FluidType.values().length; i++) {
			
			FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(fluid_barrel_full, 1, i),
					new ItemStack(fluid_barrel_empty), FluidType.getEnum(i), 16000));
		}
	}
	
	
	public static Configuration getConfig() {
		return config;
	}
	@SubscribeEvent
	public void onCfgChange(ConfigChangedEvent.OnConfigChangedEvent event) {
		if(event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
			config.save();
		}
	}
	public static CreativeTabs uselessStuff = new UselessStuff("UselessStuff");
	public static CreativeTabs nffreee = new WeaponsnReee("weapons");
	public static CreativeTabs resources = new Resources("resources");
	public static CreativeTabs food = new Food("nff foods");
	public static CreativeTabs machines = new Machines("machines");
	public static CreativeTabs bloks = new Bloks("blocks");
	
}