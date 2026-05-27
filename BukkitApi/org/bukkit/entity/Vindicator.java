package org.bukkit.entity;

/**
 * 代表卫道士.
 */
public interface Vindicator extends Illager {

    /**
     * 返回卫道士是否处于"强尼"模式.
     * <p>
     * 当此模式激活时，卫道士将对所有生物敌对.
     * <p>
     * 原文：Returns whether a vindicator is in "Johnny" mode.
     * <p>
     * When this mode is active, vindicators will be hostile to all mobs.
     *
     * @return 如果处于强尼模式则返回 true
     */
    boolean isJohnny();

    /**
     * 设置卫道士的强尼状态.
     * <p>
     * 原文：Sets the Johnny state of a vindicator.
     *
     * @param johnny 新的强尼状态
     */
    void setJohnny(boolean johnny);
}
