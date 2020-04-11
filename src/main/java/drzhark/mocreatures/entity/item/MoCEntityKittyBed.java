package drzhark.mocreatures.entity.item;

import drzhark.mocreatures.MoCTools;
import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.init.MoCItems;
import drzhark.mocreatures.init.MoCSoundEvents;
import net.minecraft.entity.*;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MoCEntityKittyBed extends LivingEntity {

    public float milklevel;
    private static final DataParameter<Boolean> HAS_MILK = EntityDataManager.<Boolean>createKey(MoCEntityKittyBed.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> HAS_FOOD = EntityDataManager.<Boolean>createKey(MoCEntityKittyBed.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> PICKED_UP = EntityDataManager.<Boolean>createKey(MoCEntityKittyBed.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> SHEET_COLOR = EntityDataManager.<Integer>createKey(MoCEntityKittyBed.class, DataSerializers.VARINT);

    public MoCEntityKittyBed(EntityType<? extends MoCEntityKittyBed> type, World world) {
        super(type, world);
        this.milklevel = 0.0F;
    }

    public MoCEntityKittyBed(EntityType<? extends MoCEntityKittyBed> type, World world, double d, double d1, double d2) {
        this(type, world);
    }

    public MoCEntityKittyBed(EntityType<? extends MoCEntityKittyBed> type, World world, int i) {
        this(type, world);
        setSheetColor(i);
    }

    public ResourceLocation getTexture() {
        return MoCreatures.getTexture("fullkittybed.png");
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D); // setMaxHealth
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(HAS_MILK, Boolean.valueOf(false));
        this.dataManager.register(HAS_FOOD, Boolean.valueOf(false));
        this.dataManager.register(PICKED_UP, Boolean.valueOf(false));
        this.dataManager.register(SHEET_COLOR, Integer.valueOf(0));
    }

    public boolean getHasFood() {
        return ((Boolean)this.dataManager.get(HAS_FOOD)).booleanValue();
    }

    public boolean getHasMilk() {
        return ((Boolean)this.dataManager.get(HAS_MILK)).booleanValue();
    }

    public boolean getPickedUp() {
        return ((Boolean)this.dataManager.get(PICKED_UP)).booleanValue();
    }

    public int getSheetColor() {
        return ((Integer)this.dataManager.get(SHEET_COLOR)).intValue();
    }

    public void setHasFood(boolean flag) {
        this.dataManager.set(HAS_FOOD, Boolean.valueOf(flag));
    }

    public void setHasMilk(boolean flag) {
        this.dataManager.set(HAS_MILK, Boolean.valueOf(flag));
    }

    public void setPickedUp(boolean flag) {
        this.dataManager.set(PICKED_UP, Boolean.valueOf(flag));
    }

    public void setSheetColor(int i) {
        this.dataManager.set(SHEET_COLOR, Integer.valueOf(i));
        //this.bedColor = EnumDyeColor.byMetadata(i).getUnlocalizedName().toLowerCase();
    }

    public boolean attackEntityFrom(Entity entity, int i) {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return this.isAlive();
    }

    @Override
    public boolean canBePushed() {
        return this.isAlive();
    }

    @Override
    public HandSide getPrimaryHand() {
        return null;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public boolean canEntityBeSeen(Entity entity) {
        return this.world.rayTraceBlocks(new Vec3d(this.getPosX(), this.getPosY() + getEyeHeight(), this.getPosZ()),
                new Vec3d(entity.getPosX(), entity.getPosY() + entity.getEyeHeight(), entity.getPosZ())) == null;
    }

    @Override
    public void fall(float f, float f1) {
    }

    @Override
    protected float getSoundVolume() {
        return 0.0F;
    }

    @Override
    public double getYOffset() {
        if (this.getRidingEntity() instanceof PlayerEntity)
        {
            return ((PlayerEntity) this.getRidingEntity()).isCrouching() ? 0.25 : 0.5F;
        }

        return super.getYOffset();
    }

    @Override
    public void handleStatusUpdate(byte byte0) {
    }

    @Override
    public Iterable<ItemStack> getArmorInventoryList() {
        return null;
    }

    @Override
    public ItemStack getItemStackFromSlot(EquipmentSlotType slotIn) {
        return null;
    }

    @Override
    public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {

    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        final ItemStack stack = player.getHeldItem(hand);
        if (!stack.isEmpty() && (stack.getItem() == Items.MILK_BUCKET)) {
            player.setHeldItem(hand, new ItemStack(Items.BUCKET, 1));
            MoCTools.playCustomSound(this, MoCSoundEvents.ENTITY_KITTYBED_POURINGMILK);
            setHasMilk(true);
            setHasFood(false);
            return true;
        }
        if (!stack.isEmpty() && !getHasFood() && (stack.getItem() == MoCItems.PETFOOD)) {
            stack.shrink(1);
            if (stack.isEmpty()) {
                player.setHeldItem(hand, ItemStack.EMPTY);
            }
            MoCTools.playCustomSound(this, MoCSoundEvents.ENTITY_KITTYBED_POURINGFOOD);
            setHasMilk(false);
            setHasFood(true);
            return true;
        }
        if (!stack.isEmpty() && ((stack.getItem() == Items.STONE_PICKAXE) || (stack.getItem() == Items.WOODEN_PICKAXE)
                        || (stack.getItem() == Items.IRON_PICKAXE) || (stack.getItem() == Items.GOLDEN_PICKAXE) || (stack.getItem() == Items.DIAMOND_PICKAXE))) {
            final int color = getSheetColor();
            player.inventory.addItemStackToInventory(new ItemStack(MoCItems.KITTYBED[color], 1));
            this.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.2F, (((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F) + 1.0F) * 2.0F);
            setDead();
            return true;
        }
        if (this.getRidingEntity() == null) {
            if (this.startRiding(player)) {
                this.rotationYaw = player.rotationYaw;
                setPickedUp(true);
            }

            return true;
        }

        return true;
    }

    @Override
    public void move(MoverType type, double d, double d1, double d2) {
        if ((this.getRidingEntity() != null) || !this.onGround || !MoCreatures.proxy.staticLitter) {
            if (!this.world.isRemote) {
                super.move(type, d, d1, d2);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.onGround) {
            setPickedUp(false);
        }
        if ((getHasMilk() || getHasFood()) && (this.isBeingRidden()) && !this.world.isRemote) {
            this.milklevel += 0.003F;
            if (this.milklevel > 2.0F) {
                this.milklevel = 0.0F;
                setHasMilk(false);
                setHasFood(false);
            }
        }
        if (this.isPassenger()) MoCTools.dismountSneakingPlayer(this);
    }

    @Override
    public void readAdditional(CompoundNBT nbttagcompound) {
        setHasMilk(nbttagcompound.getBoolean("HasMilk"));
        setSheetColor(nbttagcompound.getInt("SheetColour"));
        setHasFood(nbttagcompound.getBoolean("HasFood"));
        this.milklevel = nbttagcompound.getFloat("MilkLevel");
    }

    @Override
    public void writeAdditional(CompoundNBT nbttagcompound) {
        nbttagcompound.putBoolean("HasMilk", getHasMilk());
        nbttagcompound.putInt("SheetColour", getSheetColor());
        nbttagcompound.putBoolean("HasFood", getHasFood());
        nbttagcompound.putFloat("MilkLevel", this.milklevel);
    }

    @Override
    public void livingTick() {
        this.moveStrafing = 0.0F;
        this.moveForward = 0.0F;
        this.randomYawVelocity = 0.0F;
        super.livingTick();
    }

    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i) {
        return false;
    }
}
