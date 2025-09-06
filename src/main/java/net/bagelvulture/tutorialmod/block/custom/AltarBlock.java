package net.bagelvulture.tutorialmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.bagelvulture.tutorialmod.block.entity.custom.AltarBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AltarBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<AltarBlock> CODEC = AltarBlock.createCodec(AltarBlock::new);

    public static final VoxelShape SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
            Block.createCuboidShape(2.0, 2.0, 2.0, 14.0, 4.0, 14.0),
            Block.createCuboidShape(4.0, 4.0, 4.0, 12.0, 12.0, 12.0),
            Block.createCuboidShape(1.0, 12.0, 1.0, 15.0, 14.0, 15.0)
    );

    public AltarBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }


    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AltarBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof AltarBlockEntity) {
                ItemScatterer.spawn(world, pos, ((AltarBlockEntity) blockEntity));
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.getBlockEntity(pos) instanceof AltarBlockEntity altarBlockEntity) {

            if(altarBlockEntity.isEmpty() && !stack.isEmpty()) {
                altarBlockEntity.setStack(0, stack.copyAndEmpty());
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 2f);

                altarBlockEntity.markDirty();
                world.updateListeners(pos, state, state, 0);

            } else if(stack.isEmpty() && !player.isSneaking()) {
                ItemStack stackOnAltar = altarBlockEntity.getStack(0);
                player.setStackInHand(Hand.MAIN_HAND, stackOnAltar);
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f);
                altarBlockEntity.clear();

                altarBlockEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            } else if(!altarBlockEntity.isEmpty() && !stack.isEmpty()) { //if player and altar both have items
                if(altarBlockEntity.getStack(0).getItem() == stack.getItem() && altarBlockEntity.getStack(0).getComponents() == stack.getComponents()) { //if the items are the same AND the components are the same
                    if(altarBlockEntity.getStack(0).getCount() <= altarBlockEntity.getStack(0).getMaxCount()) { //if altar has less than the max stack size
                        if(altarBlockEntity.getStack(0).getCount() + stack.getCount() < altarBlockEntity.getStack(0).getMaxCount() + 1){ //if altar's count + player's count is less than the max stack size + 1
                            altarBlockEntity.getStack(0).setCount(altarBlockEntity.getStack(0).getCount() + stack.getCount()); //add players count to altar's count
                            stack.decrement(stack.getCount()); // decreases player's count by player's count, deleting item
                            world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f);
                        }else { //if altar's count + player's count is more than the max stack size
                            int CantBeAdded = altarBlockEntity.getStack(0).getCount() + stack.getCount() - altarBlockEntity.getStack(0).getMaxCount(); //sets CantBeAdded to altar's count + player's count - max stack size
                            int CanBeAdded = stack.getCount() - CantBeAdded; //sets CanBeAdded to players count - CantBeAdded
                            altarBlockEntity.getStack(0).setCount(altarBlockEntity.getStack(0).getCount() + CanBeAdded); // adds CanBeAdded to altars count
                            stack.decrement(CanBeAdded); // removes CanBeAdded from players count
                            world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f);
                        }
                    }
                }
            }
        }
        return ItemActionResult.SUCCESS;
    }
}