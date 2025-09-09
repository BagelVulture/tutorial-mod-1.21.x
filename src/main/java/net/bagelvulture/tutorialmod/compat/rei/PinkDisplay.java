package net.bagelvulture.tutorialmod.compat.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.bagelvulture.tutorialmod.recipe.PinkRecipe;
import net.minecraft.recipe.RecipeEntry;

import java.util.List;

public class PinkDisplay extends BasicDisplay {
    private final PinkRecipe recipe;

    public PinkDisplay(RecipeEntry<PinkRecipe> recipeEntry) {
        super(
                List.of(EntryIngredients.ofIngredient(recipeEntry.value().inputItem())),
                List.of(EntryIngredients.of(recipeEntry.value().getResult(null)))
        );
        this.recipe = recipeEntry.value();
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return PinkCategory.PINK;
    }

    public int getPinkingTime() {
        return recipe.pinkingTime();
    }
}