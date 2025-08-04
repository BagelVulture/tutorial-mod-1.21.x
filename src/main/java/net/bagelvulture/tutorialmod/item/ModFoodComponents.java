package net.bagelvulture.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent FRIED_BEVULTRIUM = new FoodComponent.Builder().nutrition(5).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 2000, 20), 0.005f)
            .snack().build();

    public static final FoodComponent BRIGHT_BERRY = new FoodComponent.Builder().nutrition(10).saturationModifier(0.0f)
            .snack().build();
}