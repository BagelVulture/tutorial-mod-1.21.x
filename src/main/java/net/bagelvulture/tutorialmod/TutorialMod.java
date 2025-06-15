package net.bagelvulture.tutorialmod;

import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.component.ModDataComponentTypes;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.bagelvulture.tutorialmod.item.ModItemGroups;
import net.bagelvulture.tutorialmod.util.HammerUsageEvent;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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

		FuelRegistry.INSTANCE.add(ModItems.FERTILE_BEVULTRIUM, 200);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}