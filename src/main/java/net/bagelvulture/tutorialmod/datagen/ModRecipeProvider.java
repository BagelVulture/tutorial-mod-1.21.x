package net.bagelvulture.tutorialmod.datagen;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
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
        List<ItemConvertible> BEVULTRIUM_SMELTABLES = List.of(RAW_BEVULTRIUM, BEVULTRIUM_ORE,
                BEVULTRIUM_DEEPSLATE_ORE, BEVULTRIUM_END_ORE, BEVULTRIUM_NETHER_ORE);

        offerSmelting(exporter, BEVULTRIUM_SMELTABLES, RecipeCategory.MISC, BEVULTRIUM, 0.20f, 200, "BEVULTRIUM");
        offerBlasting(exporter, BEVULTRIUM_SMELTABLES, RecipeCategory.MISC, BEVULTRIUM, 0.20f, 100, "BEVULTRIUM");

        //smoking recipes manually added to generated folder

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, BEVULTRIUM, RecipeCategory.MISC, BEVULTRIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, RAW_BEVULTRIUM, RecipeCategory.MISC, RAW_BEVULTRIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, HAND_SMELTER)
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
                .input('C', BEVULTRIUM_BLOCK)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, CRUDE_ALCHEMY_TRANSFORMER)
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, BEVULTRIUM_PICKAXE)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .input('B', Items.STICK)
                .input('A', BEVULTRIUM)
                .criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, BEVULTRIUM_AXE)
                .pattern("AA")
                .pattern("BA")
                .pattern("B ")
                .input('B', Items.STICK)
                .input('A', BEVULTRIUM)
                .criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, BEVULTRIUM_SHOVEL)
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .input('B', Items.STICK)
                .input('A', BEVULTRIUM)
                .criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, BEVULTRIUM_HOE)
                .pattern("AA")
                .pattern("B ")
                .pattern("B ")
                .input('B', Items.STICK)
                .input('A', BEVULTRIUM)
                .criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, BEVULTRIUM_SWORD)
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .input('B', Items.STICK)
                .input('A', BEVULTRIUM)
                .criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_HAMMER)
                .pattern(" B ")
                .pattern(" AB")
                .pattern("A  ")
                .input('A', Items.STICK)
                .input('B', BEVULTRIUM)
                .criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, OTHER_BOW)
                .pattern(" AB")
                .pattern("C B")
                .pattern(" AB")
                .input('A', BEVULTRIUM)
                .input('B', Items.STRING)
                .input('C', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.BOW), conditionsFromItem(Items.BOW))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, FERTILE_BEVULTRIUM, 9)
                .input(RAW_BEVULTRIUM_BLOCK)
                .input(Items.WHEAT_SEEDS)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, BEVULTRIUM_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .input('B', BEVULTRIUM)
                .criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, BEVULTRIUM_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', BEVULTRIUM)
                .criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, BEVULTRIUM_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', BEVULTRIUM)
                .criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, BEVULTRIUM_BOOTS)
                .pattern("B B")
                .pattern("B B")
                .input('B', BEVULTRIUM)
                .criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM))
                .offerTo(exporter);

        offerSmithingTemplateCopyingRecipe(exporter, BEVULTURE_SMITHING_TEMPLATE, BEVULTRIUM_BLOCK);
        offerSmithingTrimRecipe(exporter, BEVULTURE_SMITHING_TEMPLATE, Identifier.of(TutorialMod.MOD_ID, "bevulture"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BEVULTRIUM_SLAB, 6).input('#', BEVULTRIUM).pattern("###").criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BEVULTRIUM_STAIRS, 4).input('#', BEVULTRIUM).pattern("#  ").pattern("## ").pattern("###").criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, BEVULTRIUM_BUTTON, 1).input(BEVULTRIUM).criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BEVULTRIUM_PRESSURE_PLATE).input('#', BEVULTRIUM).pattern("##").criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BEVULTRIUM_DOOR, 3).input('#', BEVULTRIUM).pattern("##").pattern("##").pattern("##").criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BEVULTRIUM_TRAPDOOR, 2).input('#', BEVULTRIUM).pattern("###").pattern("###").criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BEVULTRIUM_FENCE, 3).input('W', BEVULTRIUM).input('#', Items.STICK).pattern("W#W").pattern("W#W").criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BEVULTRIUM_FENCE_GATE).input('#', Items.STICK).input('W', BEVULTRIUM).pattern("#W#").pattern("#W#").criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BEVULTRIUM_WALL, 6).input('#', BEVULTRIUM).pattern("###").pattern("###").criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, DISEASED_WOOD, 3).input('#', DISEASED_LOG).pattern("##").pattern("##");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, STRIPPED_DISEASED_WOOD, 3).input('#', STRIPPED_DISEASED_LOG).pattern("##").pattern("##");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, DISEASED_PLANKS, 4).input(ModTags.Items.DISEASED_LOGS).group("planks").criterion("has_logs", conditionsFromTag(ModTags.Items.DISEASED_LOGS)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, DISEASED_SLAB, 6).input('#', DISEASED_PLANKS).pattern("###").criterion(hasItem(DISEASED_PLANKS), conditionsFromItem(DISEASED_PLANKS)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, DISEASED_STAIRS, 4).input('#', DISEASED_PLANKS).pattern("#  ").pattern("## ").pattern("###").criterion(hasItem(DISEASED_PLANKS), conditionsFromItem(DISEASED_PLANKS)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, DISEASED_BUTTON, 1).input(DISEASED_PLANKS).criterion(hasItem(DISEASED_PLANKS), conditionsFromItem(DISEASED_PLANKS)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, DISEASED_PRESSURE_PLATE).input('#', DISEASED_PLANKS).pattern("##").criterion(hasItem(DISEASED_PLANKS), conditionsFromItem(DISEASED_PLANKS)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, DISEASED_TRAPDOOR, 2).input('#', DISEASED_PLANKS).pattern("###").pattern("###").criterion(hasItem(DISEASED_PLANKS), conditionsFromItem(DISEASED_PLANKS)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DISEASED_FENCE, 3).input('W', DISEASED_PLANKS).input('#', Items.STICK).pattern("W#W").pattern("W#W").criterion(hasItem(DISEASED_PLANKS), conditionsFromItem(DISEASED_PLANKS)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, DISEASED_FENCE_GATE).input('#', Items.STICK).input('W', DISEASED_PLANKS).pattern("#W#").pattern("#W#").criterion(hasItem(DISEASED_PLANKS), conditionsFromItem(DISEASED_PLANKS)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, SPEAR)
                .pattern(" AB")
                .pattern("AAA")
                .pattern("AA ")
                .input('B', Items.IRON_INGOT)
                .input('A', Items.STICK)
                .criterion(hasItem(BEVULTRIUM), conditionsFromItem(BEVULTRIUM))
                .offerTo(exporter);
    }
}