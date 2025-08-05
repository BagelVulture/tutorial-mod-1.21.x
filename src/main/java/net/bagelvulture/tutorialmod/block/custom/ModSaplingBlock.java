package net.bagelvulture.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.List;

public class ModSaplingBlock extends SaplingBlock {
    private final List<Block> blockToPlaceOn;

    public ModSaplingBlock(SaplingGenerator generator, Settings settings, List<Block> block) {
        super(generator, settings);
        this.blockToPlaceOn = block;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return blockToPlaceOn.contains(floor.getBlock());
    }
}