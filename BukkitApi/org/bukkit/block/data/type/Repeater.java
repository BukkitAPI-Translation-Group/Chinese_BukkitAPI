package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Powerable;

/**
 * 'delay' 为中继器传递信号的延迟, 即在当前信号传递过来后, 等待多少刻再激活自身以传递信号到下一个方块.
 * <br>
 * 延迟不可低于 {@link #getMinimumDelay()} 也不可高于 {@link #getMaximumDelay()}.
 * <br>
 * 'locked' 值表示中继器是否进入锁存状态.
 * <br>
 * 进入锁存状态的中继器在状态解除之前不会变更它的输出信号. 在游戏中, 从侧面对中继器充能以锁存它.
 */
public interface Repeater extends Directional, Powerable {

    /**
     * 获取 'delay' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'delay' property.
     *
     * @return 属性 'delay' 的值
     */
    int getDelay();

    /**
     * 设置 'delay' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'delay' property.
     *
     * @param delay 新的 'delay' 属性值
     */
    void setDelay(int delay);

    /**
     * 获取 'delay' 属性所允许的最小值.
     * <p>
     * 原文:
     * Gets the minimum allowed value of the 'delay' property.
     *
     * @return 最小 'delay' 属性值
     */
    int getMinimumDelay();

    /**
     * 获取 'delay' 属性所允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'delay' property.
     *
     * @return 最大 'delay' 属性值
     */
    int getMaximumDelay();

    /**
     * 获取 'locked' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'locked' property.
     *
     * @return 属性 'locked' 的值.
     */
    boolean isLocked();

    /**
     * 设置 'locked' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'locked' property.
     *
     * @param locked 新的 'locked' 属性值
     */
    void setLocked(boolean locked);
}
