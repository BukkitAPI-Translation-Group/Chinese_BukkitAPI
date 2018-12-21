package org.bukkit.entity;

import org.bukkit.Rotation;
import org.bukkit.inventory.ItemStack;

/**
 * 代表物品展示框.
 */
public interface ItemFrame extends Hanging {

    /**
     * 获取在展示框内的物品.
     * <p>
     * 原文:Get the item in this frame
     *
     * @return 展示框内的物品
     */
    public ItemStack getItem();

    /**
     * 设置在展示框内的物品.
     * <p>
     * 原文:Set the item in this frame
     *
     * @param item 新的物品
     */
    public void setItem(ItemStack item);

    /**
     * Set the item in this frame
     *
     * @param item the new item
     * @param playSound whether or not to play the item placement sound
     */
    public void setItem(ItemStack item, boolean playSound);

    /**
     * 获取展示框内物品的旋转角度.
     * <p>
     * 原文:Get the rotation of the frame's item
     *
     * @return 旋转角度
     */
    public Rotation getRotation();

    /**
     * 设置展示框内物品的旋转角度.
     * <p>
     * 原文:Set the rotation of the frame's item
     *
     * @param rotation 新的旋转角度
     * @throws IllegalArgumentException 如果旋转角度为null
     */
    public void setRotation(Rotation rotation) throws IllegalArgumentException;
}
