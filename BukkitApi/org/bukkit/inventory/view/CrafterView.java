package org.bukkit.inventory.view;

import org.bukkit.inventory.CrafterInventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

/**
 * 一个提供与合成器视图数据相关额外方法的 {@link InventoryView} 实例。
 */
public interface CrafterView extends InventoryView {

    @NotNull
    @Override
    CrafterInventory getTopInventory();

    /**
     * 检查给定的合成器槽位是否被禁用。
     *
     * @param slot 要检查的槽位
     * @return 如果槽位被禁用则返回true，否则返回false
     * <p>
     * 原文：Checks if the given crafter slot is disabled.
     *
     * @param slot the slot to check
     * @return true if the slot is disabled otherwise false
     */
    boolean isSlotDisabled(int slot);

    /**
     * 检查此合成器视图是否被通电。
     *
     * @return 如果合成器被通电则返回true
     * <p>
     * 原文：Checks whether or not this crafter view is powered.
     *
     * @return true if the crafter is powered
     */
    boolean isPowered();

    /**
     * 设置合成器槽位的状态。
     *
     * @param slot 要设置状态的槽位
     * @param disabled 如果槽位应被禁用则为true，否则为false
     * <p>
     * 原文：Sets the status of the crafter slot.
     *
     * @param slot the slot to set the status of
     * @param disabled true if the slot should be disabled otherwise false
     */
    void setSlotDisabled(int slot, boolean disabled);
}
