package net.bagelvulture.tutorialmod.datagen.custom;

import net.bagelvulture.tutorialmod.recipe.PinkRecipe;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

// usage:
//PinkRecipeJsonBuilder.create(
//                RecipeCategory.MISC,
//                Items.OUTPUT, 2,
//                Ingredient.ofItems(Items.INPUT), 7,
//                200                                                          // pinking time (in ticks)
//        ).criterion((hasItem(Items.INPUT), conditionsFromItem(Items.INPUT))
//        .offerTo(exporter, Identifier.of("tutorialmod", "output"));


public class PinkRecipeJsonBuilder {
    private final RecipeCategory category;
    private final Ingredient input;
    private final int inputCount;
    private final int outputCount;
    private final ItemStack output;
    private final int pinkingTime;  // NEW
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    private PinkRecipeJsonBuilder(RecipeCategory category, ItemConvertible outputItem, int outputCount, Ingredient input, int inputCount, int pinkingTime) {
        this.category = category;
        this.input = input;
        this.inputCount = inputCount;
        this.outputCount = outputCount;
        this.output = new ItemStack(outputItem, outputCount);
        this.pinkingTime = pinkingTime;
    }

    public static PinkRecipeJsonBuilder create(RecipeCategory category, ItemConvertible outputItem, int outputCount, Ingredient input, int inputCount, int pinkingTime) {
        return new PinkRecipeJsonBuilder(category, outputItem, outputCount, input, inputCount, pinkingTime);
    }

    public PinkRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        criteria.put(name, criterion);
        return this;
    }

    public PinkRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        if (criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }

        // Append "_from_pink" suffix
        String path = recipeId.getPath();
        if (!path.endsWith("_from_pink")) path += "_from_pink";
        Identifier id = Identifier.of(recipeId.getNamespace(), path);

        // Advancement
        Advancement.Builder advBuilder = exporter.getAdvancementBuilder()
                .criterion("has_the_recipe", RecipeUnlockedCriterion.create(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR);

        criteria.forEach(advBuilder::criterion);

        // Create PinkRecipe instance
        PinkRecipe recipe = new PinkRecipe(input, inputCount, output, pinkingTime);

        // Export recipe
        exporter.accept(id, recipe, advBuilder.build(id.withPrefixedPath("recipes/" + category.getName() + "/")));
    }
}