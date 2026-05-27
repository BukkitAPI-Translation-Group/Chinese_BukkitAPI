package org.bukkit;

import java.net.URI;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示可以发送给客户端的链接集合。
 */
public interface ServerLinks {

    /**
     * 获取给定类型的链接（如果存在）。
     *
     * @param type 链接类型。
     * @return 链接或 null。
     *
     * 原文：
     * Gets the link of a given type, if it exists.
     *
     * @param type link type
     * @return link or null
     */
    @Nullable
    ServerLink getLink(@NotNull Type type);

    /**
     * 获取所有链接的不可变列表。
     *
     * @return 不可变列表。
     *
     * 原文：
     * Gets an immutable list of all links.
     *
     * @return immutable list
     */
    @NotNull
    List<ServerLink> getLinks();

    /**
     * 添加给定的链接，如果已设置相同类型的链接，则覆盖第一个链接。
     *
     * @param type 链接类型。
     * @param url 链接 URL。
     * @return 添加的链接。
     *
     * 原文：
     * Adds the given link, overwriting the first link of the same type if
     * already set.
     *
     * @param type link type
     * @param url link url
     * @return the added link
     */
    @NotNull
    ServerLink setLink(@NotNull Type type, @NotNull URI url);

    /**
     * 将给定的链接添加到链接列表中。
     *
     * @param type 链接类型。
     * @param url 链接 URL。
     * @return 添加的链接。
     *
     * 原文：
     * Adds the given link to the list of links.
     *
     * @param type link type
     * @param url link url
     * @return the added link
     */
    @NotNull
    ServerLink addLink(@NotNull Type type, @NotNull URI url);

    /**
     * 将给定的链接添加到链接列表中。
     *
     * @param displayName 链接名称/显示文本。
     * @param url 链接 URL。
     * @return 添加的链接。
     *
     * 原文：
     * Adds the given link to the list of links.
     *
     * @param displayName link name / display text
     * @param url link url
     * @return the added link
     */
    @NotNull
    ServerLink addLink(@NotNull String displayName, @NotNull URI url);

    /**
     * 移除给定的链接。
     *
     * @param link 要移除的链接。
     * @return 链接是否存在并被移除。
     *
     * 原文：
     * Removes the given link.
     *
     * @param link the link to remove
     * @return if the link existed and was removed
     */
    boolean removeLink(@NotNull ServerLink link);

    /**
     * 返回此链接集合的副本，与服务器解除关联。
     *
     * @return 复制的链接。
     *
     * 原文：
     * Returns a copy of this link collection, unassociated from the server.
     *
     * @return copied links
     */
    @NotNull
    ServerLinks copy();

    /**
     * 表示服务器链接。
     */
    public interface ServerLink {

        /**
         * 获取此链接的类型（如果它是已知的特殊类型）。
         *
         * @return 类型或 null。
         *
         * 原文：
         * Gets the type of this link if it is a known special type.
         *
         * @return type or null
         */
        @Nullable
        Type getType();

        /**
         * 获取此链接的显示名称/文本。
         *
         * @return 显示名称。
         *
         * 原文：
         * Gets the display name/text of this link.
         *
         * @return display name
         */
        @NotNull
        String getDisplayName();

        /**
         * 获取此链接的 URL。
         *
         * @return 链接 URL。
         *
         * 原文：
         * Gets the url of this link.
         *
         * @return link url
         */
        @NotNull
        URI getUrl();
    }

    /**
     * 表示已知类型的链接，将由客户端翻译，并可能具有特殊功能。
     */
    public enum Type {

        /**
         * 错误报告链接，可能出现在断开连接/崩溃屏幕上。
         */
        REPORT_BUG,
        COMMUNITY_GUIDELINES,
        SUPPORT,
        STATUS,
        FEEDBACK,
        COMMUNITY,
        WEBSITE,
        FORUMS,
        NEWS,
        ANNOUNCEMENTS;
    }
}