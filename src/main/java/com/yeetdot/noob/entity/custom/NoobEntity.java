package com.yeetdot.noob.entity.custom;

import com.yeetdot.noob.effect.ModPotions;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class NoobEntity extends HostileEntity implements RangedAttackMob {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;

    public NoobEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 20;

    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            setUpAnimationStates();
        }
    }

    private void setUpAnimationStates() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationCooldown--;
        }
    }


    @Override
    protected void updateLimbs(float posDelta) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(posDelta * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(3, new AttackGoal(this));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge(ZombifiedPiglinEntity.class));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.add(2, new ProjectileAttackGoal(this, 1.0, 60, 100.0F));
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return true;
    }

    public static DefaultAttributeContainer.Builder createNoobAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, Double.MAX_VALUE)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35F)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, Double.MAX_VALUE);
    }


    @Override
    public void shootAt(LivingEntity target, float pullProgress) {
        Vec3d vec3d = target.getVelocity();
        double d = target.getX() + vec3d.x - this.getX();
        double e = target.getEyeY() - 1.1F - this.getY();
        double f = target.getZ() + vec3d.z - this.getZ();
        double g = Math.sqrt(d * d + f * f);
        RegistryEntry<Potion> effect = ModPotions.ALL_EFFECT;
        PotionEntity potionEntity = new PotionEntity(this.getWorld(), this);
        potionEntity.setItem(PotionContentsComponent.createStack(Items.SPLASH_POTION, effect));
        potionEntity.setPitch(potionEntity.getPitch() - -20.0F);
        potionEntity.setVelocity(d, e + g * 0.2, f, 75F, 8.0F);
        if (!this.isSilent()) {
            this.getWorld()
                    .playSound(
                            null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_WITCH_THROW, this.getSoundCategory(), 1.0F, 0.8F + this.random.nextFloat() * 0.4F
                    );
        }
        this.getWorld().spawnEntity(potionEntity);
    }
}
