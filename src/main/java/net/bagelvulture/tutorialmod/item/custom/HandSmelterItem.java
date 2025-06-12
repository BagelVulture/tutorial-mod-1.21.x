package net.bagelvulture.tutorialmod.item.custom;

import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class HandSmelterItem extends Item {
    private static final Map<Block, Block> HANDSMELTER_MAP =
        Map.of(
                ModBlocks.RAW_BEVULTRIUM_BLOCK, ModBlocks.BEVULTRIUM_BLOCK,
                Blocks.RAW_COPPER_BLOCK, Blocks.COPPER_BLOCK,
                Blocks.RAW_GOLD_BLOCK, Blocks.GOLD_BLOCK,
                Blocks.RAW_IRON_BLOCK, Blocks.IRON_BLOCK,
                Blocks.STONE, Blocks.SMOOTH_STONE,
                Blocks.COBBLESTONE, Blocks.STONE,
                Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS,
                Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE,
                Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS,
                Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES,
                Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE,
                Blocks.RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE,
                Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS,
                Blocks.BASALT, Blocks.SMOOTH_BASALT,
                Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS,
                Blocks.QUARTZ_BLOCK, Blocks.SMOOTH_QUARTZ,
                Blocks.BLACK_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA,
                Blocks.BLUE_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA,
                Blocks.BROWN_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA,
                Blocks.CYAN_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA,
                Blocks.GRAY_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA,
                Blocks.GREEN_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA,
                Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA,
                Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA,
                Blocks.LIME_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA,
                Blocks.MAGENTA_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA,
                Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA,
                Blocks.PINK_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA,
                Blocks.PURPLE_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA,
                Blocks.RED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA,
                Blocks.WHITE_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA,
                Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA,
                Blocks.SAND, Blocks.GLASS,
                Blocks.RED_SAND, Blocks.GLASS,
                Blocks.WET_SPONGE, Blocks.SPONGE,
                Blocks.FIRE, Blocks.LAVA,
                Blocks.WATER, Blocks.AIR,
                Blocks.CYAN_CANDLE, Blocks.DRAGON_EGG
        );

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

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
