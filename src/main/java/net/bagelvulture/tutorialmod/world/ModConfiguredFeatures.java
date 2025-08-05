package net.bagelvulture.tutorialmod.world;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
//import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
//import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
//import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
//import net.minecraft.world.gen.stateprovider.BlockStateProvider;
//import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

//import static net.bagelvulture.tutorialmod.block.ModBlocks.Diseased_Can_Survive_On;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BEVULTRIUM_ORE_KEY = registerKey("bevultrium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_BEVULTRIUM_ORE_KEY = registerKey("nether_bevultrium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_BEVULTRIUM_ORE_KEY = registerKey("end_bevultrium_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> DISEASED_KEY = registerKey("diseased");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldBevultriumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.BEVULTRIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.BEVULTRIUM_DEEPSLATE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherBevultriumOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.BEVULTRIUM_NETHER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endBevultriumOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.BEVULTRIUM_END_ORE.getDefaultState()));

        // datagen for worldgen doesn't work, I've concluded it's the datagen program and not my code.

        //register(context, BEVULTRIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldBevultriumOres, 9));
        //register(context, NETHER_BEVULTRIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherBevultriumOres, 5));
        //register(context, END_BEVULTRIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endBevultriumOres, 3));

        //register(context, DISEASED_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
        //        BlockStateProvider.of(ModBlocks.DISEASED_LOG),
        //        new StraightTrunkPlacer(5, 1, 2),

        //        BlockStateProvider.of(ModBlocks.DISEASED_LEAVES),
        //        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),

        //        new TwoLayersFeatureSize(1, 0, 2)).dirtProvider(BlockStateProvider.of((BlockState) Diseased_Can_Survive_On)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TutorialMod.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}