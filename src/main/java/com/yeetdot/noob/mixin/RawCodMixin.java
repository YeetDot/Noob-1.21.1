package com.yeetdot.noob.mixin;

import com.yeetdot.noob.Noob;
import com.yeetdot.noob.item.custom.NoobSpawnerItem;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Items.class)
public class RawCodMixin {
	@Final
	@Shadow
	public static final Item COD = Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.ofVanilla("cod")),
			new NoobSpawnerItem(new Item.Settings().food(FoodComponents.COD)));
}