package net.bagelvulture.tutorialmod.util;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.component.ModDataComponentTypes;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.HAND_SMELTER, Identifier.of(TutorialMod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f);

        registerCustomBow(ModItems.OTHER_BOW);
    }

    private static void registerCustomBow(Item item) {
        ModelPredicateProviderRegistry.register(item, Identifier.ofVanilla("pull"), (stack,
                  world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime(entity) -
                        entity.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(
                item,
                Identifier.ofVanilla("pulling"),
                (stack, world, entity, seed) -> entity != null &&
                        entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );

    }
}