package com.branders.sulfurpotassiummod.registry;

import java.util.List;

import com.branders.sulfurpotassiummod.config.ConfigValues;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModFeatures {
	
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
	
	private static int gen_potassium = ConfigValues.CONFIG_SPEC.get("disable_gen_potassium");
	private static int gen_sulfur = ConfigValues.CONFIG_SPEC.get("disable_gen_sulfur");
	private static int gen_nether_sulfur = ConfigValues.CONFIG_SPEC.get("disable_gen_nether_sulfur");
	
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> POTASSIUM_ORES_MIDDLE;
    public static Holder<PlacedFeature> POTASSIUM_ORES_MIDDLE_PLACED;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> POTASSIUM_ORES_UPPER;
    public static Holder<PlacedFeature> POTASSIUM_ORES_UPPER_PLACED;
    
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> SULFUR_ORES;
    public static Holder<PlacedFeature> SULFUR_ORES_PLACED;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> SULFUR_NETHER_ORES;
    public static Holder<PlacedFeature> SULFUR_NETHER_ORES_PLACED;
    
	/**
	 * 	Register the ore features
	 */
	public static void register() {
		
		// Potassium middle
		POTASSIUM_ORES_MIDDLE = FeatureUtils.m_206488_("potassium_ores_middle", 
				Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
						ModBlocks.POTASSIUM_ORE.get().defaultBlockState())),
						potassium_middle_vein_size));
		POTASSIUM_ORES_MIDDLE_PLACED = PlacementUtils.m_206509_("potassium_ores_middle",
				POTASSIUM_ORES_MIDDLE, commonOrePlacement(potassium_middle_count,
						HeightRangePlacement.uniform(VerticalAnchor.absolute(potassium_middle_min_height), VerticalAnchor.absolute(potassium_middle_max_height))));
		
		// Potassium upper
		POTASSIUM_ORES_UPPER = FeatureUtils.m_206488_("potassium_ores_upper", 
				Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
						ModBlocks.POTASSIUM_ORE.get().defaultBlockState())),
						potassium_upper_vein_size));
		POTASSIUM_ORES_UPPER_PLACED = PlacementUtils.m_206509_("potassium_ores_upper",
				POTASSIUM_ORES_UPPER, commonOrePlacement(potassium_upper_count,
						HeightRangePlacement.uniform(VerticalAnchor.absolute(potassium_upper_min_height), VerticalAnchor.absolute(potassium_upper_max_height))));
		
		// Sulfur 
		SULFUR_ORES = FeatureUtils.m_206488_("sulfur_ores", 
				Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
						ModBlocks.SULFUR_ORE.get().defaultBlockState())),
						sulfur_vein_size));
		SULFUR_ORES_PLACED = PlacementUtils.m_206509_("sulfur_ores", SULFUR_ORES, commonOrePlacement(sulfur_count,
						HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(sulfur_max_height))));
		
		// Sulfur Nether
		SULFUR_NETHER_ORES = FeatureUtils.m_206488_("sulfur_nether_ores", 
				Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES,
						ModBlocks.SULFUR_NETHER_ORE.get().defaultBlockState())),
						sulfur_nether_vein_size));
		SULFUR_NETHER_ORES_PLACED = PlacementUtils.m_206509_("sulfur_nether_ores", SULFUR_NETHER_ORES, commonOrePlacement(sulfur_nether_count,
						HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(sulfur_nether_max_height))));
	}
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onBiomeLoadingEvent(final BiomeLoadingEvent event) {
		
		if(event.getCategory().equals(BiomeCategory.THEEND))
			return;
		
		else if(event.getCategory().equals(BiomeCategory.NETHER)) {
			if(gen_nether_sulfur == 0)
				event.getGeneration().m_204201_(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.m_205709_(SULFUR_NETHER_ORES_PLACED.m_203334_()));
		}
		else {
			if(gen_sulfur == 0)
				event.getGeneration().m_204201_(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.m_205709_(SULFUR_ORES_PLACED.m_203334_()));
			if(gen_potassium == 0) {
				event.getGeneration().m_204201_(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.m_205709_(POTASSIUM_ORES_MIDDLE_PLACED.m_203334_()));
				event.getGeneration().m_204201_(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.m_205709_(POTASSIUM_ORES_UPPER_PLACED.m_203334_()));
			}
		}
	}
	
	private static List<PlacementModifier> orePlacement(PlacementModifier m1, PlacementModifier m2) {
        return List.of(m1, InSquarePlacement.spread(), m2, BiomeFilter.biome());
    }
	
	private static List<PlacementModifier> commonOrePlacement(int v1, PlacementModifier v2) {
        return orePlacement(CountPlacement.of(v1), v2);
    }
}
