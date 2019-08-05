package org.bukkit.attribute;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 用于表示一个可以包含属性的对象
 */
public interface Attributable {

    /**
     * 从指定的一个对象内获取对应的属性.
     * 这个方法将直接返回包含属性的对象，任何对此对象的变动将立即可见（生效）.
     * <p>
     * 原文:Gets the specified attribute instance from the object. This instance will
     * be backed directly to the object and any changes will be visible at once.
     *
     * @param attribute Attribute实例
     * @return 这个方法会返回一个AttributeInstance,如果不适用于此对象,将返回null
     */
    @Nullable
    AttributeInstance getAttribute(@NotNull Attribute attribute);
}