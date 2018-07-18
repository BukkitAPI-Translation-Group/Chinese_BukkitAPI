package org.bukkit.plugin;

/**
 * 当试图加载无效插件文件时抛出此异常.
 */
public class InvalidPluginException extends Exception {
    private static final long serialVersionUID = -8242141640709409544L;

    /**
     * 根据给定的异常构造一个新的 InvalidPluginException.
     * <p>
     * 原文:Constructs a new InvalidPluginException based on the given Exception
     *
     * @param cause 引发此异常的异常
     */
    public InvalidPluginException(final Throwable cause) {
        super(cause);
    }

    /**
     * 构造一个新的 InvalidPluginException.
     * <p>
     * 原文:Constructs a new InvalidPluginException
     */
    public InvalidPluginException() {

    }

    /**
     * 用指定的详细信息和导致异常的原因构造一个新的 InvalidPluginException.
     * <p>
     * 原文:Constructs a new InvalidPluginException with the specified detail
     * message and cause.
     *
     * @param message 详细信息(保存为以后由getMessage()方法检索)
     * @param cause 导致异常的原因(保存为以后通过getCause()方法检索).(允许空值,表示原因不存在或未知)
     */
    public InvalidPluginException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * 用指定的详细信息构造一个新的 InvalidPluginException.
     * <p>
     * 原文:Constructs a new InvalidPluginException with the specified detail
     * message
     *
     * @param message 保存详细信息,以便以后通过getMessage()方法进行检索
     */
    public InvalidPluginException(final String message) {
        super(message);
    }
}
