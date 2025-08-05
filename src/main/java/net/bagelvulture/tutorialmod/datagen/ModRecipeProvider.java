package net.bagelvulture.tutorialmod.datagen;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.bagelvulture.tutorialmod.block.ModBlocks.*;
import static net.bagelvulture.tutorialmod.item.ModItems.*;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> BEVULTRIUM_SMELTABLES = List.of(ModItems.RAW_BEVULTRIUM, BEVULTRIUM_ORE,
                BEVULTRIUM_DEEPSLATE_ORE, BEVULTRIUM_END_ORE, BEVULTRIUM_NETHER_ORE);

        offerSmelting(exporter, BEVULTRIUM_SMELTABLES, RecipeCategory.MISC, BEVULTRIUM, 0.20f, 200, "BEVULTRIUM");
        offerBlasting(exporter, BEVULTRIUM_SMELTABLES, RecipeCategory.MISC, BEVULTRIUM, 0.20f, 100, "BEVULTRIUM");

        //smoking recipes manually added to generated folder

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, BEVULTRIUM, RecipeCategory.MISC, ModBlocks.BEVULTRIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_BEVULTRIUM, RecipeCategory.MISC, ModBlocks.RAW_BEVULTRIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HAND_SMELTER)
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .input('A', Items.FURNACE)
                .input('B', Items.COAL_BLOCK)
                .input('C', Items.BLAZE_ROD)
                .criterion(hasItem(Items.FURNACE), conditionsFromItem(Items.FURNACE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_LAMP)
                .pattern(" B ")
                .pattern("BCB")
                .pattern(" B ")
                .input('B', Items.REDSTONE)
                .input('C', ModBlocks.BEVULTRIUM_BLOCK)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CRUDE_ALCHEMY_TRANSFORMER)
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GHI")
                .input('A', Items.EXPERIENCE_BOTTLE)
                .input('B', Items.ENCHANTED_GOLDEN_APPLE)
                .input('C', Items.NETHER_STAR)
                .input('D', Items.LAPIS_LAZULI)
                .input('E', Items.GLOW_INK_SAC)
                .input('F', Items.HEART_OF_THE_SEA)
                .input('G', Items.ECHO_SHARD)
                .input('H', Items.TOTEM_OF_UNDYING)
                .input('I', Items.BLAZE_ROD)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_PICKAXE)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .input('B', Items.STICK)
                .input('A', BEVULTRIUM)
                .criterion(hasItem(ModItems.BEVULTRIUM), conditionsFromItem(ModItems.BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_AXE)
                .pattern("AA")
                .pattern("BA")
                .pattern("B ")
                .input('B', Items.STICK)
                .input('A', BEVULTRIUM)
                .criterion(hasItem(ModItems.BEVULTRIUM), conditionsFromItem(ModItems.BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_SHOVEL)
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .input('B', Items.STICK)
                .input('A', BEVULTRIUM)
                .criterion(hasItem(ModItems.BEVULTRIUM), conditionsFromItem(ModItems.BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_HOE)
                .pattern("AA")
                .pattern("B ")
                .pattern("B ")
                .input('B', Items.STICK)
                .input('A', BEVULTRIUM)
                .criterion(hasItem(ModItems.BEVULTRIUM), conditionsFromItem(ModItems.BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_SWORD)
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .input('B', Items.STICK)
                .input('A', BEVULTRIUM)
                .criterion(hasItem(ModItems.BEVULTRIUM), conditionsFromItem(ModItems.BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_HAMMER)
                .pattern(" B ")
                .pattern(" AB")
                .pattern("A  ")
                .input('A', Items.STICK)
                .input('B', BEVULTRIUM)
                .criterion(hasItem(ModItems.BEVULTRIUM), conditionsFromItem(ModItems.BEVULTRIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, OTHER_BOW)
                .pattern(" AB")
                .pattern("C B")
                .pattern(" AB")
                .input('A', BEVULTRIUM)
                .input('B', Items.STRING)
                .input('C', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.BOW), conditionsFromItem(Items.BOW))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FERTILE_BEVULTRIUM, 9)
                .input(ModBlocks.RAW_BEVULTRIUM_BLOCK)
                .input(Items.WHEAT_SEEDS)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .input('B', BEVULTRIUM)
                .criterion(hasItem(ModItems.BEVULTRIUM), conditionsFromItem(ModItems.BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', BEVULTRIUM)
                .criterion(hasItem(ModItems.BEVULTRIUM), conditionsFromItem(ModItems.BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', BEVULTRIUM)
                .criterion(hasItem(ModItems.BEVULTRIUM), conditionsFromItem(ModItems.BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_BOOTS)
                .pattern("B B")
                .pattern("B B")
                .input('B', BEVULTRIUM)
                .criterion(hasItem(ModItems.BEVULTRIUM), conditionsFromItem(ModItems.BEVULTRIUM))
                .offerTo(exporter);

        offerSmithingTemplateCopyingRecipe(exporter, BEVULTURE_SMITHING_TEMPLATE, BEVULTRIUM_BLOCK);
        offerSmithingTrimRecipe(exporter, BEVULTURE_SMITHING_TEMPLATE, Identifier.of(TutorialMod.MOD_ID, "bevulture"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BEVULTRIUM_SLAB, 6).input('#', BEVULTRIUM).pattern("###");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BEVULTRIUM_STAIRS, 4).input('#', BEVULTRIUM).pattern("#  ").pattern("## ").pattern("###");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_BUTTON, 1).input(BEVULTRIUM).criterion(hasItem(ModItems.BEVULTRIUM), conditionsFromItem(ModItems.BEVULTRIUM)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BEVULTRIUM_PRESSURE_PLATE).input('#', BEVULTRIUM).pattern("##");
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BEVULTRIUM_DOOR, 3).input('#', BEVULTRIUM).pattern("##").pattern("##").pattern("##");
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BEVULTRIUM_TRAPDOOR, 2).input('#', BEVULTRIUM).pattern("###").pattern("###");
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BEVULTRIUM_FENCE, 3).input('W', BEVULTRIUM).input('#', Items.STICK).pattern("W#W").pattern("W#W");
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BEVULTRIUM_FENCE_GATE).input('#', Items.STICK).input('W', BEVULTRIUM).pattern("#W#").pattern("#W#");
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BEVULTRIUM_WALL, 6).input('#', BEVULTRIUM).pattern("###").pattern("###");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, DISEASED_WOOD, 3).input('#', DISEASED_LOG).pattern("##").pattern("##");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, STRIPPED_DISEASED_WOOD, 3).input('#', STRIPPED_DISEASED_LOG).pattern("##").pattern("##");
    }
}