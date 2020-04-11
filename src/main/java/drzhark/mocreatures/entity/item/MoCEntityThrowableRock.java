package drzhark.mocreatures.entity.item;

import drzhark.mocreatures.MoCTools;
import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.entity.monster.MoCEntityGolem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeBlockState;

import java.util.List;

public class MoCEntityThrowableRock extends Entity {

    public int rockTimer;
    public int acceleration = 100;
    private double oPosX;
    private double oPosY;
    private double oPosZ;
    private static final DataParameter<Integer> ROCK_STATE = EntityDataManager.<Integer>createKey(MoCEntityThrowableRock.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> MASTERS_ID = EntityDataManager.<Integer>createKey(MoCEntityThrowableRock.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> BEHAVIOUR_TYPE = EntityDataManager.<Integer>createKey(MoCEntityThrowableRock.class, DataSerializers.VARINT);

    public MoCEntityThrowableRock(EntityType<? extends MoCEntityThrowableRock> type, World par1World) {
        super(type, par1World);
        this.preventEntitySpawning = true;
        //this.yOffset = this.height / 2.0F;
    }

    public MoCEntityThrowableRock(EntityType<? extends MoCEntityThrowableRock> type, World par1World, Entity entitythrower, double par2, double par4, double par6)//, int behavior)//, int bMetadata)
    {
        this(type, par1World);
        this.setPosition(par2, par4, par6);
        this.rockTimer = 250;
        this.prevPosX = this.oPosX = par2;
        this.prevPosY = this.oPosY = par4;
        this.prevPosZ = this.oPosZ = par6;
        this.setMasterID(entitythrower.getEntityId());
    }

    public void setState(BlockState state) {
        this.dataManager.set(ROCK_STATE, (Block.getStateId(state) & 65535));
    }

    public BlockState getState() {
        return Block.getStateById(((Integer)this.dataManager.get(ROCK_STATE)).intValue() & 65535);
    }

    public void setMasterID(int i) {
        this.dataManager.set(MASTERS_ID, Integer.valueOf(i));
    }

    public int getMasterID() {
        return ((Integer)this.dataManager.get(MASTERS_ID)).intValue();
    }

    public void setBehavior(int i) {
        this.dataManager.set(BEHAVIOUR_TYPE, Integer.valueOf(i));
    }

    public int getBehavior() {
        return ((Integer)this.dataManager.get(BEHAVIOUR_TYPE)).intValue();
    }

    @Override
    protected void registerData() {
        this.dataManager.register(BEHAVIOUR_TYPE, Integer.valueOf(0));
        this.dataManager.register(ROCK_STATE, Integer.valueOf(0));
        this.dataManager.register(MASTERS_ID, Integer.valueOf(0));
    }

    @Override
    public void writeAdditional(CompoundNBT nbttagcompound) {
        BlockState iblockstate = this.getState();
        nbttagcompound = MoCTools.getEntityData(this);
        nbttagcompound.putInt("Behavior", getBehavior());
        nbttagcompound.putInt("MasterID", getMasterID());
        nbttagcompound.putShort("BlockID", (short) Block.getStateId(iblockstate));
//        nbttagcompound.putShort("BlockMetadata", (short) iblockstate.getBlock().getMetaFromState(iblockstate));
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return null;
    }

    @Override
    public void readAdditional(CompoundNBT nbttagcompound) {
        nbttagcompound = MoCTools.getEntityData(this);
        setBehavior(nbttagcompound.getInt("Behavior"));
        setMasterID(nbttagcompound.getInt("MasterID"));
        BlockState iblockstate;
        iblockstate = Block.getStateById(nbttagcompound.getShort("BlockID"));
        this.setState(iblockstate);
    }

    @Override
    public boolean canBeCollidedWith() {
        return this.isAlive();
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onEntityUpdate() {
        Entity master = getMaster();
        if (this.rockTimer-- <= -50 && getBehavior() == 0) {
            transformToItem();
        }

        /*if (getBehavior() == 0) {
            System.out.println("Zero Rock, Server? =" + !this.world.isRemote + " age " + rockTimer + " at " + this);
        }*/
        //held Trocks don't need to adjust its position
        if (getBehavior() == 1) {
            return;
        }

        //rock damage code (for all rock behaviors)
        if (!this.onGround) {
            List<Entity> list =
                    this.world.getEntitiesWithinAABBExcludingEntity(this,
                            this.getBoundingBox().contract(this.getMotion().x, this.getMotion().y, this.getMotion().z).expand(1.0D, 1.0D, 1.0D));

            for (int i = 0; i < list.size(); i++) {
                Entity entity1 = (Entity) list.get(i);
                if (master != null && entity1.getEntityId() == master.getEntityId()) {
                    continue;
                }
                if (entity1 instanceof MoCEntityGolem) {
                    continue;
                }
                if (entity1 != null && !(entity1 instanceof LivingEntity)) {
                    continue;
                }

                if (master != null) {
                    entity1.attackEntityFrom(DamageSource.causeMobDamage((LivingEntity) master), 4);
                } else {
                    entity1.attackEntityFrom(DamageSource.GENERIC, 4);
                }
            }
        }

        this.prevPosX = this.getPosX();
        this.prevPosY = this.getPosY();
        this.prevPosZ = this.getPosZ();

        if (getBehavior() == 2) {
            if (master == null) {
                setBehavior(0);
                this.rockTimer = -50;
                return;
            }

            //moves towards the master entity the bigger the number, the slower
            --this.acceleration;
            if (this.acceleration < 10) {
                this.acceleration = 10;
            }

            float tX = (float) this.getPosX() - (float) master.getPosX();
            float tZ = (float) this.getPosZ() - (float) master.getPosZ();
            float distXZToMaster = tX * tX + tZ * tZ;

            if (distXZToMaster < 1.5F && master instanceof MoCEntityGolem) {
                ((MoCEntityGolem) master).receiveRock(this.getState());
                this.setBehavior(0);
                this.setDead();
            }

            double summonedSpeed = this.acceleration;//20D;
            this.setMotion(((master.getPosX() - this.getPosX()) / summonedSpeed), ((master.getPosY() - this.getPosY()) / 20D + 0.15D), ((master.getPosZ() - this.getPosZ()) / summonedSpeed));
            if (!this.world.isRemote) {
                this.move(MoverType.SELF, this.getMotion());
            }
            return;
        }

        if (getBehavior() == 4)// imploding / exploding rock
        {
            if (master == null) {
                if (!this.world.isRemote) {
                    setBehavior(5);
                }
                return;
            }

            //moves towards the master entity the bigger the number, the slower
            this.acceleration = 10;

            float tX = (float) this.getPosX() - (float) master.getPosX();
            float tZ = (float) this.getPosZ() - (float) master.getPosZ();
            float distXZToMaster = tX * tX + tZ * tZ;

            double summonedSpeed = this.acceleration;//20D;
            this.setMotion(((master.getPosX() - this.getPosX()) / summonedSpeed), (master.getPosY() - this.getPosY()) / 20D + 0.15D, (master.getPosZ() - this.getPosZ()) / summonedSpeed);

            if (distXZToMaster < 2.5F && master instanceof MoCEntityGolem) {
                this.setMotion(Vec3d.ZERO);
            }

            if (!this.world.isRemote) {
                this.move(MoverType.SELF, this.getMotion());
            }

            return;
        }

        if (getBehavior() == 5)// exploding rock
        {
            this.acceleration = 5;
            double summonedSpeed = this.acceleration;//20D;
            this.setMotion(((this.oPosX - this.getPosX()) / summonedSpeed), ((this.oPosY - this.getPosY()) / 20D + 0.15D), ((this.oPosZ - this.getPosZ()) / summonedSpeed));
            if (!this.world.isRemote) {
                this.move(MoverType.SELF, this.getMotion());
            }
            setBehavior(0);
            return;
        }

        this.getMotion().subtract(0, 0.04D, 0);
        if (!this.world.isRemote) {
            this.move(MoverType.SELF, this.getMotion());
        }
        this.getMotion().scale(0.98D);

        if (this.onGround) {
            this.getMotion().mul(0.699D, -0.5D, 0.699D);
        }

    }

    private void transformToItem() {
        if (!this.world.isRemote && MoCTools.mobGriefing(this.world) && MoCreatures.proxy.golemDestroyBlocks) // don't drop rocks if mobgriefing is set to false, prevents duping
        {
            ItemEntity entityitem =
                    new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), new ItemStack(this.getState().getBlock(), 1, this.getState()
                            .getBlock().getMetaFromState(this.getState())));
            entityitem.setPickupDelay(10);
            entityitem.setAgeToCreativeDespawnTime();
            this.world.addEntity(entityitem);
        }
        this.setDead();
    }

    public Block getMyBlock() {
        if (this.getState() != null) {
            return this.getState().getBlock();
        }
        return Blocks.STONE;
    }

    private Entity getMaster() {
        List<Entity> entityList = this.world.loadedEntityList;
        for (Entity ent : entityList) {
            if (ent.getEntityId() == getMasterID()) {
                return ent;
            }
        }

        return null;
    }
}
