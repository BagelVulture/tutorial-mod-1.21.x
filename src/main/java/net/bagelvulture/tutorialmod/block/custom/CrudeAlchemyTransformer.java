package net.bagelvulture.tutorialmod.block.custom;

import net.bagelvulture.tutorialmod.particle.ModParticles;
import net.bagelvulture.tutorialmod.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrudeAlchemyTransformer extends Block {
    public CrudeAlchemyTransformer(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(itemEntity.getStack().getItem() == Items.BLACKSTONE) {
                world.playSound(null, pos, ModSounds.CRUDE_ALCHEMY_TRANSFORMER_USE, SoundCategory.BLOCKS,
                        1.0F,1.0F);
                if (itemEntity.age >= 10) {
                    itemEntity.setStack(new ItemStack(Items.GOLD_NUGGET, itemEntity.getStack().getCount()));
                    if(!world.isClient()) {
                        ((ServerWorld) world).spawnParticles(ModParticles.MAGIC_PARTICLE,
                                itemEntity.getX() + 0.0, itemEntity.getY() + 0.0,
                                itemEntity.getZ() + 0.0, 8, 0, 0, 0, 0.1);
                    }
                }
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}