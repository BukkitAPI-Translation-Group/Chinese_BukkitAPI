package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Powerable;
import org.jetbrains.annotations.NotNull;

/**
 * 'attachment' 值表示钟是怎么固定到其他方块上的.
 */
public interface Bell extends Directional, Powerable {

    /**
     * 获取 'attachment' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'attachment' property.
     *
     * @return 属性 'attachment' 的值
     */
    @NotNull
    Attachment getAttachment();

    /**
     * 设置 'attachment' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'attachment' property.
     *
     * @param attachment 新的 'attachment' 属性值
     */
    void setAttachment(@NotNull Attachment attachment);

    /**
     * 钟固定在什么东西上.
     */
    public enum Attachment {

        /**
         * 放在地板上
         */
        FLOOR,
        /**
         * 挂在天花板上
         */
        CEILING,
        /**
         * 固定在一面墙上
         */
        SINGLE_WALL,
        /**
         * 架在两面墙之间
         */
        DOUBLE_WALL;
    }
}
