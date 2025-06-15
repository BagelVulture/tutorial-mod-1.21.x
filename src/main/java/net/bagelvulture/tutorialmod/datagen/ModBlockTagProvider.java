package net.bagelvulture.tutorialmod.datagen;

import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BEVULTRIUM_BLOCK)
                .add(ModBlocks.RAW_BEVULTRIUM_BLOCK)
                .add(ModBlocks.BEVULTRIUM_ORE)
                .add(ModBlocks.BEVULTRIUM_DEEPSLATE_ORE)
                .add(ModBlocks.CRUDE_ALCHEMY_TRANSFORMER)
                .add(ModBlocks.BEVULTRIUM_SLAB)
                .add(ModBlocks.BEVULTRIUM_STAIRS)
                .add(ModBlocks.BEVULTRIUM_BUTTON)
                .add(ModBlocks.BEVULTRIUM_PRESSURE_PLATE)
                .add(ModBlocks.BEVULTRIUM_DOOR)
                .add(ModBlocks.BEVULTRIUM_TRAPDOOR)
                .add(ModBlocks.BEVULTRIUM_FENCE)
                .add(ModBlocks.BEVULTRIUM_FENCE_GATE)
                .add(ModBlocks.BEVULTRIUM_WALL)
                .add(ModBlocks.BEVULTRIUM_LAMP);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_BEVULTRIUM_BLOCK)
                .add(ModBlocks.BEVULTRIUM_ORE)
                .add(ModBlocks.BEVULTRIUM_DEEPSLATE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.BEVULTRIUM_BLOCK)
                .add(ModBlocks.CRUDE_ALCHEMY_TRANSFORMER)
                .add(ModBlocks.BEVULTRIUM_SLAB)
                .add(ModBlocks.BEVULTRIUM_STAIRS)
                .add(ModBlocks.BEVULTRIUM_BUTTON)
                .add(ModBlocks.BEVULTRIUM_PRESSURE_PLATE)
                .add(ModBlocks.BEVULTRIUM_DOOR)
                .add(ModBlocks.BEVULTRIUM_TRAPDOOR)
                .add(ModBlocks.BEVULTRIUM_FENCE)
                .add(ModBlocks.BEVULTRIUM_FENCE_GATE)
                .add(ModBlocks.BEVULTRIUM_WALL)
                .add(ModBlocks.BEVULTRIUM_LAMP);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.BEVULTRIUM_FENCE);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.BEVULTRIUM_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.BEVULTRIUM_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.BEVULTRIUM_WALL);
    }
}