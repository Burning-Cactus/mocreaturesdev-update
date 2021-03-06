package drzhark.mocreatures.entity.passive;

import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.entity.MoCEntityTameableAnimal;
import drzhark.mocreatures.entity.ai.MoCAlternateWanderGoal;
import drzhark.mocreatures.registry.MoCSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class MoCEntityTurkey extends MoCEntityTameableAnimal {

    public MoCEntityTurkey(EntityType<? extends MoCEntityTurkey> type, World world) {
        super(type, world);
        this.texture = "turkey.png";
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, Ingredient.of(Items.MELON_SEEDS), false));
        this.goalSelector.addGoal(5, new MoCAlternateWanderGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MoCEntityTameableAnimal.registerAttributes()
                .add(Attributes.MAX_HEALTH, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public void selectType() {
        if (getSubType() == 0) {
            setType(this.random.nextInt(2) + 1);
        }
    }

    @Override
    public ResourceLocation getTexture() {
        if (getSubType() == 1) {
            return MoCreatures.getTexture("turkey.png");
        } else {
            return MoCreatures.getTexture("turkeyfemale.png");
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        return MoCSoundEvents.ENTITY_TURKEY_HURT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return MoCSoundEvents.ENTITY_TURKEY_HURT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return MoCSoundEvents.ENTITY_TURKEY_AMBIENT;
    }

//    @Override TODO
//    protected Item getDropItem() {
//        boolean flag = (this.rand.nextInt(2) == 0);
//        if (flag) {
//            return MoCItems.RAW_TURKEY;
//        }
//        return Items.FEATHER;
//    }

    /*@Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        final Boolean tameResult = this.processTameInteract(player, hand);
        if (tameResult != null) {
            return tameResult;
        }

        final ItemStack stack = player.getHeldItem(hand);
        if (!getIsTamed() && !stack.isEmpty() && (stack.getItem() == Items.MELON_SEEDS)) {
            if (!this.world.isRemote) {
                MoCTools.tameWithName(player, this);
            }

            return true;
        }

        return super.processInteract(player, hand);
    }*/

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.onGround && this.getDeltaMovement().y < 0.0D) {
            this.getDeltaMovement().multiply(1, 0.8D, 1);
        }
    }

    @Override
    public boolean isMyHealFood(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() == Items.PUMPKIN_SEEDS;
    }

    @Override
    public int nameYOffset() {
        return -50;
    }

    @Override
    public int getAmbientSoundInterval() {
        return 400;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 2;
    }
}
