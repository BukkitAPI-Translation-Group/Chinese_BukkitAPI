package org.bukkit.command;

/**
 * 当一个命令的执行过程中发生未处理的异常时，抛出该异常。
 * 原文：Thrown when an unhandled exception occurs during the execution of a Command
 * <p>
 * 译注：比如/setblock a b c 这样x,y,z值非数字，则会抛出异常。
 */
@SuppressWarnings("serial")
public class CommandException extends RuntimeException {

    /**
     * 新建一个<code>CommandException</code>的空实例。
     * 原文：Creates a new instance of <code>CommandException</code> without detail
     * message.
     * <p>
     * 译注：without detail message.指“无详细信息”，instance指“实例”，在这翻译为“空实例”更为准确一些。
     */
    public CommandException() {}

    /**
     * 创建一个新的实例<code>CommandException</code>，该实例中包含详细信息。
     * 原文：Constructs an instance of <code>CommandException</code> with the
     * specified detail message.
     *
     * @param msg 详细信息。
     */
    public CommandException(String msg) {
        super(msg);
    }

    public CommandException(String msg, Throwable cause) {
        super(msg, cause);
    }
}