package drzhark.mocreatures.entity.passive;

import drzhark.mocreatures.MoCTools;
import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.configuration.MoCConfig;
import drzhark.mocreatures.entity.MoCEntityTameableAnimal;
import drzhark.mocreatures.entity.ai.FleeFromPlayerGoal;
import drzhark.mocreatures.entity.ai.HuntGoal;
import drzhark.mocreatures.entity.ai.MoCPanicGoal;
import drzhark.mocreatures.entity.ai.MoCAlternateWanderGoal;
import drzhark.mocreatures.registry.MoCItems;
import drzhark.mocreatures.registry.MoCSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

/**
 * Biome - specific Forest Desert plains Swamp Jungle Tundra Taiga Extreme Hills
 * Ocean
 *
 * swamp: python, bright green, #1 plains: coral, cobra #1, #2, #3, #4 desert:
 * rattlesnake , #2 jungle: all except rattlesnake hills: all except python,
 * bright green, bright orange tundra-taiga: none ocean: leave alone
 *
 */

public class MoCEntitySnake extends MoCEntityTameableAnimal {

    private float fTongue;
    private float fMouth;
    private boolean isBiting;
    private float fRattle;
    private boolean isPissed;
    private int hissCounter;

    private int movInt;
    private boolean isNearPlayer;
    public float bodyswing;

    public static final String[] snakeNames = {"Dark", "Spotted", "Orange", "Green", "Coral", "Cobra", "Rattle", "Python"};

