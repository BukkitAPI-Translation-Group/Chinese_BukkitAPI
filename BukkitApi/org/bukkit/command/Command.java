package org.bukkit.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.CommandMinecart;
import org.bukkit.permissions.Permissible;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.util.StringUtil;

import com.google.common.collect.ImmutableList;

/**
 * 代表一个命令，在用户输入时执行各种任务.
 */
public abstract class Command {
    private String name;
    private String nextLabel;
    private String label;
    private List<String> aliases;
    private List<String> activeAliases;
    private CommandMap commandMap = null;
    protected String description = "";
    protected String usageMessage;
    private String permission;
    private String permissionMessage;

    protected Command(String name) {
        this(name, "", "/" + name, new ArrayList<String>());
    }

    protected Command(String name, String description, String usageMessage, List<String> aliases) {
        this.name = name;
        this.nextLabel = name;
        this.label = name;
        this.description = description;
        this.usageMessage = usageMessage;
        this.aliases = aliases;
        this.activeAliases = new ArrayList<String>(aliases);
    }

    /**
     * 执行命令.
     * <p>
     * 原文：Executes the command, returning its success
     *
     * @param sender 执行此命令的对象
     * @param commandLabel 执行命令所用的别名
     * @param args 传递给此命令的所有参数，用' '分割
     * @return 如果命令执行成功则位true，false反之
     */
    public abstract boolean execute(CommandSender sender, String commandLabel, String[] args);

