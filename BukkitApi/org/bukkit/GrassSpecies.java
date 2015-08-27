package org.bukkit;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 代表不同种类的草丛.
 */
public enum GrassSpecies {

    /**
     * 代表枯死的灌木.
     */
    DEAD(0x0),
    /**
     * 代表普通种类的草丛.
     */
    NORMAL(0x1),
    /**
     * 代表蕨类草丛.
     */
    FERN_LIKE(0x2);

    private final byte data;
    private final static Map<Byte, GrassSpecies> BY_DATA = Maps.newHashMap();

    private GrassSpecies(final int data) {
        this.data = (byte) data;
    }

    /**
     * 获取相关数据代表的品种.
     * <p>
     * 原文:
     * Gets the associated data value representing this species
     *
     * @return 包含这种草丛的数据值字节
     * @deprecated 魔法值
     */
    @Deprecated
    public byte getData() {
        return data;
    }

    /**
     * 用给定值获取草丛品种.
     * <p>
     * 原文:
     * Gets the GrassSpecies with the given data value
     *
     * @param data 要获取的数据值
     * @return 给定值代表的草丛品种({@link GrassSpecies})，如果不存在则为null
     * @deprecated 魔法值
     */
    @Deprecated
    public static GrassSpecies getByData(final byte data) {
        return BY_DATA.get(data);
    }

    static {
        for (GrassSpecies grassSpecies : values()) {
            BY_DATA.put(grassSpecies.getData(), grassSpecies);
        }
    }
}