package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'has_record'数据值可用来快速检查此唱片机是否装入了唱片.
 */
public interface Jukebox extends BlockData {

    /**
     * 获取'has_record'数据值.
     * <p>
     * 原文:Gets the value of the 'has_record' property.
     *
     * @return 此唱片机是否装入了唱片
     */
    boolean hasRecord();
}
