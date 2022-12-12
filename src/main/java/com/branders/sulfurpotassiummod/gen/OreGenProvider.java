package com.branders.sulfurpotassiummod.gen;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import com.branders.sulfurpotassiummod.config.ConfigValues;
import com.branders.sulfurpotassiummod.registry.ModBlocks;
import com.branders.sulfurpotassiummod.registry.ModFeatures;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

/**
 *  Called from data generation where we create .json files with appropriate values.
 * 
 * 	@author Anders <Branders> Blomqvist
 */
public class OreGenProvider extends FabricDynamicRegistryProvider {

    private static int potassium_middle_vein_size = ConfigValues.CONFIG_SPEC.get("potassium_middle_vein_size");
    private static int potassium_middle_max_height = ConfigValues.CONFIG_SPEC.get("potassium_middle_max_height");
    private static int potassium_middle_min_height = ConfigValues.CONFIG_SPEC.get("potassium_middle_min_height");
    private static int potassium_middle_count = ConfigValues.CONFIG_SPEC.get("potassium_middle_count");
    
    private static int potassium_upper_vein_size = ConfigValues.CONFIG_SPEC.get("potassium_upper_vein_size");
    private static int potassium_upper_max_height = ConfigValues.CONFIG_SPEC.get("potassium_upper_max_height");
    private static int potassium_upper_min_height = ConfigValues.CONFIG_SPEC.get("potassium_upper_min_height");
    private static int potassium_upper_count = ConfigValues.CONFIG_SPEC.get("potassium_upper_count");
    
    private static int sulfur_vein_size = ConfigValues.CONFIG_SPEC.get("sulfur_vein_size");
    private static int sulfur_max_height = ConfigValues.CONFIG_SPEC.get("sulfur_max_height");
    private static int sulfur_count = ConfigValues.CONFIG_SPEC.get("sulfur_count");
    
    private static int sulfur_nether_vein_size = ConfigValues.CONFIG_SPEC.get("nether_sulfur_vein_size");
    private static int sulfur_nether_max_height = ConfigValues.CONFIG_SPEC.get("nether_sulfur_max_height");
    private static int sulfur_nether_count = ConfigValues.CONFIG_SPEC.get("nether_sulfur_count");
    
    private TagMatchRuleTest base_stone = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    private TagMatchRuleTest deepslate = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    private BlockMatchRuleTest nether = new BlockMatchRuleTest(Blocks.NETHERRACK);
    
    public OreGenProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return "Sulfur & Potassium";
    }

    @Override
    protected void configure(WrapperLookup registries, Entries entries) {
        
        ConfiguredFeature<?, ?> POTASSIUM_MIDDLE = newFeature(base_stone, ModBlocks.POTASSIUM_ORE.getDefaultState(), potassium_middle_vein_size);
        ConfiguredFeature<?, ?> POTASSIUM_UPPER  = newFeature(base_stone, ModBlocks.POTASSIUM_ORE.getDefaultState(), potassium_upper_vein_size);
        
        ConfiguredFeature<?, ?> SULFUR  = newFeature(deepslate, ModBlocks.SULFUR_ORE.getDefaultState(), sulfur_vein_size);
        ConfiguredFeature<?, ?> SULFUR_NETHER  = newFeature(nether, ModBlocks.SULFUR_NETHER_ORE.getDefaultState(), sulfur_nether_vein_size);
        
        addEntry(entries,
                ModFeatures.CF_POTASSIUM_MIDDLE, 
                ModFeatures.PF_POTASSIUM_MIDDLE, 
                POTASSIUM_MIDDLE, 
                potassium_middle_count,
                potassium_middle_min_height,
                potassium_middle_max_height);
        
        addEntry(entries,
                ModFeatures.CF_POTASSIUM_UPPER, 
                ModFeatures.PF_POTASSIUM_UPPER, 
                POTASSIUM_UPPER, 
                potassium_upper_count,
                potassium_upper_min_height,
                potassium_upper_max_height);
        
        addEntry(entries,
                ModFeatures.CF_SULFUR, 
                ModFeatures.PF_SULFUR, 
                SULFUR, 
                sulfur_count,
                -64,
                sulfur_max_height);
        
        addEntry(entries,
                ModFeatures.CF_SULFUR_NETHER, 
                ModFeatures.PF_SULFUR_NETHER, 
                SULFUR_NETHER, 
                sulfur_nether_count,
                -64,
                sulfur_nether_max_height);
        
    }

    private void addEntry(Entries entries, RegistryKey<ConfiguredFeature<?, ?>> rcf, RegistryKey<PlacedFeature> rpf, ConfiguredFeature<?, ?> cf, int count, int minHeight, int maxHeight) {
        RegistryEntry<ConfiguredFeature<?, ?>> featureRef = entries.add(rcf, cf);
        PlacedFeature placedFeature = new PlacedFeature(featureRef, Arrays.asList(
                CountPlacementModifier.of(count),
                SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.fixed(minHeight), YOffset.fixed(maxHeight))));
        entries.add(rpf, placedFeature);
    }
    
    private ConfiguredFeature<?, ?> newFeature(TagMatchRuleTest ruleTest, BlockState blockstate, int size) {
        return new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(ruleTest, blockstate, size));
    }
    
    private ConfiguredFeature<?, ?> newFeature(BlockMatchRuleTest ruleTest, BlockState blockstate, int size) {
        return new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(ruleTest, blockstate, size));
    }
}
