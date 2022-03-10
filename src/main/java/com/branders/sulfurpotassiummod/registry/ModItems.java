package com.branders.sulfurpotassiummod.registry;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 	Handle the registration of all items.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class ModItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SulfurPotassiumMod.MOD_ID);
	
	public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> POTASSIUM = ITEMS.register("potassium", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> RAW_POTASSIUM = ITEMS.register("raw_potassium", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	
	public static void register(IEventBus modEventBus) {
		ITEMS.register(modEventBus);
	}
}
