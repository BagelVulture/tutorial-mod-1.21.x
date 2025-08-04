package net.bagelvulture.tutorialmod.item;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.item.custom.HammerItem;
import net.bagelvulture.tutorialmod.item.custom.HandSmelterItem;
import net.bagelvulture.tutorialmod.item.custom.ModArmorItem;
import net.bagelvulture.tutorialmod.sound.ModSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {

    public static final Item BEVULTRIUM = registerItem("bevultrium", new Item(new Item.Settings()));
    public static final Item RAW_BEVULTRIUM = registerItem("raw_bevultrium", new Item(new Item.Settings()));

    public static final Item BEVULTRIUM_SWORD = registerItem("bevultrium_sword",
            new SwordItem(ModToolMaterials.BEVULTRIUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BEVULTRIUM, 3, -2.4f))));
    public static final Item BEVULTRIUM_PICKAXE = registerItem("bevultrium_pickaxe",
            new PickaxeItem(ModToolMaterials.BEVULTRIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BEVULTRIUM, 1, -2.8f))));
    public static final Item BEVULTRIUM_SHOVEL = registerItem("bevultrium_shovel",
            new ShovelItem(ModToolMaterials.BEVULTRIUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.BEVULTRIUM, 1.5f, -3.0f))));
    public static final Item BEVULTRIUM_AXE = registerItem("bevultrium_axe",
            new AxeItem(ModToolMaterials.BEVULTRIUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.BEVULTRIUM, 6, -3.2f))));
    public static final Item BEVULTRIUM_HOE = registerItem("bevultrium_hoe",
            new HoeItem(ModToolMaterials.BEVULTRIUM, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.BEVULTRIUM, 0, -3f))));

    public static final Item BEVULTRIUM_HELMET = registerItem("bevultrium_helmet",
            new ModArmorItem(ModArmorMaterials.BEVULTRIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item BEVULTRIUM_CHESTPLATE = registerItem("bevultrium_chestplate",
            new ArmorItem(ModArmorMaterials.BEVULTRIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item BEVULTRIUM_LEGGINGS = registerItem("bevultrium_leggings",
            new ArmorItem(ModArmorMaterials.BEVULTRIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item BEVULTRIUM_BOOTS = registerItem("bevultrium_boots",
            new ArmorItem(ModArmorMaterials.BEVULTRIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item BEVULTRIUM_HAMMER = registerItem("bevultrium_hammer",
            new HammerItem(ModToolMaterials.BEVULTRIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BEVULTRIUM,
                            7, -3.4f))));

    public static final Item BEVULTRIUM_HORSE_ARMOR = registerItem("bevultrium_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.BEVULTRIUM_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN,
                    false, new Item.Settings().maxCount(1)));

    public static final Item BEVULTURE_SMITHING_TEMPLATE = registerItem("bevulture_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(TutorialMod.MOD_ID, "bevulture"), FeatureFlags.VANILLA));

    public static final Item OTHER_BOW = registerItem("other_bow", new BowItem(new Item.Settings().maxDamage(1000)));

    public static final Item BYE_EARS_MUSIC_DISC = registerItem("bye_ears_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.BYE_EARS_KEY).maxCount(1)));



    public static final Item FERTILE_BEVULTRIUM = registerItem("fertile_bevultrium", new AliasedBlockItem
            (ModBlocks.FERTILE_BEVULTRIUM_CROP, new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if(Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.tutorialmod.fertile_bevultrium"));
            } else {
                tooltip.add(Text.translatable("tooltip.tutorialmod.generic_not_shifting"));
            }
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item HAND_SMELTER = registerItem("hand_smelter", new HandSmelterItem(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if(Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.tutorialmod.hand_smelter"));
            } else {
                tooltip.add(Text.translatable("tooltip.tutorialmod.generic_not_shifting"));
            }
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item FRIED_BEVULTRIUM = registerItem("fried_bevultrium", new Item(new Item.Settings().food(ModFoodComponents.FRIED_BEVULTRIUM)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if(Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.tutorialmod.fried_bevultrium"));
            } else {
                tooltip.add(Text.translatable("tooltip.tutorialmod.generic_not_shifting"));
            }
            super.appendTooltip(stack, context, tooltip, type);
        }
    });


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering "+ TutorialMod.MOD_ID +"'s items");
    }
}