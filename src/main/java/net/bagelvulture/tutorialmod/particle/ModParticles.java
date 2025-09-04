package net.bagelvulture.tutorialmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.bagelvulture.tutorialmod.TutorialMod;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType MAGIC_PARTICLE =
            registerParticle("magic_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(TutorialMod.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        TutorialMod.LOGGER.info("Registering " + TutorialMod.MOD_ID + "'s Particles");
    }
}