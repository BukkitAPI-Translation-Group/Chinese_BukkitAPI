package org.bukkit.entity;

/**
 * 代表一条河豚.
 */
public interface PufferFish extends Fish {

    /**
     * 获取此河豚的当前膨胀状态(即膨胀程度).
     *
     * @return 当前膨胀状态
     */
    int getPuffState();

    /**
     * 设置此河豚的当前膨胀状态(即膨胀程度).
     *
     * @param state 新的膨胀状态
     */
    void setPuffState(int state);
}
