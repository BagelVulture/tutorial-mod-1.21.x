package net.bagelvulture.tutorialmod.block;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.block.custom.BevultriumLampBlock;
import net.bagelvulture.tutorialmod.block.custom.BrightBerryBushBlock;
import net.bagelvulture.tutorialmod.block.custom.CrudeAlchemyTransformer;
import net.bagelvulture.tutorialmod.block.custom.FertileBevultriumCropBlock;
import net.bagelvulture.tutorialmod.sound.ModSounds;
import net.bagelvulture.tutorialmod.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block BEVULTRIUM_BLOCK = registerBlock("bevultrium_block", new
            Block(AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block RAW_BEVULTRIUM_BLOCK = registerBlock("raw_bevultrium_block", new
            Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block BEVULTRIUM_ORE = registerBlock("bevultrium_ore", new
            ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block BEVULTRIUM_DEEPSLATE_ORE = registerBlock("bevultrium_deepslate_ore", new
            ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(2.5f).requiresTool()));
    public static final Block BEVULTRIUM_END_ORE = registerBlock("bevultrium_end_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(5f).requiresTool()));
    public static final Block BEVULTRIUM_NETHER_ORE = registerBlock("bevultrium_nether_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));


    public static final Block CRUDE_ALCHEMY_TRANSFORMER = registerBlock("crude_alchemy_transformer",
            new CrudeAlchemyTransformer(AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(ModSounds.CRUDE_ALCHEMY_TRANSFORMER_SOUNDS)));


    public static final Block BEVULTRIUM_STAIRS = registerBlock("bevultrium_stairs",
            new StairsBlock(ModBlocks.BEVULTRIUM_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block BEVULTRIUM_SLAB = registerBlock("bevultrium_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block BEVULTRIUM_BUTTON = registerBlock("bevultrium_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().strength(4f).requiresTool().noCollision().breakInstantly()));
    public static final Block BEVULTRIUM_PRESSURE_PLATE = registerBlock("bevultrium_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block BEVULTRIUM_FENCE = registerBlock("bevultrium_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block BEVULTRIUM_FENCE_GATE = registerBlock("bevultrium_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block BEVULTRIUM_WALL = registerBlock("bevultrium_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block BEVULTRIUM_DOOR = registerBlock("bevultrium_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(4f).requiresTool().nonOpaque()));
    public static final Block BEVULTRIUM_TRAPDOOR = registerBlock("bevultrium_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(4f).requiresTool().nonOpaque()));

    public static final Block BEVULTRIUM_LAMP = registerBlock("bevultrium_lamp",
            new BevultriumLampBlock(AbstractBlock.Settings.create()
                    .strength(3f).requiresTool().luminance(state -> state.get(BevultriumLampBlock.CLICKED) ? 15 : 0)));

    public static final Block FERTILE_BEVULTRIUM_CROP = registerBlockWithoutBlockItem("fertile_bevultrium_crop",
            new FertileBevultriumCropBlock(AbstractBlock.Settings.create().noCollision().ticksRandomly().breakInstantly()
                    .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block BRIGHT_BERRY_BUSH = registerBlockWithoutBlockItem("bright_berry_bush",
            new BrightBerryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));

    public static final Block DISEASED_LOG = registerBlock("diseased_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block DISEASED_WOOD = registerBlock("diseased_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_DISEASED_LOG = registerBlock("stripped_diseased_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_DISEASED_WOOD = registerBlock("stripped_diseased_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block DISEASED_PLANKS = registerBlock("diseased_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block DISEASED_LEAVES = registerBlock("diseased_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block DISEASED_SAPLING = registerBlock("diseased_sapling",
            new SaplingBlock(ModSaplingGenerators.DISEASED, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering " + TutorialMod.MOD_ID + "'s blocks");

    }
}
