package com.yeetdot.noob.entity.client;

import com.yeetdot.noob.Noob;
import com.yeetdot.noob.entity.custom.NoobEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.*;
import net.minecraft.client.render.entity.model.ArmorEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class NoobRenderer extends LivingEntityRenderer<NoobEntity, NoobModel<NoobEntity>> {
    private static final Identifier TEXTURE = Identifier.of(Noob.MOD_ID, "textures/entity/noob.png");
    public NoobRenderer(EntityRendererFactory.Context context) {
        super(context, new NoobModel<>(context.getPart(ModModelLayers.NOOB)), 0.6f);
        this.addFeature(
                new ArmorFeatureRenderer<>(
                        this, new ArmorEntityModel<>(context.getPart(EntityModelLayers.PLAYER_INNER_ARMOR)), new ArmorEntityModel<>(context.getPart(EntityModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()
                )
        );
        this.addFeature(new HeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()));
        this.addFeature(new HeadFeatureRenderer<>(this, context.getModelLoader(), context.getHeldItemRenderer()));
        this.addFeature(new ElytraFeatureRenderer<>(this, context.getModelLoader()));
    }


    public Identifier getTexture(NoobEntity entity) {
        return TEXTURE;
    }
}
