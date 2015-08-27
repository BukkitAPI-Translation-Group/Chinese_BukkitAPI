package org.bukkit;

import java.util.Map;

import org.bukkit.entity.HumanEntity;

import com.google.common.collect.Maps;

/**
 * 代表{@link HumanEntity}能有的不同种类的游戏模式.
 */
public enum GameMode {
    /**
     * 创造模式，能飞行、瞬间破坏、无敌、无限的物品.
     */
    CREATIVE(1),

    /**
     * 生存模式，是普通的游戏类型，没有特别的特性.
     */
    SURVIVAL(0),

    /**
     * 冒险模式，没有适当的工具将不能破坏方块.
     */
    ADVENTURE(2),

    /**
     * 旁观模式，在任何地方都不能进行交互，看不见普通玩家.旁观者会一直处于飞行状态.处于旁观模式时不会受到伤害，除了虚空或/kill伤害。
     */
    SPECTATOR(3);

    private final int value;
    private final static Map<Integer, GameMode> BY_ID = Maps.newHashMap();

    private GameMode(final int value) {
        this.value = value;
    }

    /**
     * 获取相关模式的游戏模式值.
     * <p>
     * 原文:
     * Gets the mode value associated with this GameMode
     *
     * @return 游戏模式
     * @deprecated 魔法值
     */
    @Deprecated
    public int getValue() {
        return value;
    }

    /**
     * 获取指定值表示的游戏模式.
     * <p>
     * 原文:
     * Gets the GameMode represented by the specified value
     *
     * @param value 要检测的值
     * @return 给定值关联的{@link GameMode},如果为null则不存在
     * @deprecated 魔法值
     */
    @Deprecated
    public static GameMode getByValue(final int value) {
        return BY_ID.get(value);
    }

    static {
        for (GameMode mode : values()) {
            BY_ID.put(mode.getValue(), mode);
        }
    }
}