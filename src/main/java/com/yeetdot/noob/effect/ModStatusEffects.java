package com.yeetdot.noob.effect;

import com.yeetdot.noob.Noob;
import com.yeetdot.noob.effect.custom.CreativeStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final RegistryEntry<StatusEffect> CREATIVITY = register("creativity", new CreativeStatusEffect(StatusEffectCategory.BENEFICIAL, 16777215));

    public static RegistryEntry<StatusEffect> register(String name, StatusEffect effect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Noob.MOD_ID, name), effect);
    }

    public static void registerStatusEffects() {
        Noob.LOGGER.info("Registering Status Effects for " + Noob.MOD_ID);
    }
}
