package com.yeetdot.noob;

import com.yeetdot.noob.block.ModBlocks;
import com.yeetdot.noob.block.entity.ModBlockEntities;
import com.yeetdot.noob.block.entity.ModBlockEntityType;
import com.yeetdot.noob.entity.ModEntities;
import com.yeetdot.noob.entity.custom.NoobEntity;
import com.yeetdot.noob.item.ModItemGroups;
import com.yeetdot.noob.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Noob implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("noob");
	public static final String MOD_ID = "noob";

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.RegisterItemGroups();
		ModBlocks.registerModBlocks();
		ModBlockEntities.RegisterModBlockEntities();
		ModBlockEntityType.RegisterModBlockEntities();
		LOGGER.info("Hello Fabric world!");

		FabricDefaultAttributeRegistry.register(ModEntities.NOOB, NoobEntity.createNoobAttributes());
	}
}