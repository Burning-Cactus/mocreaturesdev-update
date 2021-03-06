package drzhark.mocreatures.entity.monster;

import drzhark.mocreatures.MoCreatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MoCEntityHellRat extends MoCEntityRat {

    private int textCounter;

    public MoCEntityHellRat(EntityType<? extends MoCEntityHellRat> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MoCEntityRat.registerAttributes().add(Attributes.MAX_HEALTH, 20.0D);
    }

    @Override
    public void selectType() {
        setType(4);
    }

    @Override
    public ResourceLocation getTexture() {
        if (this.random.nextInt(2) == 0) {
            this.textCounter++;
        }
        if (this.textCounter < 10) {
            this.textCounter = 10;
        }
        if (this.textCounter > 29) {
            this.textCounter = 10;
        }
        String textNumber = "" + this.textCounter;
        textNumber = textNumber.substring(0, 1);
        return MoCreatures.getTexture("hellrat" + textNumber + ".png");
    }

//    @Override //TODO
//    protected Item getDropItem() {
//        boolean flag = (this.rand.nextInt(100) < MoCreatures.proxy.rareItemDropChance);
//        if (flag) {
//            return Item.getItemFromBlock(Blocks.FIRE);
//        }
//        return Items.REDSTONE;
//    }
}
