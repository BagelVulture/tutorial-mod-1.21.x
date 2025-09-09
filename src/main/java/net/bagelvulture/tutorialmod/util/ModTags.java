package net.bagelvulture.tutorialmod.util;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_BEVULTRIUM_TOOL = createTag("needs_bevultrium_tool");
        public static final TagKey<Block> INCORRECT_FOR_BEVULTRIUM_TOOL = createTag("incorrect_for_bevultrium_tool");

        public static final TagKey<Block> DISEASED_LOGS = createTag("diseased_logs");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DISEASED_LOGS = createTag("diseased_logs");

        //for pink
        public static final TagKey<Item> WOOLS = createTag("wools");
        public static final TagKey<Item> CARPETS = createTag("carpets");
        public static final TagKey<Item> BEDS = createTag("beds");
        public static final TagKey<Item> TERRACOTTAS = createTag("terracottas");
        public static final TagKey<Item> GLAZED_TERRACOTTAS = createTag("glazed_terracottas");
        public static final TagKey<Item> CONCRETES = createTag("concretes");
        public static final TagKey<Item> STAINED_GLASS = createTag("stained_glass");
        public static final TagKey<Item> STAINED_GLASS_PANES = createTag("stained_glass_panes");
        public static final TagKey<Item> SHULKER_BOXES = createTag("shulker_boxes");
        public static final TagKey<Item> CONCRETE_POWDERS = createTag("concrete_powders");
        public static final TagKey<Item> CANDLES = createTag("candles");
        public static final TagKey<Item> BANNERS = createTag("banners");
        public static final TagKey<Item> DYES = createTag("dyes");

        private static TagKey<Item> createTag(String path) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, path));
        }
    }
}