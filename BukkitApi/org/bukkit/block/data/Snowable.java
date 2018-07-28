package org.bukkit.block.data;

/**
 * 'snowy'属性表示此方块是否被雪覆盖 (通常情况下时因为“它”的头顶下着雪).
 */
public interface Snowable extends BlockData {

    /**
     * 获取'snowy'属性值.
     * <p>
     * 原文:Gets the value of the 'snowy' property.
     *
     * @return 方块是否被雪覆盖
     */
    boolean isSnowy();

    /**
     * 设置'snowy'属性值.
     * <p>
     * 原文:Sets the value of the 'snowy' property.
     *
     * @param snowy 方块是否被雪覆盖
     */
    void setSnowy(boolean snowy);
}
