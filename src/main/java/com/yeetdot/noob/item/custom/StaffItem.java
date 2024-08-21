package com.yeetdot.noob.item.custom;

import com.yeetdot.noob.block.ModBlocks;
import com.yeetdot.noob.entity.ModEntities;
import com.yeetdot.noob.entity.custom.NoobEntity;
import com.yeetdot.noob.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class StaffItem extends Item {
    public StaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = player.getWorld();
        if(!(world instanceof ServerWorld)){
            return ActionResult.SUCCESS;
        } else if (world.getBlockState(context.getBlockPos()).isOf(ModBlocks.STAFF_BLOCK)){
            if (world.getBlockState(context.getBlockPos().offset(Direction.DOWN, 1)).isOf(Blocks.BLUE_WOOL)) {
                ModEntities.NOOB.spawn((ServerWorld) context.getWorld(), context.getBlockPos(), SpawnReason.STRUCTURE);
                world.breakBlock(context.getBlockPos(), false);
                world.breakBlock(context.getBlockPos().offset(Direction.DOWN, 1), false);
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }
}
