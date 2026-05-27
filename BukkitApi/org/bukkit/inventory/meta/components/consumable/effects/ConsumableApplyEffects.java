package org.bukkit.inventory.meta.components.consumable.effects;

import java.util.List;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

/**
 * 表示物品被消耗时应用的效果。
 */
public interface ConsumableApplyEffects extends ConsumableEffect {

    /**
     * 获取消耗此物品时可能应用的效果。
     * <p>原文：Gets the effects which may be applied by this item when consumed.
     *
     * @return 消耗效果
     */
    @NotNull
    List<PotionEffect> getEffects();

    /**
     * 设置消耗此物品时可能应用的效果。
     * <p>原文：Sets the effects which may be applied by this item when consumed.
     *
     * @param effects 新的效果
     */
    void setEffects(@NotNull List<PotionEffect> effects);

    /**
     * 添加一个消耗此物品时可能应用的效果。
     * <p>原文：Adds an effect which may be applied by this item when consumed.
     *
     * @param effect 效果
     * @return 添加的效果
     */
    @NotNull
    PotionEffect addEffect(@NotNull PotionEffect effect);

    /**
     * 获取此效果被应用的概率。
     * <p>原文：Gets the probability of this effect being applied.
     *
     * @return 概率
     */
    float getProbability();

    /**
     * 设置此效果被应用的概率。
     * <p>原文：Sets the probability of this effect being applied.
     *
     * @param probability 介于0和1之间（包含0和1）
     */
    void setProbability(float probability);
}
