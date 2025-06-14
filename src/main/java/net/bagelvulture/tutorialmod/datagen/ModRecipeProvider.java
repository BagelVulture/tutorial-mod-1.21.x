package net.bagelvulture.tutorialmod.datagen;

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

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> BEVULTRIUM_SMELTABLES = List.of(ModItems.RAW_BEVULTRIUM, ModBlocks.BEVULTRIUM_ORE,
                ModBlocks.BEVULTRIUM_DEEPSLATE_ORE);

        offerSmelting(exporter, BEVULTRIUM_SMELTABLES, RecipeCategory.MISC, ModItems.BEVULTRIUM, 0.20f, 200, "BEVULTRIUM");
        offerBlasting(exporter, BEVULTRIUM_SMELTABLES, RecipeCategory.MISC, ModItems.BEVULTRIUM, 0.20f, 100, "BEVULTRIUM");

        //smoking recipes manually added to generated folder

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BEVULTRIUM, RecipeCategory.MISC, ModBlocks.BEVULTRIUM_BLOCK);
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


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FERTILE_BEVULTRIUM, 9)
                .input(ModBlocks.RAW_BEVULTRIUM_BLOCK)
                .input(Items.WHEAT_SEEDS)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter);
    }
}