package org.bukkit.entity;

/**
 * 代表一只海龟.
 */
public interface Turtle extends Animals {

    /**
     * 获取海龟是否拥有蛋.
     * <p>
     * 原文：
     * Gets whether the turtle has an egg
     *
     * @return 海龟是否有蛋
     */
    boolean hasEgg();

    /**
     * 获取海龟是否正在下蛋.
     * <p>
     * 原文：
     * Gets whether the turtle is laying an egg
     *
     * @return 海龟是否正在下蛋
     */
    boolean isLayingEgg();
}
