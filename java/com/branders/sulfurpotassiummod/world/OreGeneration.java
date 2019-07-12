package com.branders.sulfurpotassiummod.world;

import com.branders.sulfurpotassiummod.lists.BlockList;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeManager;

public class OreGeneration 
{
	private static final CountRangeConfig sulfur_config = new CountRangeConfig(8, 0, 58, 128); // Count, bottomOffset, topOffset, maximum
	private static final int sulfurVeinSize = 6;
	
	private static final CountRangeConfig sulfur_nether_config = new CountRangeConfig(12, 0, 0, 128);
	private static final int sulfurNetherVeinSize = 12;
	
	private static final CountRangeConfig potassium_config = new CountRangeConfig(12, 0, 0, 128);
	private static final int potassiumVeinSize = 10;
	 
	public static void setupOreGeneration()
	{
		for(BiomeManager.BiomeType btype : BiomeManager.BiomeType.values())
		{
			for(BiomeManager.BiomeEntry biomeEntry : BiomeManager.getBiomes(btype))
			{
				biomeEntry.biome.addFeature(Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(Feature.ORE, 
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.sulfur_ore_block.getDefaultState(), sulfurVeinSize),
								Placement.COUNT_RANGE, sulfur_config));
				
				biomeEntry.biome.addFeature(Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(Feature.ORE, 
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.potassium_ore_block.getDefaultState(), potassiumVeinSize),
								Placement.COUNT_RANGE, potassium_config));
			}
		}
	}
	
	public static void setupNetherOreGeneration()
	{
		Biomes.NETHER.addFeature(Decoration.UNDERGROUND_ORES,
				Biome.createDecoratedFeature(Feature.ORE, 
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockList.sulfur_nether_ore_block.getDefaultState(), sulfurNetherVeinSize),
						Placement.COUNT_RANGE, sulfur_nether_config));
	}
}