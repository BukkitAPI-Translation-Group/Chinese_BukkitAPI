package org.bukkit.entity;

/**
 * {@link Frog}的幼崽.
 */
public interface Tadpole extends Fish {

    /**
     * 获取此生物的年龄.
     *
     * @return 年龄
     */
    public int getAge();

    /**
     * 设置此生物的年龄.
     *
     * @param age 新的年龄
     */
    public void setAge(int age);
}
