package drzhark.mocreatures.entity.ambient;

import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.entity.MoCEntityAmbient;
import drzhark.mocreatures.entity.MoCEntityAnimal;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MoCEntitySnail extends MoCEntityAmbient
{
    public MoCEntitySnail(World world)
    {
        super(world);
        setSize(0.2F, 0.2F);
        //health = 2;
        //texture = MoCreatures.proxy.MODEL_TEXTURE + "snaila.png";
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(22, Byte.valueOf((byte) 0));
    }

    @Override
    protected boolean isMovementCeased()
    {
        return (getIsHiding());
    }

    @Override
    public float getMaxHealth()
    {
        return 2;
    }

    @Override
    public float getMoveSpeed()
    {
        return 0.15F;
    }

    @Override
    public void selectType()
    {
        if (getType() == 0)
        {
            int i = rand.nextInt(100);
            if (i <= 17)
            {
                setType(1);
            }
            else if (i <= 34)
            {
                setType(2);
            }
            else if (i <= 55)
            {
                setType(3);
            }
            else if (i <= 75)
            {
                setType(4);
            }
            else if (i <= 90)
            {
                setType(5);
            }
            else
            {
                setType(6);
            }
        }
    }

    @Override
    public ResourceLocation getTexture()
    {
        switch (getType())
        {
        case 1:
            return MoCreatures.proxy.getTexture("snaila.png");
        case 2:
            return MoCreatures.proxy.getTexture("snailb.png");
        case 3:
            return MoCreatures.proxy.getTexture("snailc.png");
        case 4:
            return MoCreatures.proxy.getTexture("snaild.png");
        case 5:
            return MoCreatures.proxy.getTexture("snaile.png");
        case 6:
            return MoCreatures.proxy.getTexture("snailf.png");
        default:
            return MoCreatures.proxy.getTexture("snaila.png");
        }
    }

    public boolean getIsHiding()
    {
        return (dataWatcher.getWatchableObjectByte(22) == 1);
    }

    public void setIsHiding(boolean flag)
    {
        byte input = (byte) (flag ? 1 : 0);
        dataWatcher.updateObject(22, Byte.valueOf(input));
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (!worldObj.isRemote)
        {
            EntityLiving entityliving = getBoogey(3D);
            if ((entityliving != null) && entityliving.height > 0.5F && entityliving.width > 0.5F && canEntityBeSeen(entityliving))
            {
                if (!getIsHiding())
                {
                    setIsHiding(true);
                }
                setPathToEntity(null);
            }
            else
            {
                setIsHiding(false);
            }
            /**
             * snails without a shell won't hide
             */
            if (getIsHiding() && this.getType() > 4)
            {
                setIsHiding(false);
            }
        }
    }

    @Override
    protected void fall(float f)
    {
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (getIsHiding())
        {
            prevRenderYawOffset = renderYawOffset = rotationYaw = prevRotationYaw;
        }
    }

    @Override
    protected int getDropItemId()
    {
        return Item.slimeBall.itemID;
    }

    @Override
    public boolean isOnLadder()
    {
        return isCollidedHorizontally;
    }

    public boolean climbing()
    {
        return !onGround && isOnLadder();
    }

    @Override
    protected void jump()
    {
    }
}