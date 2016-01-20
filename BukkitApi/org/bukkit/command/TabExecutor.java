package org.bukkit.command;

/**
 * 这个类提供了TabCompleter和CommandExecutor两种功能
 * 原文：This class is provided as a convenience to implement both TabCompleter and
 * CommandExecutor.
 */
public interface TabExecutor extends TabCompleter, CommandExecutor {
}