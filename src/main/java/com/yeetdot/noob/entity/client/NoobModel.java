package com.yeetdot.noob.entity.client;

import com.yeetdot.noob.entity.custom.NoobEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class NoobModel<T extends NoobEntity> extends BipedEntityModel<T> {


	public NoobModel(ModelPart root) {
		super(root, RenderLayer::getEntityTranslucent);
    }

	@Override
	public void setAngles(T livingEntity, float f, float g, float h, float i, float j) {
		super.setAngles(livingEntity, f, g, h, i, j);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
	}

	public static TexturedModelData getModelData() {
		float pivotOffsetY = 0;
		Dilation dilation = Dilation.NONE;
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild(
				EntityModelPartNames.HEAD,
				ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, Dilation.NONE),
				ModelTransform.pivot(0.0F, 0.0F, 0.0F)
		);
		modelPartData.addChild(
				EntityModelPartNames.HAT,
				ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, dilation.add(0.5F)),
				ModelTransform.pivot(0.0F, 0.0F + pivotOffsetY, 0.0F)
		);
		modelPartData.addChild(
				EntityModelPartNames.BODY,
				ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation),
				ModelTransform.pivot(0.0F, 0.0F + pivotOffsetY, 0.0F)
		);
		modelPartData.addChild(
				EntityModelPartNames.RIGHT_ARM,
				ModelPartBuilder.create().uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation),
				ModelTransform.pivot(-5.0F, 2.0F + pivotOffsetY, 0.0F)
		);
		modelPartData.addChild(
				EntityModelPartNames.LEFT_ARM,
				ModelPartBuilder.create().uv(40, 16).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation),
				ModelTransform.pivot(5.0F, 2.0F + pivotOffsetY, 0.0F)
		);
		modelPartData.addChild(
				EntityModelPartNames.RIGHT_LEG,
				ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation),
				ModelTransform.pivot(-1.9F, 12.0F + pivotOffsetY, 0.0F)
		);
		modelPartData.addChild(
				EntityModelPartNames.LEFT_LEG,
				ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation),
				ModelTransform.pivot(1.9F, 12.0F + pivotOffsetY, 0.0F)
		);
		return TexturedModelData.of(modelData, 64, 32);
	}
}