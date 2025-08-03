package net.bagelvulture.tutorialmod.effect;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> IMAPLANT = registerStatusEffect("imaplant",
            new ImAPlantEffect(StatusEffectCategory.BENEFICIAL, 0x5BCD00));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(TutorialMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        TutorialMod.LOGGER.info("Registering " + TutorialMod.MOD_ID + "'s Mod Effects");
    }
}