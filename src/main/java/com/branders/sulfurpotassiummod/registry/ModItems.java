package com.branders.sulfurpotassiummod.registry;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;

import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * 	Mod items registry and reference
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class ModItems {

	public static Item
		POTASSIUM,
		SULFUR;
	
	public static void registerItems() {
		registerItem("potassium", POTASSIUM = new BoneMealItem(new Item.Settings().group(ItemGroup.MATERIALS)));
		registerItem("sulfur", SULFUR = new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
	}
	
	public static void registerItem(String name, Item item) {
		Registry.register(Registry.ITEM, new Identifier(SulfurPotassiumMod.MOD_ID, name), item);
	}

}
