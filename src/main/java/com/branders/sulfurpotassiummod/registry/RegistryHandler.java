package com.branders.sulfurpotassiummod.registry;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RegistryHandler {

	public static void init() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModBlocks.register(bus);
		ModItems.register(bus);
	}
}
