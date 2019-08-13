package org.bukkit.block.data.type;

import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Openable;
import org.bukkit.block.data.Powerable;
import org.jetbrains.annotations.NotNull;

/**
 * 'hinge'数据值表示门的门轴依靠哪一边，并且开关门时会旋转.
 */
public interface Door extends Bisected, Directional, Openable, Powerable {

    /**
     * 获取'hinge'数据值.
     * <p>
     * 原文:Gets the value of the 'hinge' property.
     *
     * @return 门轴依靠哪一侧
     */
    @NotNull
    Hinge getHinge();

    /**
     * 设置'hinge'数据值.
     * <p>
     * 原文:Sets the value of the 'hinge' property.
     *
     * @param hinge 门轴依靠哪一侧
     */
    void setHinge(@NotNull Hinge hinge);

    /**
     * 门轴.
     */
    public enum Hinge {
        /**
         * 门(轴)依靠在左侧.
         */
        LEFT,
        /**
         * 门(轴)依靠在右侧.
         */
        RIGHT;
    }
}
