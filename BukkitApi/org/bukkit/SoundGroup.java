package org.bukkit;

import org.jetbrains.annotations.NotNull;

/**
 * 表示方块的声音组，当各种动作发生时播放（例如踩踏、破坏、击打等）。
 */
public interface SoundGroup {

    /**
     * 获取这些声音的播放音量。
     *
     * 请注意，此音量并不总是代表客户端接收的实际音量。
     *
     * @return 音量。
     *
     * 原文：
     * Get the volume these sounds are played at.
     *
     * Note that this volume does not always represent the actual volume
     * received by the client.
     *
     * @return volume
     */
    public float getVolume();

    /**
     * 获取这些声音的播放音高。
     *
     * 请注意，此音高并不总是代表客户端接收的实际音高。
     *
     * @return 音高。
     *
     * 原文：
     * Gets the pitch these sounds are played at.
     *
     * Note that this pitch does not always represent the actual pitch received
     * by the client.
     *
     * @return pitch
     */
    public float getPitch();

    /**
     * 获取此组对应的破坏声音。
     *
     * @return 破坏声音。
     *
     * 原文：
     * Gets the corresponding breaking sound for this group.
     *
     * @return the break sound
     */
    @NotNull
    public Sound getBreakSound();

    /**
     * 获取此组对应的踩踏声音。
     *
     * @return 踩踏声音。
     *
     * 原文：
     * Gets the corresponding step sound for this group.
     *
     * @return the step sound
     */
    @NotNull
    public Sound getStepSound();

    /**
     * 获取此组对应的放置声音。
     *
     * @return 放置声音。
     *
     * 原文：
     * Gets the corresponding place sound for this group.
     *
     * @return the place sound
     */
    @NotNull
    public Sound getPlaceSound();

    /**
     * 获取此组对应的击打声音。
     *
     * @return 击打声音。
     *
     * 原文：
     * Gets the corresponding hit sound for this group.
     *
     * @return the hit sound
     */
    @NotNull
    public Sound getHitSound();

    /**
     * 获取此组对应的摔落声音。
     *
     * @return 摔落声音。
     *
     * 原文：
     * Gets the corresponding fall sound for this group.
     *
     * @return the fall sound
     */
    @NotNull
    public Sound getFallSound();
}
