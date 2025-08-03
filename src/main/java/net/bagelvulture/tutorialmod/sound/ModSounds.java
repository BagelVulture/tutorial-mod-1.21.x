package net.bagelvulture.tutorialmod.sound;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent CRUDE_ALCHEMY_TRANSFORMER_USE = registerSoundEvent("crude_alchemy_transformer_use");

    public static final SoundEvent CRUDE_ALCHEMY_TRANSFORMER_BREAK = registerSoundEvent("crude_alchemy_transformer_break");
    public static final SoundEvent CRUDE_ALCHEMY_TRANSFORMER_STEP = registerSoundEvent("crude_alchemy_transformer_step");
    public static final SoundEvent CRUDE_ALCHEMY_TRANSFORMER_PLACE = registerSoundEvent("crude_alchemy_transformer_place");
    public static final SoundEvent CRUDE_ALCHEMY_TRANSFORMER_HIT = registerSoundEvent("crude_alchemy_transformer_hit");
    public static final SoundEvent CRUDE_ALCHEMY_TRANSFORMER_FALL = registerSoundEvent("crude_alchemy_transformer_fall");

    public static final BlockSoundGroup CRUDE_ALCHEMY_TRANSFORMER_SOUNDS = new BlockSoundGroup(1f, 1f,
            CRUDE_ALCHEMY_TRANSFORMER_BREAK, CRUDE_ALCHEMY_TRANSFORMER_STEP, CRUDE_ALCHEMY_TRANSFORMER_PLACE,
            CRUDE_ALCHEMY_TRANSFORMER_HIT, CRUDE_ALCHEMY_TRANSFORMER_FALL);

    public static final SoundEvent BYE_EARS = registerSoundEvent("bye_ears");
    public static final RegistryKey<JukeboxSong> BYE_EARS_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(TutorialMod.MOD_ID, "bye_ears"));


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        TutorialMod.LOGGER.info("Registering " + TutorialMod.MOD_ID + "'s  Mod Sounds");
    }
}