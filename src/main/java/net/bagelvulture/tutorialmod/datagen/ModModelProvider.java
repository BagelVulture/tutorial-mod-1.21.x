package net.bagelvulture.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BEVULTRIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BEVULTRIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BEVULTRIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BEVULTRIUM_DEEPSLATE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRUDE_ALCHEMY_TRANSFORMER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BEVULTRIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BEVULTRIUM, Models.GENERATED);

        itemModelGenerator.register(ModItems.FRIED_BEVULTRIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.HAND_SMELTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.FERTILE_BEVULTRIUM, Models.GENERATED);
    }
}