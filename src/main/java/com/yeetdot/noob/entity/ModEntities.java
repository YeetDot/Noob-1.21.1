package com.yeetdot.noob.entity;

import com.yeetdot.noob.Noob;
import com.yeetdot.noob.entity.custom.NoobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<NoobEntity> NOOB = Registry.register(Registries.ENTITY_TYPE, Identifier.of(Noob.MOD_ID, "noob"), EntityType.Builder.create(NoobEntity::new, SpawnGroup.MISC).dimensions(0.6F, 1.8F).build());
}
