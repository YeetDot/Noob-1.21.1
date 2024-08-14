package com.yeetdot.noob.entity.client;

import com.yeetdot.noob.entity.animation.ModAnimations;
import com.yeetdot.noob.entity.custom.NoobEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class NoobModel<T extends NoobEntity> extends SinglePartEntityModel<T> {
	private final ModelPart noob;
	private final ModelPart head;
	private final ModelPart right_arm;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	public NoobModel(ModelPart root) {
		this.noob = root.getChild("noob");
		this.head = noob.getChild("head");
		this.right_arm = noob.getChild("right_arm");
		this.body = noob.getChild("body");
		this.left_arm = noob.getChild("left_arm");
		this.right_leg = noob.getChild("right_leg");
		this.left_leg = noob.getChild("left_leg");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData noob = modelPartData.addChild("noob", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = noob.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -6.5F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -25.0F, 0.0F));

		ModelPartData right_arm = noob.addChild("right_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-2.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -22.0F, 0.0F));

		ModelPartData body = noob.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, -23.5F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_arm = noob.addChild("left_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-2.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -22.0F, 0.0F));

		ModelPartData right_leg = noob.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -10.0F, 0.0F));

		ModelPartData left_leg = noob.addChild("left_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -10.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 32);
	}
	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.NOOB_WALK, limbSwing, limbSwingAmount, 1, 1);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.NOOB_IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.007453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		noob.render(matrices, vertices, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return noob;
	}
}