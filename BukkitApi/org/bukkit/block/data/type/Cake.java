package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'bites'数据值表示蛋糕被吃掉了多少片.
 * <br>
 * '0'值表示蛋糕一口也没吃，同时 {@link #getMaximumBites()}
 * 的返回值表示蛋糕被吃完了 :(
 */
public interface Cake extends BlockData {

    /**
     * 获取'bites'属性值.
     * <p>
     * 原文:Gets the value of the 'bites' property.
     *
     * @return 蛋糕被吃掉了多少片
     */
    int getBites();

    /**
     * 设置'bites'属性值.
     * <p>
     * 原文:Sets the value of the 'bites' property.
     *
     * @param bites 蛋糕被吃掉了多少片
     */
    void setBites(int bites);

    /**
     * 获取'bites'数据值允许的最大值.
     * <p>
     * 原文:Gets the maximum allowed value of the 'bites' property.
     *
     * @return 'bites'的最大值
     */
    int getMaximumBites();
}
