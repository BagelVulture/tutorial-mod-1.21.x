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
                entries.add(ModItems.HAND_SMELTER);
            }).build());


    public static final ItemGroup BVS_1ST_MOD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,Identifier.of
            (TutorialMod.MOD_ID, "bvs_1st_mod_blocks"), FabricItemGroup.builder().icon(() -> new ItemStack
                    (ModBlocks.BEVULTRIUM_BLOCK)).displayName(Text.translatable("itemgroup.tutorialmod.bvs_1st_mod_blocks"))
            .entries((displayContext, entries) -> {
                entries.add(ModBlocks.BEVULTRIUM_BLOCK);
                entries.add(ModBlocks.RAW_BEVULTRIUM_BLOCK);
                entries.add(ModBlocks.BEVULTRIUM_ORE);
                entries.add(ModBlocks.BEVULTRIUM_DEEPSLATE_ORE);
            }).build());


    public static void registerModItemGroups() {
        TutorialMod.LOGGER.info("Registering "+ TutorialMod.MOD_ID +"s item groups");
    }
}