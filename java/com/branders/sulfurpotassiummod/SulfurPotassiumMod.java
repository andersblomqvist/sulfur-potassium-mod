package com.branders.sulfurpotassiummod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.branders.sulfurpotassiummod.blocks.PotassiumOreBlock;
import com.branders.sulfurpotassiummod.blocks.SulfurOreBlock;
import com.branders.sulfurpotassiummod.config.Config;
import com.branders.sulfurpotassiummod.items.PotassiumItem;
import com.branders.sulfurpotassiummod.lists.BlockList;
import com.branders.sulfurpotassiummod.lists.ItemList;
import com.branders.sulfurpotassiummod.world.feature.GenOreFeature;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//The value here should match an entry in the META-INF/mods.toml file
@Mod("sulfurpotassiummod")
public class SulfurPotassiumMod
{
	private static final String modid = "sulfurpotassiummod";
	
	 // Directly reference a log4j logger.
	 private static final Logger LOGGER = LogManager.getLogger();
	 
	 public SulfurPotassiumMod() 
	 {
	     // Register the setup method for modloading
	     FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	
	     // Register ourselves for server and other game events we are interested in
	     MinecraftForge.EVENT_BUS.register(this);
	     
	     Config.init();
	 }
	
	 private void setup(final FMLCommonSetupEvent event)
	 {
		 GenOreFeature.Init();
	 }
	 
	 // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
	 // Event bus for receiving Registry Events)
	 @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	 public static class RegistryEvents 
	 {
	 	/**
	 	 * 	------------------------
	 	 * 	Item registry
	 	 * 	------------------------
	 	 */
		 @SubscribeEvent
	     public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) 
	     {
	         // register a new item here
	 		itemRegistryEvent.getRegistry().registerAll
	 		(		
	 			/**
	 			 * 	Register Items
	 			 */
 				ItemList.sulfur_item = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("sulfur_item")),
 				ItemList.potassium_item = new PotassiumItem(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("potassium_item")),
 				
 				/**
 				 * 	Register Block Items
 				 */
	        		 
	        	// Sulfur Ore (Item) Block	 
	     		ItemList.sulfur_ore_block = new ItemBlock(BlockList.sulfur_ore_block, new Item.Properties().
	     				group(ItemGroup.BUILDING_BLOCKS)).
	     				setRegistryName(BlockList.sulfur_ore_block.getRegistryName()),
				
 				// Sulfure Nether (Item) Block
	     		ItemList.sulfur_nether_block = new ItemBlock(BlockList.sulfur_nether_ore_block, new Item.Properties().
	     				group(ItemGroup.BUILDING_BLOCKS)).
	     				setRegistryName(BlockList.sulfur_nether_ore_block.getRegistryName()),
	     				
 				// Potassium Ore (Item) Block
 				ItemList.potassium_ore_block= new ItemBlock(BlockList.potassium_ore_block, new Item.Properties().
	     				group(ItemGroup.BUILDING_BLOCKS)).
	     				setRegistryName(BlockList.potassium_ore_block.getRegistryName())
	 		);
	     }
	 	
	 	/**
	 	 * 	------------------------
	 	 * 	Block registry
	 	 * 	------------------------
	 	 */
	     @SubscribeEvent
	     public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) 
	     {	
	         // register a new block here
	         blockRegistryEvent.getRegistry().registerAll
	         (
        		// Sulfur Block
	     		BlockList.sulfur_ore_block = new SulfurOreBlock(Block.Properties.from(Blocks.IRON_ORE)).setRegistryName(location("sulfur_ore_block")),
	     		
	     		// Sulfur Nether block
	     		BlockList.sulfur_nether_ore_block = new SulfurOreBlock(Block.Properties.from(Blocks.NETHER_QUARTZ_ORE)).setRegistryName(location("sulfur_nether_ore_block")),
	     				
 				// Potassium Block
 				BlockList.potassium_ore_block = new PotassiumOreBlock(Block.Properties.from(Blocks.IRON_ORE)).setRegistryName(location("potassium_ore_block"))
	 		);
	     }
	     
	    private static ResourceLocation location(String name)
	    {
	 	   return new ResourceLocation(modid, name);
	    }
	 }
}