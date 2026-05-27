package org.bukkit.entity;

/**
 * 代表一条河豚.
 */
public interface PufferFish extends Fish {

    /**
     * 获取此河豚的当前膨胀状态(即膨胀程度).
     * <p>
     * 原文：
     * Returns the current puff state of this fish (i.e. how inflated it is).
     *
     * @return 当前膨胀状态
     */
    int getPuffState();

    /**
     * 设置此河豚的当前膨胀状态(即膨胀程度).
     * <p>
     * 原文：
     * Sets the current puff state of this fish (i.e. how inflated it is).
     *
     * @param state 新的膨胀状态
     */
    void setPuffState(int state);
}
