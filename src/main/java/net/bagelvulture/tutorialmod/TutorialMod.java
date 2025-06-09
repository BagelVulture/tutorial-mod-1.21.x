package net.bagelvulture.tutorialmod;

import net.bagelvulture.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//very important change from last commit
public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorial-mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}