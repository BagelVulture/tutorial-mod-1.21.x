package net.bagelvulture.tutorialmod;

import net.bagelvulture.tutorialmod.block.entity.ModBlockEntities;
import net.bagelvulture.tutorialmod.block.entity.renderer.AltarBlockEntityRenderer;
import net.bagelvulture.tutorialmod.entity.client.*;
import net.bagelvulture.tutorialmod.particle.MagicParticle;
import net.bagelvulture.tutorialmod.particle.ModParticles;
import net.bagelvulture.tutorialmod.screen.ModScreenHandlers;
import net.bagelvulture.tutorialmod.screen.custom.AltarScreen;
import net.bagelvulture.tutorialmod.screen.custom.PinkScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.entity.ModEntities;
import net.bagelvulture.tutorialmod.util.ModModelPredicates;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEVULTRIUM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEVULTRIUM_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FERTILE_BEVULTRIUM_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BRIGHT_BERRY_BUSH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DISEASED_SAPLING, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(TardigradeModel.TARDIGRADE, TardigradeModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TARDIGRADE, TardigradeRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(SpearProjectileModel.SPEAR, SpearProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SPEAR, SpearProjectileRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(BossBarModel.BOSSBAR, BossBarModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BOSSBAR, BossBarRenderer::new);


        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.MAGIC_PARTICLE, MagicParticle.Factory::new);

        BlockEntityRendererFactories.register(ModBlockEntities.ALTAR_BE, AltarBlockEntityRenderer::new);
        HandledScreens.register(ModScreenHandlers.ALTAR_SCREEN_HANDLER, AltarScreen::new);

        HandledScreens.register(ModScreenHandlers.PINK_SCREEN_HANDLER, PinkScreen::new);
    }
}
