package org.bukkit.attribute;

/**
 * 用于表示一个可能包含属性的对象
 */
public interface Attributable {

    /**
     * 从指定的一个对象内获取对应的属性
     * 这个方法将直接会返回相对包含属性的对象
     * 如果你更改了他们的属性,你将只能获取到一次对他们的更改
     *
     * @param 用于获取Attribute实例
     * @return 这个方法会返回一个Attribute实例,如果对应对象不可用,将返回null
     */
    AttributeInstance getAttribute(Attribute attribute);
}