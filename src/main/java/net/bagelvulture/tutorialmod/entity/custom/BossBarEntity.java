package net.bagelvulture.tutorialmod.entity.custom;

import net.bagelvulture.tutorialmod.entity.ModEntities;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BossBarEntity extends AnimalEntity {

    private final ServerBossBar bossBar = new ServerBossBar(Text.literal("Boss Bar For The Boss Bar Boss"),
            BossBar.Color.GREEN, BossBar.Style.NOTCHED_10);

    public BossBarEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(1, new TemptGoal(this, 1.25D, Ingredient.ofItems(ModItems.FRIED_BEVULTRIUM), false));

        this.goalSelector.add(2, new FollowParentGoal(this, 1.1D));

        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(5, new LookAtEntityGoal(this, TardigradeEntity.class, 4.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 50)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.FRIED_BEVULTRIUM);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.BOSSBAR.create(world);
    }

    /* BOSS BAR */
    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }
}