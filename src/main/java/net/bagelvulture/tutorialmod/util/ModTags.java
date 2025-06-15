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

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> EXAMPLE_TAG = createTag();

        private static TagKey<Item> createTag() {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, "example_tag"));
        }
    }
}