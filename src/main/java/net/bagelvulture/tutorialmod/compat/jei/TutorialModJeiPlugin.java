package net.bagelvulture.tutorialmod.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.recipe.ModRecipes;
import net.bagelvulture.tutorialmod.screen.custom.PinkScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import static net.bagelvulture.tutorialmod.compat.jei.PinkRecipeCategory.JEI_PINK_TYPE;

@JeiPlugin
public class TutorialModJeiPlugin implements IModPlugin {
    @Override
    public @NotNull Identifier getPluginUid() {
        return Identifier.of(TutorialMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new PinkRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        assert MinecraftClient.getInstance()
                .world != null;

        RecipeManager recipeManager = MinecraftClient.getInstance()
                .world.getRecipeManager();

        registration.addRecipes(
                JEI_PINK_TYPE,
                recipeManager.listAllOfType(ModRecipes.PINK_TYPE)
                        .stream()
                        .map(RecipeEntry::value)
                        .toList()
        );
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(PinkScreen.class, 70, 30, 25, 20, JEI_PINK_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.PINK), JEI_PINK_TYPE);
    }
}