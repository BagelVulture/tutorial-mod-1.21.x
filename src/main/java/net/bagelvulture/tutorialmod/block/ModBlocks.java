package net.bagelvulture.tutorialmod.block;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BEVULTRIUM_BLOCK = registerBlock("bevultrium_block", new
            Block(AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block RAW_BEVULTRIUM_BLOCK = registerBlock("raw_bevultrium_block", new
            Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering " + TutorialMod.MOD_ID + "s blocks");

    }
}
