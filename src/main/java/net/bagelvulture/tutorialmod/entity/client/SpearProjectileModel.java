package net.bagelvulture.tutorialmod.entity.client;

import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.entity.custom.SpearProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SpearProjectileModel extends EntityModel<SpearProjectileEntity> {
    public static final EntityModelLayer SPEAR = new EntityModelLayer(Identifier.of(TutorialMod.MOD_ID, "spear"), "main");
    private ModelPart root;

    public void spear(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create().uv(10, -3).cuboid(0.0F, -0.5F, -14.0F, 0.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(5, 0).cuboid(-0.5F, 0.0F, -14.0F, 1.0F, 0.0F, 3.0F, new Dilation(0.0F))
                .uv(-4, 0).cuboid(-2.0F, 0.0F, 11.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, -2.0F, 11.0F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-0.5F, -0.5F, -11.0F, 1.0F, 1.0F, 25.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 23.5F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(SpearProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
    }
}