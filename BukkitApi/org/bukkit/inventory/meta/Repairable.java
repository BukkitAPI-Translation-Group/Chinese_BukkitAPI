package org.bukkit.inventory.meta;

/**
 * 代表可以在铁砧上被修复的物品.
 */
public interface Repairable {

    /**
     * 检测修复此物品是否需要消耗额外经验等级.
     * <p>
     * 原文：Checks to see if this has a repair penalty
     *
     * @return 修复此物品是否需要消耗额外经验等级
     */
    boolean hasRepairCost();

    /**
     * 获取修复此物品所需的额外经验等级.
     * <p>
     * 原文：Gets the repair penalty
     *
     * @return 修复此物品所需的额外经验等级
     */
    int getRepairCost();

    /**
     * 设置修复此物品所需的额外经验等级.
     * <p>
     * 原文：Sets the repair penalty
     *
     * @param cost 修复此物品所需的额外经验等级
     */
    void setRepairCost(int cost);

    @SuppressWarnings("javadoc")
    Repairable clone();
}
