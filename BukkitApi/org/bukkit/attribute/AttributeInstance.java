package org.bukkit.attribute;

import java.util.Collection;

/**
 * Represents a mutable instance of an attribute and its associated modifiers
 * and values.
 */
public interface AttributeInstance {

    /**
     * 有关该实例的属性
     *
     * @return 返回对应实例的属性
     */
    Attribute getAttribute();

    /**
     * 获取所有属性的基准值(也就是未更改之前的默认值)
     *
     * @return 默认属性值
     */
    double getBaseValue();

    /**
     * 设置默认值为某个属性
     *
     * @param 为了给某个值设定他的基础值
     */
    void setBaseValue(double value);

    /**
     *获取该实例上面所有被修改过的值
     *
     * @return 将会返回一个包含所有修改过的值的集合
     */
    Collection<AttributeModifier> getModifiers();

    /**
     * 向次实例添加要修改的属性
     *
     * @param 用于添加属性
     */
    void addModifier(AttributeModifier modifier);

    /**
     * 从此实例内移除一个属性值
     *
     * @param 用于移除一个属性值
     */
    void removeModifier(AttributeModifier modifier);

    /**
     * 获取当前实例的值,（所有已经应用的值）
     *
     * @return 总的属性值
     */
    double getValue();
}