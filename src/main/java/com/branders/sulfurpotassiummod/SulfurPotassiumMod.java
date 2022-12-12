package com.branders.sulfurpotassiummod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.branders.sulfurpotassiummod.config.ModConfigManager;
import com.branders.sulfurpotassiummod.registry.ModBlocks;
import com.branders.sulfurpotassiummod.registry.ModFeatures;
import com.branders.sulfurpotassiummod.registry.ModItems;

import net.fabricmc.api.ModInitializer;

/**
 * 	Sulfur Potassium Mod for Fabric 1.19
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class SulfurPotassiumMod implements ModInitializer {
	
	public static final String MOD_ID = "sulfurpotassiummod";
	
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	@Override
	public void onInitialize() {
		ModConfigManager.initConfig(MOD_ID);
		ModBlocks.register();
		ModItems.register();
		ModFeatures.register();
	}
}
