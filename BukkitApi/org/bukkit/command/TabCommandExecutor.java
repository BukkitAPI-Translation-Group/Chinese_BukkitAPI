package org.bukkit.command;

import java.util.List;

/**
 * 表示可以处理命令自动补全器(tab)和命令的类。
 * 原文：Represents a class which can handle command tab completion and commands
 * <p>
 * 译注：命令自动补全器(tab)是MC提供的功能，通过打部分命令再按tab的方法可以自动补全命令。
 *
 * @deprecated 这仍然是一个插件，甚至没有它也可以实现该功能。
 * @see 查看TabExecutor
 */
@Deprecated
public interface TabCommandExecutor extends CommandExecutor {
    public List<String> onTabComplete();

}