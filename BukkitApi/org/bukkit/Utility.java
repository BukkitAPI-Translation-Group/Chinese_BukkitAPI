package org.bukkit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个注释表示一个方法（有时是构造函数）会连接它的内部操作。
 * <p>
 * 这仅仅用于识别不需要手动重写或处理的方法。
 * <p>
 * 原文：
 * This annotation indicates a method (and sometimes constructor) will chain
 * its internal operations.
 * <p>
 * This is solely meant for identifying methods that don't need to be
 * overridden / handled manually.
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface Utility {
}
