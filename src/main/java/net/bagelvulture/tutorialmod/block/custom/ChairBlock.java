package net.bagelvulture.tutorialmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.bagelvulture.tutorialmod.entity.ModEntities;
import net.bagelvulture.tutorialmod.entity.custom.ChairEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChairBlock extends HorizontalFacingBlock {
    public static final MapCodec<ChairBlock> CODEC = createCodec(ChairBlock::new);
    public static final VoxelShape SHAPEN = VoxelShapes.union(
            Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0),
            Block.createCuboidShape(1.0, 11.0, 1.0, 15.0, 12.0, 15.0),
            Block.createCuboidShape(1.0, 12.0, 14.0, 15.0, 26.0, 15.0)
    );
    public static final VoxelShape SHAPEW = VoxelShapes.union(
            Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0),
            Block.createCuboidShape(1.0, 11.0, 1.0, 15.0, 12.0, 15.0),
            Block.createCuboidShape(14.0, 12.0, 1.0, 15.0, 26.0, 15.0)
    );
    public static final VoxelShape SHAPES = VoxelShapes.union(
            Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0),
            Block.createCuboidShape(1.0, 11.0, 1.0, 15.0, 12.0, 15.0),
            Block.createCuboidShape(1.0, 12.0, 1.0, 15.0, 26.0, 2.0)
    );
    public static final VoxelShape SHAPEE = VoxelShapes.union(
            Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0),
            Block.createCuboidShape(1.0, 11.0, 1.0, 15.0, 12.0, 15.0),
            Block.createCuboidShape(1.0, 12.0, 1.0, 2.0, 26.0, 15.0)
    );


    public ChairBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()) {
            Entity entity = null;
            List<ChairEntity> entities = world.getEntitiesByType(ModEntities.CHAIR, new Box(pos), chair -> true);
            if(entities.isEmpty()) {
                entity = ModEntities.CHAIR.spawn((ServerWorld) world, pos, SpawnReason.TRIGGERED);
            } else {
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        return switch (direction) {
            case NORTH -> SHAPEN;
            case EAST -> SHAPEE;
            case WEST -> SHAPEW;
            case SOUTH -> SHAPES;
            case DOWN,UP -> null;

        };
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}