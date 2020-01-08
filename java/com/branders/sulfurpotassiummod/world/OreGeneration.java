package com.branders.sulfurpotassiummod.world;

import com.branders.sulfurpotassiummod.config.GenerationConfig;
import com.branders.sulfurpotassiummod.lists.BlockList;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration 
{
	// ContRangeConfig values in order: count, bottomOffset, topOffset, maximum
	
	// Sulfur Overworld Config
	private static final CountRangeConfig sulfur_config = new CountRangeConfig(
			GenerationConfig.sulfur_count.get(),
			GenerationConfig.sulfur_bottom_limit.get(), 
			GenerationConfig.sulfur_upper_limit.get(), 
			128
	); 
	private static final int sulfurVeinSize = GenerationConfig.sulfur_vein_size.get();
	
	// Sulfur Nether Config
	private static final CountRangeConfig sulfur_nether_config = new CountRangeConfig(
			GenerationConfig.sulfur_nether_count.get(),
			GenerationConfig.sulfur_nether_bottom_limit.get(), 
			GenerationConfig.sulfur_nether_upper_limit.get(),
			128
	);
	private static final int sulfurNetherVeinSize = GenerationConfig.sulfur_nether_vein_size.get();
	
	// Potassium Config
	private static final CountRangeConfig potassium_config = new CountRangeConfig(
			GenerationConfig.potassium_count.get(),
			GenerationConfig.potassium_bottom_limit.get(), 
			GenerationConfig.potassium_upper_limit.get(), 
			128
	);
	private static final int potassiumVeinSize = GenerationConfig.potassium_vein_size.get();
	 
	public static void setupOreGeneration()
	{
		for(Biome biome : ForgeRegistries.BIOMES.getValues())
		{
			// Skip The End and Nether. We setup nether features elsewhere
			if(biome.getCategory() == Biome.Category.THEEND || biome.getCategory() == Biome.Category.NETHER)
				continue;
			
			biome.addFeature(Decoration.UNDERGROUND_ORES,
					Biome.createDecoratedFeature(Feature.ORE, 
							new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									BlockList.potassium_ore_block.getDefaultState(),
									potassiumVeinSize
							),
							Placement.COUNT_RANGE, potassium_config));
			
			// Check if we want to spawn sulfur
			if(!GenerationConfig.should_sulfur_spawn_in_overworld.get())
				return;
			
			biome.addFeature(Decoration.UNDERGROUND_ORES,
					Biome.createDecoratedFeature(Feature.ORE, 
							new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
									BlockList.sulfur_ore_block.getDefaultState(), 
									sulfurVeinSize
							),
							Placement.COUNT_RANGE, sulfur_config));
		}
	}
	
	public static void setupNetherOreGeneration()
	{
		// Check if we want to spawn sulfur
		if(!GenerationConfig.should_sulfur_spawn_in_nether.get())
			return;
		
		Biomes.NETHER.addFeature(Decoration.UNDERGROUND_ORES,
				Biome.createDecoratedFeature(Feature.ORE, 
						new OreFeatureConfig(
								OreFeatureConfig.FillerBlockType.NETHERRACK,
								BlockList.sulfur_nether_ore_block.getDefaultState(),
								sulfurNetherVeinSize
						),
						Placement.COUNT_RANGE, sulfur_nether_config));
	}
}