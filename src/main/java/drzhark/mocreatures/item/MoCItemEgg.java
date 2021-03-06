package drzhark.mocreatures.item;

import drzhark.mocreatures.entity.item.MoCEntityEgg;
import drzhark.mocreatures.registry.MoCEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MoCItemEgg extends MoCItem {

    public MoCItemEgg(Item.Properties builder) {
        super(builder.stacksTo(16));
//        setHasSubtypes(true);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        final ItemStack stack = player.getItemInHand(hand);
        stack.shrink(1);
        if (!world.isClientSide && !player.hasImpulse) {
            int i = stack.getDamageValue();
            if (i == 30) {
                i = 31; //for ostrich eggs. placed eggs become stolen eggs.
            }
            MoCEntityEgg entityegg = new MoCEntityEgg(MoCEntities.EGG, world, i);
            entityegg.setPos(player.getX(), player.getY(), player.getZ());
            player.level.addFreshEntity(entityegg);
            entityegg.getDeltaMovement().add((world.random.nextFloat() - world.random.nextFloat()) * 0.3F, world.random.nextFloat() * 0.05F, (world.random.nextFloat() - world.random.nextFloat()) * 0.3F);
        }
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
    }
//
//    @Override
//    @OnlyIn(Dist.CLIENT)
//    public void getSubItems(ItemGroup tab, NonNullList<ItemStack> items) {
//        if (!this.isInGroup(tab)) {
//            return;
//        }
//
//        // Fish eggs
//        int length = MoCEntityFishy.fishNames.length;
//        for (int i = 0; i < length; i++) { // fishy
//            items.add(new ItemStack(this, 1, i));
//        }
//        length = 80 + MoCEntitySmallFish.fishNames.length;
//        for (int i = 80; i < length; i++) { // small fish
//            items.add(new ItemStack(this, 1, i));
//        }
//        length = 70 + MoCEntityMediumFish.fishNames.length;
//        for (int i = 70; i < length; i++) { // medium fish
//            items.add(new ItemStack(this, 1, i));
//        }
//        items.add(new ItemStack(this, 1, 90)); // piranha
//        items.add(new ItemStack(this, 1, 11)); // shark
//        for (int i = 21; i < 28; i++) { // snakes
//            items.add(new ItemStack(this, 1, i));
//        }
//        items.add(new ItemStack(this, 1, 30)); // ostrich
//        items.add(new ItemStack(this, 1, 31)); // stolen ostrich egg
//        items.add(new ItemStack(this, 1, 33)); // komodo
//        for (int i = 41; i < 46; i++) { // scorpions
//            items.add(new ItemStack(this, 1, i));
//        }
//        for (int i = 50; i < 65; i++) { // wyverns, manticores
//            items.add(new ItemStack(this, 1, i));
//        }
//    }
//  Obsolete.
//    @Override
//    public String getUnlocalizedName(ItemStack itemstack) {
//        return (new StringBuilder()).append(getUnlocalizedName()).append(".").append(itemstack.getItemDamage()).toString();
//    }
}
