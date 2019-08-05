package org.bukkit.attribute;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个属性的可变实例以及它的修饰符和数据值.
 */
public interface AttributeInstance {

    /**
     * 属于该实例的属性.
     * <p>
     * 原文:The attribute pertaining to this instance.
     *
     * @return 返回对应实例的属性
     */
    @NotNull
    Attribute getAttribute();

    /**
     * 获取所有属性的基准值(也就是未更改之前的默认值)
     * <p>
     * 原文:Base value of this instance before modifiers are applied.
     *
     * @return 默认属性值
     */
    double getBaseValue();

    /**
     * 设置基准值为某个属性.
     * <p>
     * 原文:Set the base value of this instance.
     *
     * @param value 基准值
     */
    void setBaseValue(double value);

    /**
     * 获取该实例上的所有修饰符(属性).
     * <p>
     * 原文:Get all modifiers present on this instance.
     *
     * @return 所有修饰符的副本
     */
    @NotNull
    Collection<AttributeModifier> getModifiers();

    /**
     * 向次实例添加要修改的修饰符(属性).
     * <p>
     * 原文:Add a modifier to this instance.
     *
     * @param modifier 添加的属性
     */
    void addModifier(@NotNull AttributeModifier modifier);

    /**
     * 从此实例内移除一个修饰符(属性).
     * <p>
     * 原文:Remove a modifier from this instance.
     *
     * @param modifier 移除的属性
     */
    void removeModifier(@NotNull AttributeModifier modifier);

    /**
     * 获取当前实例的值,（所有已经应用的值）
     * <p>
     * 原文:Get the value of this instance after all associated modifiers have been
     * applied.
     *
     * @return 总属性值
     */
    double getValue();

    /**
     * Gets the default value of the Attribute attached to this instance.
     *
     * @return server default value
     */
    double getDefaultValue();
}