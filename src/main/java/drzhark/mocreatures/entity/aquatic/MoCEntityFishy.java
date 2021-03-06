package drzhark.mocreatures.entity.aquatic;

import com.google.common.base.Predicate;
import drzhark.mocreatures.MoCTools;
import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.entity.MoCEntityTameableAquatic;
import drzhark.mocreatures.entity.ai.FleeFromEntityGoal;
import drzhark.mocreatures.entity.ai.MoCPanicGoal;
import drzhark.mocreatures.entity.ai.MoCAlternateWanderGoal;
import drzhark.mocreatures.registry.MoCEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.List;

public class MoCEntityFishy extends MoCEntityTameableAquatic {

    public int gestationtime;

    public static final String fishNames[] = {"Blue", "Orange", "Cyan", "Greeny", "Green", "Purple", "Yellow", "Striped", "Yellowy", "Red"};
    private static final DataParameter<Boolean> HAS_EATEN = EntityDataManager.<Boolean>defineId(MoCEntityFishy.class, DataSerializers.BOOLEAN);
    
    public MoCEntityFishy(EntityType<? extends MoCEntityFishy> type, World world) {
        super(type, world);
        setEdad(50 + this.random.nextInt(50));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MoCPanicGoal(this, 1.3D));
        this.goalSelector.addGoal(3, new FleeFromEntityGoal(this, new Predicate<Entity>() {

            public boolean apply(Entity entity) {
                return (entity.getBbHeight() > 0.3F || entity.getBbWidth() > 0.3F);
            }
        }, 2.0F, 0.6D, 1.5D));
        this.goalSelector.addGoal(5, new MoCAlternateWanderGoal(this, 1.0D, 80));
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MoCEntityTameableAquatic.registerAttributes()
                .add(Attributes.MAX_HEALTH, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D);
    }

    @Override
    public void selectType() {
        if (getSubType() == 0) {
            setType(this.random.nextInt(fishNames.length) + 1);
        }
    }

    @Override
    public ResourceLocation getTexture() {
        switch (getSubType()) {
            case 1:
                return MoCreatures.getTexture("fishy1.png");
            case 2:
                return MoCreatures.getTexture("fishy2.png");
            case 3:
                return MoCreatures.getTexture("fishy3.png");
            case 4:
                return MoCreatures.getTexture("fishy4.png");
            case 5:
                return MoCreatures.getTexture("fishy5.png");
            case 6:
                return MoCreatures.getTexture("fishy6.png");
            case 7:
                return MoCreatures.getTexture("fishy7.png");
            case 8:
                return MoCreatures.getTexture("fishy8.png");
            case 9:
                return MoCreatures.getTexture("fishy9.png");
            case 10:
                return MoCreatures.getTexture("fishy10.png");
            default:
                return MoCreatures.getTexture("fishy1.png");
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HAS_EATEN, Boolean.valueOf(false));
    }

    public boolean getHasEaten() {
        return ((Boolean)this.entityData.get(HAS_EATEN)).booleanValue();
    }

    public void setHasEaten(boolean flag) {
        this.entityData.set(HAS_EATEN, Boolean.valueOf(flag));
    }
    
