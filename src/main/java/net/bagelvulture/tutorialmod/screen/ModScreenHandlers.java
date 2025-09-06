package net.bagelvulture.tutorialmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.screen.custom.AltarScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<AltarScreenHandler> ALTAR_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(TutorialMod.MOD_ID, "altar_screen_handler"),
                    new ExtendedScreenHandlerType<>(AltarScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        TutorialMod.LOGGER.info("Registering " + TutorialMod.MOD_ID + "'s Screen Handlers");
    }
}