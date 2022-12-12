package com.branders.sulfurpotassiummod.registry;

import java.util.function.BiConsumer;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;
import com.branders.sulfurpotassiummod.config.ConfigValues;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

/**
 * 	Handles the registration of the ore generation features from data generation.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class ModFeatures {

	private static int disable_gen_potassium = ConfigValues.CONFIG_SPEC.get("disable_gen_potassium");
	private static int disable_gen_sulfur = ConfigValues.CONFIG_SPEC.get("disable_gen_sulfur");
	private static int disable_gen_nether_sulfur = ConfigValues.CONFIG_SPEC.get("disable_gen_nether_sulfur");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CF_POTASSIUM_MIDDLE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(SulfurPotassiumMod.MOD_ID, "potassium_ores_middle"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> CF_POTASSIUM_UPPER = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(SulfurPotassiumMod.MOD_ID, "potassium_ores_upper"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> CF_SULFUR = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(SulfurPotassiumMod.MOD_ID, "sulfur_ores"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> CF_SULFUR_NETHER = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(SulfurPotassiumMod.MOD_ID, "sulfur_nether_ores"));
    
    public static final RegistryKey<PlacedFeature> PF_POTASSIUM_MIDDLE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(SulfurPotassiumMod.MOD_ID, "potassium_ores_middle"));
    public static final RegistryKey<PlacedFeature> PF_POTASSIUM_UPPER  = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(SulfurPotassiumMod.MOD_ID, "potassium_ores_upper"));
    public static final RegistryKey<PlacedFeature> PF_SULFUR  = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(SulfurPotassiumMod.MOD_ID, "sulfur_ores"));
    public static final RegistryKey<PlacedFeature> PF_SULFUR_NETHER  = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(SulfurPotassiumMod.MOD_ID, "sulfur_nether_ores"));
    
    public static void register() {
        // Overworld features
        BiomeModifications.create(new Identifier(SulfurPotassiumMod.MOD_ID, "features"))
            .add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), overworldOres());
        
        // Nether features
        BiomeModifications.create(new Identifier(SulfurPotassiumMod.MOD_ID, "nether_features"))
            .add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInTheNether(), netherOres());
    }
    
    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext> overworldOres() {
        return (biomeSelectionContext, biomeModificationContext) -> {
            if(disable_gen_potassium == 0) {
                biomeModificationContext.getGenerationSettings().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, PF_POTASSIUM_MIDDLE);
                biomeModificationContext.getGenerationSettings().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, PF_POTASSIUM_UPPER);
            }
            if(disable_gen_sulfur == 0)
                biomeModificationContext.getGenerationSettings().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, PF_SULFUR);
        };
    }
    
    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext> netherOres() {
        return (biomeSelectionContext, biomeModificationContext) -> {
            if(disable_gen_nether_sulfur == 0)
                biomeModificationContext.getGenerationSettings().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, PF_SULFUR_NETHER);
        };
    }
}
