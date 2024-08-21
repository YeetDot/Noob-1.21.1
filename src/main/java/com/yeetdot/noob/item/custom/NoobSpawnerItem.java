package com.yeetdot.noob.item.custom;

import com.yeetdot.noob.block.ModBlocks;
import com.yeetdot.noob.entity.ModEntities;
import com.yeetdot.noob.entity.custom.NoobEntity;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.minecraft.block.CarvedPumpkinBlock.breakPatternBlocks;
import static net.minecraft.block.CarvedPumpkinBlock.updatePatternBlocks;

public class NoobSpawnerItem extends Item {
    public NoobSpawnerItem(Settings settings) {
        super(settings);
    }
    private BlockPattern noobPattern;

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = player.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockPattern.Result result = this.getNoobPattern().searchAround(world, pos);
        if (result != null){
            NoobEntity noob = ModEntities.NOOB.create(world);
            if (noob != null){
                noob.setStackInHand(noob.getActiveHand(), new ItemStack(Items.TROPICAL_FISH));
                spawnEntity(world, result, noob, result.translate(0, 2, 0).getBlockPos());
            }
        }
        return ActionResult.PASS;
    }

    private static void spawnEntity(World world, BlockPattern.Result patternResult, Entity entity, BlockPos pos) {
        breakPatternBlocks(world, patternResult);
        entity.refreshPositionAndAngles((double)pos.getX() + 0.5, (double)pos.getY() + 0.05, (double)pos.getZ() + 0.5, 0.0F, 0.0F);
        world.spawnEntity(entity);

        for (ServerPlayerEntity serverPlayerEntity : world.getNonSpectatingEntities(ServerPlayerEntity.class, entity.getBoundingBox().expand(5.0))) {
            Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, entity);
        }

        updatePatternBlocks(world, patternResult);
    }

    private BlockPattern getNoobPattern() {
        if (this.noobPattern == null) {
            this.noobPattern = BlockPatternBuilder.start()
                    .aisle("^", "#", "#")
                    .where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(ModBlocks.NOOB_SKULL)))
                    .where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.COARSE_DIRT)))
                    .build();
        }

        return this.noobPattern;
    }
}
