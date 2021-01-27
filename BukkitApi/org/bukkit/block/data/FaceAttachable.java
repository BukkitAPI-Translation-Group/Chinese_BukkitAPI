package org.bukkit.block.data;

import org.jetbrains.annotations.NotNull;

/**
 * 'face' 值代表一个拉杆或按钮固定在哪一个面上.
 * <br>
 * 该值用于与 {@link Directional} 相结合来计算这些方块的方向.
 */
public interface FaceAttachable extends BlockData {

    /**
     * 获取 'face' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'face' property.
     *
     * @return 属性 'face' 的值
     */
    @NotNull
    AttachedFace getAttachedFace();

    /**
     * 设置 'face' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'face' property.
     *
     * @param face 新的 'face' 属性值
     */
    void setAttachedFace(@NotNull AttachedFace face);

    /**
     * 一个开关类型的方块可以固定的方块面.
     */
    public enum AttachedFace {
        /**
         * 开关固定在地面上且朝上
         */
        FLOOR,
        /**
         * 开关固定在墙面上
         */
        WALL,
        /**
         * 开关固定在天花板上且朝下
         */
        CEILING;
    }
}
