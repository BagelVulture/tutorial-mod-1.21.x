package net.bagelvulture.tutorialmod.item;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.item.custom.HandSmelterItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BEVULTRIUM = registerItem("bevultrium", new Item(new Item.Settings()));
    public static final Item RAW_BEVULTRIUM = registerItem("raw_bevultrium", new Item(new Item.Settings()));
    public static final Item PLACEHOLDER = registerItem("placeholder", new Item(new Item.Settings()));

    public static final Item HAND_SMELTER = registerItem("hand_smelter", new HandSmelterItem(new Item.Settings()));
    public static final Item FRIED_BEVULTRIUM = registerItem("fried_bevultrium", new Item(new Item.Settings().food(ModFoodComponents.FRIED_BEVULTRIUM)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering "+ TutorialMod.MOD_ID +"s items");
    }
}