    public MoCEntitySnake(EntityType<? extends MoCEntitySnake> type, World world) {
        super(type, world);
        this.bodyswing = 2F;
        this.movInt = this.random.nextInt(10);
        setEdad(50 + this.random.nextInt(50));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MoCPanicGoal(this, 0.8D));
        this.goalSelector.addGoal(3, new FleeFromPlayerGoal(this, 0.8D, 4D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new MoCAlternateWanderGoal(this, 0.8D, 30));
        this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(1, new HuntGoal(this, AnimalEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MoCEntityTameableAnimal.registerAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public void selectType() {
        checkSpawningBiome();
        // snake types:
        // 1 small blackish/dark snake (passive)
        // 2 dark green /brown snake (passive)
        // 3 bright orangy snake aggressive venomous swamp, jungle, forest
        // 4 bright green snake aggressive venomous swamp, jungle, forest
        // 5 coral (aggressive - venomous) small / plains, forest
        // 6 cobra (aggressive - venomous - spitting) plains, forest
        // 7 rattlesnake (aggressive - venomous) desert
        // 8 python (aggressive - non venomous) big - swamp
        // 9 sea snake (aggressive - venomous)
        if (getSubType() == 0) {
            setType(this.random.nextInt(8) + 1);
        }
    }

    @Override
    public ResourceLocation getTexture() {
        switch (getSubType()) {
            case 1:
                return MoCreatures.getTexture("snake1.png");
            case 2:
                return MoCreatures.getTexture("snake2.png");
            case 3:
                return MoCreatures.getTexture("snake3.png");
            case 4:
                return MoCreatures.getTexture("snake4.png");
            case 5:
                return MoCreatures.getTexture("snake5.png");
            case 6:
                return MoCreatures.getTexture("snake6.png");
            case 7:
                return MoCreatures.getTexture("snake7.png");
            case 8:
                return MoCreatures.getTexture("snake8.png");
            default:
                return MoCreatures.getTexture("snake1.png");
        }
    }

    @Override
    public boolean onClimbable() {
        return this.horizontalCollision;
    }

    @Override
    // snakes can't jump
            protected
            void jumpFromGround() {
        if (this.isInWater()) {
            super.jumpFromGround();
        }
    }

    @Override
    public boolean removeWhenFarAway(double d) {
        if (MoCConfig.COMMON_CONFIG.GLOBAL.forceDespawns.get()) {
            return !getIsTamed();
        } else {
            return false;
        }
    }

    public boolean pickedUp() {
        return (this.getVehicle() != null);
    }

    /*@Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        final Boolean tameResult = this.processTameInteract(player, hand);
        if (tameResult != null) {
            return tameResult;
        }

        if (!getIsTamed()) {
            return false;
        }

        if (this.getRidingEntity() == null) {
            if (this.startRiding(player)) {
                this.rotationYaw = player.rotationYaw;
            }

            return true;
        }

        return super.processInteract(player, hand);
    }*/

    @Override
    public boolean isNotScared() {
        return getSubType() > 2 && getEdad() > 50;
    }

    /**
     * returns true when is climbing up
     *
     * @return
     */
    public boolean isClimbing() {
        return onClimbable() && this.getDeltaMovement().y > 0.01F;
    }

    public boolean isResting() {
        return (!getNearPlayer() && this.onGround && (this.getDeltaMovement().x < 0.01D && this.getDeltaMovement().x > -0.01D) && (this.getDeltaMovement().z < 0.01D && this.getDeltaMovement().z > -0.01D));
    }

    public boolean getNearPlayer() {
        return (this.isNearPlayer || this.isBiting());
    }

    public int getMovInt() {
        return this.movInt;
    }

    @Override
    public boolean swimmerEntity() {
        return false;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    public void setNearPlayer(boolean flag) {
        this.isNearPlayer = flag;
    }

    @Override
    public double getMyRidingOffset() {
        if (this.getVehicle() instanceof PlayerEntity) {
            return 0.1F;
        }

        return super.getMyRidingOffset();
    }

    public float getSizeF() {
        float factor = 1.0F;
        if (getSubType() == 1 || getSubType() == 2)// small shy snakes
        {
            factor = 0.8F;
        } else if (getSubType() == 5)// coral
        {
            factor = 0.6F;
        }
        if (getSubType() == 6)// cobra 1.1
        {
            factor = 1.1F;
        }
        if (getSubType() == 7)// rattlesnake
        {
            factor = 0.9F;
        }
        if (getSubType() == 8)// python
        {
            factor = 1.5F;
        }
        return this.getEdad() * 0.01F * factor;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level.isClientSide) {
            if (getfTongue() != 0.0F) {
                setfTongue(getfTongue() + 0.2F);
                if (getfTongue() > 8.0F) {
                    setfTongue(0.0F);
                }
            }

            if (getfMouth() != 0.0F && this.hissCounter == 0) //biting
            {
                setfMouth(getfMouth() + 0.1F);
                if (getfMouth() > 0.5F) {
                    setfMouth(0.0F);
                }
            }

            if (getSubType() == 7 && getfRattle() != 0.0F) // rattling
            {
                setfRattle(getfRattle() + 0.2F);
                if (getfRattle() == 1.0F) {
                    // TODO synchronize
                    MoCTools.playCustomSound(this, MoCSoundEvents.ENTITY_SNAKE_RATTLE);
                }
                if (getfRattle() > 8.0F) {
                    setfRattle(0.0F);
                }
            }

            /**
             * stick tongue
             */
            if (this.random.nextInt(50) == 0 && getfTongue() == 0.0F) {
                setfTongue(0.1F);
            }

            /**
             * Open mouth
             */
            if (this.random.nextInt(100) == 0 && getfMouth() == 0.0F) {
                setfMouth(0.1F);
            }
            if (getSubType() == 7) {
                int chance = 0;
                if (getNearPlayer()) {
                    chance = 30;
                } else {
                    chance = 100;
                }

                if (this.random.nextInt(chance) == 0) {
                    setfRattle(0.1F);
                }
            }
            /**
             * change in movement pattern
             */
            if (!isResting() && !pickedUp() && this.random.nextInt(50) == 0) {
                this.movInt = this.random.nextInt(10);
            }

            /**
             * Biting animation
             */
            if (isBiting()) {
                this.bodyswing -= 0.5F;
                setfMouth(0.3F);

                if (this.bodyswing < 0F) {
                    MoCTools.playCustomSound(this, MoCSoundEvents.ENTITY_SNAKE_SNAP);
                    this.bodyswing = 2.5F;
                    setfMouth(0.0F);
                    setBiting(false);
                }
            }

        }
        if (pickedUp()) {
            this.movInt = 0;
        }

        if (isResting()) {

            this.yBodyRotO = this.yBodyRot = this.yRot = this.yRotO;

        }

        if (!this.onGround && (this.getVehicle() != null)) {
            this.yRot = this.getVehicle().yRot;// -90F;
        }

        if (this.level.getDifficulty().getId() > 0 && getNearPlayer() && !getIsTamed() && isNotScared()) {

            this.hissCounter++;

            // TODO synchronize and get sound
            // hiss
            if (this.hissCounter % 25 == 0) {
                setfMouth(0.3F);
                MoCTools.playCustomSound(this, MoCSoundEvents.ENTITY_SNAKE_ANGRY);
            }
            if (this.hissCounter % 35 == 0) {
                setfMouth(0.0F);
            }

            if (this.hissCounter > 100 && this.random.nextInt(50) == 0) {
                // then randomly get pissed
                setPissed(true);
                this.hissCounter = 0;
            }
        }
        if (this.hissCounter > 500) {
            this.hissCounter = 0;
        }

    }

    /**
     * from 0.0 to 4.0F 0.0 = inside mouth 2.0 = completely stuck out 3.0 =
     * returning 4.0 = in.
     *
     * @return
     */
    public float getfTongue() {
        return this.fTongue;
    }

    public void setfTongue(float fTongue) {
        this.fTongue = fTongue;
    }

    public float getfMouth() {
        return this.fMouth;
    }

    public void setfMouth(float fMouth) {
        this.fMouth = fMouth;
    }

    public float getfRattle() {
        return this.fRattle;
    }

    public void setfRattle(float fRattle) {
        this.fRattle = fRattle;
    }

    @Override
    public void aiStep() {
        super.aiStep();

        /**
         * this stops chasing the target randomly
         */
        if (getTarget() != null && this.random.nextInt(300) == 0) {
            setTarget(null);
        }

        PlayerEntity entityplayer1 = this.level.getNearestPlayer(this, 12D);
        if (entityplayer1 != null) {
            double distP = MoCTools.getSqDistanceTo(entityplayer1, this.getX(), this.getY(), this.getZ());
            if (isNotScared()) {
                if (distP < 5D) {
                    setNearPlayer(true);
                } else {
                    setNearPlayer(false);
                }

                /*if (entityplayer1.isBeingRidden()
                        && (entityplayer1.riddenByEntity instanceof MoCEntityMouse || entityplayer1.riddenByEntity instanceof MoCEntityBird)) {
                    PathEntity pathentity = this.navigator.getPathToEntityLiving(entityplayer1);
                    this.navigator.setPath(pathentity, 16F);
                    setPissed(false);
                    this.hissCounter = 0;
                }*/
            } else {
                setNearPlayer(false);
            }

        } else {
            setNearPlayer(false);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if ((getSubType() < 3 || getIsTamed()) && entityIn instanceof PlayerEntity) {
            return false;
        }

        if (entityIn instanceof PlayerEntity && !shouldAttackPlayers()) {
            return false;
        }
        setBiting(true);
        return super.doHurtTarget(entityIn);
    }

    @Override
    public void performAnimation(int i) {
        setBiting(true);
    }

    public boolean isBiting() {
        return this.isBiting;
    }

    public void setBiting(boolean flag) {
//        if (flag && !this.world.isRemote) {
//            MoCMessageHandler.INSTANCE.sendToAllAround(new MoCMessageAnimation(this.getEntityId(), 0),
//                    new TargetPoint(this.world.dimension.getType().getId(), this.getPosX(), this.getPosY(), this.getPosZ(), 64));
//        }
        this.isBiting = flag;
    }

    public boolean isPissed() {
        return this.isPissed;
    }

    public void setPissed(boolean isPissed) {
        this.isPissed = isPissed;
    }

    @Override
    public boolean hurt(DamageSource damagesource, float i) {

        if (getSubType() < 3) {
            return super.hurt(damagesource, i);
        }

        if (super.hurt(damagesource, i)) {
            Entity entity = damagesource.getEntity();
            if (this.hasIndirectPassenger(entity)) {
                return true;
            }
            if ((entity != this) && entity instanceof LivingEntity && (super.shouldAttackPlayers())) {
                setPissed(true);
                setTarget((LivingEntity) entity);
            }
            return true;
        } else {
            return false;
        }
    }

//    @Override TODO
//    protected void dropFewItems(boolean flag, int x) {
//        if (getEdad() > 60) {
//            int j = this.rand.nextInt(3);
//            for (int l = 0; l < j; l++) {
//
//                entityDropItem(new ItemStack(MoCItems.MOCEGG, 1, getSubType() + 20), 0.0F);
//            }
//        }
//    }

    @Override
    public boolean canAttackTarget(LivingEntity entity) {
        return !(entity instanceof MoCEntitySnake) && entity.getBbHeight() < 0.5D && entity.getBbWidth() < 0.5D;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockState) {
        if (isInWater()) {
            MoCTools.playCustomSound(this, MoCSoundEvents.ENTITY_SNAKE_SWIM);
        }
        // TODO - add sound for slither
        /*
         * else { world.playSoundAtEntity(this, "snakeslither", 1.0F, 1.0F);
         * }
         */
    }

    @Override
    protected SoundEvent getDeathSound() {
        return MoCSoundEvents.ENTITY_SNAKE_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return MoCSoundEvents.ENTITY_SNAKE_HURT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return MoCSoundEvents.ENTITY_SNAKE_AMBIENT;
    }

    @Override
    public boolean checkSpawnRules(IWorld worldIn, SpawnReason reason) {
        return getCanSpawnHereCreature() && getCanSpawnHereLiving(); //&& checkSpawningBiome()
    }

//    @Override
//    public boolean checkSpawningBiome() {
//        BlockPos pos = new BlockPos(MathHelper.floor(this.getPosX()), MathHelper.floor(getBoundingBox().minY), this.getPosZ());
//        /**
//         * swamp: python, bright green, #1 (done) plains: coral, cobra #1, #2,
//         * #3, #4 (everyone but 7) desert: rattlesnake , #2 jungle: all except
//         * rattlesnake forest: all except rattlesnake hills: all except python,
//         * bright green, bright orange, rattlesnake tundra-taiga: none ocean:
//         * leave alone
//         */
//
//        /**
//         * Biome lists: Ocean Plains Desert Extreme Hills Forest Taiga Swampland
//         * River Frozen Ocean Frozen River Ice Plains Ice Mountains Mushroom
//         * Island Mushroom Island Shore Beach DesertHills ForestHills TaigaHills
//         * Extreme Hills Edge Jungle JungleHills
//         *
//         */
//        try {
//            Biome currentbiome = MoCTools.Biomekind(this.world, pos);
//            int l = this.rand.nextInt(10);
//
//            if (BiomeDictionary.hasType(currentbiome, Type.SNOWY)) {
//                return false;
//            }
//
//            if (BiomeDictionary.hasType(currentbiome, Type.SANDY)) {
//                if (l < 5) {
//                    setType(7); // rattlesnake or spotted brownish ?
//                } else {
//                    setType(2);
//                }
//            }
//
//            if (getSubType() == 7 && !(BiomeDictionary.hasType(currentbiome, Type.SANDY))) {
//                setType(2);
//            }
//            if (BiomeDictionary.hasType(currentbiome, Type.HILLS)) {
//                if (l < 4) {
//                    setType(1);
//                } else if (l < 7) {
//                    setType(5);
//                } else {
//                    setType(6);
//                }
//            }
//            if (BiomeDictionary.hasType(currentbiome, Type.SWAMP)) {
//                // python or bright green bright orange
//                if (l < 4) {
//                    setType(8);
//                } else if (l < 8) {
//                    setType(4);
//                } else {
//                    setType(1);
//                }
//            }
//        } catch (Exception e) {
//        }
//        return true;
//    }

    @Override
    public int nameYOffset() {
        return -30;
    }

    @Override
    public boolean isMyHealFood(ItemStack stack) {
        return !stack.isEmpty() && (stack.getItem() == MoCItems.RAT_RAW);
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 2;
    }

    @Override
    public boolean isReadyToHunt() {
        return this.getIsAdult() && !this.isMovementCeased();
    }

    @Override
    public void doEnchantDamageEffects(LivingEntity entityLivingBaseIn, Entity entityIn) {
        if (isVenomous()) {
            if (entityIn instanceof PlayerEntity) {
                MoCreatures.poisonPlayer((PlayerEntity) entityIn);
            }
            ((LivingEntity) entityIn).addEffect(new EffectInstance(Effects.POISON, 150, 2));
        }
        super.doEnchantDamageEffects(entityLivingBaseIn, entityIn);
    }

    private boolean isVenomous() {
        return getSubType() == 3 || getSubType() == 4 || getSubType() == 5 || getSubType() == 6 || getSubType() == 7 || getSubType() == 9;
    }

    @Override
    public boolean shouldAttackPlayers() {
        return this.isPissed() && super.shouldAttackPlayers();
    }

    @Override
    public int getAmbientSoundInterval() {
        return 400;
    }

    @Override
    public boolean isAmphibian() {
        return true;
    }

    @Override
    public boolean canRidePlayer()
    {
        return true;
    }

     @Override
     protected double maxDivingDepth()
     {
         return 1D * (this.getEdad()/100D);
     }
}
