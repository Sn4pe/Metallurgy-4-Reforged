/*
 * -------------------------------------------------------------------------------------------------------
 * Class: ModMetals
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: ItHurtsLikeHell & Davoleo
 * Copyright (c) 2020.
 * --------------------------------------------------------------------------------------------------------
 */

package it.hurts.metallurgy_reforged.material;

import it.hurts.metallurgy_reforged.util.ItemUtils;
import net.minecraft.block.Block;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

import static it.hurts.metallurgy_reforged.material.MetalStats.FluidStats;

public class ModMetals {

	public static List<Metal> metalList = new ArrayList<>();

	//Disclaimer: These variables might need a balancement update
	//Davoleo isn't responsible for any blast resistance level complains
	public static final float LOW_TIER_BLAST_RESISTANCE = 6F;                            //or maybe 3, I don't remember
	public static final float MID_TIER_BLAST_RESISTANCE = 10F;                            //Cobblestone-like
	public static final float HIGH_TIER_BLAST_RESISTANCE = 15F;
	public static final float EXTREME_TIER_BLAST_RESISTANCE = 20F;                    //Obsidian-like
	public static final float UNBREAKABLE_TIER_BLAST_RESISTANCE = 18000000F;            //Bedrock-like

	//    MetalStats("name", "Name", harvestLevelOfMetalBlock, blastResistance, ArmorStats, ToolStats, FluidStats, harvestLevelOfOreBlock).createMetal;
	//damage_parameter = in-game_sword_damage - 3

