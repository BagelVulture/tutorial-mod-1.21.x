package net.bagelvulture.tutorialmod.enchantment;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> TOO_MANY_PIGS =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(TutorialMod.MOD_ID, "too_many_pigs"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        // register(registerable, TOO_MANY_PIGS, Enchantment.builder(Enchantment.definition(
        //              items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
        //              items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
        //              5,
        //              5,                                                //doesnt work, copied it over manually to resources
        //              Enchantment.leveledCost(5, 7),
        //              Enchantment.leveledCost(10, 9),
        //              1,
        //              AttributeModifierSlot.MAINHAND))
        //      .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
        //      .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
        //              EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
        //              new TooManyPigsEnchantmentEffect()));
    }


    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}