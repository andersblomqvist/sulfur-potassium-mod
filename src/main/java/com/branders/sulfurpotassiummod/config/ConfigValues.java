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
		CONFIG_SPEC.put("potassium_vein_size", 9);
		CONFIG_SPEC.put("potassium_max_height", 128);
		CONFIG_SPEC.put("potassium_count", 20);
		
		CONFIG_SPEC.put("sulfur_vein_size", 8);
		CONFIG_SPEC.put("sulfur_max_height", 48);
		CONFIG_SPEC.put("sulfur_count", 12);
		
		CONFIG_SPEC.put("nether_sulfur_vein_size", 12);
		CONFIG_SPEC.put("nether_sulfur_max_height", 255);
		CONFIG_SPEC.put("nether_sulfur_count", 20);
		
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