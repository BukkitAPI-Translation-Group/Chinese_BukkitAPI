package org.bukkit.command;

import java.util.List;

/**
 * 代表可以同时处理命令tab补全和命令的类.
 * <p>
 * 原文:Represents a class which can handle command tab completion and commands
 *
 * @deprecated 留给插件可以实现的接口，它甚至没有功能
 * @see TabExecutor
 */
@Deprecated
public interface TabCommandExecutor extends CommandExecutor {
    public List<String> onTabComplete();

}