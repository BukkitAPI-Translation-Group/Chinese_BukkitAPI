package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Powerable;

/**
 * 'has_book' 可用于快速检测讲台内是否有书.
 */
public interface Lectern extends Directional, Powerable {

    /**
     * 获取 'has_book' 属性的值.
     * <p>
     * 原文:Gets the value of the 'has_book' property.
     *
     * @return 属性 'has_book' 的值
     */
    boolean hasBook();
}
