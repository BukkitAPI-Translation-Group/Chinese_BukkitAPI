package org.bukkit.block.data.type;

import org.bukkit.block.data.Ageable;
import org.jetbrains.annotations.NotNull;

/**
 * 'leaves' 值代表该竹子方块上叶子的大小.
 */
public interface Bamboo extends Ageable, Sapling {

    /**
     * 获取 'leaves' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'leaves' property.
     *
     * @return 属性 'leaves' 的值
     */
    @NotNull
    Leaves getLeaves();

    /**
     * 设置 'leaves' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'leaves' property.
     *
     * @param leaves 新的 'leaves' 属性值
     */
    void setLeaves(@NotNull Leaves leaves);

    /**
     * 竹叶的大小.
     */
    public enum Leaves {

        /**
         * 没有竹叶
         */
        NONE,
        /**
         * 小竹叶
         */
        SMALL,
        /**
         * 大竹叶
         */
        LARGE;
    }
}
