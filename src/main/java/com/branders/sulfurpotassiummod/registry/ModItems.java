package com.branders.sulfurpotassiummod.registry;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * 	Mod items registry and reference
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class ModItems {

	public static Item
		POTASSIUM,
		RAW_POTASSIUM,
		SULFUR;
	
	public static void register() {
		registerItem("potassium", POTASSIUM = new BoneMealItem(new Item.Settings()), ItemGroups.INGREDIENTS);
		registerItem("raw_potassium", RAW_POTASSIUM = new Item(new Item.Settings()), ItemGroups.INGREDIENTS);
		registerItem("sulfur", SULFUR = new Item(new Item.Settings()), ItemGroups.INGREDIENTS);
	}
	
	public static void registerItem(String name, Item item, ItemGroup group) {
		Registry.register(Registries.ITEM, new Identifier(SulfurPotassiumMod.MOD_ID, name), item);
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
	}
}
