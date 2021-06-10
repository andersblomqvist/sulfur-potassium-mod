package com.branders.sulfurpotassiummod.registry;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;

import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;

/**
 * 	List of all items in mod.	
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class ModItems {
	
	public static Item
		SULFUR_ITEM,
		POTASSIUM_ITEM;
	
	public static void registerItems(RegistryEvent.Register<Item> event) {
		registerItem(event, "sulfur_item", new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
		registerItem(event, "potassium_item", new BoneMealItem(new Item.Properties().group(ItemGroup.MATERIALS)));
	}
	
	private static void registerItem(RegistryEvent.Register<Item> event, String name, Item item) {
		item.setRegistryName(SulfurPotassiumMod.MODID, name);
		event.getRegistry().register(item);
	}
}
