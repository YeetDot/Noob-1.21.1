package com.yeetdot.noob.block.entity;

import com.mojang.datafixers.types.Type;
import com.yeetdot.noob.Noob;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;

public class ModBlockEntityType implements FabricBlockEntityType {
    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, BlockEntityType.Builder<T> builder){
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, name, builder.build(type));
    }

    public static void RegisterModBlockEntities() {
        Noob.LOGGER.info("Registering Block Entities for " + Noob.MOD_ID);
    }
}
