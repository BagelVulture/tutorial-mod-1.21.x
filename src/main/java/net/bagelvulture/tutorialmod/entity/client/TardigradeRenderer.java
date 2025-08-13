package net.bagelvulture.tutorialmod.entity.client;

import com.google.common.collect.Maps;
import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.entity.custom.TardigradeEntity;
import net.bagelvulture.tutorialmod.entity.custom.TardigradeVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class TardigradeRenderer extends MobEntityRenderer<TardigradeEntity, TardigradeModel<TardigradeEntity>> {
    private static final Map<TardigradeVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(TardigradeVariant.class), map -> {
                map.put(TardigradeVariant.DEFAULT,
                        Identifier.of(TutorialMod.MOD_ID, "textures/entity/tardigrade/tardigrade.png"));
                map.put(TardigradeVariant.ORANGE,
                        Identifier.of(TutorialMod.MOD_ID, "textures/entity/tardigrade/tardigrade_orange.png"));
                map.put(TardigradeVariant.BLUE,
                        Identifier.of(TutorialMod.MOD_ID, "textures/entity/tardigrade/tardigrade_blue.png"));
                map.put(TardigradeVariant.GREEN,
                        Identifier.of(TutorialMod.MOD_ID, "textures/entity/tardigrade/tardigrade_green.png"));
                map.put(TardigradeVariant.PURPLE,
                        Identifier.of(TutorialMod.MOD_ID, "textures/entity/tardigrade/tardigrade_purple.png"));
            });

    public TardigradeRenderer(EntityRendererFactory.Context context) {
        super(context, new TardigradeModel<>(context.getPart(TardigradeModel.TARDIGRADE)), 0.50f);
    }

    @Override
    public Identifier getTexture(TardigradeEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(TardigradeEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}