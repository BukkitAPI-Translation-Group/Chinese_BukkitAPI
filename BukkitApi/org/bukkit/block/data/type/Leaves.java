package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'persistent' 值决定树叶是否会被服务器检查以腐烂 (自动消失).
 * <br>
 * 'distance' 值表示该树叶距离一棵树有多远, 用于与 'persistent' 属性结合判断该树叶是否会腐烂.
 */
public interface Leaves extends BlockData {

    /**
     * 获取 'persistent' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'persistent' property.
     *
     * @return 属性 'persistent' 的值
     */
    boolean isPersistent();

    /**
     * 设置 'persistent' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'persistent' property.
     *
     * @param persistent 新的 'persistent' 属性值
     */
    void setPersistent(boolean persistent);

    /**
     * 获取 'distance' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'distance' property.
     *
     * @return 属性 'distance' 的值
     */
    int getDistance();

    /**
     * 设置 'distance' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'distance' property.
     *
     * @param distance 新的 'distance' 属性值
     */
    void setDistance(int distance);
}
