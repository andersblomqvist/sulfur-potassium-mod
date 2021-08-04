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
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ModFeatures {

	private static int disable_gen_potassium = ConfigValues.CONFIG_SPEC.get("disable_gen_potassium");
	private static int disable_gen_sulfur = ConfigValues.CONFIG_SPEC.get("disable_gen_sulfur");
	private static int disable_gen_nether_sulfur = ConfigValues.CONFIG_SPEC.get("disable_gen_nether_sulfur");
	
	public static void registerOreFeatures() {
		
		if(disable_gen_potassium == 0) {
			RegistryKey<ConfiguredFeature<?, ?>> potassiumOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(SulfurPotassiumMod.MOD_ID, "potassium_ores"));
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, potassiumOre.getValue(), OreFeatures.POTASSIUM_ORE);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, potassiumOre);
		}
		
		if(disable_gen_sulfur == 0) {
			RegistryKey<ConfiguredFeature<?, ?>> sulfurOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(SulfurPotassiumMod.MOD_ID, "sulfur_ores"));
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, sulfurOre.getValue(), OreFeatures.SULFUR_ORE);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, sulfurOre);
		}
		
		if(disable_gen_nether_sulfur == 0) {
			RegistryKey<ConfiguredFeature<?, ?>> sulfurNetherOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(SulfurPotassiumMod.MOD_ID, "sulfur_nether_ores"));
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, sulfurNetherOre.getValue(), OreFeatures.SULFUR_NETHER_ORE);
			BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, sulfurNetherOre);
		}
	}
}
