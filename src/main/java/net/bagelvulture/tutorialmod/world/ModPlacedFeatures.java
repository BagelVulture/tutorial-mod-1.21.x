package net.bagelvulture.tutorialmod.world;

import net.bagelvulture.tutorialmod.TutorialMod;
//import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
//import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
//import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> BEVULTRIUM_ORE_PLACED_KEY = registerKey("bevultrium_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_BEVULTRIUM_ORE_PLACED_KEY = registerKey("nether_bevultrium_ore_placed");
    public static final RegistryKey<PlacedFeature> END_BEVULTRIUM_ORE_PLACED_KEY = registerKey("end_bevultrium_ore_placed");

    public static final RegistryKey<PlacedFeature> DISEASED_PLACED_KEY = registerKey("diseased_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // datagen for worldgen doesn't work, I've concluded it's the datagen program and not my code.

        //register(context, BEVULTRIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BEVULTRIUM_ORE_KEY),
        //        ModOrePlacement.modifiersWithCount(14,
        //                HeightRangePlacementModifier.trapezoid(YOffset.fixed(-120), YOffset.fixed(120))));
        //register(context, NETHER_BEVULTRIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_BEVULTRIUM_ORE_KEY),
        //        ModOrePlacement.modifiersWithCount(10,
        //                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(128))));
        //register(context, END_BEVULTRIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_BEVULTRIUM_ORE_KEY),
        //        ModOrePlacement.modifiersWithCount(14,
        //                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(256))));

                                //this gives an error, but it wouldn't have done anything anyway so... oh well!
        //register(context, DISEASED_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DISEASED_KEY),
        //        VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
        //                PlacedFeatures.createCountExtraModifier(0, 0.2f, 1), ModBlocks.DISEASED_SAPLING));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(TutorialMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                    RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context,
                RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                PlacementModifier... modifiers) {register(context, key, configuration, List.of(modifiers));
    }
}