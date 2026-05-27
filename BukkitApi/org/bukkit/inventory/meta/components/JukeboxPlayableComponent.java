package org.bukkit.inventory.meta.components;

import org.bukkit.JukeboxSong;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示一个可以插入唱片机的组件。
 */
@ApiStatus.Experimental
public interface JukeboxPlayableComponent extends ConfigurationSerializable {

    /**
     * 获取分配给此组件的歌曲。
     * <p>原文：Gets the song assigned to this component.
     *
     * @return 歌曲，如果服务器上不存在该歌曲则返回null
     */
    @Nullable
    JukeboxSong getSong();

    /**
     * 获取分配给此组件的歌曲的键。
     * <p>原文：Gets the key of the song assigned to this component.
     *
     * @return 歌曲键
     */
    @Nullable
    NamespacedKey getSongKey();

    /**
     * 设置分配给此组件的歌曲。
     * <p>原文：Sets the song assigned to this component.
     *
     * @param song 歌曲
     */
    void setSong(@NotNull JukeboxSong song);

    /**
     * 设置分配给此组件的歌曲的键。
     * <p>原文：Sets the key of the song assigned to this component.
     *
     * @param song 歌曲键
     */
    void setSongKey(@NotNull NamespacedKey song);
}
