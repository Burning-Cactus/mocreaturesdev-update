package drzhark.mocreatures.entity.passive;

import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.entity.IMoCTameable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MoCEntityLiger extends MoCEntityBigCat {

    public MoCEntityLiger(EntityType<? extends MoCEntityLiger> type, World world) {
        super(type, world);
    }

    @Override
    public void selectType() {
        if (getSubType() == 0) {
            setType(1);
    }
        super.selectType();
    }

    @Override
    public ResourceLocation getTexture() {
        return MoCreatures.getTexture("bcliger.png");
    }

    /*@Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        final Boolean tameResult = this.processTameInteract(player, hand);
        if (tameResult != null) {
            return tameResult;
        }

        final ItemStack stack = player.getHeldItem(hand);
        if (!stack.isEmpty() && getIsTamed() && (getSubType() == 1) && (stack.getItem() == MoCItems.ESSENCELIGHT)) {
            stack.shrink(1);
            if (stack.isEmpty()) {
                player.setHeldItem(hand, new ItemStack(Items.GLASS_BOTTLE));
            } else {
                player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
            }
            setType(getSubType() + 1);
            return true;
        }

        if (this.getIsRideable() && this.getIsAdult() && (!this.getIsChested() || !player.isCrouching()) && !this.isBeingRidden()) {
            if (!this.world.isRemote && player.startRiding(this)) {
                player.rotationYaw = this.rotationYaw;
                player.rotationPitch = this.rotationPitch;
                setSitting(false);
            }

            return true;
        }

        return super.processInteract(player, hand);
    }*/

    @Override
    public String getOffspringClazz(IMoCTameable mate) {
        return "Liger";
    }

    @Override
    public int getOffspringTypeInt(IMoCTameable mate) {
        return 1;
    }

    @Override
    public boolean compatibleMate(Entity mate) {
        return false;
    }

    @Override
    public float calculateMaxHealth() {
        return 35F;
    }

    @Override
    public double calculateAttackDmg() {
        return 8D;
    }

    @Override
    public double getAttackRange() {
        return 10D;
    }

    @Override
    public int getMaxEdad() {
        return 135;
    }

    @Override
    public boolean canAttackTarget(LivingEntity entity) {
        if (!this.getIsAdult() && (this.getEdad() < this.getMaxEdad() * 0.8)) {
            return false;
        }
        if (entity instanceof MoCEntityLiger) {
            return false;
        }
        return entity.getBbHeight() < 2F && entity.getBbWidth() < 2F;
    }
    
    @Override
    public boolean isFlyer() {
        return this.getSubType() == 2;
    }
}
