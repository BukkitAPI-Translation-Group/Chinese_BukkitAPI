package org.bukkit.enchantments;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;

/**
 * 本类描述了附魔台中可用的附魔选项.
 */
public class EnchantmentOffer {

    private Enchantment enchantment;
    private int enchantmentLevel;
    private int cost;

    public EnchantmentOffer(@NotNull Enchantment enchantment, int enchantmentLevel, int cost) {
        this.enchantment = enchantment;
        this.enchantmentLevel = enchantmentLevel;
        this.cost = cost;
    }

    /**
     * 获取魔咒/附魔种类.
     * <p>
     * 原文:Get the type of the enchantment.
     *
     * @return 魔咒种类
     */
    @NotNull
    public Enchantment getEnchantment() {
        return enchantment;
    }

    /**
     * 设置魔咒/附魔种类.
     * <p>
     * 设置:Sets the type of the enchantment.
     *
     * @param enchantment 魔咒种类
     */
    public void setEnchantment(@NotNull Enchantment enchantment) {
        Preconditions.checkArgument(enchantment != null, "The enchantment may not be null!");

        this.enchantment = enchantment;
    }

    /**
     * 获取魔咒/附魔的等级.
     * <p>
     * 原文:Gets the level of the enchantment.
     *
     * @return 魔咒等级
     */
    public int getEnchantmentLevel() {
        return enchantmentLevel;
    }

    /**
     * 设置魔咒/附魔的等级.
     * <p>
     * 原文:Sets the level of the enchantment.
     *
     * @param enchantmentLevel 魔咒等级
     */
    public void setEnchantmentLevel(int enchantmentLevel) {
        Preconditions.checkArgument(enchantmentLevel > 0, "The enchantment level must be greater than 0!");

        this.enchantmentLevel = enchantmentLevel;
    }

    /**
     * 获取花费的经验等级(最低), 这个等级以数字形式显示在附魔台界面中附魔选项的右侧.
     * <p>
     * 原文:Gets the cost (minimum level) which is displayed as a number on the right
     * hand side of the enchantment offer.
     *
     * @return 附魔花费的经验等级
     */
    public int getCost() {
        return cost;
    }

    /**
     * 设置花费的经验等级(最低), 这个等级以数字形式显示在附魔台界面中附魔选项的右侧.
     * <p>
     * 原文:Sets the cost (minimum level) which is displayed as a number on the right
     * hand side of the enchantment offer.
     *
     * @param cost 附魔花费的经验等级
     */
    public void setCost(int cost) {
        Preconditions.checkArgument(cost > 0, "The cost must be greater than 0!");

        this.cost = cost;
    }
}
