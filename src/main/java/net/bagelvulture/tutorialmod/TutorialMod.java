package net.bagelvulture.tutorialmod;

import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.component.ModDataComponentTypes;
import net.bagelvulture.tutorialmod.effect.ModEffects;
import net.bagelvulture.tutorialmod.enchantment.ModEnchantmentEffects;
import net.bagelvulture.tutorialmod.entity.ModEntities;
import net.bagelvulture.tutorialmod.entity.custom.BossBarEntity;
import net.bagelvulture.tutorialmod.entity.custom.TardigradeEntity;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.bagelvulture.tutorialmod.particle.ModParticles;
import net.bagelvulture.tutorialmod.potion.ModPotions;
import net.bagelvulture.tutorialmod.sound.ModSounds;
import net.bagelvulture.tutorialmod.util.ModLootTableModifiers;
import net.bagelvulture.tutorialmod.villager.ModVillagers;
import net.bagelvulture.tutorialmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.bagelvulture.tutorialmod.item.ModItemGroups;
import net.bagelvulture.tutorialmod.util.HammerUsageEvent;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();

		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModEnchantmentEffects.registerEnchantmentEffects();

		ModWorldGeneration.generateModWorldGen();

		ModEntities.registerModEntities();
		ModVillagers.registerVillagers();

		ModParticles.registerParticles();

		ModLootTableModifiers.modifyLootTables();

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
		CompostingChanceRegistry.INSTANCE.add(ModItems.DISEASED_APPLE, 0.75f);
		CompostingChanceRegistry.INSTANCE.add(Items.ROTTEN_FLESH, 0.5f);

		StrippableBlockRegistry.register(ModBlocks.DISEASED_LOG, ModBlocks.STRIPPED_DISEASED_LOG);
		StrippableBlockRegistry.register(ModBlocks.DISEASED_WOOD, ModBlocks.STRIPPED_DISEASED_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DISEASED_LOG, 10, 10);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DISEASED_WOOD, 10, 10);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DISEASED_LOG, 10, 10);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DISEASED_WOOD, 10, 10);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DISEASED_PLANKS, 10, 25);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DISEASED_LEAVES, 35, 65);

		FabricDefaultAttributeRegistry.register(ModEntities.TARDIGRADE, TardigradeEntity.createAttributes());
		FabricDefaultAttributeRegistry.register((EntityType<? extends LivingEntity>) ModEntities.BOSSBAR, BossBarEntity.createAttributes());

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 1),
					new ItemStack(ModItems.DISEASED_APPLE, 1), 10, 0, 0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(ModItems.BRIGHT_BERRIES, 8), 7, 7, 0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.BV_FAN, 1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 10),
					new ItemStack(ModItems.BEVULTRIUM, 1), 8, 7, 0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 64),
                    Optional.of(new TradedItem(Items.EMERALD, 36)),
					new ItemStack(ModBlocks.BEVULTRIUM_BLOCK, 1), 4, 7, 0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.BV_FAN, 2, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 10),
					new ItemStack(Items.PAINTING, 1), 4, 7, 0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 16),
					new ItemStack(ModItems.SPEAR, 1), 3, 12, 0.09f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.BV_FAN, 3, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 10),
					new ItemStack(Items.PAINTING, 1), 4, 7, 0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.BV_FAN, 4, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 10),
					new ItemStack(Items.PAINTING, 1), 4, 7, 0.04f));
		});

		TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 10),
					new ItemStack(ModItems.HAND_SMELTER, 1), 4, 7, 0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.BEVULTRIUM, 64),
					new ItemStack(ModItems.BEVULTURE_SMITHING_TEMPLATE, 1), 3, 12, 0.09f));
		});
	}
}