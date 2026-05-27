package org.bukkit.entity;

/**
 * {@link Frog}的幼崽.
 */
public interface Tadpole extends Fish {

    /**
     * 获取此生物的年龄.
     * <p>
     * 原文：
     * Gets the age of this mob.
     *
     * @return 年龄
     */
    public int getAge();

    /**
     * 设置此生物的年龄.
     * <p>
     * 原文：
     * Sets the age of this mob.
     *
     * @param age 新的年龄
     */
    public void setAge(int age);
}
