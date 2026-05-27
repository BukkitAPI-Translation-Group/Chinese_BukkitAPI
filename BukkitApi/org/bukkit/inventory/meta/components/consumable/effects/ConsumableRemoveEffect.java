package org.bukkit.inventory.meta.components.consumable.effects;

import java.util.List;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

/**
 * 表示物品被消耗时要移除的效果。
 */
public interface ConsumableRemoveEffect extends ConsumableEffect {

    /**
     * 获取消耗此物品时可能移除的效果。
     * <p>原文：Gets the effects which may be removed by this item when consumed.
     *
     * @return 效果
     */
    @NotNull
    List<PotionEffectType> getEffectTypes();

    /**
     * 设置消耗此物品时可能移除的效果。
     * <p>原文：Sets the effects which may be removed by this item when consumed.
     *
     * @param effects 新的效果
     */
    void setEffectTypes(@NotNull List<PotionEffectType> effects);

    /**
     * 添加一个消耗此物品时可能应用的效果。
     * <p>原文：Adds an effect which may be applied by this item when consumed.
     *
     * @param effect 效果
     * @return 添加的效果
     */
    @NotNull
    PotionEffectType addEffectType(@NotNull PotionEffectType effect);
}
