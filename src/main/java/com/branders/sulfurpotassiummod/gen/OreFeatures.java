package com.branders.sulfurpotassiummod.gen;

import com.branders.sulfurpotassiummod.config.ConfigValues;
import com.branders.sulfurpotassiummod.registry.ModBlocks;

import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

/**
 * 	Ore generation features are declared here.
 * 	They are then registered in ModFeatures.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class OreFeatures {

	private static int potassium_vein_size = ConfigValues.CONFIG_SPEC.get("potassium_vein_size");
	private static int potassium_max_height = ConfigValues.CONFIG_SPEC.get("potassium_max_height");
	private static int potassium_count = ConfigValues.CONFIG_SPEC.get("potassium_count");
	
	private static int sulfur_vein_size = ConfigValues.CONFIG_SPEC.get("sulfur_vein_size");
	private static int sulfur_max_height = ConfigValues.CONFIG_SPEC.get("sulfur_max_height");
	private static int sulfur_count = ConfigValues.CONFIG_SPEC.get("sulfur_count");
	
	private static int sulfur_nether_vein_size = ConfigValues.CONFIG_SPEC.get("nether_sulfur_vein_size");
	private static int sulfur_nether_max_height = ConfigValues.CONFIG_SPEC.get("nether_sulfur_max_height");
	private static int sulfur_nether_count = ConfigValues.CONFIG_SPEC.get("nether_sulfur_count");
	
	public static ConfiguredFeature<?, ?> POTASSIUM_ORE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ModBlocks.POTASSIUM_ORE.getDefaultState(),
					potassium_vein_size)) // Vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					UniformHeightProvider.create(
							YOffset.fixed(0),
							YOffset.fixed(potassium_max_height))))) // Max height
			.spreadHorizontally()
			.repeat(potassium_count); // Number of veins per chunk
	
	public static ConfiguredFeature<?, ?> SULFUR_ORE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ModBlocks.SULFUR_ORE.getDefaultState(),
					sulfur_vein_size)) // Vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					UniformHeightProvider.create(
							YOffset.fixed(0),
							YOffset.fixed(sulfur_max_height))))) // Max height
			.spreadHorizontally()
			.repeat(sulfur_count); // Number of veins per chunk
	
	public static ConfiguredFeature<?, ?> SULFUR_NETHER_ORE = Feature.ORE
			.configure(new OreFeatureConfig(
				      OreFeatureConfig.Rules.BASE_STONE_NETHER,
				      ModBlocks.SULFUR_NETHER_ORE.getDefaultState(),
				      sulfur_nether_vein_size)) // Vein size
		    .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
		    		UniformHeightProvider.create(
							YOffset.fixed(0),
							YOffset.fixed(sulfur_nether_max_height))))) // Max height
		    .spreadHorizontally()
		    .repeat(sulfur_nether_count); // Number of veins per chunk
	
}
