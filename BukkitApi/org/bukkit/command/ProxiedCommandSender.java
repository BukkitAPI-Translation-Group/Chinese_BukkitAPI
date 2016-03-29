package org.bukkit.command;

public interface ProxiedCommandSender extends CommandSender {

    /**
     * 返回触发这个代理命令的CommandSender.
     * <p>
     * 原文:Returns the CommandSender which triggered this proxied command
     *
     * @return 命令调用者
     */
    CommandSender getCaller();

    /**
     * 返回CommandSender正在运行的命令.
     * <p>
     * 原文:Returns the CommandSender which is being used to call the command
     *
     * @return 调用者正在运行的命令
     */
    CommandSender getCallee();

}