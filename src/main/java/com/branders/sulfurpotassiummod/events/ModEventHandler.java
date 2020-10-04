package com.branders.sulfurpotassiummod.events;

import com.branders.sulfurpotassiummod.config.OreGenerationConfig;
import com.branders.sulfurpotassiummod.lists.BlockList;

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
 * 	Ore Generation moved to event instead.
 * 	
 * 	Here we setup necessary ore configs and features and from the BiomeLoadingEvent we
 * 	access the BiomeGenerationSettingsBuilder for adding our new features.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
@EventBusSubscriber
public class ModEventHandler {
	
	int pVeinSize =   (int) OreGenerationConfig.GENERAL.potassium_vein_size.get();
	int pUpperLimit = (int) OreGenerationConfig.GENERAL.potassium_upper_limit.get();
	int pLowerLimit = (int) OreGenerationConfig.GENERAL.potassium_bottom_limit.get();
	
	int sVeinSize =   (int) OreGenerationConfig.GENERAL.sulfur_vein_size.get();
	int sUpperLimit = (int) OreGenerationConfig.GENERAL.sulfur_upper_limit.get();
	int sLowerLimit = (int) OreGenerationConfig.GENERAL.sulfur_bottom_limit.get();
	
	int sNetherVeinSize =   (int) OreGenerationConfig.GENERAL.sulfur_nether_vein_size.get();
//	int sNetherUpperLimit = (int) OreGenerationConfig.GENERAL.sulfur_nether_upper_limit.get();
	int sNetherLowerLimit = (int) OreGenerationConfig.GENERAL.sulfur_nether_bottom_limit.get();
	
	boolean sSpawnNether = 	  (boolean) OreGenerationConfig.GENERAL.should_sulfur_spawn_in_nether.get();
	boolean sSpawnOverworld = (boolean) OreGenerationConfig.GENERAL.should_sulfur_spawn_in_overworld.get();
	
	// OreConfig which states
	//	- which block we place our ore in
	//	- the ore block we generate
	// 	- probably max vein size
	
	OreFeatureConfig potassium_ore = new OreFeatureConfig (
			OreFeatureConfig.FillerBlockType.field_241882_a, 
			BlockList.potassium_ore_block.getDefaultState(), 
			pVeinSize
	);
	
	OreFeatureConfig sulfur_ore = new OreFeatureConfig (
			OreFeatureConfig.FillerBlockType.field_241882_a, 
			BlockList.sulfur_ore_block.getDefaultState(), 
			sVeinSize
	);
	
	OreFeatureConfig sulfur_nether_ore = new OreFeatureConfig (
			OreFeatureConfig.FillerBlockType.field_241883_b,
			BlockList.sulfur_nether_ore_block.getDefaultState(),
			sNetherVeinSize
	);
	
	// Create the generation feature where we pass in our ore config and set generation coordinates values.
	
	ConfiguredFeature<?, ?> potassiumFeature = Feature.ORE.withConfiguration(potassium_ore)
			.func_242733_d(pUpperLimit)
			.func_242728_a()
			.func_242731_b(pLowerLimit);
	
	ConfiguredFeature<?, ?> sulfurFeature = Feature.ORE.withConfiguration(sulfur_ore)
			.func_242733_d(sUpperLimit)
			.func_242728_a()
			.func_242731_b(sLowerLimit);
	
	ConfiguredFeature<?, ?> sulfurNetherFeature = Feature.ORE.withConfiguration(sulfur_nether_ore)
			.withPlacement(Features.Placements.field_243998_i)
			.func_242728_a()
			.func_242731_b(sNetherLowerLimit);
	
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

			event.getGeneration().func_242513_a(Decoration.UNDERGROUND_ORES, sulfurNetherFeature);
		} 
		
		// Regular overworld biomes		
		else {			
			event.getGeneration().func_242513_a(Decoration.UNDERGROUND_ORES, potassiumFeature);
			if(sSpawnOverworld)
				event.getGeneration().func_242513_a(Decoration.UNDERGROUND_ORES, sulfurFeature);
		}
	}
}
