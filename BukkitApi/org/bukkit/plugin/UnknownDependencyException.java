package org.bukkit.plugin;

/**
 * 当试图加载无效插件文件时抛出(插件缺少依赖的异常)
 */
public class UnknownDependencyException extends RuntimeException {

    private static final long serialVersionUID = 5721389371901775895L;

    /**
     * 根据给定的异常构造一个新的 UnknownDependencyException.
     * <p>
     * 原文:Constructs a new UnknownDependencyException based on the given
     * Exception
     *
     * @param throwable 引发此异常的异常
     */
    public UnknownDependencyException(final Throwable throwable) {
        super(throwable);
    }

    /**
     * 以给定消息构造一个新的 UnknownDependencyException.
     * <p>
     * 原文:Constructs a new UnknownDependencyException with the given message
     *
     * @param message 异常原因的简要说明
     */
    public UnknownDependencyException(final String message) {
        super(message);
    }

    /**
     * 根据给定的异常构造一个新的 UnknownDependencyException.
     * <p>
     * 原文:Constructs a new UnknownDependencyException based on the given
     * Exception
     *
     * @param message 异常原因的简要说明
     * @param throwable 引发此异常的异常
     */
    public UnknownDependencyException(final Throwable throwable, final String message) {
        super(message, throwable);
    }

    /**
     * 构造一个新的UnknownDependencyException.
     */
    public UnknownDependencyException() {

    }
}
