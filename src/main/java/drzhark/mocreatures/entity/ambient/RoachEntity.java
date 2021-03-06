package drzhark.mocreatures.entity.ambient;

import com.google.common.base.Predicate;
import drzhark.mocreatures.entity.ai.FleeFromEntityGoal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class RoachEntity extends MoCEntityInsect

{

    public RoachEntity(EntityType<? extends RoachEntity> type, World world) {
        super(type, world);
        this.texture = "roach.png";
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new FleeFromEntityGoal(this, new Predicate<Entity>() {

            public boolean apply(Entity entity) {
                return !(entity instanceof CrabEntity) && (entity.getBbHeight() > 0.3F || entity.getBbWidth() > 0.3F);
            }
        }, 6.0F, 0.8D, 1.3D));
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level.isClientSide) {

            if (getIsFlying() && this.random.nextInt(50) == 0) {
                setIsFlying(false);
            }

            /*if (!getIsFlying() && this.rand.nextInt(10) == 0) {
                EntityLivingBase entityliving = getBoogey(3D);
                if (entityliving != null) {
                    MoCTools.runLikeHell(this, entityliving);
                }
            }*/
        }
    }

    @Override
    public boolean entitiesToInclude(Entity entity) {
        return !(entity instanceof MoCEntityInsect) && super.entitiesToInclude(entity);
    }

    @Override
    public boolean isFlyer() {
        return true;
    }

    @Override
    public boolean isMyFavoriteFood(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() == Items.ROTTEN_FLESH;
    }

    @Override
    protected int getFlyingFreq() {
        return 500;
    }

    @Override
    public float getSpeed() {
        if (getIsFlying()) {
            return 0.1F;
        }
        return 0.25F;
    }

    @Override
    public boolean isNotScared() {
        return getIsFlying();
    }
}
