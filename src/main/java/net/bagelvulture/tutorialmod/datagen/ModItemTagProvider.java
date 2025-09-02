package net.bagelvulture.tutorialmod.datagen;

import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.bagelvulture.tutorialmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookup) {
        super(output, lookup, new ModBlockTagProvider(output, lookup));
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.BEVULTRIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.BEVULTRIUM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.BEVULTRIUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BEVULTRIUM_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.BEVULTRIUM_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BEVULTRIUM_HELMET)
                .add(ModItems.BEVULTRIUM_CHESTPLATE)
                .add(ModItems.BEVULTRIUM_LEGGINGS)
                .add(ModItems.BEVULTRIUM_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.BEVULTRIUM);

        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.BEVULTURE_SMITHING_TEMPLATE);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.DISEASED_LOG.asItem())
                .add(ModBlocks.DISEASED_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DISEASED_LOG.asItem())
                .add(ModBlocks.STRIPPED_DISEASED_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.DISEASED_PLANKS.asItem());

        getOrCreateTagBuilder(ModTags.Items.DISEASED_LOGS)
                .add(ModBlocks.DISEASED_LOG.asItem())
                .add(ModBlocks.DISEASED_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DISEASED_LOG.asItem())
                .add(ModBlocks.STRIPPED_DISEASED_WOOD.asItem());
    }
}