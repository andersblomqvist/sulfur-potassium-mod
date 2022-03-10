package com.branders.sulfurpotassiummod.registry;

import com.branders.sulfurpotassiummod.SulfurPotassiumMod;
import com.branders.sulfurpotassiummod.blocks.PotassiumBlock;
import com.branders.sulfurpotassiummod.blocks.PotassiumOre;
import com.branders.sulfurpotassiummod.blocks.SulfurBlock;
import com.branders.sulfurpotassiummod.blocks.SulfurNetherOre;
import com.branders.sulfurpotassiummod.blocks.SulfurOre;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 	Handle the registration of the Blocks and Block Items.	
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
			ForgeRegistries.BLOCKS,
			SulfurPotassiumMod.MOD_ID);
	
	public static final DeferredRegister<Item> BLOCK_ITEMS  = DeferredRegister.create(
			ForgeRegistries.ITEMS,
			SulfurPotassiumMod.MOD_ID);
	
	private static final Item.Properties BASE_ITEM_PROPERTIES = new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS);
	
	public static final RegistryObject<Block> POTASSIUM_ORE = BLOCKS.register("potassium_ore", PotassiumOre::new);
    public static final RegistryObject<Item> POTASSIUM_ORE_ITEM = BLOCK_ITEMS.register("potassium_ore", () -> new BlockItem(POTASSIUM_ORE.get(), BASE_ITEM_PROPERTIES));
	
    public static final RegistryObject<Block> POTASSIUM_BLOCK = BLOCKS.register("potassium_block", PotassiumBlock::new);
    public static final RegistryObject<Item> POTASSIUM_BLOCK_ITEM = BLOCK_ITEMS.register("potassium_block", () -> new BlockItem(POTASSIUM_BLOCK.get(), BASE_ITEM_PROPERTIES));
    
    public static final RegistryObject<OreBlock> SULFUR_ORE = BLOCKS.register("sulfur_ore", SulfurOre::new);
    public static final RegistryObject<Item> SULFUR_ORE_ITEM = BLOCK_ITEMS.register("sulfur_ore", () -> new BlockItem(SULFUR_ORE.get(), BASE_ITEM_PROPERTIES));
    
    public static final RegistryObject<OreBlock> SULFUR_NETHER_ORE = BLOCKS.register("sulfur_nether_ore", SulfurNetherOre::new);
    public static final RegistryObject<Item> SULFUR_NETHER_ORE_ITEM = BLOCK_ITEMS.register("sulfur_nether_ore", () -> new BlockItem(SULFUR_NETHER_ORE.get(), BASE_ITEM_PROPERTIES));
    
    public static final RegistryObject<Block> SULFUR_BLOCK = BLOCKS.register("sulfur_block", SulfurBlock::new);
    public static final RegistryObject<Item> SULFUR_BLOCK_ITEM = BLOCK_ITEMS.register("sulfur_block", () -> new BlockItem(SULFUR_BLOCK.get(), BASE_ITEM_PROPERTIES));
    
	public static void register(IEventBus modEventBus) {
		BLOCKS.register(modEventBus);
		BLOCK_ITEMS.register(modEventBus);
	}
}
