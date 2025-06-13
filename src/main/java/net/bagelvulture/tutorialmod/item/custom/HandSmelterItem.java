package net.bagelvulture.tutorialmod.item.custom;

import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

import static java.util.Map.entry;

public class HandSmelterItem extends Item {
    private static final Map<Block, Block> HANDSMELTER_MAP =
            Map.ofEntries(
                    entry(ModBlocks.RAW_BEVULTRIUM_BLOCK, ModBlocks.BEVULTRIUM_BLOCK),
                    entry(Blocks.RAW_COPPER_BLOCK, Blocks.COPPER_BLOCK),
                    entry(Blocks.RAW_GOLD_BLOCK, Blocks.GOLD_BLOCK),
                    entry(Blocks.RAW_IRON_BLOCK, Blocks.IRON_BLOCK),
                    entry(Blocks.STONE, Blocks.SMOOTH_STONE),
                    entry(Blocks.COBBLESTONE, Blocks.STONE),
                    entry(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS),
                    entry(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE),
                    entry(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS),
                    entry(Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES),
                    entry(Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE),
                    entry(Blocks.RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE),
                    entry(Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS),
                    entry(Blocks.BASALT, Blocks.SMOOTH_BASALT),
                    entry(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS),
                    entry(Blocks.QUARTZ_BLOCK, Blocks.SMOOTH_QUARTZ),
                    entry(Blocks.BLACK_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA),
                    entry(Blocks.BLUE_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA),
                    entry(Blocks.BROWN_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA),
                    entry(Blocks.CYAN_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA),
                    entry(Blocks.GRAY_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA),
                    entry(Blocks.GREEN_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA),
                    entry(Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA),
                    entry(Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA),
                    entry(Blocks.LIME_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA),
                    entry(Blocks.MAGENTA_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA),
                    entry(Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA),
                    entry(Blocks.PINK_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA),
                    entry(Blocks.PURPLE_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA),
                    entry(Blocks.RED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA),
                    entry(Blocks.WHITE_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA),
                    entry(Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA),
                    entry(Blocks.SAND, Blocks.GLASS),
                    entry(Blocks.RED_SAND, Blocks.GLASS),
                    entry(Blocks.WET_SPONGE, Blocks.SPONGE),
                    entry(Blocks.FIRE, Blocks.LAVA),
                    entry(Blocks.WATER, Blocks.AIR),
                    entry(Blocks.CYAN_CANDLE, Blocks.DRAGON_EGG));

    public HandSmelterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(HANDSMELTER_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), HANDSMELTER_MAP.get(clickedBlock).getDefaultState());
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
