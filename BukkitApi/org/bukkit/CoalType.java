package org.bukkit;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 代表两种煤.
 */
public enum CoalType {
    COAL(0x0),
    CHARCOAL(0x1);

    private final byte data;
    private final static Map<Byte, CoalType> BY_DATA = Maps.newHashMap();

    private CoalType(final int data) {
        this.data = (byte) data;
    }

    /**
     * 获取表示该类型的煤的相关数据值.
     * <p>
     * 原文:
     * Gets the associated data value representing this type of coal
     * 获取煤的数据值
     * @return 煤的数据值
     * @deprecated 魔法值
     */
    @Deprecated
    public byte getData() {
        return data;
    }

    /**
     * 用数据值获取煤的类型.
     * <p>
     * 原文:
     * Gets the type of coal with the given data value
     * 
     * @param data 要获取的煤的类型
     * @return {@link CoalType} 代表给定的值, 如果不存在则为null
     * @deprecated 魔法值
     */
    @Deprecated
    public static CoalType getByData(final byte data) {
        return BY_DATA.get(data);
    }

    static {
        for (CoalType type : values()) {
            BY_DATA.put(type.data, type);
        }
    }
}