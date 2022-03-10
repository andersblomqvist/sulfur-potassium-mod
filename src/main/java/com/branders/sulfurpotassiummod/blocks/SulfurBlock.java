package com.branders.sulfurpotassiummod.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * 	Copies behavior from Iron Block.
 * 
 * 	Crafted from 9 sulfur.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class SulfurBlock extends Block {
	
	public SulfurBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK));
	}
}
