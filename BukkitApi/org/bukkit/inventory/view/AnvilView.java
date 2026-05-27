package org.bukkit.inventory.view;

import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 一个提供与铁砧视图数据相关额外方法的 {@link InventoryView} 实例。
 */
public interface AnvilView extends InventoryView {

    @NotNull
    @Override
    AnvilInventory getTopInventory();

    /**
     * 获取铁砧文本字段中指定的重命名文本。
     *
     * @return 如果物品存在则返回铁砧文本字段中的文本，否则返回null
     * <p>
     * 原文：Gets the rename text specified within the anvil's text field.
     *
     * @return The text within the anvil's text field if an item is present
     * otherwise null
     */
    @Nullable
    String getRenameText();

    /**
     * 获取修复所需的物品数量。
     *
     * @return 修复物品所需的材料数量
     * <p>
     * 原文：Gets the amount of items needed to repair.
     *
     * @return The amount of materials required to repair the item
     */
    int getRepairItemCountCost();

    /**
     * 获取修复所需的经验值消耗。
     *
     * @return 修复所需的经验值消耗
     * <p>
     * 原文：Gets the experience cost needed to repair.
     *
     * @return The repair cost in experience
     */
    int getRepairCost();

    /**
     * 获取修复所需的最大经验值消耗。
     *
     * @return 修复所需的最大经验值消耗
     * <p>
     * 原文：Gets the maximum repair cost needed to repair.
     *
     * @return The maximum repair cost in experience
     */
    int getMaximumRepairCost();

    /**
     * 设置修复物品所需的修复材料数量。
     *
     * @param amount 修复材料的数量
     * <p>
     * 原文：Sets the amount of repair materials required to repair the item.
     *
     * @param amount the amount of repair materials
     */
    void setRepairItemCountCost(int amount);

    /**
     * 设置修复所需的经验值消耗。
     *
     * @param cost 修复所需的经验值消耗
     * <p>
     * 原文：Sets the repair cost in experience.
     *
     * @param cost the experience cost to repair
     */
    void setRepairCost(int cost);

    /**
     * 设置修复所需的最大经验值消耗。
     *
     * @param levels 要设置的等级
     * <p>
     * 原文：Sets maximum repair cost in experience.
     *
     * @param levels the levels to set
     */
    void setMaximumRepairCost(int levels);
}
