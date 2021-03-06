package drzhark.mocreatures.entity.aquatic;

import drzhark.mocreatures.MoCreatures;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MoCEntityAngelFish extends MoCEntitySmallFish{

    public MoCEntityAngelFish(EntityType<? extends MoCEntityAngelFish> type, World world) {
        super(type, world);
        this.setType(2);
    }

    @Override
    public ResourceLocation getTexture() {
        return MoCreatures.getTexture("smallfish_angelfish.png");
    }

    @Override
    protected int getEggNumber() {
        return 81;
    }
}
