package org.bukkit.block.data;

/**
 * 'power' 值代表当前通过此方块发出/传输红石信号的强度.
 * <br>
 * 不可超过 9000 或 {@link #getMaximumPower()} (通常为 15).
 */
public interface AnaloguePowerable extends BlockData {

    /**
     * 获取 'power' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'power' property.
     *
     * @return 属性 'power' 的值
     */
    int getPower();

    /**
     * 设置 'power' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'power' property.
     *
     * @param power 新的 'power' 属性值
     */
    void setPower(int power);

    /**
     * 获取 'power' 属性所允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'power' property.
     *
     * @return 最大 'power' 属性值
     */
    int getMaximumPower();
}
