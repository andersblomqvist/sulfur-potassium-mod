package com.branders.sulfurpotassiummod.blocks;

import com.branders.sulfurpotassiummod.lists.BlockList;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PotassiumOreBlock extends Block 
{
	/**
	 * 	Init defualt constructor
	 * 	Block properties is set when registred in Main class
	 */
	public PotassiumOreBlock(Block.Properties builder) 
	{
		super(builder);
	}
	
	/**
	 * 	Return when harvested
	 */
	public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) 
	{
		return BlockList.potassium_ore_block;
	}
}