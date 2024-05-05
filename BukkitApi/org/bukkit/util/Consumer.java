package org.bukkit.util;

/**
 * 表示接受一个输入参数且没有返回值的操作.
 * <p>
 * 原文:Represents an operation that accepts a single input argument and returns no
 * result.
 *
 * @param <T> 输入参数类型
 * @deprecated 请使用 {@link java.util.function.Consumer}
 */
// Bukkit developer note (NOT plugin developers):
// NEVER use this consumer in the API.
// API methods which use this consumer will be remapped to Java's consumer at runtime, resulting in an error.
@Deprecated
public interface Consumer<T> extends java.util.function.Consumer<T> {

    /**
     * 使用给定的参数执行操作.
     * <p>
     * 原文:Performs this operation on the given argument.
     *
     * @param t 输入参数
     */
    @Override
    void accept(T t);
}
