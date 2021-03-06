package drzhark.mocreatures.util;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum MoCItemTier implements IItemTier {

    SILVER(0, 250, 6.0F, 4F, 15, () -> Ingredient.EMPTY);

    MoCItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackIn, int enchantabilityIn, Supplier<Ingredient> material) {
        harvestLevel = harvestLevelIn;
        maxUses = maxUsesIn;
        efficiency = efficiencyIn;
        attackDamage = attackIn;
        enchantability = enchantabilityIn;
        repairMaterial = new LazyValue(material);
    }

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    @Override
    public int getUses() {
        return 0;
    }

    @Override
    public float getSpeed() {
        return 0;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
