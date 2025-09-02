package net.bagelvulture.tutorialmod.entity.custom;

import net.bagelvulture.tutorialmod.entity.ModEntities;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class SpearProjectileEntity extends PersistentProjectileEntity {
    public Vector2f groundedOffset = new Vector2f(0f, 0f);

    public SpearProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public SpearProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.SPEAR, player, world, new ItemStack(ModItems.SPEAR), null);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.SPEAR);
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 4);

        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }
}