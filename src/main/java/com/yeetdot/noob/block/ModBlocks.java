package com.yeetdot.noob.block;

import com.yeetdot.noob.Noob;
import com.yeetdot.noob.block.custom.NoobSkull;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block STAFF_BLOCK = registerBlock("staff_block", new Block(AbstractBlock.Settings.create()));
    public static final Block NOOB_SKULL = registerBlock("noob_skull", new NoobSkull(AbstractBlock.Settings.create()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Noob.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Noob.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(Noob.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Noob.LOGGER.info("Registering ModBlocks for " + Noob.MOD_ID);
    }
}
