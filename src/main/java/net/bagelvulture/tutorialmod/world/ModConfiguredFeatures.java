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
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BEVULTRIUM_ORE_KEY = registerKey("bevultrium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_BEVULTRIUM_ORE_KEY = registerKey("nether_bevultrium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_BEVULTRIUM_ORE_KEY = registerKey("end_bevultrium_ore");

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
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TutorialMod.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}