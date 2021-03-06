 /*
 * -------------------------------------------------------------------------------------------------------
 * Class: Metallurgy
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: ItHurtsLikeHell & Davoleo
 * Copyright (c) 2020.
 * --------------------------------------------------------------------------------------------------------
 */

 package it.hurts.metallurgy_reforged;

 import it.hurts.metallurgy_reforged.capabilities.krik.IKrikEffect;
 import it.hurts.metallurgy_reforged.capabilities.krik.KrikEffectCallable;
 import it.hurts.metallurgy_reforged.capabilities.krik.KrikEffectStorage;
 import it.hurts.metallurgy_reforged.capabilities.punch.IPunchEffect;
 import it.hurts.metallurgy_reforged.capabilities.punch.PunchEffectCallable;
 import it.hurts.metallurgy_reforged.capabilities.punch.PunchEffectStorage;
 import it.hurts.metallurgy_reforged.config.GeneralConfig;
 import it.hurts.metallurgy_reforged.fluid.ModFluids;
 import it.hurts.metallurgy_reforged.gui.GuiHandler;
 import it.hurts.metallurgy_reforged.handler.TileEntityHandler;
 import it.hurts.metallurgy_reforged.integration.mods.IntegrationIF;
 import it.hurts.metallurgy_reforged.integration.mods.IntegrationProjectE;
 import it.hurts.metallurgy_reforged.integration.mods.conarm.IntegrationCArmory;
 import it.hurts.metallurgy_reforged.integration.mods.crafttweaker.IntegrationCT;
 import it.hurts.metallurgy_reforged.integration.mods.tic.IntegrationTIC;
 import it.hurts.metallurgy_reforged.material.ModMetals;
 import it.hurts.metallurgy_reforged.network.PacketManager;
 import it.hurts.metallurgy_reforged.proxy.CommonProxy;
 import it.hurts.metallurgy_reforged.recipe.CrusherRecipes;
 import it.hurts.metallurgy_reforged.recipe.ModRecipes;
 import it.hurts.metallurgy_reforged.util.ModChecker;
 import it.hurts.metallurgy_reforged.util.SubEvent;
 import it.hurts.metallurgy_reforged.world.ModWorldGen;
 import it.hurts.metallurgy_reforged.world.WorldTickHandler;
 import net.minecraftforge.common.MinecraftForge;
 import net.minecraftforge.common.capabilities.CapabilityManager;
 import net.minecraftforge.fluids.FluidRegistry;
 import net.minecraftforge.fml.common.Mod;
 import net.minecraftforge.fml.common.SidedProxy;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
 import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
 import net.minecraftforge.fml.common.network.NetworkRegistry;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 import org.apache.logging.log4j.Logger;

 @Mod(modid = Metallurgy.MODID, name = Metallurgy.NAME, version = Metallurgy.VERSION, dependencies = "required-after:forge@[14.23.5.2768,)", acceptedMinecraftVersions = "[1.12.2]")
 public class Metallurgy {

	 public static final String MODID = "metallurgy";
	 public static final String NAME = "Metallurgy 4: Reforged";
	 public static final String VERSION = "0.3.3";

	 public static Logger logger;

	 @Mod.Instance(MODID)
	 public static Metallurgy instance;

	 @SidedProxy(serverSide = "it.hurts.metallurgy_reforged.proxy.CommonProxy", clientSide = "it.hurts.metallurgy_reforged.proxy.ClientProxy")
	 public static CommonProxy proxy;

	 static
	 {
		 FluidRegistry.enableUniversalBucket();
	 }

	 @Mod.EventHandler
	 public void preInit(FMLPreInitializationEvent event)
	 {
		 logger = event.getModLog();
		 logger.info(NAME + " is entering pre-initialization!");
		 proxy.preInit(event);

		 ModMetals.registerFluids();
		 ModFluids.registerFluids();
		 logger.info("Fluid registration complete!");

		 GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
		 MinecraftForge.EVENT_BUS.register(ModWorldGen.instance);
		 MinecraftForge.EVENT_BUS.register(WorldTickHandler.instance);
		 logger.info("World generation successful!");

		 SubEvent.init();

		 TileEntityHandler.registerTileEntities();
		 logger.info("Tile Entities Registered!");

		 //		check if tinker is installed
		 if (ModChecker.isTConLoaded && !GeneralConfig.tinkerIntegration)
		 {
			 IntegrationTIC.preInit();
			 logger.info("Tinkers' Construct integration has been pre-initialized");

			 if (ModChecker.isConarmLoaded && !GeneralConfig.armoryIntegration)
			 {
				 IntegrationCArmory.preInit();
				 logger.info("Construct's Armory integration has been pre-initialized");
			 }
		 }

		 if (ModChecker.isIFLoaded && !GeneralConfig.inForegoingIntegration)
		 {
			 IntegrationIF.preInit();
			 logger.info("Industrial Foregoing integration has been pre-initialized");
		 }

		 if (ModChecker.isCraftTweakerLoaded)
		 {
			 IntegrationCT.preInit();
			 logger.info("CraftTweaker Integration has been pre-initialized");
		 }

		 NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		 logger.info(NAME + ": GUIs have been registered!");

		 CapabilityManager.INSTANCE.register(IPunchEffect.class, new PunchEffectStorage(), new PunchEffectCallable());
		 logger.info(NAME + ": Punch effect capability Registered");

		 CapabilityManager.INSTANCE.register(IKrikEffect.class, new KrikEffectStorage(), new KrikEffectCallable());
		 logger.info(NAME + ": Krik effect capability Registered");

	 }

	 @Mod.EventHandler
	 public void init(FMLInitializationEvent event)
	 {
		 logger.info(NAME + " is entering initialization!");
		 ModRecipes.init();
		 logger.info("Recipes loaded!");

		 if (ModChecker.isTConLoaded && !GeneralConfig.tinkerIntegration)
		 {
			 IntegrationTIC.init();
			 logger.info("Tinkers' Construct integration has been initialized");

			 if (ModChecker.isConarmLoaded && !GeneralConfig.armoryIntegration)
			 {
				 IntegrationCArmory.init();
				 logger.info("Construct's Armory integration has been initialized");
			 }
		 }

		 if (ModChecker.isProjectELoaded && !GeneralConfig.projectEIntegration)
		 {
			 IntegrationProjectE.init();
			 logger.info("ProjectE's Integration has been initialized");
		 }

		 CrusherRecipes.registerDefaultOreRecipes();
	 }


	 @Mod.EventHandler
	 public void postInit(FMLPostInitializationEvent event)
	 {
		 logger.info(NAME + " is entering post-initialization!");

		 proxy.postInit(event);

		 PacketManager.init();
		 logger.info(NAME + "'s Network System Loaded");

		 if (ModChecker.isTConLoaded && !GeneralConfig.tinkerIntegration)
			 IntegrationTIC.postInit();
		 logger.info("Tinker's alloy recipes loaded");

		 logger.info(NAME + " has been completely loaded");
	 }

 }
