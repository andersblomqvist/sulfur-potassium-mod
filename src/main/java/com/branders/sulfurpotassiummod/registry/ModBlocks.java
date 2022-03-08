package com.branders.sulfurpotassiummod.registry;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

/**
 * 	Mod Block registry and references
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class ModBlocks {
	
	public static final Block 
		SULFUR_ORE = registerBlock("sulfur_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(2, 4))),
		SULFUR_NETHER_ORE = registerBlock("sulfur_nether_ore", new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.DARK_RED).strength(3.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE), UniformIntProvider.create(2, 5))),
		SULFUR_BLOCK = registerBlock("sulfur_block", new Block(FabricBlockSettings.of(Material.METAL, MapColor.GOLD).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL))),
		POTASSIUM_ORE = registerBlock("potassium_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F))),
		POTASSIUM_BLOCK = registerBlock("potassium_block", new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)));
	
	public static void register() {}
	
	private static Block registerBlock(String name, Block block) {
		Registry.register(Registry.BLOCK, new Identifier(SulfurPotassiumMod.MOD_ID, name), block);
		ModItems.registerItem(name, new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		return block;
	}
}
