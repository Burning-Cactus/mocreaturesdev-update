package drzhark.mocreatures.entity.monster;

import drzhark.mocreatures.entity.MoCEntityMob;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MoCEntitySilverSkeleton extends MoCEntityMob {

    public int attackCounterLeft;
    public int attackCounterRight;

    public MoCEntitySilverSkeleton(EntityType<? extends MoCEntitySilverSkeleton> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MoCEntityMob.registerAttributes()
                .func_233815_a_(Attributes.MAX_HEALTH, 25.0D)
                .func_233815_a_(Attributes.MOVEMENT_SPEED, 0.25D)
                .func_233815_a_(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    @Override
    public void livingTick() {
        if (!this.world.isRemote) {
            setSprinting(this.getAttackTarget() != null);
        }

        if (this.attackCounterLeft > 0 && ++this.attackCounterLeft > 10) {
            this.attackCounterLeft = 0;
        }

        if (this.attackCounterRight > 0 && ++this.attackCounterRight > 10) {
            this.attackCounterRight = 0;
        }

        super.livingTick();
    }
//
//    @Override TODO loot tables
//    protected Item getDropItem() {
//        if (this.rand.nextInt(10) == 0) {
//            return MoCItems.SILVERSWORD;
//        }
//        return Items.BONE;
//    }

    @Override
    public void performAnimation(int animationType) {

        if (animationType == 1) //left arm
        {
            this.attackCounterLeft = 1;
        }
        if (animationType == 2) //right arm
        {
            this.attackCounterRight = 1;
        }
    }

    /**
     * Starts attack counters and synchronizes animations with clients
     */
    private void startAttackAnimation() {
        if (!this.world.isRemote) {
            boolean leftArmW = this.rand.nextInt(2) == 0;

            if (leftArmW) {
                this.attackCounterLeft = 1;
//                MoCMessageHandler.INSTANCE.sendToAllAround(new MoCMessageAnimation(this.getEntityId(), 1),
//                        new TargetPoint(this.world.dimension.getType().getId(), this.getPosX(), this.getPosY(), this.getPosZ(), 64));
            } else {
                this.attackCounterRight = 1;
//                MoCMessageHandler.INSTANCE.sendToAllAround(new MoCMessageAnimation(this.getEntityId(), 2),
//                        new TargetPoint(this.world.dimension.getType().getId(), this.getPosX(), this.getPosY(), this.getPosZ(), 64));
            }
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        startAttackAnimation();
        return super.attackEntityAsMob(entityIn);
    }

    @Override
    public float getAIMoveSpeed() {
        if (isSprinting()) {
            return 0.35F;
        }
        return 0.2F;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.UNDEAD;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState block) {
        this.playSound(SoundEvents.ENTITY_SKELETON_STEP, 0.15F, 1.0F);
    }

    @Override
    protected boolean isHarmedByDaylight() {
        return true;
    }
}
