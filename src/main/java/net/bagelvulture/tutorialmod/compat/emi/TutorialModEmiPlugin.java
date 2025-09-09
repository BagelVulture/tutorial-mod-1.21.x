package net.bagelvulture.tutorialmod.compat.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.widget.WidgetHolder;

import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.recipe.ModRecipes;
import net.bagelvulture.tutorialmod.recipe.PinkRecipe;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;

import java.util.List;

public class TutorialModEmiPlugin implements EmiPlugin {

    public static final EmiStack WORKSTATION = EmiStack.of(ModBlocks.PINK);

    // recipe category id: tutorial-mod:pink_crafting
    public static final EmiRecipeCategory PINK_CATEGORY =
            new EmiRecipeCategory(
                    Identifier.of("tutorialmod", "pink_crafting"),
                    TutorialModEmiPlugin.WORKSTATION
            );

    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(PINK_CATEGORY);
        registry.addWorkstation(PINK_CATEGORY, WORKSTATION);

        /*
         * Get the RecipeManager and iterate through the entries for your custom recipe type.
         * RecipeManager.listAllOfType returns iterable/collection of RecipeEntry<PinkRecipe>.
         * We create an EMI wrapper for each entry so we can access the recipe id (from the entry).
         */
        RecipeManager manager = registry.getRecipeManager();
        List<RecipeEntry<PinkRecipe>> entries = manager.listAllOfType(ModRecipes.PINK_TYPE).stream().toList();

        for (RecipeEntry<PinkRecipe> entry : entries) {
            registry.addRecipe(new EmiPinkRecipe(entry));
        }
    }

    //EMI wrapper for a PinkRecipe. Keeps the RecipeEntry so we can use the real recipe id for EMI.
    public static class EmiPinkRecipe extends BasicEmiRecipe {
        private final RecipeEntry<PinkRecipe> entry;
        private final PinkRecipe recipe;

        public EmiPinkRecipe(RecipeEntry<PinkRecipe> entry) {
            super(PINK_CATEGORY, entry.id(), 84, 36); // ints are size of background
            this.entry = entry;
            this.recipe = entry.value();

            // Input: wrap the ingredient itself with input count
            EmiIngredient input = EmiIngredient.of(recipe.inputItem(), recipe.inputCount());
            this.inputs.add(input);

            this.outputs.add(EmiStack.of(recipe.output()));
        }

        //custom textures for widgets
        private static final EmiTexture PINK_ARROW = new EmiTexture(Identifier.of("tutorialmod", "textures/gui/pink/pink_arrow.png"), 0, 0, 24, 16, 24, 16, 24, 16);
        private static final EmiTexture PINK_BG = new EmiTexture(Identifier.of("tutorialmod", "textures/gui/pink/pink_emi_bg.png"), 0, 0, 92, 44, 92, 44, 92, 44);

        @Override
        public void addWidgets(WidgetHolder widgets) {
            widgets.addText(Text.of(recipe.pinkingTime() / 10 + " Seconds"), 2, 28, 0x5a1551, false);

            widgets.addTexture(PINK_BG, -4, -4);
            widgets.addAnimatedTexture(PINK_ARROW, 30, 11, recipe.pinkingTime() * 100, true, false, false);

            widgets.addSlot(inputs.get(0), 9, 9).drawBack(false);
            // Note that output slots need to call `recipeContext` to inform EMI about their recipe context
            // This includes being able to resolve recipe trees, favorite stacks with recipe context, and more
            widgets.addSlot(outputs.get(0), 57, 9).recipeContext(this).drawBack(false);
        }
    }
}