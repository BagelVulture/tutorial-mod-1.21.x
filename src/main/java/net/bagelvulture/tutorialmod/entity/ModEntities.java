package net.bagelvulture.tutorialmod.entity;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.entity.custom.SpearProjectileEntity;
import net.bagelvulture.tutorialmod.entity.custom.TardigradeEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<TardigradeEntity> TARDIGRADE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TutorialMod.MOD_ID, "tardigrade"),
            EntityType.Builder.create(TardigradeEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 0.625f).build());

    public static final EntityType<SpearProjectileEntity> SPEAR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TutorialMod.MOD_ID, "spear"),
            EntityType.Builder.<SpearProjectileEntity>create(SpearProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.125f).  build());


    public static void registerModEntities() {
        TutorialMod.LOGGER.info("Registering " + TutorialMod.MOD_ID + "'s Entities");
    }
}