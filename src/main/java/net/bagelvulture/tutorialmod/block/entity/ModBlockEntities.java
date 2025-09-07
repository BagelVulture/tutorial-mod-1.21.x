package net.bagelvulture.tutorialmod.block.entity;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.block.entity.custom.AltarBlockEntity;
import net.bagelvulture.tutorialmod.block.entity.custom.PinkBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<AltarBlockEntity> ALTAR_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(TutorialMod.MOD_ID, "altar_be"),
                    BlockEntityType.Builder.create(AltarBlockEntity::new, ModBlocks.ALTAR).build(null));

    public static final BlockEntityType<PinkBlockEntity> PINK_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(TutorialMod.MOD_ID, "pink_be"),
                    BlockEntityType.Builder.create(PinkBlockEntity::new, ModBlocks.PINK).build(null));


    public static void registerBlockEntities() {
        TutorialMod.LOGGER.info("Registering " + TutorialMod.MOD_ID + "'s Block Entities");
    }
}