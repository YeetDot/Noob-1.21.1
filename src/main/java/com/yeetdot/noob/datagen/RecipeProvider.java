package com.yeetdot.noob.datagen;

import com.yeetdot.noob.block.ModBlocks;
import com.yeetdot.noob.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STAFF_BLOCK, 1)
                .pattern(" SS")
                .pattern("S S")
                .pattern("SS ")
                .input('S', ModItems.STAFF)
                .criterion(hasItem(ModItems.STAFF), InventoryChangedCriterion.Conditions.items(ModItems.STAFF))
                .group("staff_block")
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.STAFF_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STAFF_BLOCK, 1)
                .pattern("SS ")
                .pattern("S S")
                .pattern(" SS")
                .group("staff_block")
                .input('S', ModItems.STAFF)
                .criterion(hasItem(ModItems.STAFF), InventoryChangedCriterion.Conditions.items(ModItems.STAFF))
                .offerTo(exporter, Identifier.of("secondary_staff_block"));

        offerShapelessRecipe(exporter, ModItems.STAFF, ModBlocks.STAFF_BLOCK, null, 6);
    }
}
