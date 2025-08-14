package net.bagelvulture.tutorialmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.bagelvulture.tutorialmod.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawns {                              //below should be all overworld biomes
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS,
                        BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.ICE_SPIKES, BiomeKeys.DESERT,
                        BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST,
                        BiomeKeys.BIRCH_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST,
                        BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.TAIGA,
                        BiomeKeys.SNOWY_TAIGA, BiomeKeys.SAVANNA, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.WINDSWEPT_HILLS,
                        BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_SAVANNA,
                        BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.BADLANDS,
                        BiomeKeys.ERODED_BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.MEADOW, BiomeKeys.CHERRY_GROVE,
                        BiomeKeys.GROVE, BiomeKeys.SNOWY_SLOPES, BiomeKeys.FROZEN_PEAKS, BiomeKeys.JAGGED_PEAKS,
                        BiomeKeys.STONY_PEAKS, BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER, BiomeKeys.BEACH,
                        BiomeKeys.SNOWY_BEACH, BiomeKeys.STONY_SHORE, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN,
                        BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN,
                        BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN,
                        BiomeKeys.MUSHROOM_FIELDS, BiomeKeys.DRIPSTONE_CAVES, BiomeKeys.LUSH_CAVES, BiomeKeys.DEEP_DARK),
                SpawnGroup.CREATURE, ModEntities.TARDIGRADE, 1, 1, 6);

        SpawnRestriction.register(ModEntities.TARDIGRADE, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}