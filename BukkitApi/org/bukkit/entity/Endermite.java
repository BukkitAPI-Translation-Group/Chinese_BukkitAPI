package org.bukkit.entity;

/**
 * 名副其实的小不点 - 末影螨.
 */
public interface Endermite extends Monster {
    
    /**
     * 该末影螨是否因玩家而生成 (玩家使用末影珍珠而导致末影螨的生成).
     * 由于玩家使用末影珍珠而生成的末影螨会被附近的末影人攻击.
     * <p>
     * 原文:Gets whether this Endermite was spawned by a player.
     *
     * An Endermite spawned by a player will be attacked by nearby Enderman.
     *
     * @return 该末影螨是否因玩家而生成
     * @deprecated 本功能不再存在(自1.17版本起)
     */
    @Deprecated
    boolean isPlayerSpawned();

    /**
     * 该末影螨是否因玩家而生成 (玩家使用末影珍珠而导致末影螨的生成).
     * 由于玩家使用末影珍珠而生成的末影螨会被附近的末影人攻击.
     * <p>
     * 原文:Sets whether this Endermite was spawned by a player.
     *
     * An Endermite spawned by a player will be attacked by nearby Enderman.
     *
     * @param playerSpawned 该末影螨是否因玩家而生成
     * @deprecated 本功能不再存在(自1.17版本起)
     */
    @Deprecated
    void setPlayerSpawned(boolean playerSpawned);
}
