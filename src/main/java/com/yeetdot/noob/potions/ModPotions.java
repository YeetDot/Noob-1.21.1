package com.yeetdot.noob.potions;

import com.yeetdot.noob.Noob;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> ALL_EFFECT = register("all_effect", new Potion(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200), new StatusEffectInstance(StatusEffects.RESISTANCE, 1200), new StatusEffectInstance(StatusEffects.SLOWNESS, 1200), new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1200), new StatusEffectInstance(StatusEffects.ABSORPTION, 1200), new StatusEffectInstance(StatusEffects.BAD_OMEN, 1200), new StatusEffectInstance(StatusEffects.BLINDNESS, 1200), new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 1200), new StatusEffectInstance(StatusEffects.DARKNESS, 1200), new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1200), new StatusEffectInstance(StatusEffects.GLOWING, 1200), new StatusEffectInstance(StatusEffects.HASTE, 1200), new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1200), new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 1200), new StatusEffectInstance(StatusEffects.HUNGER, 1200), new StatusEffectInstance(StatusEffects.INFESTED, 1200), new StatusEffectInstance(StatusEffects.INVISIBILITY, 1200), new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1200), new StatusEffectInstance(StatusEffects.LEVITATION, 1200), new StatusEffectInstance(StatusEffects.LUCK, 1200), new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 1200), new StatusEffectInstance(StatusEffects.NAUSEA, 1200), new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200), new StatusEffectInstance(StatusEffects.OOZING, 1200), new StatusEffectInstance(StatusEffects.POISON, 1200), new StatusEffectInstance(StatusEffects.RAID_OMEN, 1200), new StatusEffectInstance(StatusEffects.REGENERATION, 1200), new StatusEffectInstance(StatusEffects.SATURATION, 1200), new StatusEffectInstance(StatusEffects.SPEED, 1200), new StatusEffectInstance(StatusEffects.STRENGTH, 1200), new StatusEffectInstance(StatusEffects.TRIAL_OMEN, 1200), new StatusEffectInstance(StatusEffects.UNLUCK, 1200), new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1200), new StatusEffectInstance(StatusEffects.WEAKNESS, 1200), new StatusEffectInstance(StatusEffects.WEAVING, 1200), new StatusEffectInstance(StatusEffects.WIND_CHARGED, 1200), new StatusEffectInstance(StatusEffects.WITHER, 1200), new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1200), new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1200)));

    private static RegistryEntry<Potion> register(String name, Potion potion) {
//        return Registry.registerReference(Registries.POTION, Identifier.of(Noob.MOD_ID, name), potion);
        return Registry.registerReference(Registries.POTION, Identifier.of(Noob.MOD_ID, name), potion);
    }
}
