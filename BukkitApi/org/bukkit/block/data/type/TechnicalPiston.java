package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.jetbrains.annotations.NotNull;

/**
 * 'type' 值代表该 (技术) 活塞方块对应的类型.
 */
public interface TechnicalPiston extends Directional {

    /**
     * 获取 'type' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'type' property.
     *
     * @return 属性 'type' 的值
     */
    @NotNull
    Type getType();

    /**
     * 设置 'type' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'type' property.
     *
     * @param type 新的 'type' 属性值
     */
    void setType(@NotNull Type type);

    /**
     * 不同的活塞变种.
     */
    public enum Type {
        /**
         * 普通的活塞, 不会在回缩时将方块拉回来
         */
        NORMAL,
        /**
         * 有粘性的活塞, 会在回缩时把方块带回来
         */
        STICKY;
    }
}
