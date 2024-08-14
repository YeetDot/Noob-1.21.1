package com.yeetdot.noob;

import com.yeetdot.noob.entity.ModEntities;
import com.yeetdot.noob.entity.client.ModModelLayers;
import com.yeetdot.noob.entity.client.NoobModel;
import com.yeetdot.noob.entity.client.NoobRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class NoobClient implements ClientModInitializer {
    @Override
	public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NOOB, NoobModel::getModelData);
		EntityRendererRegistry.register(ModEntities.NOOB, NoobRenderer::new);

	}
}