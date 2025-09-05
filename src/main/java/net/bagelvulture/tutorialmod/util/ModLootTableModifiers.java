package net.bagelvulture.tutorialmod.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier GRASS_ID
            = Identifier.of("minecraft", "blocks/short_grass");
    private static final Identifier CREEPER_ID
            = Identifier.of("minecraft", "entities/creeper");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if(GRASS_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.001f))
                        .with(ItemEntry.builder(ModItems.BOSS_BAR_SPAWN_EGG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(LootTables.IGLOO_CHEST_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.BEVULTURE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.REPLACE.register((key, tableBuilder, source, registry) -> {
            if (CREEPER_ID.equals(key.getValue())) {

                // Gunpowder pool
                LootPool gunpowderPool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(net.minecraft.item.Items.GUNPOWDER)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f))))
                        .build();

                // Music disc pool (skeleton-kill only)
                LootPool discPool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(EntityPropertiesLootCondition.builder(
                                LootContext.EntityTarget.ATTACKER,
                                net.minecraft.predicate.entity.EntityPredicate.Builder.create().type(EntityType.SKELETON)
                        ))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_13))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_CAT))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_BLOCKS))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_CHIRP))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_FAR))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_MALL))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_MELLOHI))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_STAL))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_STRAD))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_WARD))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_11))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_WAIT))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_OTHERSIDE))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_PIGSTEP))
                        .with(ItemEntry.builder(net.minecraft.item.Items.MUSIC_DISC_RELIC))
                        .with(ItemEntry.builder(ModItems.BYE_EARS_MUSIC_DISC))
                        .build();

                return LootTable.builder()
                        .pool(gunpowderPool)
                        .pool(discPool).build();
            }
            return null;
        });
    }
}