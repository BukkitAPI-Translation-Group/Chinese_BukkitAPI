package org.bukkit;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 代表不同的树木种类。
 */
public enum TreeSpecies {

    /**
     * 代表普通树种(橡树).
     */
    GENERIC(0x0),
    /**
     * 代表叶子颜色较暗的树.
     */
    REDWOOD(0x1),
    /**
     * 代表桦树.
     */
    BIRCH(0x2),
    /**
     * 代表丛林树.
     */
    JUNGLE(0x3),
    /**
     * 代表金合欢树.
     */
    ACACIA(0x4),
    /**
     * 代表深色橡木树.
     */
    DARK_OAK(0x5),
    ;

    private final byte data;
    private final static Map<Byte, TreeSpecies> BY_DATA = Maps.newHashMap();

    private TreeSpecies(final int data) {
        this.data = (byte) data;
    }

    /**
     * 获取该树种相关的数据值。
     * <p>
     * 原文：Gets the associated data value representing this species
     *
     * @return 包含该物种相关数据值的字节
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getData() {
        return data;
    }

    /**
     * 获取给定值代表的树种。
     * <p>
     * 原文：Gets the TreeSpecies with the given data value
     *
     * @param data 要获取的数据值
     * @return {@link TreeSpecies}所代表的值，如果不存在则为null
     * @deprecated 不安全的参数
     */
    @Deprecated
    public static TreeSpecies getByData(final byte data) {
        return BY_DATA.get(data);
    }

    static {
        for (TreeSpecies species : values()) {
            BY_DATA.put(species.data, species);
        }
    }
}