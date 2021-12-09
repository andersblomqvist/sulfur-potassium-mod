package com.branders.sulfurpotassiummod.registry;

import java.util.ArrayList;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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

	private static ArrayList<Block> blockList = new ArrayList<Block>();
	
	public static final Block 
		SULFUR_ORE = registerBlock("sulfur_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).strength(3.0F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(2, 4))),
		SULFUR_NETHER_ORE = registerBlock("sulfur_nether_ore", new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.DARK_RED).breakByTool(FabricToolTags.PICKAXES, 2).strength(3.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE), UniformIntProvider.create(2, 5))),
		SULFUR_BLOCK = registerBlock("sulfur_block", new Block(FabricBlockSettings.of(Material.METAL, MapColor.GOLD).breakByTool(FabricToolTags.PICKAXES, 2).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL))),
		POTASSIUM_ORE = registerBlock("potassium_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).strength(3.0F, 3.0F))),
		POTASSIUM_BLOCK = registerBlock("potassium_block", new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).breakByTool(FabricToolTags.PICKAXES, 2).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)));
	
	public static void register() {}
	
	private static Block registerBlock(String name, Block block) {
		Registry.register(Registry.BLOCK, new Identifier(SulfurPotassiumMod.MOD_ID, name), block);
		ModItems.registerItem(name, new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		blockList.add(block);
		return block;
	}
	
	/**
	 * 	Searches for the block and returns its default blockstate.
	 * 
	 * 	Returns null if block not found.
	 * 
	 * 	@param name Block registry name
	 * 	@return BlockState
	 */
	public static BlockState getBlockState(String name) {
		for(Block block : blockList) {
			if(block.getName().toString().contains(name)) {
				return block.getDefaultState();
			}
		}
		System.out.println("Could not find block with name: " + name + ", returning NULL value");
		return null;
	}
	
}
