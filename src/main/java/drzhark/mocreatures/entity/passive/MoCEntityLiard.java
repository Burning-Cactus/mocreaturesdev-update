package drzhark.mocreatures.entity.passive;

import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.entity.IMoCTameable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MoCEntityLiard extends MoCEntityBigCat {

    public MoCEntityLiard(EntityType<? extends MoCEntityLiard> type, World world) {
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
        return MoCreatures.getTexture("bcliard.png");
    }

    /*@Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        final Boolean tameResult = this.processTameInteract(player, hand);
        if (tameResult != null) {
            return tameResult;
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
        return "Liard";
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
        return 30F;
    }

    @Override
    public double calculateAttackDmg() {
        return 6D;
    }

    @Override
    public double getAttackRange() {
        return 8D;
    }

    @Override
    public int getMaxEdad() {
        return 100;
    }

    @Override
    public boolean canAttackTarget(LivingEntity entity) {
        if (!this.getIsAdult() && (this.getEdad() < this.getMaxEdad() * 0.8)) {
            return false;
        }
        if (entity instanceof MoCEntityLiard) {
            return false;
        }
        return entity.getBbHeight() < 2F && entity.getBbWidth() < 2F;
    }
}
