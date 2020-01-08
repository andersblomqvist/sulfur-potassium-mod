package com.branders.sulfurpotassiummod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class GenerationConfig 
{
	public static ForgeConfigSpec.BooleanValue should_sulfur_spawn_in_nether;
	public static ForgeConfigSpec.BooleanValue should_sulfur_spawn_in_overworld;
	
	public static ForgeConfigSpec.IntValue sulfur_count;
	public static ForgeConfigSpec.IntValue sulfur_vein_size;
	public static ForgeConfigSpec.IntValue sulfur_bottom_limit;
	public static ForgeConfigSpec.IntValue sulfur_upper_limit;
	
	public static ForgeConfigSpec.IntValue sulfur_nether_count;
	public static ForgeConfigSpec.IntValue sulfur_nether_vein_size;
	public static ForgeConfigSpec.IntValue sulfur_nether_bottom_limit;
	public static ForgeConfigSpec.IntValue sulfur_nether_upper_limit;
	
	public static ForgeConfigSpec.IntValue potassium_count;
	public static ForgeConfigSpec.IntValue potassium_vein_size;
	public static ForgeConfigSpec.IntValue potassium_bottom_limit;
	public static ForgeConfigSpec.IntValue potassium_upper_limit;
	
	public static void init(ForgeConfigSpec.Builder common)
	{
		common.comment("Generation Config");
		
		should_sulfur_spawn_in_nether = common
				.comment("")
				.define("generationconfig.should_sulfur_spawn_in_nether", true);
		
		should_sulfur_spawn_in_overworld = common
				.comment("")
				.define("generationconfig.should_sulfur_spawn_in_overworld", true);
		
		// Sulfur overworld config
		
		sulfur_count = common
				.comment("Spawn frequency. Default is 8")
				.defineInRange("generationconfig.sulfur_count", 8, 0, 100);
		
		sulfur_vein_size = common
				.comment("Default is 6")
				.defineInRange("generationconfig.sulfur_vein_size", 6, 0, 100);
		
		sulfur_bottom_limit = common
				.comment("Default is 0")
				.defineInRange("generationconfig.sulfur_bottom_limit", 0, 0, 100);
		
		sulfur_upper_limit = common
				.comment("Default is 58")
				.defineInRange("generationconfig.sulfur_upper_limit", 58, 0, 100);
		
		// Sulfur nether config
		
		sulfur_nether_count = common
				.comment("Spawn frequency. Default is 12")
				.defineInRange("generationconfig.sulfur_nether_count", 12, 0, 100);
		
		sulfur_nether_vein_size = common
				.comment("Default is 12")
				.defineInRange("generationconfig.sulfur_nether_vein_size", 12, 0, 100);
		
		sulfur_nether_bottom_limit = common
				.comment("Default is 0")
				.defineInRange("generationconfig.sulfur_nether_bottom_limit", 0, 0, 100);
		
		sulfur_nether_upper_limit = common
				.comment("Default is 0")
				.defineInRange("generationconfig.sulfur_nether_upper_limit", 0, 0, 100);
		
		// Potassium config
		
		potassium_count = common
				.comment("Spawn frequency. Default is 12")
				.defineInRange("generationconfig.potassium_count", 12, 0, 100);
		
		potassium_vein_size = common
				.comment("Default is 10")
				.defineInRange("generationconfig.potassium_vein_size", 10, 0, 100);
		
		potassium_bottom_limit = common
				.comment("Default is 0")
				.defineInRange("generationconfig.potassium_bottom_limit", 0, 0, 100);
		
		potassium_upper_limit = common
				.comment("Default is 0")
				.defineInRange("generationconfig.potassium_upper_limit", 0, 0, 100);
	}
}
