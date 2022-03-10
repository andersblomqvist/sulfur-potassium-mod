package com.branders.sulfurpotassiummod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.branders.sulfurpotassiummod.config.ModConfigManager;
import com.branders.sulfurpotassiummod.registry.ModFeatures;
import com.branders.sulfurpotassiummod.registry.RegistryHandler;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * 	This mods adds two new blocks into Minecraft - sulfur and potassium.
 * 	Their raw materials can then make gunpowder. (Minecraft Forge 1.18)
 * 
 *	@author Anders <Branders> Blomqvist
 */
@Mod(SulfurPotassiumMod.MOD_ID)
public class SulfurPotassiumMod {
	
	public static final String MOD_ID = "sulfurpotassiummod";
    public static final Logger LOGGER = LogManager.getLogger();
    
    @SuppressWarnings("resource")
	public SulfurPotassiumMod() {
		RegistryHandler.init();
		ModConfigManager.initConfig(MOD_ID, Minecraft.getInstance().gameDirectory.getAbsoluteFile());
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}
	
	public void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ModFeatures.register();
		});
	}
}