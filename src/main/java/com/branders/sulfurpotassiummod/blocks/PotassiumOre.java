package com.branders.sulfurpotassiummod.blocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * 	Copies the block behavior from Iron Ore.
 * 
 * 	Potassium Ore drops raw potassium which can be smelled into potassium.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class PotassiumOre extends OreBlock {
	
	public PotassiumOre() {
		super(BlockBehaviour.Properties.copy(Blocks.IRON_ORE));
	}
}
