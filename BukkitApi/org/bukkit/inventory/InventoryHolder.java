package org.bukkit.inventory;

import org.jetbrains.annotations.NotNull;

public interface InventoryHolder {

    /**
     * 获取该对象的用户界面项目.
     * <p>
     * 原文:Get the object's inventory.
     *
     * @return 该对象的物品栏.
     */
    @NotNull
    public Inventory getInventory();
}