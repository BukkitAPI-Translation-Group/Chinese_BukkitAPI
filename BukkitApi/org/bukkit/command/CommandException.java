package org.bukkit.command;

/**
 * 当执行命令过程中出现未处理的异常时抛出.
 */
@SuppressWarnings("serial")
public class CommandException extends RuntimeException {

    /**
     * 创建一个没有详细信息的新的<code>CommandException</code>实例.
     * <p>
     * 原文:Creates a new instance of <code>CommandException</code> without detail
     * message.
     */
    public CommandException() {}

    /**
     * 用指定的详细信息构造一个新的<code>CommandException</code>实例.
     * <p>
     * 原文:Constructs an instance of <code>CommandException</code> with the
     * specified detail message.
     *
     * @param msg 报错详细信息
     */
    public CommandException(String msg) {
        super(msg);
    }

    public CommandException(String msg, Throwable cause) {
        super(msg, cause);
    }
}