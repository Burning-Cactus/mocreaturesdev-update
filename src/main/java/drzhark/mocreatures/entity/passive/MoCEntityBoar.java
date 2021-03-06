package drzhark.mocreatures.entity.passive;

import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.configuration.MoCConfig;
import drzhark.mocreatures.entity.MoCEntityAnimal;
import drzhark.mocreatures.entity.ai.FleeFromPlayerGoal;
import drzhark.mocreatures.entity.ai.FollowAdultGoal;
import drzhark.mocreatures.entity.ai.HuntGoal;
import drzhark.mocreatures.entity.ai.MoCAlternateWanderGoal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class MoCEntityBoar extends MoCEntityAnimal {

    public MoCEntityBoar(EntityType<? extends MoCEntityBoar> type, World world) {
        super(type, world);
        setEdad(this.random.nextInt(15) + 45);
        if (this.random.nextInt(4) == 0) {
            setAdult(false);

        } else {
            setAdult(true);
        }
    }
    
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new FleeFromPlayerGoal(this, 1.0D, 4D));
        this.goalSelector.addGoal(3, new FollowAdultGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(7, new MoCAlternateWanderGoal(this, 1.0D));
        this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(1, new HuntGoal(this, AnimalEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MoCEntityAnimal.registerAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    @Override
    public ResourceLocation getTexture() {
        if (getIsAdult()) {
            return MoCreatures.getTexture("boara.png");
        }
        return MoCreatures.getTexture("boarb.png");

    }

    @Override
    public boolean removeWhenFarAway(double d) {
        if (MoCConfig.COMMON_CONFIG.GLOBAL.forceDespawns.get()) {
            return !getIsTamed();
        } else {
            return false;
        }
    }

    @Override
    public boolean hurt(DamageSource damagesource, float i) {
        if (super.hurt(damagesource, i)) {
            Entity entity = damagesource.getEntity();
            if (this.hasIndirectPassenger(entity)) {
                return true;
            }
            if ((entity != this && entity instanceof LivingEntity) && super.shouldAttackPlayers() && getIsAdult()) {
                setTarget((LivingEntity) entity);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isNotScared() {
        return getIsAdult();
    }

//    @Override
//    protected Item getDropItem() {
//
//        if (this.rand.nextInt(2) == 0) {
//            return Items.PORKCHOP;
//        }
//
//        return MoCItems.animalHide;
//    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.PIG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PIG_DEATH;
    }

    @Override
    public boolean canAttackTarget(LivingEntity entity) {
        return !(entity instanceof MoCEntityBoar) && super.canAttackTarget(entity);
    }

    @Override
    public boolean isReadyToHunt() {
        return this.getIsAdult() && !this.isMovementCeased();
    }

    @Override
    public boolean renderName() {
        return false;
    }

    @Override
    public float getSizeFactor() {
        if (getIsAdult()) {
            return 1F;
        }
        return getEdad() * 0.01F;
    }

}
