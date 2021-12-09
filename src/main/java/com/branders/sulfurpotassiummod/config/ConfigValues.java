package com.branders.sulfurpotassiummod.config;

import java.util.HashMap;

/**
 * 	All mod config values are stored here.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class ConfigValues {
	
	public static HashMap<String, Integer> CONFIG_SPEC = new HashMap<String, Integer>();
	
	/**
	 * 	Set default config values
	 */
	public static void setDefaultConfigValues() {
		CONFIG_SPEC.put("potassium_middle_vein_size", 9);
		CONFIG_SPEC.put("potassium_middle_max_height", 56);
		CONFIG_SPEC.put("potassium_middle_min_height", 6);
		CONFIG_SPEC.put("potassium_middle_count", 10);
		
		CONFIG_SPEC.put("potassium_upper_vein_size", 12);
		CONFIG_SPEC.put("potassium_upper_min_height", 70);
		CONFIG_SPEC.put("potassium_upper_max_height", 384);
		CONFIG_SPEC.put("potassium_upper_count", 20);
		
		CONFIG_SPEC.put("sulfur_vein_size", 10);
		CONFIG_SPEC.put("sulfur_max_height", 0);
		CONFIG_SPEC.put("sulfur_count", 8);
		
		CONFIG_SPEC.put("nether_sulfur_vein_size", 15);
		CONFIG_SPEC.put("nether_sulfur_max_height", 255);
		CONFIG_SPEC.put("nether_sulfur_count", 25);
		
		CONFIG_SPEC.put("disable_gen_potassium", 0);
		CONFIG_SPEC.put("disable_gen_sulfur", 0);
		CONFIG_SPEC.put("disable_gen_nether_sulfur", 0);
	}
	
	/**
	 * 	Called from {@link ModConfigManager} when reading from json file
	 */
	public static void setConfigValue(String key, int value) {
		CONFIG_SPEC.put(key, value);
	}
}