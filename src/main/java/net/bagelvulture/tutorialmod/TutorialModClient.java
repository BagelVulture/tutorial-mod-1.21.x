package net.bagelvulture.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.util.ModModelPredicates;
import net.minecraft.client.render.RenderLayer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEVULTRIUM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEVULTRIUM_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FERTILE_BEVULTRIUM_CROP, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();
    }
}
