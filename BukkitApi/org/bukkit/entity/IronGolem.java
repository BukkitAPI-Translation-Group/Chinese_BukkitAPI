package org.bukkit.entity;

/**
 * 村民守卫者——铁傀儡.
 */
public interface IronGolem extends Golem {

    /**
     * 获取这个铁傀儡是否由玩家建造.
     * <p>
     * 原文：Gets whether this iron golem was built by a player.
     *
     * @return 这个铁傀儡是否由玩家建造
     */
    public boolean isPlayerCreated();

    /**
     * 设置这个铁傀儡是否由玩家建造.
     * <p>
     * 原文：Sets whether this iron golem was built by a player or not.
     *
     * @param playerCreated 这个铁傀儡是否由玩家建造，如果想让这个铁傀儡是自然的那就false
     */
    public void setPlayerCreated(boolean playerCreated);
}