package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Powerable;

/**
 * 与{@link Powerable}相似, 'triggered'数据值表示此发射器是否被激活.
 */
public interface Dispenser extends Directional {

    /**
     * 获取'triggered'数据值.
     * <p>
     * 原文:Gets the value of the 'triggered' property.
     *
     * @return 此发射器是否被激活
     */
    boolean isTriggered();

    /**
     * 设置'triggered'数据值.
     * <p>
     * 原文:Sets the value of the 'triggered' property.
     *
     * @param triggered 此发射器是否被激活
     */
    void setTriggered(boolean triggered);
}
