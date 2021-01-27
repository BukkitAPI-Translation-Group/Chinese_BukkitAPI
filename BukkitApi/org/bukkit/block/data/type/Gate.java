package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Openable;
import org.bukkit.block.data.Powerable;

/**
 * 'in_wall" 值表示栅栏门是否固定在墙上,
 * 若为 true, 栅栏门的材质会被稍微降低一点以更好的融入周围 (墙, 比如圆石墙).
 */
public interface Gate extends Directional, Openable, Powerable {

    /**
     * 获取 'in_wall' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'in_wall' property.
     *
     * @return 属性 'in_wall' 的值
     */
    boolean isInWall();

    /**
     * 设置 'in_wall' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'in_wall' property.
     *
     * @param inWall 新的 'in_wall' 属性值
     */
    void setInWall(boolean inWall);
}
