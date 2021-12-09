package com.branders.sulfurpotassiummod.gen;

import java.util.List;

import com.branders.sulfurpotassiummod.config.ConfigValues;
import com.branders.sulfurpotassiummod.registry.ModBlocks;

import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.PlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

/**
 * 	Ore generation features are declared here.
 * 	They are then registered in ModFeatures.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class OreFeatures {

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
	
	// Potassium Ore - middle
	public static final PlacedFeature POTASSIUM_ORE_MIDDLE = Feature.ORE.configure(
			new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES, 
					ModBlocks.POTASSIUM_ORE.getDefaultState(),
					potassium_middle_vein_size)).withPlacement(
							modifiersWithCount(
									potassium_middle_count, 
									HeightRangePlacementModifier.trapezoid(
											YOffset.fixed(potassium_middle_min_height), 
											YOffset.fixed(potassium_middle_max_height))));
	// Potassium Ore - upper
	public static final PlacedFeature POTASSIUM_ORE_UPPER = Feature.ORE.configure(
			new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES, 
					ModBlocks.POTASSIUM_ORE.getDefaultState(),
					potassium_upper_vein_size)).withPlacement(
							modifiersWithCount(
									potassium_upper_count, 
									HeightRangePlacementModifier.trapezoid(
											YOffset.fixed(potassium_upper_min_height), 
											YOffset.fixed(potassium_upper_max_height))));
	
	// Sulfur Ore - Overworld
	public static final PlacedFeature SULFUR_ORE = Feature.ORE.configure(
			new OreFeatureConfig(
					OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, 
					ModBlocks.SULFUR_ORE.getDefaultState(),
					sulfur_vein_size)).withPlacement(
							modifiersWithCount(
									sulfur_count, 
									HeightRangePlacementModifier.trapezoid(
											YOffset.getBottom(), 
											YOffset.fixed(sulfur_max_height))));
	
	// Sulfur Ore - Nether
		public static final PlacedFeature SULFUR_NETHER_ORE = Feature.ORE.configure(
				new OreFeatureConfig(
						OreConfiguredFeatures.NETHERRACK, 
						ModBlocks.SULFUR_NETHER_ORE.getDefaultState(),
						sulfur_nether_vein_size)).withPlacement(
								modifiersWithCount(
										sulfur_nether_count, 
										HeightRangePlacementModifier.trapezoid(
												YOffset.getBottom(), 
												YOffset.fixed(sulfur_nether_max_height))));
	
	private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
	
	private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModfier) {
        return modifiers(CountPlacementModifier.of(count), heightModfier);
    }
}
