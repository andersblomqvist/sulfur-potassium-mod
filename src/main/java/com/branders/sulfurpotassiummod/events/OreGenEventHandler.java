package com.branders.sulfurpotassiummod.events;

import com.branders.sulfurpotassiummod.config.OreGenerationConfig;
import com.branders.sulfurpotassiummod.registry.ModBlocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * 	Setup the Ore Generation event.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
@EventBusSubscriber
public class OreGenEventHandler {
	
	int pVeinSize =   (int) OreGenerationConfig.GENERAL.potassium_vein_size.get();
	int pUpperLimit = (int) OreGenerationConfig.GENERAL.potassium_upper_limit.get();
	
	int sVeinSize =   (int) OreGenerationConfig.GENERAL.sulfur_vein_size.get();
	int sUpperLimit = (int) OreGenerationConfig.GENERAL.sulfur_upper_limit.get();
	
	int sNetherVeinSize = (int) OreGenerationConfig.GENERAL.sulfur_nether_vein_size.get();
	
	boolean sSpawnNether = 	  (boolean) OreGenerationConfig.GENERAL.should_sulfur_spawn_in_nether.get();
	boolean sSpawnOverworld = (boolean) OreGenerationConfig.GENERAL.should_sulfur_spawn_in_overworld.get();
	
	ConfiguredFeature<?, ?> POTASSIUM_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(
			OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.getBlockState("potassium_ore_block"), pVeinSize))
			.range(pUpperLimit).square().func_242731_b(20);
	
	ConfiguredFeature<?, ?> SULFUR_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(
			OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.getBlockState("sulfur_ore_block"), sVeinSize))
			.range(sUpperLimit).square().func_242731_b(12);
	
	ConfiguredFeature<?, ?> SULFUR_NETHER_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(
			OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.getBlockState("sulfur_nether_ore_block"), sNetherVeinSize))
			.withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).square().func_242731_b(16);
	
	/**
	 * 	Event fired when loading biomes.
	 * 
	 * 	Add ore generation features here
	 */
	@SubscribeEvent
	public void oreGenerationEvent(BiomeLoadingEvent event) {
		
		// Leave if we found the End
		if(event.getCategory() == Biome.Category.THEEND)
			return;
		
		// Check nether, leave if we don't want to generate in nether
		else if(event.getCategory() == Biome.Category.NETHER) {
			if(!sSpawnNether)
				return;

			event.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, SULFUR_NETHER_ORE);
		} 
		
		// Regular overworld biomes		
		else {
			event.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, POTASSIUM_ORE);
			if(sSpawnOverworld)
				event.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, SULFUR_ORE);
		}
	}
}
