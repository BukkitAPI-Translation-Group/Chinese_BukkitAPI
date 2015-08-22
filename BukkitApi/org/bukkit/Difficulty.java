package org.bukkit;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 代表了不同的难度
 */
public enum Difficulty {
    /**
     * 玩家随时间回血，敌对生物不会生成，饥饿条不减少。
     */
    PEACEFUL(0),

    /**
     * 敌对生物会生成，敌人会造成比在NORMAL难度更少的伤害。饥饿条会减少，最高扣
     * 5个心（默认值）。
     */
    EASY(1),

    /**
     * 敌对生物会生成，敌人会造成正常的伤害。饥饿条会减少，最高扣9.5个心（默认
     * 值）。
     */
    NORMAL(2),

    /**
     * 敌对生物会生成，敌人会造成更高的伤害。饥饿条会减少，最高会把玩家饿死。
     */
    HARD(3);

    private final int value;
    private final static Map<Integer, Difficulty> BY_ID = Maps.newHashMap();

    private Difficulty(final int value) {
        this.value = value;
    }

    /**
     * 获得难度数值.
     * <p>
     * 原文：Gets the difficulty value associated with this Difficulty.
     *
     * @return 返回难度数值，一个整数。
     * @deprecated Magic value
     */
    @Deprecated
    public int getValue() {
        return value;
    }

    /**
     * 通过难度数值获得难度。
     *
     * @param value 难度数值。
     * @return 返回一个难度 {@link Difficulty} 若不存在，返回 null。
     * @deprecated Magic value
     */
    @Deprecated
    public static Difficulty getByValue(final int value) {
        return BY_ID.get(value);
    }

    static {
        for (Difficulty diff : values()) {
            BY_ID.put(diff.value, diff);
        }
    }
}
