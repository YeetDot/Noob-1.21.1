package com.yeetdot.noob.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.WallSkullBlock;

public class WallNoobSkullBlock extends WallSkullBlock {
    public static final MapCodec<WallNoobSkullBlock> CODEC = createCodec(WallNoobSkullBlock::new);

    public WallNoobSkullBlock(Settings settings) {
        super(SkullBlock.Type.PLAYER, settings);
    }

    @Override
    public MapCodec<? extends WallSkullBlock> getCodec() {
        return CODEC;
    }
}
