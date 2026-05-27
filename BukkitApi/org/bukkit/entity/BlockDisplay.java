package org.bukkit.entity;

import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个方块展示实体。
 */
public interface BlockDisplay extends Display {

    /**
     * 获取展示的方块。
     *
     * @return 展示的方块
     * <p>原文：Gets the displayed block.
     */
    @NotNull
    public BlockData getBlock();

    /**
     * 设置展示的方块。
     *
     * @param block 新的方块
     * <p>原文：Sets the displayed block.
     */
    public void setBlock(@NotNull BlockData block);
}
