package org.bukkit.command;

import java.util.List;

/**
 * 代表可以为命令提供补全建议的类.
 */
public interface TabCompleter {

    /**
     * 用命令传递的参数请求可能的补全项的list.
	 * <p>
     * 原文:Requests a list of possible completions for a command argument.
     *
     * @param sender 发起命令的来源. 至于玩家在命令方块内补全命令，这个来源就是玩家，而不是命令方块.
     * @param command 执行的Command
     * @param alias 使用的别名
     * @param args 传递给这个命令的参数，包括用来补全的部分最终参数和命令别名
     * @return 可能的最终补全参数列表(就是list里都是已经补全了的)，或为null则传递给命令执行器
     */
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args);
}