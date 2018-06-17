package org.bukkit.util;

/**
 * 表示接受一个输入参数且没有返回值的操作.
 * <p>
 * 原文:Represents an operation that accepts a single input argument and returns no
 * result.
 *
 * @param <T> 输入参数类型
 */
public interface Consumer<T> {

    /**
     * 使用给定的参数执行操作.
     * <p>
     * 原文:Performs this operation on the given argument.
     *
     * @param t 输入参数
     */
    void accept(T t);
}
