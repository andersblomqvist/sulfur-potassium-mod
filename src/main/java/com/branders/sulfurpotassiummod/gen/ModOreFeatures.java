package com.branders.sulfurpotassiummod.gen;

import java.util.Arrays;

import com.branders.sulfurpotassiummod.config.ConfigValues;
import com.branders.sulfurpotassiummod.registry.ModBlocks;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

/**
 * 	Ore generation features are declared here.
 * 	They are then registered in ModFeatures.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class ModOreFeatures {

	private static int potassium_middle_vein_size = ConfigValues.CONFIG_SPEC.get("potassium_middle_vein_size");
	private static int potassium_middle_max_height = ConfigValues.CONFIG_SPEC.get("potassium_middle_max_height");
	private static int potassium_middle_min_height = ConfigValues.CONFIG_SPEC.get("potassium_middle_min_height");
	private static int potassium_middle_count = ConfigValues.CONFIG_SPEC.get("potassium_middle_count");
	
	private static int potassium_upper_vein_size = ConfigValues.CONFIG_SPEC.get("potassium_upper_vein_size");
	private static int potassium_upper_max_height = ConfigValues.CONFIG_SPEC.get("potassium_upper_max_height");
	private static int potassium_upper_min_height = ConfigValues.CONFIG_SPEC.get("potassium_upper_min_height");
	private static int potassium_upper_count = ConfigValues.CONFIG_SPEC.get("potassium_upper_count");
	
	private static int sulfur_vein_size = ConfigValues.CONFIG_SPEC.get("sulfur_vein_size");
	private static int sulfur_max_height = ConfigValues.CONFIG_SPEC.get("sulfur_max_height");
	private static int sulfur_count = ConfigValues.CONFIG_SPEC.get("sulfur_count");
	
	private static int sulfur_nether_vein_size = ConfigValues.CONFIG_SPEC.get("nether_sulfur_vein_size");
	private static int sulfur_nether_max_height = ConfigValues.CONFIG_SPEC.get("nether_sulfur_max_height");
	private static int sulfur_nether_count = ConfigValues.CONFIG_SPEC.get("nether_sulfur_count");
	
	// potassium middle
	public static ConfiguredFeature<?, ?> POTASSIUM_MIDDLE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
			Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					ModBlocks.POTASSIUM_ORE.getDefaultState(),
					potassium_middle_vein_size));
	public static PlacedFeature POTASSIUM_MIDDLE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(POTASSIUM_MIDDLE_CONFIGURED_FEATURE),
				Arrays.asList(
					CountPlacementModifier.of(potassium_middle_count),
					SquarePlacementModifier.of(),
					HeightRangePlacementModifier.uniform(YOffset.fixed(potassium_middle_min_height), YOffset.fixed(potassium_middle_max_height))));
	
	// potassium upper
	public static ConfiguredFeature<?, ?> POTASSIUM_UPPER_CONFIGURED_FEATURE = new ConfiguredFeature<>(
			Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					ModBlocks.POTASSIUM_ORE.getDefaultState(),
					potassium_upper_vein_size));
	public static PlacedFeature POTASSIUM_UPPER_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(POTASSIUM_UPPER_CONFIGURED_FEATURE),
				Arrays.asList(
					CountPlacementModifier.of(potassium_upper_count),
					SquarePlacementModifier.of(),
					HeightRangePlacementModifier.uniform(YOffset.fixed(potassium_upper_min_height), YOffset.fixed(potassium_upper_max_height))));
	
	// sulfur overworld
	public static ConfiguredFeature<?, ?> SULFUR_CONFIGURED_FEATURE = new ConfiguredFeature<>(
			Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
					ModBlocks.SULFUR_ORE.getDefaultState(),
					sulfur_vein_size));
	public static PlacedFeature SULFUR_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(SULFUR_CONFIGURED_FEATURE),
				Arrays.asList(
					CountPlacementModifier.of(sulfur_count),
					SquarePlacementModifier.of(),
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(sulfur_max_height))));
	
	// sulfur nether
	public static ConfiguredFeature<?, ?> SULFUR_NETHER_CONFIGURED_FEATURE = new ConfiguredFeature<>(
			Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.NETHERRACK,
					ModBlocks.SULFUR_NETHER_ORE.getDefaultState(),
					sulfur_nether_vein_size));
	public static PlacedFeature SULFUR_NETHER_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(SULFUR_NETHER_CONFIGURED_FEATURE),
				Arrays.asList(
					CountPlacementModifier.of(sulfur_nether_count),
					SquarePlacementModifier.of(),
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(sulfur_nether_max_height))));
}
