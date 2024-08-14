package com.yeetdot.noob.entity.client;

import com.yeetdot.noob.Noob;
import com.yeetdot.noob.entity.custom.NoobEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class NoobRenderer extends MobEntityRenderer<NoobEntity, NoobModel<NoobEntity>> {
    private static final Identifier TEXTURE = Identifier.of(Noob.MOD_ID, "textures/entity/noob.png");

    public NoobRenderer(EntityRendererFactory.Context context) {
        super(context, new NoobModel<>(context.getPart(ModModelLayers.NOOB)), 0.6F);
    }

    @Override
    public Identifier getTexture(NoobEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(NoobEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isAttacking()) {
            matrixStack.scale(15f, 15f, 15f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
