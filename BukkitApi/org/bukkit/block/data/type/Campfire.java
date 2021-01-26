package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Lightable;
import org.bukkit.block.data.Waterlogged;

/**
 * 'signal_fire' 值表示该营火是否因为底部放了干草块而冒出更多的烟 (信号营火).
 */
public interface Campfire extends Directional, Lightable, Waterlogged {

    /**
     * 获取 'signal_fire' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'signal_fire' property.
     *
     * @return 属性 'signal_fire' 的值
     */
    boolean isSignalFire();

    /**
     * 设置 'signal_fire' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'signal_fire' property.
     *
     * @param signalFire 新的 'signal_fire' 属性值
     */
    void setSignalFire(boolean signalFire);
}
