package org.bukkit.block.data;

/**
 * 'lit'表示此方块(红石或熔炉)是否在发光 ———— 不是烧毁他们的意思.
 */
public interface Lightable extends BlockData {

    /**
     * 获取'lit'数据值.
     * <p>
     * 原文:Gets the value of the 'lit' property.
     *
     * @return 方块是否在发光
     */
    boolean isLit();

    /**
     * 设置'lit'数据值.
     * <p>
     * 原文:Sets the value of the 'lit' property.
     *
     * @param lit 方块是否在发光
     */
    void setLit(boolean lit);
}
