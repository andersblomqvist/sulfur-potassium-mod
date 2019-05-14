package com.branders.sulfurpotassiummod.blocks;

import com.branders.sulfurpotassiummod.lists.ItemList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class SulfurOreBlock extends BlockOre
{
	public SulfurOreBlock(Block.Properties builder) {
		super(builder);
	}
	
	/**
	 * 	Return item when harvested
	 */
	public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) 
	{
		return ItemList.sulfur_item;
	}
	
	/**
	 * 	Get exp drop when harvested
	 */
	@Override
	public int getExpDrop(IBlockState state, IWorldReader reader, BlockPos pos, int fortune) 
	{
		World world = reader instanceof World ? (World)reader : null;
		
	      if (world == null || this.getItemDropped(state, world, pos, fortune) != this) 
	      {
	         int i = MathHelper.nextInt(RANDOM, 2, 5);
	         return i;
	      }
	      
	      return 0;
	}
}
