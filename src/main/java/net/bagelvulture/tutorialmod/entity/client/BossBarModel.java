package net.bagelvulture.tutorialmod.entity.client;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.entity.custom.BossBarEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BossBarModel<T extends BossBarEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer BOSSBAR = new EntityModelLayer(Identifier.of(TutorialMod.MOD_ID, "bossbar"), "main");
    private ModelPart root;

    public BossBarModel(ModelPart root) {this.root = root.getChild("root");}

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.0F, -1.0F, 30.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 4).cuboid(2.0F, -16.0F, 0.0F, 20.0F, 14.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-12.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(BossBarEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
    }
    @Override
    public ModelPart getPart() {
        return null;
    }
}