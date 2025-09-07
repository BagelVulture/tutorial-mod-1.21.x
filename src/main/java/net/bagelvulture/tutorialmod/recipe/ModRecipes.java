package net.bagelvulture.tutorialmod.recipe;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<PinkRecipe> PINK_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(TutorialMod.MOD_ID, "pink"),
            new PinkRecipe.Serializer());
    public static final RecipeType<PinkRecipe> PINK_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(TutorialMod.MOD_ID, "pink"), new RecipeType<PinkRecipe>() {
                @Override
                public String toString() {
                    return "pink";
                }
            });

    public static void registerRecipes() {
        TutorialMod.LOGGER.info("Registering " + TutorialMod.MOD_ID + "'s Custom Recipes");
    }
}