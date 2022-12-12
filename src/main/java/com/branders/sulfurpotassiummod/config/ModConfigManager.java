package com.branders.sulfurpotassiummod.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.fabricmc.loader.api.FabricLoader;

/**
 * 	Simple config manager using a <modid>.json file
 * 	
 * 	@author Anders <Branders> Blomqvist
 */
public class ModConfigManager {

	private static File file;
	
	public static final Gson GSON = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.setPrettyPrinting().create();
	
	/**
	 * 	Initialize the mod config. Try find an existing config file. If it exists we set values from
	 * 	file. Otherwise we create a new config file with default values.
	 */
	public static void initConfig(String modid) {
		
		// Config values will be overwritten if a config file exists.
		ConfigValues.setDefaultConfigValues();
		
		file = new File(FabricLoader.getInstance().getConfigDir().toFile(), modid + ".json");
		
		if(!file.exists()) {
			// No config file found. Create a new default config
			SulfurPotassiumMod.LOGGER.info("Could not find config, generating new default config.");
			saveConfig();
		}
		else {
			SulfurPotassiumMod.LOGGER.info("Reading config values from file.");
			readConfig();
		}
	}
	
	/**
	 * 	Reads the .json file where we iterate over the CONFIG_SPEC key values and read the value for
	 * 	each key.
	 */
	private static void readConfig() {
		try {
			BufferedReader reader =  new BufferedReader(new FileReader(file));
			@SuppressWarnings("deprecation")
			JsonObject json = new JsonParser().parse(reader).getAsJsonObject();
			
			for(String key : ConfigValues.CONFIG_SPEC.keySet()) {
				if(json.get(key) != null)
					ConfigValues.setConfigValue(key, json.get(key).getAsInt());
				else 
					System.err.println("Key Error: Could not find key: " + key);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	Saves the current values of the config to file.
	 */
	private static void saveConfig() {
		JsonObject config = new JsonObject();
		
		// Sort the keys so it's easier to edit config file
		Object[] keys = ConfigValues.CONFIG_SPEC.keySet().toArray();
		Arrays.sort(keys);
		
		for(Object key : keys) {
			config.addProperty((String) key, ConfigValues.CONFIG_SPEC.get(key));
			SulfurPotassiumMod.LOGGER.info("Adding key=" + key + ", value=" + ConfigValues.CONFIG_SPEC.get(key));
		}
		
		String jsonConfig = GSON.toJson(config);
		
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(jsonConfig);
			writer.close();
		} catch (IOException e) {
		    SulfurPotassiumMod.LOGGER.error("Could not save config file.");
			e.printStackTrace();
		}
	}
}
