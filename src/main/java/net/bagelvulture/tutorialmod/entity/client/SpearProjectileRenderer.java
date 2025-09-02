package net.bagelvulture.tutorialmod.entity.client;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.entity.custom.SpearProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class SpearProjectileRenderer extends EntityRenderer<SpearProjectileEntity> {
    protected final SpearProjectileModel model;

    public SpearProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new SpearProjectileModel(); // Use default constructor
        this.model.spear(ctx.getPart(SpearProjectileModel.SPEAR)); // Initialize with model part
    }

    @Override
    public void render(SpearProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        float yawbv = MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw());
        float pitchbv = MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch());

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yawbv));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-pitchbv));

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));

        matrices.translate(0, -1.0f, 0);

        VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers,
                this.model.getLayer(Identifier.of(TutorialMod.MOD_ID, "textures/entity/spear/spear.png")), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(SpearProjectileEntity entity) {
        return Identifier.of(TutorialMod.MOD_ID, "textures/entity/spear/spear.png");
    }
}