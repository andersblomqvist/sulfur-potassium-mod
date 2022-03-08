package com.branders.sulfurpotassiummod.registry;

import java.util.function.Predicate;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;
import com.branders.sulfurpotassiummod.config.ConfigValues;
import com.branders.sulfurpotassiummod.gen.OreFeatures;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

/**
 * 	Handles the registration of the ore generation features
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class ModFeatures {

	private static int disable_gen_potassium = ConfigValues.CONFIG_SPEC.get("disable_gen_potassium");
	private static int disable_gen_sulfur = ConfigValues.CONFIG_SPEC.get("disable_gen_sulfur");
	private static int disable_gen_nether_sulfur = ConfigValues.CONFIG_SPEC.get("disable_gen_nether_sulfur");
	
	/**
	 * 	Register new ore generation feature.
	 * 
	 * 	@param name Identifier name
	 * 	@param config ConfiguredFeature object
	 * 	@param placed PlacedFeature object
	 * 	@param biome BiomeSelector.foundIn ... 
	 */
	private static void register(String name, ConfiguredFeature<?, ?> config, PlacedFeature placed, Predicate<BiomeSelectionContext> biome) {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(SulfurPotassiumMod.MOD_ID, name), config);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(SulfurPotassiumMod.MOD_ID, name), placed);
		
		if(biome.equals(BiomeSelectors.foundInOverworld()))
			BiomeModifications.addFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(SulfurPotassiumMod.MOD_ID, name)));
		else if(biome.equals(BiomeSelectors.foundInTheNether()))
			BiomeModifications.addFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(SulfurPotassiumMod.MOD_ID, name)));
	}
	
	/**
	 * 	Init the mod features
	 */
	public static void registerOreFeatures() {
		if(disable_gen_potassium == 0) {
			register("potassium_ores_middle", OreFeatures.POTASSIUM_MIDDLE_CONFIGURED_FEATURE, OreFeatures.POTASSIUM_MIDDLE_PLACED_FEATURE, BiomeSelectors.foundInOverworld());
			register("potassium_ores_upper", OreFeatures.POTASSIUM_UPPER_CONFIGURED_FEATURE, OreFeatures.POTASSIUM_UPPER_PLACED_FEATURE, BiomeSelectors.foundInOverworld());
		}
		
		if(disable_gen_sulfur == 0)
			register("sulfur_ores", OreFeatures.SULFUR_CONFIGURED_FEATURE, OreFeatures.SULFUR_PLACED_FEATURE, BiomeSelectors.foundInOverworld());
		
		if(disable_gen_nether_sulfur == 0)
			register("sulfur_nether_ores", OreFeatures.SULFUR_NETHER_CONFIGURED_FEATURE, OreFeatures.SULFUR_NETHER_PLACED_FEATURE, BiomeSelectors.foundInTheNether());
	}
}
