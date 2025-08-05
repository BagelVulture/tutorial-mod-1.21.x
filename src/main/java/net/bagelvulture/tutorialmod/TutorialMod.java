package net.bagelvulture.tutorialmod;

import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.component.ModDataComponentTypes;
import net.bagelvulture.tutorialmod.effect.ModEffects;
import net.bagelvulture.tutorialmod.enchantment.ModEnchantmentEffects;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.bagelvulture.tutorialmod.potion.ModPotions;
import net.bagelvulture.tutorialmod.sound.ModSounds;
import net.bagelvulture.tutorialmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.bagelvulture.tutorialmod.item.ModItemGroups;
import net.bagelvulture.tutorialmod.util.HammerUsageEvent;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();

		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModEnchantmentEffects.registerEnchantmentEffects();

		ModWorldGeneration.generateModWorldGen();


		FuelRegistry.INSTANCE.add(ModItems.FERTILE_BEVULTRIUM, 200);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (!world.isClient && !player.isCreative()) {
				String selected = null;
				String[] options = {"POW!", "BANG!", "BASH!", "KAPOW!", "KABLAMO!", "WHAM!", "BOOM!"};
				selected = options[new java.util.Random().nextInt(options.length)];
				player.sendMessage(Text.literal(selected));
			}
			return ActionResult.PASS;
		});

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.VINE, ModPotions.IMAPLANT_POTION);
		});

		CompostingChanceRegistry.INSTANCE.add(ModItems.FERTILE_BEVULTRIUM, 0.25f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.FRIED_BEVULTRIUM, 0.75f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.BRIGHT_BERRIES, 0.5f);

		StrippableBlockRegistry.register(ModBlocks.DISEASED_LOG, ModBlocks.STRIPPED_DISEASED_LOG);
		StrippableBlockRegistry.register(ModBlocks.DISEASED_WOOD, ModBlocks.STRIPPED_DISEASED_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DISEASED_LOG, 10, 10);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DISEASED_WOOD, 10, 10);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DISEASED_LOG, 10, 10);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DISEASED_WOOD, 10, 10);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DISEASED_PLANKS, 10, 25);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DISEASED_LEAVES, 35, 65);
	}
}