	//THIS LIST MUST BE IN SORTED IN ALPHABETICAL ORDER IN ORDER TO MAKE THE MOD FUNCTION PROPERLY
	//WHEN ADDING NEW METALS REMEMBER TO REGISTER EMCs AND ADD THEM TO THE MAIN LIST IN UTILS.JAVA
	public static final Metal ADAMANTINE = new MetalStats("adamantine", "Adamantine", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 4, 5, 3}, 8, 36, 3.5F, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND),
			new ToolStats(22, 7, 1550, 10F, 5F), new FluidStats((int) MetalColors.ADAMANTINE.getColorIntWithAlpha()), 6).createMetal();
	public static final Metal AMORDRINE = new MetalStats("amordrine", "Amordrine", 2, MID_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 4, 5, 3}, 50, 50, 2F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(50, 5, 500, 14F, 4F), new FluidStats((int) MetalColors.AMORDRINE.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal ANGMALLEN = new MetalStats("angmallen", "Angmallen", 2, MID_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 5, 6, 3}, 18, 30, 0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(30, 3, 300, 7F, 3F), new FluidStats((int) MetalColors.ANGMALLEN.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal ALDUORITE = new MetalStats("alduorite", "Alduorite", 2, MID_TIER_BLAST_RESISTANCE, null, null, new FluidStats((int) MetalColors.ALDUORITE.getColorIntWithAlpha()), 3).createMetal();
	public static final Metal ASTRAL_SILVER = new MetalStats("astral_silver", "AstralSilver", 2, MID_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{2, 5, 6, 2}, 9, 15, 0.0F, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC),
			new ToolStats(30, 5, 350, 12F, 2F), new FluidStats((int) MetalColors.ASTRAL_SILVER.getColorIntWithAlpha()), 4).createMetal();
	public static final Metal ATLARUS = new MetalStats("atlarus", "Atlarus", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 3, 3, 4}, 2, 35, 3.5F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(22, 7, 1750, 10F, 5F), new FluidStats((int) MetalColors.ATLARUS.getColorIntWithAlpha()), 6).createMetal();
	public static final Metal BLACK_STEEL = new MetalStats("black_steel", "BlackSteel", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 5, 6, 3}, 17, 50, 4F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(17, 3, 500, 8F, 3F), new FluidStats((int) MetalColors.BLACK_STEEL.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal BRASS = new MetalStats("brass", "Brass", 2, MID_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{1, 2, 3, 2}, 18, 15, 4F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(18, 1, 15, 10F, 2F), new FluidStats((int) MetalColors.BRASS.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal BRONZE = new MetalStats("bronze", "Bronze", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 3, 4, 2}, 9, 25, 2F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(9, 3, 250, 6F, 2F), new FluidStats((int) MetalColors.BRONZE.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal CARMOT = new MetalStats("carmot", "Carmot", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{2, 4, 5, 2}, 7, 28, 0.0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(40, 5, 500, 12F, 2F), new FluidStats((int) MetalColors.CARMOT.getColorIntWithAlpha()), 4).createMetal();
	public static final Metal CELENEGIL = new MetalStats("celenegil", "Celenegil", 2, EXTREME_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 6, 7, 5}, 50, 160, 0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(50, 6, 1600, 14F, 4F), new FluidStats((int) MetalColors.CELENEGIL.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal CERUCLASE = new MetalStats("ceruclase", "Ceruclase", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 6, 5, 4}, 50, 137, 0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(18, 4, 500, 7, 4F), new FluidStats((int) MetalColors.CERUCLASE.getColorIntWithAlpha()), 3).createMetal();
	public static final Metal COPPER = new MetalStats("copper", "Copper", 2, LOW_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{2, 3, 2, 1}, 50, 5, 0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(5, 2, 180, 5F, 2F), new FluidStats((int) MetalColors.COPPER.getColorIntWithAlpha()), 1).createMetal();
	public static final Metal DAMASCUS_STEEL = new MetalStats("damascus_steel", "DamascusSteel", 2, EXTREME_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 5, 6, 3}, 18, 50, 3F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(18, 4, 500, 6F, 3F), new FluidStats((int) MetalColors.DAMASCUS_STEEL.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal DEEP_IRON = new MetalStats("deep_iron", "DeepIron", 2, MID_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{2, 4, 5, 2}, 1, 38, 0.0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(14, 3, 250, 6F, 3F), new FluidStats((int) MetalColors.DEEP_IRON.getColorIntWithAlpha()), 2).createMetal();
	public static final Metal DESICHALKOS = new MetalStats("desichalkos", "Desichalkos", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 5, 7, 4}, 30, 180, 3F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(30, 4, 1800, 8F, 5F), new FluidStats((int) MetalColors.DESICHALKOS.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal ELECTRUM = new MetalStats("electrum", "Electrum", 2, LOW_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 5, 6, 2}, 30, 51, 3F, SoundEvents.ENTITY_LIGHTNING_IMPACT),
			new ToolStats(30, 2, 70, 14F, 2F), new FluidStats((int) MetalColors.ELECTRUM.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal ETHERIUM = new MetalStats("etherium", "Etherium", 2, LOW_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 5, 6, 2}, 45, 75, 0F, SoundEvents.UI_TOAST_IN),
			new ToolStats(35, 8, 500, 18F, 2F), new FluidStats((int) MetalColors.ETHERIUM.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal EXIMITE = new MetalStats("eximite", "Eximite", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 5, 6, 4}, 25, 100, 5.0F, SoundEvents.ENTITY_ENDERDRAGON_GROWL),
			new ToolStats(25, 7, 1000, 8F, 4F), new FluidStats((int) MetalColors.EXIMITE.getColorIntWithAlpha()), 3).createMetal();
	public static final Metal HADEROTH = new MetalStats("haderoth", "Haderoth", 2, EXTREME_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 5, 7, 4}, 19, 125, 6F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(19, 5, 1250, 12F, 4F), new FluidStats((int) MetalColors.HADEROTH.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal HEPATIZON = new MetalStats("hepatizon", "Hepatizon", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 3, 4, 2}, 22, 57, 2F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(22, 3, 300, 8F, 2F), new FluidStats((int) MetalColors.HEPATIZON.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal IGNATIUS = new MetalStats("ignatius", "Ignatius", 2, LOW_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{2, 5, 6, 2}, 15, 24, 0.0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(15, 2, 200, 4F, 3F), new FluidStats((int) MetalColors.IGNATIUS.getColorIntWithAlpha(), 2100), 1).createMetal();
	public static final Metal INFUSCOLIUM = new MetalStats("infuscolium", "Infuscolium", 2, MID_TIER_BLAST_RESISTANCE, null, null, new FluidStats((int) MetalColors.INFUSCOLIUM.getColorIntWithAlpha()), 2).createMetal();
	public static final Metal INOLASHITE = new MetalStats("inolashite", "Inolashite", 2, EXTREME_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 5, 7, 4}, 25, 70, 4F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(25, 5, 900, 8F, 4F), new FluidStats((int) MetalColors.INOLASHITE.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal KALENDRITE = new MetalStats("kalendrite", "Kalendrite", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 5, 6, 4}, 20, 40, 3.0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(20, 5, 1000, 8F, 4F), new FluidStats((int) MetalColors.KALENDRITE.getColorIntWithAlpha()), 4).createMetal();
	public static final Metal KRIK = new MetalStats("krik", "Krik", 2, MID_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{2, 4, 3, 1}, 17, 45, 9.0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(17, 4, 350, 5F, 7F), new FluidStats((int) MetalColors.KRIK.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal LEMURITE = new MetalStats("lemurite", "Lemurite", 2, LOW_TIER_BLAST_RESISTANCE, null, null, new FluidStats((int) MetalColors.LEMURITE.getColorIntWithAlpha()), 2).createMetal();
	public static final Metal LUTETIUM = new MetalStats("lutetium", "Lutetium", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{5, 6, 5, 4}, 17, 50, 3F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			null, new FluidStats((int) MetalColors.LUTETIUM.getColorIntWithAlpha()), 4).createMetal();
	public static final Metal MANGANESE = new MetalStats("manganese", "Manganese", 2, MID_TIER_BLAST_RESISTANCE, null, null, new FluidStats((int) MetalColors.MANGANESE.getColorIntWithAlpha()), 3).createMetal();
	public static final Metal MEUTOITE = new MetalStats("meutoite", "Meutoite", 2, HIGH_TIER_BLAST_RESISTANCE, null, null, new FluidStats((int) MetalColors.MEUTOITE.getColorIntWithAlpha()), 4).createMetal();
	public static final Metal MIDASIUM = new MetalStats("midasium", "Midasium", 2, MID_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 3, 5, 2}, 35, 16, 4.0F, SoundEvents.ITEM_ARMOR_EQUIP_GOLD),
			new ToolStats(35, 4, 100, 10F, 7F), new FluidStats((int) MetalColors.MIDASIUM.getColorIntWithAlpha()), 3).createMetal();
	public static final Metal MITHRIL = new MetalStats("mithril", "Mithril", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{2, 4, 5, 3}, 20, 21, 0.0F, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN),
			new ToolStats(18, 5, 1000, 9F, 7F), new FluidStats((int) MetalColors.MITHRIL.getColorIntWithAlpha()), 4).createMetal();
	public static final Metal ORICHALCUM = new MetalStats("orichalcum", "Orichalcum", 2, EXTREME_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{2, 6, 7, 2}, 4, 20, 1.4F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(20, 6, 1350, 9F, 7F), new FluidStats((int) MetalColors.ORICHALCUM.getColorIntWithAlpha()), 5).createMetal();
	public static final Metal OSMIUM = new MetalStats("osmium", "Osmium", 2, EXTREME_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 5, 5, 4}, 17, 100, 3F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			null, new FluidStats((int) MetalColors.OSMIUM.getColorIntWithAlpha()), 2).createMetal();
	public static final Metal OURECLASE = new MetalStats("oureclase", "Oureclase", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 6, 5, 4}, 2, 28, 1.5F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(18, 3, 750, 8F, 6F), new FluidStats((int) MetalColors.OURECLASE.getColorIntWithAlpha()), 3).createMetal();
	public static final Metal PLATINUM = new MetalStats("platinum", "Platinum", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 5, 6, 3}, 12, 17, 0.5F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(50, 3, 250, 16F, 5F), new FluidStats((int) MetalColors.PLATINUM.getColorIntWithAlpha()), 2).createMetal();
	public static final Metal PROMETHEUM = new MetalStats("prometheum", "Prometheum", 2, MID_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{1, 2, 3, 2}, 11, 30, 0.1F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(16, 2, 200, 4F, 5F), new FluidStats((int) MetalColors.PROMETHEUM.getColorIntWithAlpha()), 1).createMetal();
	public static final Metal QUICKSILVER = new MetalStats("quicksilver", "QuickSilver", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 7, 5, 4}, 50, 165, 0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(20, 5, 1100, 14F, 7F), new FluidStats((int) MetalColors.QUICKSILVER.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal RUBRACIUM = new MetalStats("rubracium", "Rubracium", 2, MID_TIER_BLAST_RESISTANCE, null, null, new FluidStats((int) MetalColors.RUBRACIUM.getColorIntWithAlpha()), 4).createMetal();
	public static final Metal SANGUINITE = new MetalStats("sanguinite", "Sanguinite", 2, EXTREME_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 6, 7, 5}, 25, 175, 4.0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(25, 7, 1750, 11F, 8F), new FluidStats((int) MetalColors.SANGUINITE.getColorIntWithAlpha()), 6).createMetal();
	public static final Metal SHADOW_IRON = new MetalStats("shadow_iron", "ShadowIron", 2, LOW_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 5, 6, 3}, 3, 32, 4.0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(3, 2, 300, 5F, 6F), new FluidStats((int) MetalColors.SHADOW_IRON.getColorIntWithAlpha()), 1).createMetal();
	public static final Metal SHADOW_STEEL = new MetalStats("shadow_steel", "ShadowSteel", 2, MID_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 5, 6, 3}, 5, 40, 3.0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(5, 3, 400, 6F, 7F), new FluidStats((int) MetalColors.SHADOW_STEEL.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal SILVER = new MetalStats("silver", "Silver", 2, MID_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{2, 3, 4, 2}, 20, 8, 2.1F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(20, 1, 25, 15F, 5F), new FluidStats((int) MetalColors.SILVER.getColorIntWithAlpha()), 1).createMetal();
	public static final Metal STEEL = new MetalStats("steel", "Steel", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{3, 5, 6, 3}, 18, 40, 4F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(18, 4, 750, 8F, 7F), new FluidStats((int) MetalColors.STEEL.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal TARTARITE = new MetalStats("tartarite", "Tartarite", 2, EXTREME_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{5, 6, 7, 5}, 20, 300, 6.0F, SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT),
			new ToolStats(25, 8, 3000, 14F, 9F), new FluidStats((int) MetalColors.TARTARITE.getColorIntWithAlpha()), -1).createMetal();
	public static final Metal TIN = new MetalStats("tin", "Tin", 2, LOW_TIER_BLAST_RESISTANCE, null, null, new FluidStats((int) MetalColors.TIN.getColorIntWithAlpha()), 1).createMetal();
	public static final Metal VULCANITE = new MetalStats("vulcanite", "Vulcanite", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 6, 7, 4}, 20, 150, 4.0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(20, 6, 1500, 10F, 7F), new FluidStats((int) MetalColors.VULCANITE.getColorIntWithAlpha(), 4200), 5).createMetal();
	public static final Metal VYROXERES = new MetalStats("vyroxeres", "Vyroxeres", 2, HIGH_TIER_BLAST_RESISTANCE,
			new ArmorStats(new int[]{4, 5, 6, 3}, 16, 37, 3.0F, SoundEvents.ITEM_ARMOR_EQUIP_IRON),
			new ToolStats(16, 4, 300, 7F, 7F), new FluidStats((int) MetalColors.VYROXERES.getColorIntWithAlpha()), 4).createMetal();
	public static final Metal ZINC = new MetalStats("zinc", "Zinc", 2, MID_TIER_BLAST_RESISTANCE, null, null, new FluidStats((int) MetalColors.ZINC.getColorIntWithAlpha()), 1).createMetal();

	public static void registerFluids()
	{
		for (Metal m : metalList)
		{
			FluidRegistry.registerFluid(m.getMolten());
			m.initFluidBlock();
		}
	}

	public static void registerBlocks(IForgeRegistry<Block> registry)
	{
		for (Metal m : metalList)
		{
			registry.register(m.getBlock());
			if (m.getOre() != null)
			{
				registry.register(m.getOre());
			}
			registry.register(m.getFluidBlock());
		}
	}

	public static void registerModels()
	{
		for (Metal m : metalList)
		{
			ItemUtils.registerCustomItemModel(m.getDust(), 0);
			ItemUtils.registerCustomItemModel(m.getIngot(), 0);
			ItemUtils.registerCustomItemModel(m.getNugget(), 0);
			if (m.getOre() != null)
			{
				ItemUtils.registerCustomItemModel(Item.getItemFromBlock(m.getOre()), 0);
			}
			ItemUtils.registerCustomItemModel(Item.getItemFromBlock(m.getBlock()), 0);
			ItemUtils.registerCustomItemModel(Item.getItemFromBlock(m.getFluidBlock()), 0);
		}
	}

	public static void registerItems(IForgeRegistry<Item> registry)
	{
		for (Metal m : metalList)
		{
			registry.register(m.getBlock().createItemBlock());
			if (m.getOre() != null)
			{
				registry.register(m.getOre().createItemBlock());
			}
			registry.register(m.getFluidBlock().createItemBlock());
			registry.register(m.getDust());
			registry.register(m.getIngot());
			registry.register(m.getNugget());
		}
	}

}