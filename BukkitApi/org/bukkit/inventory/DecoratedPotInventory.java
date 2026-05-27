package org.bukkit.inventory;

import org.bukkit.block.DecoratedPot;
import org.jetbrains.annotations.Nullable;

/**
 * 装饰陶罐物品栏的接口。
 */
public interface DecoratedPotInventory extends Inventory {

    /**
     * 设置装饰陶罐中的物品堆。
     *
     * <p>原文：Set the item stack in the decorated pot.
     *
     * @param item 新的物品堆
     */
    public void setItem(@Nullable ItemStack item);

    /**
     * 获取装饰陶罐中的物品堆。
     *
     * <p>原文：Get the item stack in the decorated pot.
     *
     * @return 当前物品堆
     */
    @Nullable
    public ItemStack getItem();

    @Nullable
    @Override
    public DecoratedPot getHolder();
}
