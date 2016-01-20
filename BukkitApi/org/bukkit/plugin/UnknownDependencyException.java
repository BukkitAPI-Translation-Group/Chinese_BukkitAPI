package org.bukkit.plugin;

/**
 * 在试图加载无效的插件文件时将抛出异常
 * Thrown when attempting to load an invalid Plugin file
 */
public class UnknownDependencyException extends RuntimeException {

    private static final long serialVersionUID = 5721389371901775895L;

    /**
     * 新建一个新的异常类型UnknownDependencyException。
     * 原文：Constructs a new UnknownDependencyException based on the given
     * Exception
     *
     * @param throwable 导致抛出此异常的异常。
     */
    public UnknownDependencyException(final Throwable throwable) {
        super(throwable);
    }

    /**
     * 抛出一个新的UnknownDependencyException异常及它给定的消息。
     * 原文：Constructs a new UnknownDependencyException with the given message
     *
     * @param message 发短消息来解释异常的原因。
     */
    public UnknownDependencyException(final String message) {
        super(message);
    }

    /**
     * 基于给定的异常，抛出一个新的UnknownDependencyException异常
     * 原文：Constructs a new UnknownDependencyException based on the given
     * Exception
     *
     * @param message 发短消息来解释异常的原因
     * @param throwable 导致抛出此异常的异常。
     */
    public UnknownDependencyException(final Throwable throwable, final String message) {
        super(message, throwable);
    }

    /**
     * 抛出一个新的UnknownDependencyException异常
     * Constructs a new UnknownDependencyException
     */
    public UnknownDependencyException() {

    }
}