    /**
     * 执行此命令的tab补全时返回选项列表.
     * <p>
     * 原文：Executed on tab completion for this command, returning a list of
     * options the player can tab through.
     *
     * @param sender 执行此命令的对象
     * @param alias 被使用的别名
     * @param args 传递给此命令的所有参数，用' '分割
     * @return 指定参数的tab补全项列表.这将永远不会为null. 列表可能是不可变的.
     * @throws IllegalArgumentException 如果sender, alias, args任意一参数为null
     */
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        return tabComplete0(sender, alias, args, null);
    }

    /**
     * 执行此命令的tab补全时返回选项列表.
     * <p>
     * 原文：Executed on tab completion for this command, returning a list of
     * options the player can tab through.
     *
     * @param sender 执行此命令的对象
     * @param alias 使用的别名
     * @param args 传递给此命令的所有参数，用' '分割
     * @param location The position looked at by the sender, or null if none (不懂，且依源码看，该参数无任何作用，可以传null)
     * @return 指定参数的tab补全项列表.这将永远不会为null. 列表可能是不可变的
     * @throws IllegalArgumentException 如果参数sender, alias或args为null
     */
    public List<String> tabComplete(CommandSender sender, String alias, String[] args, Location location) throws IllegalArgumentException {
        return tabComplete(sender, alias, args);
    }

    private List<String> tabComplete0(CommandSender sender, String alias, String[] args, Location location) throws IllegalArgumentException {
        Validate.notNull(sender, "Sender cannot be null");
        Validate.notNull(args, "Arguments cannot be null");
        Validate.notNull(alias, "Alias cannot be null");

        if (args.length == 0) {
            return ImmutableList.of();
        }

        String lastWord = args[args.length - 1];

        Player senderPlayer = sender instanceof Player ? (Player) sender : null;

        ArrayList<String> matchedPlayers = new ArrayList<String>();
        for (Player player : sender.getServer().getOnlinePlayers()) {
            String name = player.getName();
            if ((senderPlayer == null || senderPlayer.canSee(player)) && StringUtil.startsWithIgnoreCase(name, lastWord)) {
                matchedPlayers.add(name);
            }
        }

        Collections.sort(matchedPlayers, String.CASE_INSENSITIVE_ORDER);
        return matchedPlayers;
    }

    /**
     * 返回这个命令的名称.
     * <p>
     * 原文:Returns the name of this command
     *
     * @return 这个命令的名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置这个命令的名称.
     * <p>
     * 可能只能在注册之前使用本方法.
     * <p>
     * 如果新的名称被设置将返回true，命令已被注册返回false.
     * <p>
     * 原文：Sets the name of this command.
     * <p>
     * May only be used before registering the command.
     * Will return true if the new name is set, and false
     * if the command has already been registered.
     *
     * @param name 新的命令名称
     * @return 如果新的名称被更改返回true，命令已被注册返回false
     */
    public boolean setName(String name) {
        if (!isRegistered()) {
            this.name = name;
            return true;
        }
        return false;
    }

    /**
     * 获取用户执行此命令所需的权限。
     * <p>
     * 原文：Gets the permission required by users to be able to perform this
     * command
     *
     * @return 权限名，没有为null
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置用户执行此命令所需的权限.
     * <p>
     * 原文：Sets the permission required by users to be able to perform this
     * command
     *
     * @param permission 权限名，或者为null
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 测试给定的{@link CommandSender}能否执行此命令.
     * <p>
     * 如果他们没有权限，他们会被告知他们不能这样做.
     * <p>
     * 原文：Tests the given {@link CommandSender} to see if they can perform this
     * command.
     * <p>
     * If they do not have permission, they will be informed that they cannot
     * do this.
     *
     * @param target 要测试的用户
     * @return 如果他们有权限则为true，false反之
     */
    public boolean testPermission(CommandSender target) {
        if (testPermissionSilent(target)) {
            return true;
        }

        if (permissionMessage == null) {
            target.sendMessage(ChatColor.RED + "I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.");
        } else if (permissionMessage.length() != 0) {
            for (String line : permissionMessage.replace("<permission>", permission).split("\n")) {
                target.sendMessage(line);
            }
        }

        return false;
    }

    /**
     * 测试给定的{@link CommandSender}能否执行这个命令.
     * <p>
     * 不会给sender发送错误消息.
     * <p>
     * 原文:Tests the given {@link CommandSender} to see if they can perform this
     * command.
     * <p>
     * No error is sent to the sender.
     *
     * @param target 要测试的用户
     * @return 他们能不能使用命令
     */
    public boolean testPermissionSilent(CommandSender target) {
        if ((permission == null) || (permission.length() == 0)) {
            return true;
        }

        for (String p : permission.split(";")) {
            if (target.hasPermission(p)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 返回这个命令的别名.
     * <p>
     * 原文:Returns the label for this command
     *
     * @return 这个命令的别名
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置这个命令的别名.
     * <p>
     * 可能只能在注册之前使用本方法.
     * <p>
     * 如果新的名称被设置将返回true，命令已被注册返回false.
     * <p>
     * 原文：Sets the label of this command.
     * <p>
     * May only be used before registering the command.
     * Will return true if the new name is set, and false
     * if the command has already been registered.
     *
     * @param name 新的命令别名
     * @return 如果新的别名被更改返回true，命令已被注册返回false
     */
    public boolean setLabel(String name) {
        this.nextLabel = name;
        if (!isRegistered()) {
            this.label = name;
            return true;
        }
        return false;
    }

    /**
     * 把这个命令注册给一个CommandMap.
     * <p>
     * 只允许改变注册的CommandMap.
     * <p>
     * 原文：Registers this command to a CommandMap.
     * Once called it only allows changes the registered CommandMap
     *
     * @param commandMap 注册此命令给这个CommandMap
     * @return 如果注册成功则为true(当前注册的CommandMap是传递的CommandMap或null)，false反之
     */
    public boolean register(CommandMap commandMap) {
        if (allowChangesFrom(commandMap)) {
            this.commandMap = commandMap;
            return true;
        }

        return false;
    }

    /**
     * 从传递给此方法的CommandMap参数里注销这个命令，应用所有未完成的更改.
     * <p>
     * 原文：Unregisters this command from the passed CommandMap applying any
     * outstanding changes
     *
     * @param commandMap 要注销的CommandMap
     * @return 如果成功注销则为true(当前注册的CommandMap是传递的CommandMap或null)，false反之
     */
    public boolean unregister(CommandMap commandMap) {
        if (allowChangesFrom(commandMap)) {
            this.commandMap = null;
            this.activeAliases = new ArrayList<String>(this.aliases);
            this.label = this.nextLabel;
            return true;
        }

        return false;
    }

    private boolean allowChangesFrom(CommandMap commandMap) {
        return (null == this.commandMap || this.commandMap == commandMap);
    }

    /**
     * 返回这个命令的注册状态.
     * <p>
     * 原文:Returns the current registered state of this command
     *
     * @return 这个命令当前是否已注册
     */
    public boolean isRegistered() {
        return (null != this.commandMap);
    }

    /**
     * 返回这个命令激活的别名的列表.
     * <p>
     * 原文:Returns a list of active aliases of this command
     *
     * @return 别名列表
     */
    public List<String> getAliases() {
        return activeAliases;
    }

    /**
     * 返回当没有这个命令的权限时显示的消息.
     * <p>
     * 原文:Returns a message to be displayed on a failed permission check for this
     * command
     *
     * @return 无权提示消息
     */
    public String getPermissionMessage() {
        return permissionMessage;
    }

    /**
     * 获取这个命令的简介.
     * <p>
     * 原文:Gets a brief description of this command
     *
     * @return 命令简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 获取这个命令的用法示例.
     * <p>
     * 原文:Gets an example usage of this command
     *
     * @return 一个或多个用法示例
     */
    public String getUsage() {
        return usageMessage;
    }

    /**
     * 设置这个命令的别名.
     * 若没在{@link PluginDescriptionFile#getCommands()}的 <code>aliases</code> 节点定义(就是没在plugin.yml定义)将没有效果，与此等效.
     * <p>
     * 译注：不懂原文第二段在说什么，根据源代码，aliases一定会赋值给这个类的aliases成员变量，如果这个命令还没有注册，aliases同样会赋值给这个类的activeAliases成员变量.第二段的意思整理为如果没在plugin.yml定义命令别名这个方法不会有效果.
     * <p>
     * 原文：Sets the list of aliases to request on registration for this command.
     * This is not effective outside of defining aliases in the {@link
     * PluginDescriptionFile#getCommands()} (under the
     * `<code>aliases</code>' node) is equivalent to this method.
     *
     * @param aliases 要为这个命令注册的别名
     * @return 这个命令对象，可用于链式
     */
    public Command setAliases(List<String> aliases) {
        this.aliases = aliases;
        if (!isRegistered()) {
            this.activeAliases = new ArrayList<String>(aliases);
        }
        return this;
    }

    /**
     * 设置此命令的简介.在{@link PluginDescriptionFile#getCommands()}的 <code>description</code> 节点上定义介绍与本方法是等效的.
     * <p>
     * 原文：Sets a brief description of this command. Defining a description in the
     * {@link PluginDescriptionFile#getCommands()} (under the
     * `<code>description</code>' node) is equivalent to this method.
     *
     * @param description 新的命令介绍
     * @return 这个命令对象，可用于链式
     */
    public Command setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 设置当没有这个命令的权限时发送的消息.
     * <p>
     * 原文：Sets the message sent when a permission check fails
     *
     * @param permissionMessage 新的无权提示消息，null表示默认消息，空字符串表示没有提示消息
     * @return 这个命令对象，可用于链式
     */
    public Command setPermissionMessage(String permissionMessage) {
        this.permissionMessage = permissionMessage;
        return this;
    }

    /**
     * 设置这个命令的用法示例.
     * <p>
     * 原文:Sets the example usage of this command
     *
     * @param usage 新的用法示例
     * @return 命令对象
     */
    public Command setUsage(String usage) {
        this.usageMessage = usage;
        return this;
    }

    public static void broadcastCommandMessage(CommandSender source, String message) {
        broadcastCommandMessage(source, message, true);
    }

    public static void broadcastCommandMessage(CommandSender source, String message, boolean sendToSource) {
        String result = source.getName() + ": " + message;

        if (source instanceof BlockCommandSender) {
            BlockCommandSender blockCommandSender = (BlockCommandSender) source;

            if (!blockCommandSender.getBlock().getWorld().getGameRuleValue(GameRule.COMMAND_BLOCK_OUTPUT)) {
                Bukkit.getConsoleSender().sendMessage(result);
                return;
            }
        } else if (source instanceof CommandMinecart) {
            CommandMinecart commandMinecart = (CommandMinecart) source;

            if (!commandMinecart.getWorld().getGameRuleValue(GameRule.COMMAND_BLOCK_OUTPUT)) {
                Bukkit.getConsoleSender().sendMessage(result);
                return;
            }
        }

        Set<Permissible> users = Bukkit.getPluginManager().getPermissionSubscriptions(Server.BROADCAST_CHANNEL_ADMINISTRATIVE);
        String colored = ChatColor.GRAY + "" + ChatColor.ITALIC + "[" + result + ChatColor.GRAY + ChatColor.ITALIC + "]";

        if (sendToSource && !(source instanceof ConsoleCommandSender)) {
            source.sendMessage(message);
        }

        for (Permissible user : users) {
            if (user instanceof CommandSender && user.hasPermission(Server.BROADCAST_CHANNEL_ADMINISTRATIVE)) {
                CommandSender target = (CommandSender) user;

                if (target instanceof ConsoleCommandSender) {
                    target.sendMessage(result);
                } else if (target != source) {
                    target.sendMessage(colored);
                }
            }
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + '(' + name + ')';
    }
}