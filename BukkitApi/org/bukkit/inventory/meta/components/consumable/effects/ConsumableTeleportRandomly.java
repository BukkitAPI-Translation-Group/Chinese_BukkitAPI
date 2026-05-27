package org.bukkit.inventory.meta.components.consumable.effects;

/**
 * 表示物品被消耗时随机传送。
 */
public interface ConsumableTeleportRandomly extends ConsumableEffect {

    /**
     * 获取消耗者被传送的直径范围。
     * <p>原文：Gets the diameter that the consumer is teleported within.
     *
     * @return 直径
     */
    float getDiameter();

    /**
     * 设置消耗者被传送的直径范围。
     * <p>原文：Sets the diameter that the consumer is teleported within.
     *
     * @param diameter 新的直径
     */
    void setDiameter(float diameter);
}
