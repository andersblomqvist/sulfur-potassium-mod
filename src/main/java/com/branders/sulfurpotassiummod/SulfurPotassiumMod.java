package com.branders.sulfurpotassiummod;

import com.branders.sulfurpotassiummod.config.OreGenerationConfig;
import com.branders.sulfurpotassiummod.events.OreGenEventHandler;
import com.branders.sulfurpotassiummod.registry.ModBlocks;
import com.branders.sulfurpotassiummod.registry.ModItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * 	This mods adds two new blocks into Minecraft - sulfur and potassium.
 * 	Their raw materials can then make gunpowder. (Minecraft Forge 1.16)
 * 
 *	@author Anders <Branders> Blomqvist
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod(SulfurPotassiumMod.MODID)
public class SulfurPotassiumMod {
	
	public static final String MODID = "sulfurpotassiummod";
	 
	public SulfurPotassiumMod() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OreGenerationConfig.SPEC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new OreGenEventHandler());
	}
	
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	ModBlocks.registerBlocks(event);
    }
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ModItems.registerItems(event);
        ModBlocks.registerItemBlocks(event);
    }
}