package net.bagelvulture.tutorialmod.compat.rei;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.recipe.PinkRecipe;
import net.bagelvulture.tutorialmod.recipe.ModRecipes;
import net.bagelvulture.tutorialmod.screen.custom.PinkScreen;

public class TutorialModReiClient implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new PinkCategory());

        registry.addWorkstations(PinkCategory.PINK, EntryStacks.of(ModBlocks.PINK));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(PinkRecipe.class, ModRecipes.PINK_TYPE,
                PinkDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25), PinkScreen.class,
                PinkCategory.PINK);
    }
}