//    @Override //TODO: Fishy loot table
//    protected void dropFewItems(boolean flag, int x) {
//        int i = this.rand.nextInt(100);
//        if (i < 70) {
//            entityDropItem(new ItemStack(Items.COD, 1, 0), 0.0F);
//        } else {
//            int j = this.rand.nextInt(2);
//            for (int k = 0; k < j; k++) {
//                entityDropItem(new ItemStack(MoCItems.MOCEGG, 1, getType()), 0.0F);
//            }
//
//        }
//    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.isInWater()) {
            this.yBodyRotO = this.yBodyRot = this.yRot = this.yRotO;
            this.xRot = this.xRotO;
        }

        if (!this.level.isClientSide) {

            if (getIsTamed() && this.random.nextInt(100) == 0 && getHealth() < getMaxHealth()) {
                this.setHealth(getMaxHealth());
            }

            if (!ReadyforParenting(this)) {
                return;
            }
            int i = 0;
            List<Entity> list = this.level.getEntities(this, getBoundingBox().expandTowards(4D, 3D, 4D));
            for (int j = 0; j < list.size(); j++) {
                Entity entity = list.get(j);
                if (entity instanceof MoCEntityFishy) {
                    i++;
                }
            }

            if (i > 1) {
                return;
            }
            List<Entity> list1 = this.level.getEntities(this, getBoundingBox().expandTowards(4D, 2D, 4D));
            for (int k = 0; k < list.size(); k++) {
                Entity entity1 = list1.get(k);
                if (!(entity1 instanceof MoCEntityFishy) || (entity1 == this)) {
                    continue;
                }
                MoCEntityFishy entityfishy = (MoCEntityFishy) entity1;
                if (!ReadyforParenting(this) || !ReadyforParenting(entityfishy) || (this.getType() != entityfishy.getType())) {
                    continue;
                }
                if (this.random.nextInt(100) == 0) {
                    this.gestationtime++;
                }
                if (this.gestationtime % 3 == 0) {
//                    MoCMessageHandler.INSTANCE.sendToAllAround(new MoCMessageHeart(this.getEntityId()),
//                            new TargetPoint(this.world.dimension.getType().getId(), this.getPosX(), this.getPosY(), this.getPosZ(), 64));
                }
                if (this.gestationtime <= 50) {
                    continue;
                }
                int l = this.random.nextInt(3) + 1;
                for (int i1 = 0; i1 < l; i1++) {
                    MoCEntityFishy entityfishy1 = new MoCEntityFishy(MoCEntities.FISHY, this.level);
                    entityfishy1.setPos(this.getX(), this.getY(), this.getZ());
                    this.level.addFreshEntity(entityfishy1);
                    MoCTools.playCustomSound(this, SoundEvents.CHICKEN_EGG);
                    setHasEaten(false);
                    entityfishy.setHasEaten(false);
                    this.gestationtime = 0;
                    entityfishy.gestationtime = 0;

                    PlayerEntity entityplayer = this.level.getNearestPlayer(this, 24D);
                    if (entityplayer != null) {
                        MoCTools.tameWithName(entityplayer, entityfishy1);
                    }

                    entityfishy1.setEdad(20);
                    entityfishy1.setAdult(false);
                    entityfishy1.setTypeInt(getSubType());
                }

                break;
            }
        }

    }

    public boolean ReadyforParenting(MoCEntityFishy entityfishy) {
        return false; //TOOD pending overhaul of breeding
    }

    @Override
    protected boolean canBeTrappedInNet() {
        return true;
    }

    @Override
    public int nameYOffset() {
        return -25;
    }

    @Override
    public float rollRotationOffset() {
        if (!this.isInWater()) {
            return -90F;
        }
        return 0F;
    }

    @Override
    protected boolean isFisheable() {
        return !getIsTamed();
    }

    @Override
    protected boolean usesNewAI() {
        return true;
    }

    @Override
    public float getSpeed() {
        return 0.10F;
    }

    @Override
    public boolean isMovementCeased() {
        return !isInWater();
    }

    @Override
    protected double minDivingDepth() {
        return 0.2D;
    }

    @Override
    protected double maxDivingDepth() {
        return 2.0D;
    }

    @Override
    public float getSizeFactor() {
        return getEdad() * 0.01F;
    }
    
    @Override
    public float getAdjustedZOffset() {
        return 0F;
    }

    @Override
    public float getAdjustedXOffset() {
        if (!isInWater()) {
            return -0.1F;
        }
        return 0F;
    }
    
    @Override
    public float getAdjustedYOffset() {
        if (!this.isInWater()) {
            return 0.2F;
        }
        return -0.5F;
    }
}
