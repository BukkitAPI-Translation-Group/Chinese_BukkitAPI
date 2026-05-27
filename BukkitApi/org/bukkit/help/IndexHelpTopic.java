package org.bukkit.help;

import java.util.Collection;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.ChatPaginator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 此帮助主题生成其他帮助主题的列表. 此类对于添加自己的索引帮助主题很有用.
 * 要强制特定顺序, 请使用排序集合.
 * <p>
 * 如果向构造函数提供了前言文本, 该文本将在索引中的第一项之前显示.
 */
public class IndexHelpTopic extends HelpTopic {

    protected String permission;
    protected String preamble;
    protected Collection<HelpTopic> allTopics;

    public IndexHelpTopic(@NotNull String name, @Nullable String shortText, @Nullable String permission, @NotNull Collection<HelpTopic> topics) {
        this(name, shortText, permission, topics, null);
    }

    public IndexHelpTopic(@NotNull String name, @Nullable String shortText, @Nullable String permission, @NotNull Collection<HelpTopic> topics, @Nullable String preamble) {
        this.name = name;
        this.shortText = (shortText == null) ? "" : shortText;
        this.permission = permission;
        this.preamble = (preamble == null) ? "" : preamble;
        setTopicsCollection(topics);
    }

    /**
     * 设置内部allTopics集合的内容.
     * <p>
     * 原文：
     * Sets the contents of the internal allTopics collection.
     *
     * @param topics 要设置的主题.
     */
    protected void setTopicsCollection(@NotNull Collection<HelpTopic> topics) {
        this.allTopics = topics;
    }

    @Override
    public boolean canSee(@NotNull CommandSender sender) {
        if (sender instanceof ConsoleCommandSender) {
            return true;
        }
        if (permission == null) {
            return true;
        }
        return sender.hasPermission(permission);
    }

    @Override
    public void amendCanSee(@Nullable String amendedPermission) {
        permission = amendedPermission;
    }

    @Override
    @NotNull
    public String getFullText(@NotNull CommandSender sender) {
        StringBuilder sb = new StringBuilder();

        if (preamble != null) {
            sb.append(buildPreamble(sender));
            sb.append("\n");
        }

        for (HelpTopic topic : allTopics) {
            if (topic.canSee(sender)) {
                String lineStr = buildIndexLine(sender, topic).replace("\n", ". ");
                if (sender instanceof Player && lineStr.length() > ChatPaginator.GUARANTEED_NO_WRAP_CHAT_PAGE_WIDTH) {
                    sb.append(lineStr, 0, ChatPaginator.GUARANTEED_NO_WRAP_CHAT_PAGE_WIDTH - 3);
                    sb.append("...");
                } else {
                    sb.append(lineStr);
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * 构建主题前言. 重写此方法可更改索引前言的外观.
     * <p>
     * 原文:
     * Builds the topic preamble. Override this method to change how the index
     * preamble looks.
     *
     * @param sender 请求前言的命令发送者
     * @return 主题前言
     */
    @NotNull
    protected String buildPreamble(@NotNull CommandSender sender) {
        return ChatColor.GRAY + preamble;
    }

    /**
     * 构建索引主题中的每一行. 重写此方法可更改索引行的渲染方式.
     * <p>
     * 原文:
     * Builds individual lines in the index topic. Override this method to
     * change how index lines are rendered.
     *
     * @param sender 请求索引行的命令发送者
     * @param topic  要渲染为索引行的主题
     * @return 渲染后的索引行
     */
    @NotNull
    protected String buildIndexLine(@NotNull CommandSender sender, @NotNull HelpTopic topic) {
        StringBuilder line = new StringBuilder();
        line.append(ChatColor.GOLD);
        line.append(topic.getName());
        line.append(": ");
        line.append(ChatColor.WHITE);
        line.append(topic.getShortText());
        return line.toString();
    }
}
