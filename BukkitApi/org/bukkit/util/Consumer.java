package org.bukkit.util;

/**
 * 代表一个消费者的操作，它接受单独的输入参数却没有返回值
 * <p>
 * 原文：Represents an operation that accepts a single input argument and returns no
 * result.
 *
 * @param <T> 输入这个操作的类型
 */
public interface Consumer<T> {

    /**
     * 通过给定的参数执行操作。
     * <p>
     * 原文：Performs this operation on the given argument.
     *
     * @param t 输入参数
     */
    void accept(T t);
}
