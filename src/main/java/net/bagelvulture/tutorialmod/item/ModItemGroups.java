package net.bagelvulture.tutorialmod.item;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup BVS_1ST_MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,Identifier.of
            (TutorialMod.MOD_ID, "bvs_1st_mod_items"), FabricItemGroup.builder().icon(() -> new ItemStack
                    (ModItems.BEVULTRIUM)).displayName(Text.translatable("itemgroup.tutorialmod.bvs_1st_mod_items"))
            .entries((displayContext, entries) -> {
                entries.add(ModItems.BEVULTRIUM);
                entries.add(ModItems.RAW_BEVULTRIUM);
                entries.add(ModItems.FERTILE_BEVULTRIUM);

                entries.add(ModItems.HAND_SMELTER);
                entries.add(ModItems.FRIED_BEVULTRIUM);

                entries.add(ModItems.BEVULTRIUM_SWORD);
                entries.add(ModItems.BEVULTRIUM_PICKAXE);
                entries.add(ModItems.BEVULTRIUM_SHOVEL);
                entries.add(ModItems.BEVULTRIUM_AXE);
                entries.add(ModItems.BEVULTRIUM_HOE);

                entries.add(ModItems.BEVULTRIUM_HAMMER);

                entries.add(ModItems.BEVULTRIUM_HELMET);
                entries.add(ModItems.BEVULTRIUM_CHESTPLATE);
                entries.add(ModItems.BEVULTRIUM_LEGGINGS);
                entries.add(ModItems.BEVULTRIUM_BOOTS);

                entries.add(ModItems.BEVULTRIUM_HORSE_ARMOR);

                entries.add(ModItems.BEVULTURE_SMITHING_TEMPLATE);

                entries.add(ModItems.OTHER_BOW);

                entries.add(ModItems.BYE_EARS_MUSIC_DISC);
            }).build());


    public static final ItemGroup BVS_1ST_MOD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,Identifier.of
            (TutorialMod.MOD_ID, "bvs_1st_mod_blocks"), FabricItemGroup.builder().icon(() -> new ItemStack
                    (ModBlocks.BEVULTRIUM_BLOCK)).displayName(Text.translatable("itemgroup.tutorialmod.bvs_1st_mod_blocks"))
            .entries((displayContext, entries) -> {
                entries.add(ModBlocks.BEVULTRIUM_BLOCK);
                entries.add(ModBlocks.RAW_BEVULTRIUM_BLOCK);
                entries.add(ModBlocks.BEVULTRIUM_ORE);
                entries.add(ModBlocks.BEVULTRIUM_DEEPSLATE_ORE);

                entries.add(ModBlocks.CRUDE_ALCHEMY_TRANSFORMER);
                entries.add(ModBlocks.BEVULTRIUM_LAMP);

                entries.add(ModBlocks.BEVULTRIUM_SLAB);
                entries.add(ModBlocks.BEVULTRIUM_STAIRS);
                entries.add(ModBlocks.BEVULTRIUM_BUTTON);
                entries.add(ModBlocks.BEVULTRIUM_PRESSURE_PLATE);
                entries.add(ModBlocks.BEVULTRIUM_DOOR);
                entries.add(ModBlocks.BEVULTRIUM_TRAPDOOR);
                entries.add(ModBlocks.BEVULTRIUM_FENCE);
                entries.add(ModBlocks.BEVULTRIUM_FENCE_GATE);
                entries.add(ModBlocks.BEVULTRIUM_WALL);
            }).build());


    public static void registerModItemGroups() {
        TutorialMod.LOGGER.info("Registering "+ TutorialMod.MOD_ID +"s item groups");
    }
}