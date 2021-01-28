package org.bukkit.block.data.type;

import org.bukkit.block.data.Attachable;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.block.data.Powerable;

/**
 * 'disarmed' 值表示该绊线被剪刀破坏, 所以不会在破坏时触发绊线钩.
 */
public interface Tripwire extends Attachable, MultipleFacing, Powerable {

    /**
     * 获取 'disarmed' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'disarmed' property.
     *
     * @return 属性 'disarmed' 的值
     */
    boolean isDisarmed();

    /**
     * 设置 'disarmed' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'disarmed' property.
     *
     * @param disarmed 新的 'disarmed' 属性值
     */
    void setDisarmed(boolean disarmed);
}
