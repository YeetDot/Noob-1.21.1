package com.yeetdot.noob.block.custom;

import net.minecraft.block.SkullBlock;

public enum Type implements SkullBlock.SkullType {
    NOOB("noob");

    private final String id;

    Type(final String id) {
        this.id = id;
        TYPES.put(id, this);
    }

    public String asString() {
        return this.id;
    }
}
