package org.bukkit.command;

import org.jetbrains.annotations.NotNull;

/**
 * 包含了一个执行命令的方法的类.
 */
public interface CommandExecutor {

    /**
     * 执行给定的命令，成功时返回.
     * <br>
     * 如果返回假（false），则会输出plugin.yml下对应usage的内容，
     * 返回到玩家聊天窗口（前提需要被定义）；
     * <br>
     * 如果为真（true）则不返回内容
     * <p>
     * 原文:Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender 命令执行的来源（可以是 player 可以是 console）
     * @param command 被执行的命令
     * @param label 使用的命令别名
     * @param args 传递的命令参数（不包含命令主体）
     * @return 如果是合法的命令则为true，否则为false
     */
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args);
}