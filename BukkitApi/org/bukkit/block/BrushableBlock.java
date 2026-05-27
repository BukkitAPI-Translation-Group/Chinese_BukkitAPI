package org.bukkit.block;

import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.Lootable;
import org.jetbrains.annotations.Nullable;

/**
 * 表示可疑的沙子或沙砾的捕获状态。
 */
public interface BrushableBlock extends Lootable, TileState {

    /**
     * 获取当沙子被完全刷掉并露出时将显示的物品。
     *
     * @return 物品
     * <p>
     * 原文：Get the item which will be revealed when the sand is fully brushed away
     * and uncovered.
     */
    @Nullable
    public ItemStack getItem();

    /**
     * 设置当沙子被完全刷掉并露出时将显示的物品。
     *
     * @param item 物品
     * <p>
     * 原文：Sets the item which will be revealed when the sand is fully brushed away
     * and uncovered.
     */
    public void setItem(@Nullable ItemStack item);
}
