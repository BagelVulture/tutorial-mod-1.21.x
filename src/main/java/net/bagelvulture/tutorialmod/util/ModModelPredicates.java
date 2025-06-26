package net.bagelvulture.tutorialmod.util;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.component.ModDataComponentTypes;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.HAND_SMELTER, Identifier.of(TutorialMod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f);

    }
}