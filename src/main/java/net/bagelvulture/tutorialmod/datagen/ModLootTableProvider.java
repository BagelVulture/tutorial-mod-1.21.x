package net.bagelvulture.tutorialmod.datagen;

import net.bagelvulture.tutorialmod.block.custom.BrightBerryBushBlock;
import net.bagelvulture.tutorialmod.block.custom.FertileBevultriumCropBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.bagelvulture.tutorialmod.block.ModBlocks.*;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        addDrop(ModBlocks.BEVULTRIUM_BLOCK);
        addDrop(ModBlocks.RAW_BEVULTRIUM_BLOCK);
        addDrop(ModBlocks.CRUDE_ALCHEMY_TRANSFORMER);
        addDrop(ModBlocks.BEVULTRIUM_LAMP);

        addDrop(ModBlocks.BEVULTRIUM_ORE, oreDrops(ModBlocks.BEVULTRIUM_ORE, ModItems.RAW_BEVULTRIUM));
        addDrop(ModBlocks.BEVULTRIUM_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.BEVULTRIUM_DEEPSLATE_ORE,
                ModItems.RAW_BEVULTRIUM, 2, 3));
        addDrop(ModBlocks.BEVULTRIUM_NETHER_ORE, multipleOreDrops(ModBlocks.BEVULTRIUM_NETHER_ORE, ModItems.RAW_BEVULTRIUM, 1, 2));
        addDrop(ModBlocks.BEVULTRIUM_END_ORE, oreDrops(ModBlocks.BEVULTRIUM_END_ORE, ModItems.RAW_BEVULTRIUM));

        addDrop(ModBlocks.BEVULTRIUM_STAIRS);
        addDrop(ModBlocks.BEVULTRIUM_SLAB, slabDrops(ModBlocks.BEVULTRIUM_SLAB));

        addDrop(ModBlocks.BEVULTRIUM_BUTTON);
        addDrop(ModBlocks.BEVULTRIUM_PRESSURE_PLATE);

        addDrop(ModBlocks.BEVULTRIUM_WALL);
        addDrop(ModBlocks.BEVULTRIUM_FENCE);
        addDrop(ModBlocks.BEVULTRIUM_FENCE_GATE);

        addDrop(ModBlocks.BEVULTRIUM_DOOR, doorDrops(ModBlocks.BEVULTRIUM_DOOR));
        addDrop(ModBlocks.BEVULTRIUM_TRAPDOOR);

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition
                .builder(ModBlocks.FERTILE_BEVULTRIUM_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(FertileBevultriumCropBlock.AGE, FertileBevultriumCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.FERTILE_BEVULTRIUM_CROP, this.cropDrops(ModBlocks.FERTILE_BEVULTRIUM_CROP,
                ModItems.FRIED_BEVULTRIUM, ModItems.FERTILE_BEVULTRIUM, builder2));

        this.addDrop(ModBlocks.BRIGHT_BERRY_BUSH,
                block -> this.applyExplosionDecay(
                        block,LootTable.builder().pool(LootPool.builder().conditionally(
                        BlockStatePropertyLootCondition.builder(ModBlocks.BRIGHT_BERRY_BUSH)
                        .properties(StatePredicate.Builder.create().exactMatch(BrightBerryBushBlock.AGE, 3)))
                        .with(ItemEntry.builder(ModItems.BRIGHT_BERRIES)).apply(SetCountLootFunction
                        .builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))
                        .pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition
                        .builder(ModBlocks.BRIGHT_BERRY_BUSH).properties(StatePredicate.Builder.create()
                        .exactMatch(BrightBerryBushBlock.AGE, 2))).with(ItemEntry.builder(ModItems.BRIGHT_BERRIES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));
        addDrop(ModBlocks.DISEASED_LOG);
        addDrop(ModBlocks.DISEASED_WOOD);
        addDrop(ModBlocks.STRIPPED_DISEASED_LOG);
        addDrop(ModBlocks.STRIPPED_DISEASED_WOOD);
        addDrop(ModBlocks.DISEASED_PLANKS);

        addDrop(ModBlocks.DISEASED_STAIRS);
        addDrop(ModBlocks.DISEASED_SLAB, slabDrops(ModBlocks.BEVULTRIUM_SLAB));
        addDrop(ModBlocks.DISEASED_BUTTON);
        addDrop(ModBlocks.DISEASED_PRESSURE_PLATE);
        addDrop(ModBlocks.DISEASED_FENCE);
        addDrop(ModBlocks.DISEASED_FENCE_GATE);
        addDrop(ModBlocks.DISEASED_TRAPDOOR);

        addDrop(ModBlocks.DISEASED_SAPLING);

        addDrop(ModBlocks.DISEASED_LEAVES, diseasedLeavesDrops(ModBlocks.DISEASED_LEAVES, ModBlocks.DISEASED_SAPLING, 0.0625f));

        addDrop(OAK_CHAIR);
        addDrop(SPRUCE_CHAIR);
        addDrop(BIRCH_CHAIR);
        addDrop(JUNGLE_CHAIR);
        addDrop(ACACIA_CHAIR);
        addDrop(DARK_OAK_CHAIR);
        addDrop(MANGROVE_CHAIR);
        addDrop(CHERRY_CHAIR);
        addDrop(BAMBOO_CHAIR);
        addDrop(WARPED_CHAIR);
        addDrop(CRIMSON_CHAIR);
        addDrop(DISEASED_CHAIR);

        addDrop(ALTAR);
    }

    public LootTable.Builder diseasedLeavesDrops(Block leaves, Block sapling, float... saplingChance) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.leavesDrops(leaves, sapling, saplingChance)
                .pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                                .with(
                                        ((LeafEntry.Builder<?>)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(ModItems.DISEASED_APPLE)))
                                                .conditionally(TableBonusLootCondition.builder(impl.getOrThrow(Enchantments.FORTUNE), 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))
                                )
                );
    }


    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}