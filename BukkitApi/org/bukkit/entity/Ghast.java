package org.bukkit.entity;

/**
 * 代表恶魂.
 */
public interface Ghast extends Flying, Enemy {

    /**
     * 获取恶魂是否正在充能.
     * <p>
     * 原文：Gets whether the Ghast is charging
     *
     * @return 恶魂是否正在充能
     */
    boolean isCharging();

    /**
     * 设置恶魂是否正在充能.
     * <p>
     * 原文：Sets whether the Ghast is charging
     *
     * @param flag 恶魂是否正在充能
     */
    void setCharging(boolean flag);
}