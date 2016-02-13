package org.bukkit.inventory.meta;

/**
 * 代表可以被修复的物品.
 */
public interface Repairable {

    /**
     * 检测这个物品是否损耗了耐久.
     * <p>
     * 原文：Checks to see if this has a repair penalty
     *
     * @return 如果这个物品损耗了耐久则为true
     */
    boolean hasRepairCost();

    /**
     * 获取这个物品的耐久度.
     * <p>
     * 原文：Gets the repair penalty
     *
     * @return 耐久度
     */
    int getRepairCost();

    /**
     * 设置这个物品的耐久度.
     * <p>
     * 原文：Sets the repair penalty
     *
     * @param cost 耐久度
     */
    void setRepairCost(int cost);

    @SuppressWarnings("javadoc")
    Repairable clone();
}