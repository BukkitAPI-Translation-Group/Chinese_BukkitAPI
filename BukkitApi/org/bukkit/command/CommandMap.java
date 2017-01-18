package org.bukkit.command;

import java.util.List;
import org.bukkit.Location;

public interface CommandMap {

    /**
     * 注册所有属于某个插件的命令.
     * <p>
     * 调用者可使用:-
     * <ul>
     * <li>用 command.getName() 确定这个别名已注册给这个命令
     * <li>用 command.getAliases() 确定这个别名在哪注册
     * </ul>
     * 原文：Registers all the commands belonging to a certain plugin.
     * <p>
     * Caller can use:-
     * <ul>
     * <li>command.getName() to determine the label registered for this
     *     command
     * <li>command.getAliases() to determine the aliases which where
     *     registered
     * </ul>
     *
     * @param fallbackPrefix 预置在命令之前的前缀（即fallbackPrefix:命令，用英文冒号分开，前面的部分就是fallbackPrefix），以使命令独一无二
     * @param commands 要注册的命令的列表
     */
    public void registerAll(String fallbackPrefix, List<Command> commands);

    /**
     * 注册一个命令.如果成功返回true，如果名称已被占据、fallback已被使用则返回false.
     * <p>
     * 调用者可使用:-
     * <ul>
     * <li>用 command.getName() 确定这个别名已注册给这个命令
     * <li>用 command.getAliases() 确定这个别名在哪注册
     * </ul>
     * <p>
     * 原文：Registers a command. Returns true on success; false if name is already
     * taken and fallback had to be used.
     * <p>
     * Caller can use:-
     * <ul>
     * <li>command.getName() to determine the label registered for this
     *     command
     * <li>command.getAliases() to determine the aliases which where
     *     registered
     * </ul>
     *
     * @param label 命令的别名，即“prefix”，没有“/”
     * @param fallbackPrefix 预置在命令之前的前缀（即fallbackPrefix:命令，用英文冒号分开，前面的部分就是fallbackPrefix），以使命令独一无二
     * @param command 要注册的命令
     * @return 如果用传递的label注册了命令则为true，如果指定的fallbackPrefix已被使用一次或多次则为false
     */
    public boolean register(String label, String fallbackPrefix, Command command);

    /**
     * 注册一个命令.如果成功返回true，如果名称已被占据、fallback已被使用则返回false.
     * <p>
     * 调用者可使用:-
     * <ul>
     * <li>用 command.getName() 确定这个别名已注册给这个命令
     * <li>用 command.getAliases() 确定这个别名在哪注册
     * </ul>
     * <p>
     * 原文：Registers a command. Returns true on success; false if name is already
     * taken and fallback had to be used.
     * <p>
     * Caller can use:-
     * <ul>
     * <li>command.getName() to determine the label registered for this
     *     command
     * <li>command.getAliases() to determine the aliases which where
     *     registered
     * </ul>
     *
     * @param fallbackPrefix 预置在命令之前的前缀（即fallbackPrefix:命令，用英文冒号分开，前面的部分就是fallbackPrefix），以使命令独一无二
     * @param command 要注册的命令，从此命令的别名确定
     * @return 如果用传递的label注册了命令则为true，如果指定的fallbackPrefix已被使用一次或多次则为false
     */
    public boolean register(String fallbackPrefix, Command command);

    /**
     * 查找请求的命令并执行，如果找到了。
     * <p>
     * 原文：Looks for the requested command and executes it if found.
     *
     * @param sender 命令发送者
     * @param cmdLine 命令 + 参数. 梨子: "/test abc 123"
     * @return 如果没有目标找到返回false，true反之
     * @throws CommandException 当给定命令的执行器执行命令时有异常未处理原文则抛出
     */
    public boolean dispatch(CommandSender sender, String cmdLine) throws CommandException;

    /**
     * 清除所有已注册命令.
     * <p>
     * 原文：Clears all registered commands.
     */
    public void clearCommands();

    /**
     * 获取指定名称的注册命令.
     * <p>
     * 原文：Gets the command registered to the specified name
     *
     * @param name 要检索的命令名称
     * @return 指定名称的Cimmand，如果不存在指定名称/别名的命令则返回false
     */
    public Command getCommand(String name);

    /**
     * 查找请求的命令并执行适当的tab补全器，如果找到了.
     * <p>
     * Looks for the requested command and executes an appropriate
     * tab-completer if found. This method will also tab-complete partial
     * commands.
     *
     * @param sender 命令发送者
     * @param cmdLine 整个被tab补全的命令字符串，不包括最前的“/”
     * @return 可能的tab补全项的列表.这个列表可能是不变的.如果命令发送者没有匹配命令的权限将会为null
     * @throws CommandException 当给定命令的tab补全器处理时有异常未处理则抛出
     * @throws IllegalArgumentException 如果sender或cmdLine其一为null
     */
    public List<String> tabComplete(CommandSender sender, String cmdLine) throws IllegalArgumentException;

    /**
     * Looks for the requested command and executes an appropriate
     * tab-completer if found. This method will also tab-complete partial
     * commands.
     *
     * @param sender The command's sender.
     * @param cmdLine The entire command string to tab-complete, excluding
     *     initial slash.
     * @param location The position looked at by the sender, or null if none
     * @return a list of possible tab-completions. This list may be immutable.
     *     Will be null if no matching command of which sender has permission.
     * @throws CommandException Thrown when the tab-completer for the given
     *     command fails with an unhandled exception
     * @throws IllegalArgumentException if either sender or cmdLine are null
     */
    public List<String> tabComplete(CommandSender sender, String cmdLine, Location location) throws IllegalArgumentException;
}
