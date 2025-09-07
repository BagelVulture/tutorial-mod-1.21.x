package net.bagelvulture.tutorialmod.datagen;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.datagen.custom.PinkRecipeJsonBuilder;
import net.bagelvulture.tutorialmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
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
        List<ItemConvertible> WOOLS = List.of(Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL, Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.GRAY_WOOL, Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.GREEN_WOOL, Blocks.RED_WOOL, Blocks.BLACK_WOOL);
        List<ItemConvertible> CARPETS = List.of(Blocks.WHITE_CARPET, Blocks.ORANGE_CARPET, Blocks.MAGENTA_CARPET, Blocks.LIGHT_BLUE_CARPET, Blocks.YELLOW_CARPET, Blocks.LIME_CARPET, Blocks.GRAY_CARPET, Blocks.LIGHT_GRAY_CARPET, Blocks.CYAN_CARPET, Blocks.PURPLE_CARPET, Blocks.BLUE_CARPET, Blocks.BROWN_CARPET, Blocks.GREEN_CARPET, Blocks.RED_CARPET, Blocks.BLACK_CARPET);
        List<ItemConvertible> BEDS = List.of(Blocks.WHITE_BED, Blocks.ORANGE_BED, Blocks.MAGENTA_BED, Blocks.LIGHT_BLUE_BED, Blocks.YELLOW_BED, Blocks.LIME_BED, Blocks.GRAY_BED, Blocks.LIGHT_GRAY_BED, Blocks.CYAN_BED, Blocks.PURPLE_BED, Blocks.BLUE_BED, Blocks.BROWN_BED, Blocks.GREEN_BED, Blocks.RED_BED, Blocks.BLACK_BED);
        List<ItemConvertible> TERRACOTTAS = List.of(Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.BLACK_TERRACOTTA);
        List<ItemConvertible> GLAZED_TERRACOTTAS = List.of(Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA);
        List<ItemConvertible> CONCRETES = List.of(Blocks.WHITE_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.YELLOW_CONCRETE, Blocks.LIME_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.RED_CONCRETE, Blocks.BLACK_CONCRETE);
        List<ItemConvertible> STAINED_GLASS = List.of(Blocks.WHITE_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS, Blocks.MAGENTA_STAINED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.YELLOW_STAINED_GLASS, Blocks.LIME_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS, Blocks.CYAN_STAINED_GLASS, Blocks.PURPLE_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS, Blocks.GREEN_STAINED_GLASS, Blocks.RED_STAINED_GLASS, Blocks.BLACK_STAINED_GLASS);
        List<ItemConvertible> STAINED_GLASS_PANES = List.of(Blocks.WHITE_STAINED_GLASS_PANE, Blocks.ORANGE_STAINED_GLASS_PANE, Blocks.MAGENTA_STAINED_GLASS_PANE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, Blocks.YELLOW_STAINED_GLASS_PANE, Blocks.LIME_STAINED_GLASS_PANE, Blocks.GRAY_STAINED_GLASS_PANE, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, Blocks.CYAN_STAINED_GLASS_PANE, Blocks.PURPLE_STAINED_GLASS_PANE, Blocks.BLUE_STAINED_GLASS_PANE, Blocks.BROWN_STAINED_GLASS_PANE, Blocks.GREEN_STAINED_GLASS_PANE, Blocks.RED_STAINED_GLASS_PANE, Blocks.BLACK_STAINED_GLASS_PANE);
        List<ItemConvertible> SHULKER_BOXES = List.of(Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX);
        List<ItemConvertible> CONCRETE_POWDERS = List.of(Blocks.WHITE_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER);

        record PinkRecipeData(ItemConvertible result, int pinkingTime) {}

        offerSmelting(exporter, BEVULTRIUM_SMELTABLES, RecipeCategory.MISC, BEVULTRIUM, 0.20f, 200, "BEVULTRIUM");
        offerBlasting(exporter, BEVULTRIUM_SMELTABLES, RecipeCategory.MISC, BEVULTRIUM, 0.20f, 100, "BEVULTRIUM");

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

        chairRecipeBuilder(exporter, Items.OAK_PLANKS, OAK_CHAIR);
        chairRecipeBuilder(exporter, Items.SPRUCE_PLANKS, SPRUCE_CHAIR);
        chairRecipeBuilder(exporter, Items.BIRCH_PLANKS, BIRCH_CHAIR);
        chairRecipeBuilder(exporter, Items.JUNGLE_PLANKS, JUNGLE_CHAIR);
        chairRecipeBuilder(exporter, Items.ACACIA_PLANKS, ACACIA_CHAIR);
        chairRecipeBuilder(exporter, Items.DARK_OAK_PLANKS, DARK_OAK_CHAIR);
        chairRecipeBuilder(exporter, Items.MANGROVE_PLANKS, MANGROVE_CHAIR);
        chairRecipeBuilder(exporter, Items.CHERRY_PLANKS, CHERRY_CHAIR);
        chairRecipeBuilder(exporter, Items.BAMBOO_PLANKS, BAMBOO_CHAIR);
        chairRecipeBuilder(exporter, Items.CRIMSON_PLANKS, CRIMSON_CHAIR);
        chairRecipeBuilder(exporter, Items.WARPED_PLANKS, WARPED_CHAIR);
        chairRecipeBuilder(exporter, DISEASED_PLANKS, DISEASED_CHAIR);

        PinkRecipeJsonBuilder.create(
                        RecipeCategory.MISC,
                        DISEASED_APPLE, 7,
                        Ingredient.ofItems(Items.APPLE), 2,
                        200
                ).criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .offerTo(exporter, Identifier.of("tutorialmod", "diseased_apple"));

        for (Map.Entry<List<ItemConvertible>, PinkRecipeData> entry : Map.of(
                WOOLS, new PinkRecipeData(Items.PINK_WOOL, 20),
                CARPETS, new PinkRecipeData(Items.PINK_CARPET, 10),
                BEDS, new PinkRecipeData(Items.PINK_BED, 40),
                TERRACOTTAS, new PinkRecipeData(Blocks.PINK_TERRACOTTA, 100),
                GLAZED_TERRACOTTAS, new PinkRecipeData(Blocks.PINK_GLAZED_TERRACOTTA, 200),
                CONCRETES, new PinkRecipeData(Blocks.PINK_CONCRETE, 120),
                STAINED_GLASS, new PinkRecipeData(Blocks.PINK_STAINED_GLASS, 80),
                STAINED_GLASS_PANES, new PinkRecipeData(Blocks.PINK_STAINED_GLASS_PANE, 60),
                SHULKER_BOXES, new PinkRecipeData(Blocks.PINK_SHULKER_BOX, 40),
                CONCRETE_POWDERS, new PinkRecipeData(Blocks.PINK_CONCRETE_POWDER, 40)
        ).entrySet()) {
            List<ItemConvertible> sources = entry.getKey();
            PinkRecipeData data = entry.getValue();

            for (ItemConvertible source : sources) {
                PinkRecipeJsonBuilder.create(
                                RecipeCategory.MISC,
                                data.result(), 1,
                                Ingredient.ofItems(source), 1,
                                data.pinkingTime()
                        ).criterion(hasItem(source), conditionsFromItem(source))
                        .offerTo(exporter, Identifier.of("tutorialmod", Registries.ITEM.getId(data.result().asItem()).getPath() + "_" + Registries.ITEM.getId(source.asItem()).getPath()));
            }
        }
    }
    public static void chairRecipeBuilder(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 2)
                .pattern("A  ")
                .pattern("AAA")
                .pattern("A A")
                .input('A', input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
}