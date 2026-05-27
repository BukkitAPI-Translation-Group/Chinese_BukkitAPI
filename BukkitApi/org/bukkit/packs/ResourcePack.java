package org.bukkit.packs;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个资源包.
 *
 * @see <a href="https://minecraft.wiki/w/Resource_pack">Minecraft wiki</a>
 */
public interface ResourcePack {

    /**
     * 获取资源包的ID.
     * <p>
     * 原文：
     * Gets the id of the resource pack.
     *
     * @return ID
     */
    @NotNull
    public UUID getId();

    /**
     * 获取资源包的URL.
     * <p>
     * 原文：
     * Gets the url of the resource pack.
     *
     * @return URL
     */
    @NotNull
    public String getUrl();

    /**
     * 获取资源包的哈希值.
     * <p>
     * 原文：
     * Gets the hash of the resource pack.
     *
     * @return 哈希值
     */
    @Nullable
    public String getHash();

    /**
     * 获取资源包显示的提示信息.
     * <p>
     * 原文：
     * Gets the prompt to show of the resource pack.
     *
     * @return 提示信息
     */
    @Nullable
    public String getPrompt();

    /**
     * 获取资源包是否被服务器要求.
     * <p>
     * 原文：
     * Gets if the resource pack is required by the server.
     *
     * @return 如果是必需的则为True
     */
    public boolean isRequired();
}
