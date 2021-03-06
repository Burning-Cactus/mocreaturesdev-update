package drzhark.mocreatures.entity;

import drzhark.mocreatures.MoCPetData;
import drzhark.mocreatures.MoCTools;
import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.configuration.MoCConfig;
import drzhark.mocreatures.registry.MoCItems;
import drzhark.mocreatures.registry.MoCSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

public class MoCEntityTameableAnimal extends MoCEntityAnimal implements IMoCTameable {

    protected static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.defineId(MoCEntityTameableAnimal.class, DataSerializers.OPTIONAL_UUID);
    protected static final DataParameter<Integer> PET_ID = EntityDataManager.<Integer>defineId(MoCEntityTameableAnimal.class, DataSerializers.INT);
    protected static final DataParameter<Boolean> TAMED = EntityDataManager.<Boolean>defineId(MoCEntityTameableAnimal.class, DataSerializers.BOOLEAN);
    private boolean hasEaten;
    private int gestationtime;
    
    public MoCEntityTameableAnimal(EntityType<? extends MoCEntityTameableAnimal> type, World world) {
        super(type, world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(OWNER_UNIQUE_ID, Optional.empty());
        this.entityData.define(PET_ID, -1);
        this.entityData.define(TAMED, false);
    }

    @Override
    public int getOwnerPetId() {
        return this.entityData.get(PET_ID);
    }

    @Override
    public void setOwnerPetId(int i) {
        this.entityData.set(PET_ID, i);
    }

    @Nullable
    public UUID getOwnerId() {
        return this.entityData.get(OWNER_UNIQUE_ID).isPresent() ? this.entityData.get(OWNER_UNIQUE_ID).get() : null;
    }

    public void setOwnerId(@Nullable UUID uniqueId) {
        this.entityData.set(OWNER_UNIQUE_ID, Optional.ofNullable(uniqueId));
    }
    
    @Override
    public void setTamed(boolean tamed) {
        this.entityData.set(TAMED, tamed);
    }

    @Override
    public boolean getIsTamed() {
        return this.entityData.get(TAMED);
    }

    @Nullable
    public LivingEntity getOwner() {
        try
        {
            UUID uuid = this.getOwnerId();
            return uuid == null ? null : this.level.getPlayerByUUID(uuid);
        }
        catch (IllegalArgumentException var2)
        {
            return null;
        }
    }

    @Override
    public boolean hurt(DamageSource damagesource, float i) {
        Entity entity = damagesource.getEntity();
        if ((this.isVehicle() && entity == this.getVehicle()) || (this.getVehicle() != null && entity == this.getVehicle())) {
            return false;
        }

        //this avoids damage done by Players to a tamed creature that is not theirs
        if ((MoCConfig.COMMON_CONFIG.OWNERSHIP.enableOwnership.get() && this.getOwnerId() != null
                && entity instanceof PlayerEntity) && !((PlayerEntity) entity).getUUID().equals(this.getOwnerId())
                && !MoCTools.isThisPlayerAnOP((PlayerEntity) entity)) {
            return false;
        }

        return super.hurt(damagesource, i);
    }

    private boolean checkOwnership(PlayerEntity player, Hand hand) {
        final ItemStack stack = player.getItemInHand(hand);
        if (!this.getIsTamed() || MoCTools.isThisPlayerAnOP(player)) {
            return true;
        }

        if (this.getIsGhost() && !stack.isEmpty() && stack.getItem() == MoCItems.PETAMULET) {
            if (!this.level.isClientSide) {
                // Remove when client is updated
                ((ServerPlayerEntity) player).refreshContainer(player.containerMenu, player.containerMenu.getItems());
                player.sendMessage(new TranslationTextComponent(TextFormatting.RED + "This pet does not belong to you."), Util.NIL_UUID);
            }
            return false;
        }

        //if the player interacting is not the owner, do nothing!
        if (MoCConfig.COMMON_CONFIG.OWNERSHIP.enableOwnership.get() && this.getOwnerId() != null
                && !player.getUUID().equals(this.getOwnerId())) {
            player.sendMessage(new TranslationTextComponent(TextFormatting.RED + "This pet does not belong to you."), Util.NIL_UUID);
            return false;
        }

        return true;
    }

    /*@Override
    public ActionResultType processInitialInteract(PlayerEntity player, Hand hand) {
        final Boolean tameResult = this.processTameInteract(player, hand);
        if (tameResult != null) {
            if(tameResult)
                return ActionResultType.SUCCESS;
            return ActionResultType.FAIL;
        }

        return super.processInitialInteract(player, hand);
    }*/

    // This should always run first for all tameable animals
    public Boolean processTameInteract(PlayerEntity player, Hand hand) {
        if (!this.checkOwnership(player, hand)) {
            return false;
        }

        final ItemStack stack = player.getItemInHand(hand);
        //before ownership check
        if (!stack.isEmpty() && getIsTamed() && ((stack.getItem() == MoCItems.SCROLLOFOWNER)) && MoCConfig.COMMON_CONFIG.OWNERSHIP.enableResetOwnerScroll.get()
                && MoCTools.isThisPlayerAnOP(player)) {
            stack.shrink(1);
            if (stack.isEmpty()) {
                player.setItemInHand(hand, ItemStack.EMPTY);
            }
            if (!this.level.isClientSide) {
                if (this.getOwnerPetId() != -1) // required since getInteger will always return 0 if no key is found
                {
                    MoCreatures.instance.mapData.removeOwnerPet(this, this.getOwnerPetId());//this.getOwnerPetId());
                }
                this.setOwnerId(null);
            }
            return true;
        }
        //changes name
        if (!this.level.isClientSide && !stack.isEmpty() && getIsTamed()
                && (stack.getItem() == MoCItems.MEDALLION || stack.getItem() == Items.BOOK || stack.getItem() == Items.NAME_TAG)) {
            if (MoCTools.tameWithName(player, this)) {
                return true;
            }
            return false;
        }
        //sets it free, untamed
        if (!stack.isEmpty() && getIsTamed() && ((stack.getItem() == MoCItems.SCROLLOFFREEDOM))) {
            stack.shrink(1);
            if (stack.isEmpty()) {
                player.setItemInHand(hand, ItemStack.EMPTY);
            }
            if (!this.level.isClientSide) {
                if (this.getOwnerPetId() != -1) // required since getInteger will always return 0 if no key is found
                {
                    MoCreatures.instance.mapData.removeOwnerPet(this, this.getOwnerPetId());
                }
                this.setOwnerId(null);
                this.setPetName("");
                this.dropMyStuff();
                this.setTamed(false);
            }

            return true;
        }

        //removes owner, any other player can claim it by renaming it
        if (!stack.isEmpty() && getIsTamed() && ((stack.getItem() == MoCItems.SCROLLOFSALE))) {
            stack.shrink(1);
            if (stack.isEmpty()) {
                player.setItemInHand(hand, ItemStack.EMPTY);
            }
            if (!this.level.isClientSide) {
                if (this.getOwnerPetId() != -1) // required since getInteger will always return 0 if no key is found
                {
                    MoCreatures.instance.mapData.removeOwnerPet(this, this.getOwnerPetId());//this.getOwnerPetId());
                }
                this.setOwnerId(null);
            }
            return true;
        }

        //stores in petAmulet
        if (!stack.isEmpty() && stack.getItem() == MoCItems.PETAMULET && stack.getDamageValue() == 0 && this.canBeTrappedInNet()) {
            player.setItemInHand(hand, ItemStack.EMPTY);
            if (!this.level.isClientSide) {
                MoCPetData petData = MoCreatures.instance.mapData.getPetData(this.getOwnerId());
                if (petData != null) {
                    petData.setInAmulet(this.getOwnerPetId(), true);
                }
                this.dropMyStuff();
                MoCTools.dropAmulet(this, 2, player);
                this.remove();
            }

            return true;
        }

        if (!stack.isEmpty() && getIsTamed() && (stack.getItem() == Items.SHEARS)) {
            if (!this.level.isClientSide) {
                dropMyStuff();
            }

            return true;
        }

        //heals
        if (!stack.isEmpty() && getIsTamed() && (this.getHealth() != this.getMaxHealth()) && isMyHealFood(stack)) {
            stack.shrink(1);
            if (stack.isEmpty()) {
                player.setItemInHand(hand, ItemStack.EMPTY);
            }
            MoCTools.playCustomSound(this, MoCSoundEvents.ENTITY_GENERIC_EATING);
            if (!this.level.isClientSide) {
                this.setHealth(getMaxHealth());
            }
            return true;
        }

        return null;
    }

    // Fixes despawn issue when chunks unload and duplicated mounts when disconnecting on servers
    @Override
    public void remove() {
        if (!this.level.isClientSide && getIsTamed() && getHealth() > 0) {
            return;
        }
        super.remove();
    }

    @Override
    public boolean removeWhenFarAway(double d) {
        if (MoCConfig.COMMON_CONFIG.GLOBAL.forceDespawns.get()) {
            return !getIsTamed();
        } else {
            return false;
        }
    }

    /**
     * Play the taming effect, will either be hearts or smoke depending on
     * status
     */
    @Override
    public void playTameEffect(boolean par1) {
        BasicParticleType particleType = ParticleTypes.HEART;

        if (!par1) {
            particleType = ParticleTypes.SMOKE;
        }

        for (int i = 0; i < 7; ++i) {
            double d0 = this.random.nextGaussian() * 0.02D;
            double d1 = this.random.nextGaussian() * 0.02D;
            double d2 = this.random.nextGaussian() * 0.02D;
            this.level.addParticle(particleType, this.getX() + this.random.nextFloat() * this.getBbWidth() * 2.0F - this.getBbWidth(), this.getY() + 0.5D
                    + this.random.nextFloat() * this.getBbHeight(), this.getZ() + this.random.nextFloat() * this.getBbWidth() * 2.0F - this.getBbWidth(), d0, d1, d2);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT nbttagcompound) {
        super.addAdditionalSaveData(nbttagcompound);
        nbttagcompound.putBoolean("Tamed", getIsTamed());
        if (this.getOwnerId() != null) {
            nbttagcompound.putString("OwnerUUID", this.getOwnerId().toString());
        }
        if (getOwnerPetId() != -1) {
            nbttagcompound.putInt("PetId", this.getOwnerPetId());
        }
        if (this instanceof IMoCTameable && getIsTamed() && MoCreatures.instance.mapData != null) {
            MoCreatures.instance.mapData.updateOwnerPet(this);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbttagcompound) {
        super.readAdditionalSaveData(nbttagcompound);
        setTamed(nbttagcompound.getBoolean("Tamed"));
        String s = "";
        if (nbttagcompound.contains("OwnerUUID", 8))
        {
            s = nbttagcompound.getString("OwnerUUID");
        }
        if (!s.isEmpty())
        {
            this.setOwnerId(UUID.fromString(s));
        }
        if (nbttagcompound.contains("PetId")) {
            setOwnerPetId(nbttagcompound.getInt("PetId"));
        }
        if (this.getIsTamed() && nbttagcompound.contains("PetId")) {
            MoCPetData petData = MoCreatures.instance.mapData.getPetData(this.getOwnerId());
            if (petData != null) {
                ListNBT tag = petData.getOwnerRootNBT().getList("TamedList", 10);
                for (int i = 0; i < tag.size(); i++) {
                    CompoundNBT nbt = tag.getCompound(i);
                    if (nbt.getInt("PetId") == nbttagcompound.getInt("PetId")) {
                        // update amulet flag
                        nbt.putBoolean("InAmulet", false);
                        // check if cloned and if so kill
                        if (nbt.contains("Cloned")) {
                            // entity was cloned
                            nbt.remove("Cloned"); // clear flag
                            this.setTamed(false);
                            this.remove();
                        }
                    }
                }
            } else // no pet data was found, mocreatures.dat could of been deleted so reset petId to -1
            {
                this.setOwnerPetId(-1);
            }
        }
    }

    @Override
    public boolean isFood(ItemStack par1ItemStack) {
        return false;
    }

    // Override to fix heart animation on clients
    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte par1) {
        if (par1 == 2) {
            this.animationSpeed = 1.5F;
            this.invulnerableTime = this.invulnerableDuration;
            this.hurtTime = (this.hurtDuration = 10);
            this.hurtDir = 0.0F;
            playSound(getHurtSound(DamageSource.GENERIC), getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            hurt(DamageSource.GENERIC, 0.0F);
        } else if (par1 == 3) {
            playSound(getDeathSound(), getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            setHealth(0.0F);
            die(DamageSource.GENERIC);
        }
    }

    @Override
    public float getPetHealth() {
        return this.getHealth();
    }

    @Override
    public boolean isRiderDisconnecting() {
        return this.riderIsDisconnecting;
    }

    @Override
    public void setRiderDisconnecting(boolean flag) {
        this.riderIsDisconnecting = flag;
    }

    /**
     * Used to spawn hearts at this location
     */
    @Override
    public void spawnHeart() {
        double var2 = this.random.nextGaussian() * 0.02D;
        double var4 = this.random.nextGaussian() * 0.02D;
        double var6 = this.random.nextGaussian() * 0.02D;

        this.level.addParticle(ParticleTypes.HEART, this.getX() + this.random.nextFloat() * this.getBbWidth() * 2.0F - this.getBbWidth(), this.getY() + 0.5D
                + this.random.nextFloat() * this.getBbHeight(), this.getZ() + this.random.nextFloat() * this.getBbWidth() * 2.0F - this.getBbWidth(), var2, var4, var6);
    }

    /**
     * ready to start breeding
     */
    @Override
    public boolean readytoBreed() {
        return !this.isVehicle() && this.getVehicle() == null && this.getIsTamed() && this.getHasEaten() && this.getIsAdult();
    }

    @Override
    public String getOffspringClazz(IMoCTameable mate) {
        return "";
    }

    @Override
    public int getOffspringTypeInt(IMoCTameable mate) {
        return 0;
    }

    @Override
    public boolean compatibleMate(Entity mate) {
        return mate instanceof IMoCTameable;
    }
    
    @Override
    public void aiStep() {
        super.aiStep();
        //breeding code
        if (!this.level.isClientSide && readytoBreed() && this.random.nextInt(100) == 0) {
            doBreeding();
        }

        if (this.getIsFlying()) {
            // Safety checks to prevent 'moving too fast' checks
            if (this.getDeltaMovement().x > 0.5) {
                this.setDeltaMovement(0.5, getDeltaMovement().y, getDeltaMovement().z);
            }
            if (this.getDeltaMovement().y > 0.5) {
                this.setDeltaMovement(getDeltaMovement().x, 0.5, getDeltaMovement().z);
            }
            if (this.getDeltaMovement().z > 2.5) {
                this.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y, 2.5);
            }
        }
    }
    
    /**
     * Breeding code
     */
    protected void doBreeding() {
        int i = 0;

        List<Entity> list = this.level.getEntities(this, getBoundingBox().expandTowards(8D, 3D, 8D));
        for (int j = 0; j < list.size(); j++) {
            Entity entity = list.get(j);
            if (compatibleMate(entity)) {
                i++;
            }
        }

        if (i > 1) {
            return;
        }

        List<Entity> list1 = this.level.getEntities(this, getBoundingBox().expandTowards(4D, 2D, 4D));
        for (int k = 0; k < list1.size(); k++) {
            Entity mate = list1.get(k);
            if (!(compatibleMate(mate)) || (mate == this)) {
                continue;
            }

            if (!this.readytoBreed()) {
                return;
            }

            if (!((IMoCTameable) mate).readytoBreed()) {
                return;
            }

            setGestationTime(getGestationTime()+1);
//            if (!this.world.isRemote) {
//                MoCMessageHandler.INSTANCE.sendTo(new MoCMessageHeart(this.getEntityId()),
//                        new TargetPoint(this.world.dimension.getType().getId(), this.getPosX(), this.getPosY(), this.getPosZ(), 64));
//            }

            if (getGestationTime() <= 50) {
                continue;
            }

            try {
                    //TODO: Fix breeding method
                String offspringName = this.getOffspringClazz((IMoCTameable) mate);

//                LivingEntity offspring = (LivingEntity) EntityList.createEntityByIDFromName(new ResourceLocation(MoCConstants.MOD_PREFIX + offspringName.toLowerCase()), this.world);
//                if (offspring instanceof IMoCTameable) {
//                    IMoCTameable baby = (IMoCTameable) offspring;
//                    ((LivingEntity) baby).setPosition(this.getPosX(), this.getPosY(), this.getPosZ());
//                    this.world.addEntity((LivingEntity) baby);
//                    baby.setAdult(false);
//                    baby.setEdad(35);
//                    baby.setTamed(true);
//                    baby.setOwnerId(this.getOwnerId());
//                    baby.setType(getOffspringTypeInt((IMoCTameable) mate));
//
//                    PlayerEntity entityplayer = this.world.getPlayerByUuid(this.getOwnerId());
//                    if (entityplayer != null) {
//                        MoCTools.tameWithName(entityplayer, baby);
//                    }
//                }
                MoCTools.playCustomSound(this, SoundEvents.CHICKEN_EGG);

            } catch (Exception e) {
            }

            this.setHasEaten(false);
            this.setGestationTime(0);
            ((IMoCTameable) mate).setHasEaten(false);
            ((IMoCTameable) mate).setGestationTime(0);
            break;
        }
    }

    @Override
    public void setHasEaten(boolean flag) {
        hasEaten = flag;
    }

    /**
     * used to determine if the entity has eaten and is ready to breed
     */
    @Override
    public boolean getHasEaten() {
        return hasEaten;
    }

    @Override
    public void setGestationTime(int time) {
        gestationtime = time;
    }

    /**
     * returns breeding timer
     */
    @Override
    public int getGestationTime() {
        return gestationtime;
    }

    @Override
    public boolean getIsGhost() {
        return false;
    }
}
