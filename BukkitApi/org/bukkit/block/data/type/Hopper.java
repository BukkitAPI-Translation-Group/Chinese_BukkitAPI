package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Powerable;

/**
 * 与{@link Powerable}相似, 'enabled'数据值表示此漏斗是否被激活.
 * <br>
 * 不像其它大多数方块，漏斗不接受任何红石信号时为激活态.
 * (当它被激活时，漏斗停止工作，可以玩玩红石试得)
 */
public interface Hopper extends Directional {

    /**
     * 获取'enabled'属性数据值.
     * <p>
     * 原文:Gets the value of the 'enabled' property.
     *
     * @return 'enabled'数据值
     */
    boolean isEnabled();

    /**
     * 设置'enabled'属性数据值.
     * <p>
     * 原文:Sets the value of the 'enabled' property.
     *
     * @param enabled 'enabled'数据值
     */
    void setEnabled(boolean enabled);
}
