package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.FaceAttachable;
import org.bukkit.block.data.Powerable;
import org.jetbrains.annotations.NotNull;

public interface Switch extends Directional, FaceAttachable, Powerable {

    /**
     * 获取 'face' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'face' property.
     *
     * @return 属性 'face' 的值
     * @deprecated 请使用 {@link #getAttachedFace()}
     */
    @NotNull
    @Deprecated
    Face getFace();

    /**
     * 设置 'face' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'face' property.
     *
     * @param face 新的 'face' 属性值
     * @deprecated 请使用 {@link #getAttachedFace()}
     */
    @Deprecated
    void setFace(@NotNull Face face);

    /**
     * 固定拉杆的的方块面.
     *
     * @deprecated 请使用 {@link AttachedFace}
     */
    @Deprecated
    public enum Face {
        /**
         * 拉杆安装在地板上且朝上
         */
        FLOOR,
        /**
         * 拉杆安装在墙上
         */
        WALL,
        /**
         * 拉杆安装在天花板上且朝下
         */
        CEILING;
    }
}
