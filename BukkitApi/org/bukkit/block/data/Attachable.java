package org.bukkit.block.data;

/**
 * 'attached' 值表示绊线钩或绊线是否构成了一个完整的绊线回路并准备好触发.
 * <br>
 * 对一个绊线钩更新此属性将会改变其材质,
 * 但是对绊线本身更新没有任何效果.
 * 然而它还是可以拿来检查该绊线是否构成了一个完整的绊线回路.
 */
public interface Attachable extends BlockData {

    /**
     * 获取 'attached' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'attached' property.
     *
     * @return 属性 'attached' 的值
     */
    boolean isAttached();

    /**
     * 设置 'attached' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'attached' property.
     *
     * @param attached 新的 'attached' 属性值
     */
    void setAttached(boolean attached);
}
