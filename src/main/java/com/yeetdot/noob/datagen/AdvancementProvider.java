package com.yeetdot.noob.datagen;

import com.yeetdot.noob.block.ModBlocks;
import com.yeetdot.noob.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AdvancementProvider extends FabricAdvancementProvider {
    public AdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.STAFF,
                        Text.translatable("advancement.noob.root.title"),
                        Text.translatable("advancement.noob.root.description"),
                        Identifier.of("textures/block/quartz_pillar.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("has_staff", InventoryChangedCriterion.Conditions.items(ModItems.STAFF))
                .build(consumer, "noob" + "/root");

        AdvancementEntry gotStaffBlock = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.STAFF,
                        Text.translatable("advancement.noob.has_staff_block.title"),
                        Text.translatable("advancement.noob.has_staff_block.description"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100000))
                .criterion("has_staff_block", InventoryChangedCriterion.Conditions.items(ModBlocks.STAFF_BLOCK))
                .build(consumer, "noob" + "/has_staff_block");
    }


}
