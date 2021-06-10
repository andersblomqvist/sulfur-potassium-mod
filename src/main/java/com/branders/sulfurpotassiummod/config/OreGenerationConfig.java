package com.branders.sulfurpotassiummod.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class OreGenerationConfig {
	
private static final ForgeConfigSpec.Builder BUILDER = new Builder();
	
	public static final General GENERAL = new General(BUILDER);
	public static final ForgeConfigSpec SPEC = BUILDER.build();
	
	public static class General {
		
		public final BooleanValue should_sulfur_spawn_in_nether;
		public final BooleanValue should_sulfur_spawn_in_overworld;
		
		public final IntValue potassium_vein_size;
		public final IntValue potassium_upper_limit;
		
		public final IntValue sulfur_vein_size;
		public final IntValue sulfur_upper_limit;
		
		public final IntValue sulfur_nether_vein_size;
		
		public General(ForgeConfigSpec.Builder builder) {
			builder.push("Disable nether/overworld for Sulfur");
			
			should_sulfur_spawn_in_nether = builder
					.comment("")
					.define("generationconfig.should_sulfur_spawn_in_nether", true);
			
			should_sulfur_spawn_in_overworld = builder
					.comment("")
					.define("generationconfig.should_sulfur_spawn_in_overworld", true);
			
			builder.pop();
			
			builder.push("Spawn Rates Data");
	
			sulfur_vein_size = builder
					.comment("Default is 9")
					.defineInRange("generationconfig.sulfur_vein_size", 9, 0, 100);
			
			sulfur_upper_limit = builder
					.comment("Default is 64")
					.defineInRange("generationconfig.sulfur_upper_limit", 48, 1, 255);
			
			// Sulfur nether config
			
			sulfur_nether_vein_size = builder
					.comment("Default is 14")
					.defineInRange("generationconfig.sulfur_nether_vein_size", 14, 0, 100);
			
			// Potassium config
			
			potassium_vein_size = builder
					.comment("Default is 9")
					.defineInRange("generationconfig.potassium_vein_size", 9, 0, 100);
			
			potassium_upper_limit = builder
					.comment("Default is 128")
					.defineInRange("generationconfig.potassium_upper_limit", 128, 1, 255);
			
			builder.pop();
		}
	}
}
