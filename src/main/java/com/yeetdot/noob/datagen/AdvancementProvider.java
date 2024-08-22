package com.yeetdot.noob.datagen;

import com.yeetdot.noob.Noob;
import com.yeetdot.noob.block.ModBlocks;
import com.yeetdot.noob.entity.ModEntities;
import com.yeetdot.noob.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
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
                        Items.DIRT,
                        Text.translatable("advancement.noob.root.title"),
                        Text.translatable("advancement.noob.root.description"),
                        Identifier.of("textures/block/quartz_pillar.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        true
                )
                .criterion("has_dirt", InventoryChangedCriterion.Conditions.items(Items.DIRT))
                .build(consumer, Noob.MOD_ID + "/root");

        AdvancementEntry HasRawFish = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.COD,
                        Text.translatable("advancement.noob.has_staff_block.title"),
                        Text.translatable("advancement.noob.has_raw_fish.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("has_raw_cod", InventoryChangedCriterion.Conditions.items(Items.COD))
                .criterion("has_raw_salmon", InventoryChangedCriterion.Conditions.items(Items.SALMON))
                .criterion("has_raw_tropical_fish", InventoryChangedCriterion.Conditions.items(Items.TROPICAL_FISH))
                .criterion("has_raw_pufferfish", InventoryChangedCriterion.Conditions.items(Items.PUFFERFISH))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR)
                .build(consumer, Noob.MOD_ID + "/has_raw_fish");

        AdvancementEntry killNoob = Advancement.Builder.create().parent(HasRawFish)
                .display(
                        ModBlocks.NOOB_SKULL,
                        Text.translatable("advancement.noob.kill_noob.title"),
                        Text.translatable("advancement.noob.kill_noob.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("kill_noob", OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(ModEntities.NOOB)))
                .build(consumer, Noob.MOD_ID + "/kill_noob");
    }


}
