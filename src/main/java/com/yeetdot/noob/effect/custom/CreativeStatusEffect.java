package com.yeetdot.noob.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;

public class CreativeStatusEffect extends StatusEffect {
    public CreativeStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration < 2;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity player && !player.isSpectator()) {
            player.changeGameMode(GameMode.SURVIVAL);
        } else {
            entity.setInvulnerable(false);
        }
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity player && !player.isSpectator()) {
            player.changeGameMode(GameMode.CREATIVE);
        } else {
            entity.setInvulnerable(true);
        }
    }

}
