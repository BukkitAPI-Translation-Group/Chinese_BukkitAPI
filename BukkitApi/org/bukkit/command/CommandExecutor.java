package org.bukkit.command;

/**
 * 包含了一个执行命令的方法的类.
 */
public interface CommandExecutor {

    /**
     * 执行给定的命令，成功时返回.
     * <p>
     * 原文:Executes the given command, returning its success
     *
     * @param sender 命令执行的来源
     * @param command 被执行的命令
     * @param label 使用的命令别名
     * @param args 传递的命令参数
     * @return 如果是合法的命令则为true，否则为false
     */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args);
}