package com.yeetdot.noob.item;

import com.yeetdot.noob.Noob;
import com.yeetdot.noob.entity.ModEntities;
import com.yeetdot.noob.item.custom.NoobSpawnerItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;

public class ModItems {

    public static final Item STAFF = registerItem("staff", new NoobSpawnerItem(new Item.Settings()));
    public static final Item NOOB_SPAWN_EGG = registerItem("noob_spawn_egg", new SpawnEggItem(ModEntities.NOOB, ColorHelper.Argb.fromFloats(255, 65, 200, 240), ColorHelper.Argb.fromFloats(255, 10, 40, 230), new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Noob.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Noob.LOGGER.info("Registering Mod Items for " + Noob.MOD_ID);
    }
}
