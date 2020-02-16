package org.bukkit.inventory;

import org.bukkit.block.DoubleChest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 大箱子的用户界面接口.
 */
public interface DoubleChestInventory extends Inventory {

    /**
     * 获取这个大箱子的左半部分界面.
     *
     * @return 左半部分界面
     */
    @NotNull
    Inventory getLeftSide();

    /**
     * 获取这个大箱子的右半部分界面
     *
     * @return 左半部分界面
     */
    @NotNull
    Inventory getRightSide();

    @Override
    @Nullable
    DoubleChest getHolder();
}