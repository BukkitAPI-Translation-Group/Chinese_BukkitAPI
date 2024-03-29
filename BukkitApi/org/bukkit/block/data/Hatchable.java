package org.bukkit.block.data;

/**
 * 'hatch' 值为这些蛋中孵化出实体的数量.
 */
public interface Hatchable extends BlockData {

    /**
     * 获取 'hatch' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'hatch' property.
     *
     * @return 属性 'hatch' 的值
     */
    int getHatch();

    /**
     * 设置 'hatch' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'hatch' property.
     *
     * @param hatch 新的 'hatch' 属性值
     */
    void setHatch(int hatch);

    /**
     * 获取 'hatch' 属性所能允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'hatch' property.
     *
     * @return 最大 'hatch' 属性值.
     */
    int getMaximumHatch();
}
