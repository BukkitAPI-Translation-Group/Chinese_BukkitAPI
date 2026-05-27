package org.bukkit.entity;

/**
 * 代表一个僵尸疣猪兽。
 */
public interface Zoglin extends Monster, Ageable {

    /**
     * 获取僵尸疣猪兽是否为幼年。
     *
     * @return 僵尸疣猪兽是否为幼年
     * @deprecated see {@link Ageable#isAdult()}
     * <p>原文：Gets whether the zoglin is a baby
     */
    @Deprecated(since = "1.6.2")
    public boolean isBaby();

    /**
     * 设置僵尸疣猪兽是否为幼年。
     *
     * @param flag 僵尸疣猪兽是否为幼年
     * @deprecated see {@link Ageable#setBaby()} and {@link Ageable#setAdult()}
     * <p>原文：Sets whether the zoglin is a baby
     */
    @Deprecated(since = "1.16.2")
    public void setBaby(boolean flag);
}
