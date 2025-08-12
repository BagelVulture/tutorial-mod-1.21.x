package net.bagelvulture.tutorialmod.entity.client;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.entity.custom.TardigradeEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class TardigradeModel<T extends TardigradeEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer TARDIGRADE = new EntityModelLayer(Identifier.of(TutorialMod.MOD_ID, "tardigrade"), "main");
    private final ModelPart root;
    private final ModelPart non_legs;
    private final ModelPart fullhead;

    public TardigradeModel(ModelPart root) {
        this.root = root.getChild("root");
        this.non_legs = this.root.getChild("non_legs");
        this.fullhead = this.non_legs.getChild("fullhead");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData non_legs = root.addChild("non_legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData body = non_legs.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -10.0F, -12.0F, 10.0F, 7.0F, 24.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData fullhead = non_legs.addChild("fullhead", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -6.0F, 12.0F));

        ModelPartData head = fullhead.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.4938F, 1.2835F));

        ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(0, 12).cuboid(-3.0F, -9.0F, -2.0F, 6.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.4938F, -0.2835F, -0.0436F, 0.0F, 0.0F));

        ModelPartData nose = fullhead.addChild("nose", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.11F, 3.5191F));

        ModelPartData nose_r1 = nose.addChild("nose_r1", ModelPartBuilder.create().uv(16, 0).cuboid(-1.0F, -7.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.89F, -1.5191F, -0.0873F, 0.0F, 0.0F));

        ModelPartData legs = root.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData frontright = legs.addChild("frontright", ModelPartBuilder.create(), ModelTransform.pivot(-4.9178F, -8.0F, -7.0F));

        ModelPartData frontright_r1 = frontright.addChild("frontright_r1", ModelPartBuilder.create().uv(8, 0).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0822F, 8.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

        ModelPartData middleright = legs.addChild("middleright", ModelPartBuilder.create(), ModelTransform.pivot(-4.9178F, -8.0F, 0.0F));

        ModelPartData middleright_r1 = middleright.addChild("middleright_r1", ModelPartBuilder.create().uv(8, 0).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0822F, 8.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

        ModelPartData backright = legs.addChild("backright", ModelPartBuilder.create(), ModelTransform.pivot(-4.9178F, -8.0F, 7.0F));

        ModelPartData backright_r1 = backright.addChild("backright_r1", ModelPartBuilder.create().uv(8, 0).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0822F, 8.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

        ModelPartData frontleft = legs.addChild("frontleft", ModelPartBuilder.create(), ModelTransform.pivot(4.9178F, -8.0F, -7.0F));

        ModelPartData frontleft_r1 = frontleft.addChild("frontleft_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0822F, 8.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

        ModelPartData middleleft = legs.addChild("middleleft", ModelPartBuilder.create(), ModelTransform.pivot(4.9178F, -8.0F, 0.0F));

        ModelPartData middleleft_r1 = middleleft.addChild("middleleft_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0822F, 8.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

        ModelPartData backleft = legs.addChild("backleft", ModelPartBuilder.create(), ModelTransform.pivot(4.9178F, -8.0F, 7.0F));

        ModelPartData backleft_r1 = backleft.addChild("backleft_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0822F, 8.0F, 0.0F, 0.0F, 0.0F, -0.2182F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(TardigradeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(TardigradeAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, TardigradeAnimations.IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.fullhead.yaw = headYaw * 0.017453292F;
        this.fullhead.pitch = headPitch * -0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}