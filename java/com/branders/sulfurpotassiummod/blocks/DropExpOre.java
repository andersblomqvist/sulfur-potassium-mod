package com.branders.sulfurpotassiummod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

/**
 *	Didn't get OreBlock class to work. Therefore Sulfur block uses this class instead.
 *	Only to make sure block drop exp when not harvested with silk touch.
 */
public class DropExpOre extends OreBlock
{
	public DropExpOre(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) 
	{
		return silktouch == 0 ? MathHelper.nextInt(RANDOM, 2, 5) : 0;
	}
}
