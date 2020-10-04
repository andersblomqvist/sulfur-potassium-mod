package com.branders.sulfurpotassiummod;

import com.branders.sulfurpotassiummod.blocks.DropExpOre;
import com.branders.sulfurpotassiummod.config.OreGenerationConfig;
import com.branders.sulfurpotassiummod.events.ModEventHandler;
import com.branders.sulfurpotassiummod.lists.BlockList;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * 	This mods adds two new blocks into Minecraft - sulfur and potassium.
 * 	Their raw materials can then make gunpowder. (Minecraft Forge 1.16)
 * 
 *	@author Anders <Branders> Blomqvist
 */
@Mod(SulfurPotassiumMod.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SulfurPotassiumMod {
	
	public static final String MODID = "sulfurpotassiummod";
	 
	public SulfurPotassiumMod() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OreGenerationConfig.SPEC);
	    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new ModEventHandler());
	}
	
	/**
     * 	Event for register blocks
     */
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	registerBlocks(event.getRegistry());
    }
    
    public static void registerBlocks(IForgeRegistry<Block> registry) {
    	// Register Blocks
    	registry.register(BlockList.sulfur_ore_block = new DropExpOre(Block.Properties.from(Blocks.COAL_ORE)).setRegistryName(MODID, "sulfur_ore_block"));
    	registry.register(BlockList.sulfur_block = new Block(Block.Properties.from(Blocks.COAL_BLOCK)).setRegistryName(MODID, "sulfur_block"));
    	registry.register(BlockList.sulfur_nether_ore_block = new DropExpOre(Block.Properties.from(Blocks.NETHER_QUARTZ_ORE)).setRegistryName(MODID, "sulfur_nether_ore_block"));
    	registry.register(BlockList.potassium_ore_block = new Block(Block.Properties.from(Blocks.IRON_ORE)).setRegistryName(MODID, "potassium_ore_block"));
    	registry.register(BlockList.potassium_block = new Block(Block.Properties.from(Blocks.COAL_BLOCK)).setRegistryName(MODID, "potassium_block"));
    }
    
    
	/**
     * 	Event for register items and item blocks
     */
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        registerItems(event.getRegistry());
    }
    
    public static void registerItems(IForgeRegistry<Item> registry) {
    	// Register Items
    	registry.register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(MODID, "sulfur_item"));
    	registry.register(new BoneMealItem(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(MODID, "potassium_item"));
    	
    	// Register Item Blocks
    	registry.register(new BlockItem(BlockList.sulfur_ore_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.sulfur_ore_block.getRegistryName()));
    	registry.register(new BlockItem(BlockList.sulfur_nether_ore_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.sulfur_nether_ore_block.getRegistryName()));
    	registry.register(new BlockItem(BlockList.sulfur_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.sulfur_block.getRegistryName()));
    	registry.register(new BlockItem(BlockList.potassium_ore_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.potassium_ore_block.getRegistryName()));
    	registry.register(new BlockItem(BlockList.potassium_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.potassium_block.getRegistryName()));
    }
}