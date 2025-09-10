package net.bagelvulture.tutorialmod.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.recipe.PinkRecipe;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PinkRecipeCategory implements IRecipeCategory<PinkRecipe> {
    public static final Identifier UID = Identifier.of(TutorialMod.MOD_ID, "pink");

    public static final mezz.jei.api.recipe.RecipeType<PinkRecipe> JEI_PINK_TYPE =
            new mezz.jei.api.recipe.RecipeType<>(PinkRecipeCategory.UID, PinkRecipe.class);

    private final IDrawable icon;
    private final Identifier background = Identifier.of(TutorialMod.MOD_ID, "textures/gui/pink/pink_emi_bg.png");
    private final Identifier arrow = Identifier.of(TutorialMod.MOD_ID, "textures/gui/pink/pink_arrow.png");

    public PinkRecipeCategory(IGuiHelper helper) {
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.PINK));
    }

    @Override
    public int getWidth() {
        return 84;
    }

    @Override
    public int getHeight() {
        return 36;
    }

    @Override
    public @NotNull mezz.jei.api.recipe.RecipeType<PinkRecipe> getRecipeType() {
        return JEI_PINK_TYPE;
    }

    @Override
    public @NotNull Text getTitle() {
        return Text.translatable("block.tutorialmod.pink");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PinkRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 10, 10)
                .addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 58, 10)
                .addItemStack(recipe.getResult(null));
    }

    @Override
    public void draw(PinkRecipe recipe, IRecipeSlotsView recipeSlotsView, DrawContext guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        guiGraphics.drawTexture(background, -4, -4, 92, 44, 0, 0, 92, 44, 92, 44);

        guiGraphics.drawText(MinecraftClient.getInstance().textRenderer, recipe.pinkingTime() / 20 + " Seconds",
                3, 29, 0x5a1551, false
        );

        guiGraphics.drawTexture(arrow, 30, 11, 24, 16, 0, 0, 24, 16, 24, 16);
    }
}