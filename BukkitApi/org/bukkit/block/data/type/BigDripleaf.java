package org.bukkit.block.data.type;

import org.jetbrains.annotations.NotNull;

/**
 * 'tilt' 表示叶片的倾斜程度.
 */
public interface BigDripleaf extends Dripleaf {

    /**
     * 获取 'tilt' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'tilt' property.
     *
     * @return 'tilt' 的值
     */
    @NotNull
    Tilt getTilt();

    /**
     * 设置 'tilt' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'tilt' property.
     *
     * @param tilt 新的 'tilt' 值
     */
    void setTilt(@NotNull Tilt tilt);

    /**
     * 叶片的倾斜状态.
     */
    public enum Tilt {
        /**
         * 无倾斜.
         */
        NONE,
        /**
         * 不稳定倾斜.
         */
        UNSTABLE,
        /**
         * 部分倾斜.
         */
        PARTIAL,
        /**
         * 完全倾斜.
         */
        FULL;
    }
}
