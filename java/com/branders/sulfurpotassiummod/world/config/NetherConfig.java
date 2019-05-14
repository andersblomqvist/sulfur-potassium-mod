package com.branders.sulfurpotassiummod.world.config;

import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.MinableConfig;

public class NetherConfig extends MinableConfig
{
	public static final Predicate<IBlockState> IS_NETHER = (p_210462_0_) -> {
		if (p_210462_0_ == null) {
	      return false;
	   } else {
	      Block block = p_210462_0_.getBlock();
	      return block == Blocks.NETHERRACK || block == Blocks.SOUL_SAND || block == Blocks.GRAVEL || block == Blocks.MAGMA_BLOCK;
	   }
	};
	
	public NetherConfig(Predicate<IBlockState> canReplaceIn, IBlockState stateIn, int sizeIn) 
	{
		super(canReplaceIn, stateIn, sizeIn);
	}

}
