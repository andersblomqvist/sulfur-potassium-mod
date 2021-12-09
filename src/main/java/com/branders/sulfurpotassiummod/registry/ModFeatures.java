package com.branders.sulfurpotassiummod.registry;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;
import com.branders.sulfurpotassiummod.config.ConfigValues;
import com.branders.sulfurpotassiummod.gen.OreFeatures;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModFeatures {

	private static int disable_gen_potassium = ConfigValues.CONFIG_SPEC.get("disable_gen_potassium");
	private static int disable_gen_sulfur = ConfigValues.CONFIG_SPEC.get("disable_gen_sulfur");
	private static int disable_gen_nether_sulfur = ConfigValues.CONFIG_SPEC.get("disable_gen_nether_sulfur");
	
	public static void registerOreFeatures() {

		if(disable_gen_potassium == 0) {
			RegistryKey<PlacedFeature> potassiumOreMiddle = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(SulfurPotassiumMod.MOD_ID, "potassium_ores_middle"));
			Registry.register(BuiltinRegistries.PLACED_FEATURE, potassiumOreMiddle.getValue(), OreFeatures.POTASSIUM_ORE_MIDDLE);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, potassiumOreMiddle);
			
			RegistryKey<PlacedFeature> potassiumOreUpper = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(SulfurPotassiumMod.MOD_ID, "potassium_ores_upper"));
			Registry.register(BuiltinRegistries.PLACED_FEATURE, potassiumOreUpper.getValue(), OreFeatures.POTASSIUM_ORE_UPPER);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, potassiumOreUpper);
		}
		
		if(disable_gen_sulfur == 0) {
			RegistryKey<PlacedFeature> sulfurOre = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(SulfurPotassiumMod.MOD_ID, "sulfur_ores"));
			Registry.register(BuiltinRegistries.PLACED_FEATURE, sulfurOre.getValue(), OreFeatures.SULFUR_ORE);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, sulfurOre);
		}
		
		if(disable_gen_nether_sulfur == 0) {
			RegistryKey<PlacedFeature> sulfurOre = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(SulfurPotassiumMod.MOD_ID, "sulfur_nether_ores"));
			Registry.register(BuiltinRegistries.PLACED_FEATURE, sulfurOre.getValue(), OreFeatures.SULFUR_NETHER_ORE);
			BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, sulfurOre);
		}
	}
}
