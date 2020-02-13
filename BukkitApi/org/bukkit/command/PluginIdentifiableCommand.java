package org.bukkit.command;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * 这个接口可以用于帮助系统分类命令至基于{@link Plugin}的子索引的一部分.自定义的命令实现这个接口来拥有由插件自动生成的子索引.
 * <p>
 * 原文:This interface is used by the help system to group commands into
 * sub-indexes based on the {@link Plugin} they are a part of. Custom command
 * implementations will need to implement this interface to have a sub-index
 * automatically generated on the plugin's behalf.
 */
public interface PluginIdentifiableCommand {

    /**
     * 获取拥有这个PluginIdentifiableCommand的插件.
     * <p>
     * 原文:Gets the owner of this PluginIdentifiableCommand.
     *
     * @return 拥有这个PluginIdentifiableCommand的插件
     */
    @NotNull
    public Plugin getPlugin();
}