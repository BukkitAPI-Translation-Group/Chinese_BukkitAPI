package org.bukkit.plugin;

/**
 * 当试图加载无效插件描述文件(plugin.yml)时抛出此异常.
 */
public class InvalidDescriptionException extends Exception {
    private static final long serialVersionUID = 5721389122281775896L;

    /**
     * 根据给定的异常构造一个新的 InvalidDescriptionException.
     * <p>
     * 原文:Constructs a new InvalidDescriptionException based on the given
     * Exception
     *
     * @param message 异常原因的简要说明
     * @param cause 引发此异常的异常
     */
    public InvalidDescriptionException(final Throwable cause, final String message) {
        super(message, cause);
    }

    /**
     * 根据给定的异常构造一个新的 InvalidDescriptionException.
     * <p>
     * 原文:Constructs a new InvalidDescriptionException based on the given
     * Exception
     *
     * @param cause 引发此异常的异常
     */
    public InvalidDescriptionException(final Throwable cause) {
        super("Invalid plugin.yml", cause);
    }

    /**
     * 根据给定消息构造一个新的 InvalidDescriptionException.
     * <p>
     * 原文:Constructs a new InvalidDescriptionException with the given message
     *
     * @param message 异常原因的简要说明
     */
    public InvalidDescriptionException(final String message) {
        super(message);
    }

    /**
     * 构造一个新的InvalidDescriptionException.
     */
    public InvalidDescriptionException() {
        super("Invalid plugin.yml");
    }
}
