package net.bagelvulture.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BEVULTRIUM_BLOCK);
        addDrop(ModBlocks.RAW_BEVULTRIUM_BLOCK);
        addDrop(ModBlocks.CRUDE_ALCHEMY_TRANSFORMER);

        addDrop(ModBlocks.BEVULTRIUM_ORE, oreDrops(ModBlocks.BEVULTRIUM_ORE, ModItems.RAW_BEVULTRIUM));
        addDrop(ModBlocks.BEVULTRIUM_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.BEVULTRIUM_DEEPSLATE_ORE, ModItems.RAW_BEVULTRIUM, 2, 3));

        addDrop(ModBlocks.BEVULTRIUM_STAIRS);
        addDrop(ModBlocks.BEVULTRIUM_SLAB, slabDrops(ModBlocks.BEVULTRIUM_SLAB));

        addDrop(ModBlocks.BEVULTRIUM_BUTTON);
        addDrop(ModBlocks.BEVULTRIUM_PRESSURE_PLATE);

        addDrop(ModBlocks.BEVULTRIUM_WALL);
        addDrop(ModBlocks.BEVULTRIUM_FENCE);
        addDrop(ModBlocks.BEVULTRIUM_FENCE_GATE);

        addDrop(ModBlocks.BEVULTRIUM_DOOR, doorDrops(ModBlocks.BEVULTRIUM_DOOR));
        addDrop(ModBlocks.BEVULTRIUM_TRAPDOOR);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}