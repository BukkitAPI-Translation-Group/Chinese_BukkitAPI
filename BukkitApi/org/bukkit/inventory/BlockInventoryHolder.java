package org.bukkit.inventory;

import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个方块物品栏持有者 - 可以是BlockState或普通Block.
 */
public interface BlockInventoryHolder extends InventoryHolder {

    /**
     * 获取与此持有者关联的方块.
     * <p>
     * 原文：
     * Gets the block associated with this holder.
     *
     * @return 与此持有者关联的方块
     * @throws IllegalStateException 如果持有者是方块状态且未被放置
     */
    @NotNull
    Block getBlock();
}
