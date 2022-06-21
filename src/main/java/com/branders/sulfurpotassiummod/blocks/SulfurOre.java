package com.branders.sulfurpotassiummod.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * 	Copies the block behavior from Iron Ore.
 * 
 * 	Sulfur Ore drops sulfur which does not need any more processing
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class SulfurOre extends DropExperienceBlock {
	
	public SulfurOre() {
		super(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE), UniformInt.of(2, 5));
	}
}
