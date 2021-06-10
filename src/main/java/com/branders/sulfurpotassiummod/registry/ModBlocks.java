package com.branders.sulfurpotassiummod.registry;

import java.util.ArrayList;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;
import com.branders.sulfurpotassiummod.blocks.DropExpOre;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;

/**
 * 	List of all blocks in mod.	
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class ModBlocks {
	
	private static ArrayList<Block> blockList = new ArrayList<Block>();
	
	public static Block 
		SULFUR_ORE_BLOCK,
		SULFUR_NETHER_ORE_BLOCK,
		SULFUR_BLOCK,
		POTASSIUM_ORE_BLOCK,
		POTASSIUM_BLOCK;
	
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		registerBlock(event, "potassium_ore_block", POTASSIUM_ORE_BLOCK = new Block(Block.Properties.from(Blocks.IRON_ORE)));
		registerBlock(event, "potassium_block", POTASSIUM_BLOCK = new Block(Block.Properties.from(Blocks.IRON_BLOCK)));
		registerBlock(event, "sulfur_ore_block", SULFUR_ORE_BLOCK = new DropExpOre(Block.Properties.from(Blocks.IRON_ORE)));
		registerBlock(event, "sulfur_nether_ore_block", SULFUR_ORE_BLOCK = new DropExpOre(Block.Properties.from(Blocks.NETHER_QUARTZ_ORE)));
		registerBlock(event, "sulfur_block", SULFUR_BLOCK = new Block(Block.Properties.from(Blocks.IRON_BLOCK)));
	}
	
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		for(Block block : blockList)
			event.getRegistry().register(new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	
	private static void registerBlock(RegistryEvent.Register<Block> event, String name, Block block) {
		block.setRegistryName(SulfurPotassiumMod.MODID, name);
		event.getRegistry().register(block);
		blockList.add(block);
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
			if(block.getRegistryName().toString().contains(name)) {
				return block.getDefaultState();
			}
		}
		return null;
	}
}
