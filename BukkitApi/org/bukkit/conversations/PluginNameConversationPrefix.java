package org.bukkit.conversations;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * PluginNameConversationPrefix 是一个 {@link ConversationPrefix} 实现，它在对话输出前显示插件名称。
 */
public class PluginNameConversationPrefix implements ConversationPrefix {

    protected String separator;
    protected ChatColor prefixColor;
    protected Plugin plugin;

    private String cachedPrefix;

    public PluginNameConversationPrefix(@NotNull Plugin plugin) {
        this(plugin, " > ", ChatColor.LIGHT_PURPLE);
    }

    public PluginNameConversationPrefix(@NotNull Plugin plugin, @NotNull String separator, @NotNull ChatColor prefixColor) {
        this.separator = separator;
        this.prefixColor = prefixColor;
        this.plugin = plugin;

        cachedPrefix = prefixColor + plugin.getDescription().getName() + separator + ChatColor.WHITE;
    }

    /**
     * 在每条对话消息前添加插件名称。
     * <p>
     * 原文：
     * Prepends each conversation message with the plugin name.
     *
     * @param context 关于对话的上下文信息。
     * @return 空字符串。
     */
    @Override
    @NotNull
    public String getPrefix(@NotNull ConversationContext context) {
        return cachedPrefix;
    }
}
