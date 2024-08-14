package com.yeetdot.noob;

import com.google.common.collect.ImmutableMap;
import com.yeetdot.noob.entity.ModEntities;
import com.yeetdot.noob.entity.client.ModModelLayers;
import com.google.common.collect.ImmutableMap.Builder;
import com.yeetdot.noob.entity.client.NoobModel;
import com.yeetdot.noob.entity.client.NoobRenderer;
import com.yeetdot.noob.entity.custom.NoobEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.SkinTextures;

public class NoobClient implements ClientModInitializer {
    @Override
	public void onInitializeClient() {
		Builder<SkinTextures.Model, EntityRenderer<? extends NoobEntity>> builder = ImmutableMap.builder();
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NOOB, NoobModel::getModelData);
		EntityRendererRegistry.register(ModEntities.NOOB, NoobRenderer::new);

	}
}