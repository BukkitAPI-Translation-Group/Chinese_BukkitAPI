package org.bukkit.entity;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表掉落物实体.
 */
public interface Item extends Entity {

    /**
     * 获取与此掉落物相关的物品堆.
     * <p>
     * 原文:Gets the item stack associated with this item drop.
     *
     * @return 物品堆
     */
    @NotNull
    public ItemStack getItemStack();

    /**
     * 设置与此掉落物相关的物品堆.
     * <p>
     * 原文:Sets the item stack associated with this item drop.
     *
     * @param stack 物品堆
     */
    public void setItemStack(@Nullable ItemStack stack);

    /**
     * 获取此掉落物剩余的不可被捡起的时间.
     * <p>
     * 原文:Gets the delay before this Item is available to be picked up by players
     *
     * @return 掉落物剩余的不可被捡起的时间
     */
    public int getPickupDelay();

    /**
     * 设置掉落物剩余的不可被捡起的时间.
     * <p>
     * 原文:Sets the delay before this Item is available to be picked up by players
     *
     * @param delay 掉落物剩余的不可被捡起的时间
     */
    public void setPickupDelay(int delay);
}
