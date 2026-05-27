package org.bukkit.entity;

/**
 * 代表一只海龟.
 */
public interface Turtle extends Animals {

    /**
     * 获取海龟是否拥有蛋.
     *
     * @return 海龟是否有蛋
     */
    boolean hasEgg();

    /**
     * 获取海龟是否正在下蛋.
     *
     * @return 海龟是否正在下蛋
     */
    boolean isLayingEgg();
}
