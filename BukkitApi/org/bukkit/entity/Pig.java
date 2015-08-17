package org.bukkit.entity;

/**
 * 代表猪.
 */
public interface Pig extends Animals, Vehicle {

    /**
     * 检查这个猪是否装上了鞍.
     * <p>
     * 原文:
     * Check if the pig has a saddle.
     *
     * @return 这个猪是否装上了鞍
     */
    public boolean hasSaddle();

    /**
     * 设置这只猪是否装上了鞍.
     * <p>
     * 原文:
     * Sets if the pig has a saddle or not
     *
     * @param saddled 这只猪是否装上了鞍
     */
    public void setSaddle(boolean saddled);
}