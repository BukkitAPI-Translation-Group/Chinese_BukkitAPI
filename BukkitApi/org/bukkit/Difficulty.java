package org.bukkit;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 代表不同的游戏难度.
 */
public enum Difficulty {
    /**
     * 玩家随时间回血，敌对生物不会生成，饥饿度不减少。
     */
    PEACEFUL(0),

    /**
     * 敌对生物会生成，敌人会造成比在NORMAL难度更少的伤害。饥饿度会减少，
     * 最高减少5颗心（默认值）.
     */
    EASY(1),

    /**
     * 敌对生物会生成，敌人会造成正常的伤害.
     * 饥饿度会减少，最减少9.5颗心（默认值）.
     */
    NORMAL(2),

    /**
     * 敌对生物会生成，敌人会造成更高的伤害.饥饿度会减少，最高可能会致死.
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
     * @return 返回一个整数的难度数值.
     * @deprecated 不安全的参数
     */
    @Deprecated
    public int getValue() {
        return value;
    }

    /**
     * 通过难度数值获得难度.
     *
     * @param value 难度数值
     * @return 返回一个难度 {@link Difficulty} 若不存在，返回 null
     * @deprecated 不安全的参数
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
