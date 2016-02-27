package org.bukkit.help;

import java.util.Collection;
import java.util.List;

/**
 * HelpMap跟踪所有注册在Bukkit服务器的帮助主题。
 * 当服务器启动或重新加载时，按以下顺序处理帮助和添加内容：
 * 
 * <ol>
 * <li>从help.yml加载总主题
 * <li>插件加载并可选择调用{@code addTopic()}添加主题
 * <li>使用{@link HelpTopicFactory}帮助主题工厂对象的注册插件命令，来创建主题
 * <li>主题内容被修改为指向help.yml
 * </ol>
 * <p>
 * 原文:The HelpMap tracks all help topics registered in a Bukkit server. When the
 * server starts up or is reloaded, help is processed and topics are added in
 * the following order:
 * 
 * <ol>
 * <li>General topics are loaded from the help.yml
 * <li>Plugins load and optionally call {@code addTopic()}
 * <li>Registered plugin commands are processed by {@link HelpTopicFactory}
 *     objects to create topics
 * <li>Topic contents are amended as directed in help.yml
 * </ol>
 */
public interface HelpMap {
    /**
     * 获取指定主题名称的帮助主题。
     * <p>
     * 原文：Returns a help topic for a given topic name.
     *
     * 
     * @param topicName 按名称查找帮助主题。
     * @return 如果有则为返回{@link HelpTopic}对象，如果没有则返回null。
     */
    public HelpTopic getHelpTopic(String topicName);

    /**
     * 获得所有注册过的帮助主题集合。
     * <p>
     * 原文：Returns a collection of all the registered help topics.
     *
     * @return 所有注册过的帮助主题。
     */
    public Collection<HelpTopic> getHelpTopics();
    
    /**
     * 把主题添加到服务器的帮助索引。
     * <p>
     * 原文：Adds a topic to the server's help index.
     *
     * @param topic 要添加的帮助主题.
     */
    public void addTopic(HelpTopic topic);

    /**
     * 清除帮助索引的内容。通常在服务器重新加载时调用。
     * <p>
     * 原文：Clears out the contents of the help index. Normally called during
     * server reload.
     */
    public void clear();

    /**
     * 关联一个HelpTopicFactory对象到指定的命令基类。
     * 插件通常在onLoad()中调用此方法。
     * 注册后，自定义HelpTopicFactory将用来创建一个所有命令源于commandClass基类的自定义HelpTopic，
     * 或者所有命令源于org.bukkit.command.PluginCommand中执行源于commandClass基类的那个类。
     * <p>
     * 原文：Associates a {@link HelpTopicFactory} object with given command base
     * class. Plugins typically call this method during {@code onLoad()}. Once
     * registered, the custom HelpTopicFactory will be used to create a custom
     * {@link HelpTopic} for all commands deriving from the {@code
     * commandClass} base class, or all commands deriving from {@link
     * org.bukkit.command.PluginCommand} who's executor derives from {@code
     * commandClass} base class.
     *
     * @param commandClass 用于自定义HelpTopicFactory泛型。
     *     必须继承org.bukkit.command.Command或org.bukkit.command.CommandExecutor
     * <p>
     * 原文：The class for which the custom HelpTopicFactory
     *     applies. Must derive from either {@link org.bukkit.command.Command}
     *     or {@link org.bukkit.command.CommandExecutor}.
     * @param factory HelpTopicFactory的实现于commandClass相关联。
     * <p>
     * 原文：The {@link HelpTopicFactory} implementation to associate
     *     with the {@code commandClass}.
     * @throws IllegalArgumentException 如果commandClass不是继承一个合法的基类
     * <p>
     * 原文：Thrown if {@code commandClass} does
     *     not derive from a legal base class.
     */
    public void registerHelpTopicFactory(Class<?> commandClass, HelpTopicFactory<?> factory);

    /**
     * 获取服务器管理者选择从帮助索引中排除的插件列表。
     * 想确保完成服务器管理者的预期，
     * 插件作者需要查看实现HelpTopicFactory的集合来选择直接继承org.bukkit.command.Command而不是PluginCommand。
     * <p>
     * 原文：Gets the list of plugins the server administrator has chosen to exclude
     * from the help index. Plugin authors who choose to directly extend
     * {@link org.bukkit.command.Command} instead of {@link
     * org.bukkit.command.PluginCommand} will need to check this collection in
     * their {@link HelpTopicFactory} implementations to ensure they meet the
     * server administrator's expectations.
     *
     * @return 一个应该被排除在帮助索引之外的插件列表。
     */
    public List<String> getIgnoredPlugins();
}
