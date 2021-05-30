package org.bukkit.block;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * 代表营火.
 */
public interface Campfire extends TileState {

    /**
     * @return 物品栏大小
     * @see Inventory#getSize()
     */
    int getSize();

    /**
     * @param index 物品所在的格子
     * @return 格子内的物品
     * @see Inventory#getItem(int)
     */
    @Nullable
    ItemStack getItem(int index);

    /**
     * @param index 放置物品堆于哪个格子
     * @param item 要放入的物品堆
     * @see Inventory#setItem(int, org.bukkit.inventory.ItemStack)
     */
    void setItem(int index, @Nullable ItemStack item);

    /**
     * 获取某个物品已被烹饪多久.
     * <p>
     * 原文:Get cook time.
     *
     * This is the amount of time the item has been cooking for.
     *
     * @param index 物品槽位
     * @return 已烹饪时长
     */
    int getCookTime(int index);

    /**
     * 设置某个物品已被烹饪多久.
     * <p>
     * 原文:Set cook time.
     *
     * This is the amount of time the item has been cooking for.
     *
     * @param index 物品槽位
     * @param cookTime 已烹饪时长
     */
    void setCookTime(int index, int cookTime);

    /**
     * 获取烹饪某个物品所需的时间.
     * <p>
     * 原文:Get cook time total.
     *
     * This is the amount of time the item is required to cook for.
     *
     * @param index 物品槽位
     * @return 烹饪总时长
     */
    int getCookTimeTotal(int index);

    /**
     * 设置烹饪某个物品所需的时间.
     * <p>
     * 原文:Set cook time.
     *
     * This is the amount of time the item is required to cook for.
     *
     * @param index 物品槽位
     * @param cookTimeTotal 烹饪总时长
     */
    void setCookTimeTotal(int index, int cookTimeTotal);
}
