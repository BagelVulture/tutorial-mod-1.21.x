package net.bagelvulture.tutorialmod.entity.custom;

import net.bagelvulture.tutorialmod.entity.ModEntities;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Util;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TardigradeEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(TardigradeEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public TardigradeEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(1, new TemptGoal(this, 1.25D, Ingredient.ofItems(ModItems.FRIED_BEVULTRIUM), false));

        this.goalSelector.add(2, new FollowParentGoal(this, 1.1D));

        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(3, new SwimGoal(this));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(5, new LookAtEntityGoal(this, TardigradeEntity.class, 4.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1000)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20)
                .add(EntityAttributes.GENERIC_FALL_DAMAGE_MULTIPLIER, 0.01);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 240;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.FRIED_BEVULTRIUM);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        TardigradeEntity baby = ModEntities.TARDIGRADE.create(world);

        // Cast to access parent's variants
        if (!(entity instanceof TardigradeEntity otherParent)) {
            return baby; // fallback if cast fails
        }

        TardigradeVariant parentVariant = this.getVariant();
        TardigradeVariant otherParentVariant = otherParent.getVariant();

        // Random number from 0 to 99.9 (for 0.1% precision if needed)
        double roll = this.random.nextDouble() * 100;

        TardigradeVariant chosenVariant;
        if (roll < 45.0) {
            chosenVariant = parentVariant; // 45% this parent's variant
        } else if (roll < 90.0) {
            chosenVariant = otherParentVariant; // next 45%
        } else if (roll < 94.0) {
            chosenVariant = TardigradeVariant.DEFAULT; // 4%
        } else if (roll < 96.5) {
            chosenVariant = TardigradeVariant.BLUE; // 2.5%
        } else if (roll < 98.5) {
            chosenVariant = TardigradeVariant.GREEN; // 2%
        } else if (roll < 99.5) {
            chosenVariant = TardigradeVariant.ORANGE; // 1%
        } else {
            chosenVariant = TardigradeVariant.PURPLE; // last 0.5%
        }

        baby.setVariant(chosenVariant);
        return baby;
    }

    /* VARIANT */
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
    }

    public TardigradeVariant getVariant() {
        return TardigradeVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(TardigradeVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        TardigradeVariant variant = Util.getRandom(TardigradeVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    private TardigradeVariant getWeightedRandomVariant() {
        double roll = this.random.nextDouble() * 100; // 0.0 to 99.999...

        if (roll < 72.25) {
            return TardigradeVariant.DEFAULT;   // 72.25%
        } else if (roll < 84.75) {
            return TardigradeVariant.BLUE;      // next 12.5%
        } else if (roll < 94.75) {
            return TardigradeVariant.GREEN;     // next 10%
        } else if (roll < 99.75) {
            return TardigradeVariant.ORANGE;    // next 5%
        } else {
            return TardigradeVariant.PURPLE;    // remaining 0.25%
        }
    }
}