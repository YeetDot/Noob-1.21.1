package com.yeetdot.noob.entity.client;

import com.yeetdot.noob.Noob;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer NOOB =
            new EntityModelLayer(Identifier.of(Noob.MOD_ID, "noob"), "main");
}
