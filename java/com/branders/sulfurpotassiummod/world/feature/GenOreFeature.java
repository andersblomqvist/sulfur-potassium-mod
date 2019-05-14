package com.branders.sulfurpotassiummod.world.feature;

import java.util.Random;

import com.branders.sulfurpotassiummod.lists.BlockList;
import com.branders.sulfurpotassiummod.world.config.NetherConfig;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class GenOreFeature
{	
	public static void Init()
	{
		/** **********************************************************************************************************************************************************
		 * 	Add ore generation for POTASSIUM ORE
		 */
		
		int potassiumCount = 10;
		int potassiumMinHeight = 3;
		int potassiumMaxHeightBase = 40;
		int potassiumMaxHeight = 93;
		
		int potassiumVeinSize = getRandomNumberInRange(5, 10);
		
		BiomeManager.getBiomes(BiomeType.WARM).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature
				(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.potassium_ore_block.getDefaultState(), potassiumVeinSize), 
						Biome.COUNT_RANGE, 
						new CountRangeConfig(potassiumCount, potassiumMinHeight, potassiumMaxHeightBase, potassiumMaxHeight))	// Count, MinHeight, MaxHeightBase, MaxHeight
				)
		);
		
		BiomeManager.getBiomes(BiomeType.COOL).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature
				(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.potassium_ore_block.getDefaultState(), potassiumVeinSize), 
						Biome.COUNT_RANGE, 
						new CountRangeConfig(potassiumCount, potassiumMinHeight, potassiumMaxHeightBase, potassiumMaxHeight))	// Count, MinHeight, MaxHeightBase, MaxHeight
				)
		);
		
		BiomeManager.getBiomes(BiomeType.DESERT).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature
				(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.potassium_ore_block.getDefaultState(), potassiumVeinSize), 
						Biome.COUNT_RANGE, 
						new CountRangeConfig(potassiumCount, potassiumMinHeight, potassiumMaxHeightBase, potassiumMaxHeight))	// Count, MinHeight, MaxHeightBase, MaxHeight
				)
		);
		
		BiomeManager.getBiomes(BiomeType.ICY).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature
				(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.potassium_ore_block.getDefaultState(), potassiumVeinSize), 
						Biome.COUNT_RANGE, 
						new CountRangeConfig(potassiumCount, potassiumMinHeight, potassiumMaxHeightBase, potassiumMaxHeight))	// Count, MinHeight, MaxHeightBase, MaxHeight
				)
		);
		
		
		
		
		/** **********************************************************************************************************************************************************
		 * 	Add ore generation for SULFUR ORE
		 */
		
		int sulfurCount = 10;
		int sulfurMinHeight = 3;
		int sulfurMaxHeightBase = 40;
		int sulfurMaxHeight = 63;
		
		int sulfurVeinSize = getRandomNumberInRange(4, 8);
		
		
		BiomeManager.getBiomes(BiomeType.WARM).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature
				(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.sulfur_ore_block.getDefaultState(), sulfurVeinSize), 
						Biome.COUNT_RANGE, 
						new CountRangeConfig(sulfurCount, sulfurMinHeight, sulfurMaxHeightBase, sulfurMaxHeight))	// Count, MinHeight, MaxHeightBase, MaxHeight
				)
		);
		
		BiomeManager.getBiomes(BiomeType.COOL).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature
				(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.sulfur_ore_block.getDefaultState(), sulfurVeinSize), 
						Biome.COUNT_RANGE, 
						new CountRangeConfig(sulfurCount, sulfurMinHeight, sulfurMaxHeightBase, sulfurMaxHeight))	// Count, MinHeight, MaxHeightBase, MaxHeight
				)
		);
		
		BiomeManager.getBiomes(BiomeType.DESERT).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature
				(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.sulfur_ore_block.getDefaultState(), sulfurVeinSize), 
						Biome.COUNT_RANGE, 
						new CountRangeConfig(sulfurCount, sulfurMinHeight, sulfurMaxHeightBase, sulfurMaxHeight))	// Count, MinHeight, MaxHeightBase, MaxHeight
				)
		);
		
		BiomeManager.getBiomes(BiomeType.ICY).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature
				(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.sulfur_ore_block.getDefaultState(), sulfurVeinSize), 
						Biome.COUNT_RANGE, 
						new CountRangeConfig(sulfurCount, sulfurMinHeight, sulfurMaxHeightBase, sulfurMaxHeight))	// Count, MinHeight, MaxHeightBase, MaxHeight
				)
		);
		
		/**
		 * 	NETHER GENERATION
		 */
		
		int netherSulfurCount = 10;
		int netherSulfurMinHeight = 23;
		int netherSulfurMaxHeightBase = 60;
		int netherSulfurMaxHeight = 125;
		
		int netherSulfurVeinSize = getRandomNumberInRange(6, 11);
		
		Biomes.NETHER.addFeature(GenerationStage.Decoration.RAW_GENERATION,
						Biome.createCompositeFeature(Feature.MINABLE, new NetherConfig(NetherConfig.IS_NETHER, BlockList.sulfur_nether_ore_block.getDefaultState(), netherSulfurVeinSize), 
						Biome.COUNT_RANGE, 
						new CountRangeConfig(netherSulfurCount, netherSulfurMinHeight, netherSulfurMaxHeightBase, netherSulfurMaxHeight)));	// Count, MinHeight, MaxHeightBase, MaxHeight);
	}
	
	/**
	 * 	Returns a random number between two ints
	 */
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}