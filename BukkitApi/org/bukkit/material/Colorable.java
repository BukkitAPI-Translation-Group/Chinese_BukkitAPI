package org.bukkit.material;

import org.bukkit.DyeColor;

/**
 * 代表可染色的物品.
 */
public interface Colorable {

    /**
     * 获取这个物品的颜色.
     * <p>
     * 原文:Gets the color of this object.
     *
     * @return 物品的DyeColor
     */
    public DyeColor getColor();

    /**
     * 设置这个物品的颜色.
     * <p>
     * 原文:Sets the color of this object to the specified DyeColor.
     *
     * @param color 物品的DyeColor
     */
    public void setColor(DyeColor color);

}
