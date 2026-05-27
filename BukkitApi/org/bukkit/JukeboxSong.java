package org.bukkit;

import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.NotNull;

/**
 * 表示可以在唱片机中播放的歌曲。
 */
public interface JukeboxSong extends Keyed, Translatable, RegistryAware {

    public static final JukeboxSong THIRTEEN = get("13");
    public static final JukeboxSong CAT = get("cat");
    public static final JukeboxSong BLOCKS = get("blocks");
    public static final JukeboxSong CHIRP = get("chirp");
    public static final JukeboxSong FAR = get("far");
    public static final JukeboxSong MALL = get("mall");
    public static final JukeboxSong MELLOHI = get("mellohi");
    public static final JukeboxSong STAL = get("stal");
    public static final JukeboxSong STRAD = get("strad");
    public static final JukeboxSong WARD = get("ward");
    public static final JukeboxSong ELEVEN = get("11");
    public static final JukeboxSong WAIT = get("wait");
    public static final JukeboxSong PIGSTEP = get("pigstep");
    public static final JukeboxSong OTHERSIDE = get("otherside");
    public static final JukeboxSong FIVE = get("5");
    public static final JukeboxSong RELIC = get("relic");
    public static final JukeboxSong PRECIPICE = get("precipice");
    public static final JukeboxSong CREATOR = get("creator");
    public static final JukeboxSong CREATOR_MUSIC_BOX = get("creator_music_box");
    public static final JukeboxSong TEARS = get("tears");
    public static final JukeboxSong LAVA_CHICKEN = get("lava_chicken");

    @NotNull
    private static JukeboxSong get(@NotNull String key) {
        return Registry.JUKEBOX_SONG.getOrThrow(NamespacedKey.minecraft(key));
    }

    /**
     * {@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated 键可能并不总是存在，请改用 {@link #getKeyOrThrow()}。
     *
     * 原文：
     * A key might not always be present, use {@link #getKeyOrThrow()} instead.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    NamespacedKey getKey();
}