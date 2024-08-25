package com.yeetdot.noob.item;

import com.yeetdot.noob.Noob;
import com.yeetdot.noob.block.ModBlocks;
import com.yeetdot.noob.effect.ModPotions;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup NOOB_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Noob.MOD_ID, "noob"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.noob"))
                    .icon(() -> new ItemStack(Blocks.COARSE_DIRT)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.STAFF_BLOCK);
                        entries.add(ModBlocks.NOOB_SKULL);
                        entries.add(ModItems.NOOB_SPAWN_EGG);
                        entries.add(PotionContentsComponent.createStack(Items.POTION, ModPotions.ALL_EFFECT));
                        entries.add(PotionContentsComponent.createStack(Items.SPLASH_POTION, ModPotions.ALL_EFFECT));
                        entries.add(PotionContentsComponent.createStack(Items.LINGERING_POTION, ModPotions.ALL_EFFECT));
                        entries.add(PotionContentsComponent.createStack(Items.POTION, ModPotions.ALL_EFFECT_LONG));
                        entries.add(PotionContentsComponent.createStack(Items.SPLASH_POTION, ModPotions.ALL_EFFECT_LONG));
                        entries.add(PotionContentsComponent.createStack(Items.LINGERING_POTION, ModPotions.ALL_EFFECT_LONG));
                    }).build());


    public static void RegisterItemGroups() {
        Noob.LOGGER.info("Registering Item Groups For " + Noob.MOD_ID);
    }
}
