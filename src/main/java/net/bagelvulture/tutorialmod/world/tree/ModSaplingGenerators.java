package net.bagelvulture.tutorialmod.world.tree;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator DISEASED = new SaplingGenerator(TutorialMod.MOD_ID + ":diseased",
            Optional.empty(), Optional.of(ModConfiguredFeatures.DISEASED_KEY), Optional.empty());
}