package org.bukkit;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 表示农作物的不同生长阶段.
 */
public enum CropState {

    /**
     * 最开始的播种阶段
     */
    SEEDED(0x0),
    /**
     * 发芽阶段(第一生长阶段).
     */
    GERMINATED(0x1),
    /**
     * 第二生长阶段.
     */
    VERY_SMALL(0x2),
    /**
     * 第三生长阶段.
     */
    SMALL(0x3),
    /**
     * 第四生长阶段
     */
    MEDIUM(0x4),
    /**
     * 第五生长阶段
     */
    TALL(0x5),
    /**
     * 即将成熟的阶段
     */
    VERY_TALL(0x6),
    /**
     * 成熟阶段
     */
    RIPE(0x7);

    private final byte data;
    private final static Map<Byte, CropState> BY_DATA = Maps.newHashMap();

    private CropState(final int data) {
        this.data = (byte) data;
    }

    /**
     * 获取表示这个生长阶段的相关数值.
     * <p>
     * 原文：
     * Gets the associated data value representing this growth state
     *
     * @return 一个包含这个生长阶段的数值的字节
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getData() {
        return data;
    }

    /**
     * 根据指定的数值获取农作物阶段.
     * <p>
     * 原文：
     * Gets the CropState with the given data value
     *
     * @param data 用于获取农作物阶段的数值
     * @return 表示指定数值的农作物阶段{@link CropState}，如果不存在则返回null
     * @deprecated 不安全的参数
     */
    @Deprecated
    public static CropState getByData(final byte data) {
        return BY_DATA.get(data);
    }

    static {
        for (CropState cropState : values()) {
            BY_DATA.put(cropState.getData(), cropState);
        }
    }
}