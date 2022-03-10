package com.branders.sulfurpotassiummod.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * 	Copies the block behavior from Nether Quartz Ore.
 * 
 * 	Drops sulfur which does not need any more processing.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class SulfurNetherOre extends OreBlock {
	
	public SulfurNetherOre() {
		super(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE), UniformInt.of(2, 5));
	}
}
