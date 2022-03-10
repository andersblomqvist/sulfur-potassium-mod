package com.branders.sulfurpotassiummod.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * 	Copies the block behavior from Iron Ore.
 * 
 * 	Sulfur Ore drops sulfur which does not need any more processing
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class SulfurOre extends OreBlock {
	
	public SulfurOre() {
		super(BlockBehaviour.Properties.copy(Blocks.IRON_ORE), UniformInt.of(2, 5));
	}
}
