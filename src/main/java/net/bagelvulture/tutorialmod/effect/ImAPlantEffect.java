package net.bagelvulture.tutorialmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import java.util.List;

public class ImAPlantEffect extends StatusEffect {

    public ImAPlantEffect(StatusEffectCategory category, int color) {
        super(StatusEffectCategory.BENEFICIAL, 0x5BCD00);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 20 == 0;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if (world.isClient) return true;

        double triggerChance = Math.min((2.5 + amplifier) / 10.0, 1.0);
        if (Math.random() >= triggerChance) return true;

        double radius = 5.0 + amplifier;
        double immobilizeChance = Math.min((4.0 + amplifier) / 10.0, 1.0);

        List<LivingEntity> targets = world.getEntitiesByClass(
                LivingEntity.class,
                entity.getBoundingBox().expand(radius),
                e -> e != entity && e.isAlive() && e instanceof HostileEntity
        );

        for (LivingEntity target : targets) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0));

            if (amplifier >= 1 && Math.random() < immobilizeChance) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 5));
            }

            if (world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(ParticleTypes.ITEM_SLIME,
                        target.getX(), target.getY() + 0.5, target.getZ(),
                        5, 0.3, 0.2, 0.3, 0.01);
            }

            world.playSound(null, target.getBlockPos(),
                    SoundEvents.BLOCK_ROOTED_DIRT_HIT, SoundCategory.HOSTILE, 0.5f, 1f);
        }

        return true;
    }
}
