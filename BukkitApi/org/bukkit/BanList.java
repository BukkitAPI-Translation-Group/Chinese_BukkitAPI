package org.bukkit;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 一个封禁列表，包含了一些{@link Type 封禁类型}
 *
 * @param <T> 封禁目标
 */
public interface BanList<T> {

    /**
     * 封禁类型.
     * <p>
     * 原文:Represents a ban-type that a {@link BanList} may track.
     */
    public enum Type {
        /**
         * 已封禁的玩家名称
         *
         * @deprecated 被 {@link #PROFILE} 取代
         */
        @Deprecated(since = "1.20.1")
        NAME,
        /**
         * 已封禁的玩家ip地址
         */
        IP,
        /**
         * 已封禁的玩家资料
         */
        PROFILE,
        ;
    }

    /**
     * 根据封禁目标(IP地址或玩家名)来获取对应的 {@link BanEntry}.
     * <p>
     * 原文：Gets {@link BanEntry} by target.
     *
     * @param target 封禁目标(IP地址或玩家名)
     * @return 对应的封禁条目, 如果没有则返回null
     * @deprecated 参见 {@link #getBanEntry(Object)}
     */
    @Deprecated(since = "1.20.1")
    @Nullable
    public BanEntry<T> getBanEntry(@NotNull String target);

    /**
     * 根据封禁目标(IP地址或玩家资料)来获取对应的 {@link BanEntry}.
     * <p>
     * 原文:Gets a {@link BanEntry} by target.
     *
     * @param target 封禁目标(IP地址或玩家资料)
     * @return 对应的封禁条目, 如果没有则返回null
     */
    @Nullable
    public BanEntry<T> getBanEntry(@NotNull T target);

    /**
     * 添加一个封禁到这个列表。如果以前的封禁存在，这将更新以前的封禁.
     * <p>
     * 原文：Adds a ban to the this list. If a previous ban exists, this will
     * update the previous entry.
     *
     * @param target 封禁目标
     * @param reason 封禁理由，null则使用默认
     * @param expires 封禁的截止日期(解除封禁)，null则为永远封禁
     * @param source 封禁来源，null则使用默认
     * @return 新创建的封禁条目，或为更新之前的封禁
     * @deprecated 参见 {@link #addBan(Object, String, Date, String)}
     */
    @Deprecated(since = "1.20.1")
    @Nullable
    public BanEntry<T> addBan(@NotNull String target, @Nullable String reason, @Nullable Date expires, @Nullable String source);

    /**
     * 添加一个封禁到这个列表。如果以前的封禁存在，这将更新以前的封禁.
     * <p>
     * 原文:Adds a ban to this list. If a previous ban exists, this will
     * update the previous entry.
     *
     * @param target 封禁目标
     * @param reason 封禁理由，null则使用默认
     * @param expires 封禁的截止日期(解除封禁)，null则为永远封禁
     * @param source 封禁来源，null则使用默认
     * @return 新创建的封禁条目，或为更新之前的封禁
     */
    @Nullable
    public BanEntry<T> addBan(@NotNull T target, @Nullable String reason, @Nullable Date expires, @Nullable String source);

    /**
     * 添加一个封禁到这个列表。如果以前的封禁存在，这将更新以前的封禁.
     * <p>
     * 原文:Adds a ban to this list. If a previous ban exists, this will
     * update the previous entry.
     *
     * @param target 封禁目标
     * @param reason 封禁理由，null则使用默认
     * @param expires 封禁的截止日期(解除封禁)，null则为永远封禁
     * @param source 封禁来源，null则使用默认
     * @return 新创建的封禁条目，或为更新之前的封禁
     */
    @Nullable
    public BanEntry<T> addBan(@NotNull T target, @Nullable String reason, @Nullable Instant expires, @Nullable String source);

    /**
     * 添加一个封禁到这个列表。如果以前的封禁存在，这将更新以前的封禁.
     * <p>
     * 原文:Adds a ban to this list. If a previous ban exists, this will
     * update the previous entry.
     *
     * @param target 封禁目标
     * @param reason 封禁理由，null则使用默认
     * @param duration 封禁持续时长, null则为永远封禁
     * @param source 封禁来源，null则使用默认
     * @return 新创建的封禁条目，或为更新之前的封禁
     */
    @Nullable
    public BanEntry<T> addBan(@NotNull T target, @Nullable String reason, @Nullable Duration duration, @Nullable String source);

    /**
     * 获取此列表包含的所有{@link BanEntry}.
     * <p>
     * 原文:
     * Gets a set containing every {@link BanEntry} in this list.
     *
     * @return 包含了通过此列表跟踪的每个BanEntry的一个不可变列表
     * @deprecated 该方法返回了一个形参化类的原始使用, 推荐使用带泛型参数的 {@link #getEntries()}
     */
    @Deprecated(since = "1.20.1")
    @NotNull
    public Set<BanEntry> getBanEntries();

    /**
     * 获取此列表包含的所有{@link BanEntry}.
     * <p>
     * 原文:
     * Gets a set containing every {@link BanEntry} in this list.
     *
     * @return 包含了通过此列表跟踪的每个BanEntry的一个不可变列表
     */
    @NotNull
    public Set<BanEntry<T>> getEntries();

    /**
     * 获取此目标的封禁状态.
     * <p>
     * 原文:Gets if a {@link BanEntry} exists for the target, indicating an active
     * ban status.
     *
     * @param target 寻找的目标
     * @return 如果{@link BanEntry}存在这个目标则表示被封禁了，否则为false
     */
    public boolean isBanned(@NotNull T target);

    /**
     * 获取此目标的封禁状态.
     * <p>
     * 原文:
     * Gets if a {@link BanEntry} exists for the target, indicating an active
     * ban status.
     *
     * @param target 寻找的目标
     * @return 如果{@link BanEntry}存在这个目标则表示被封禁了，否则为false
     * @deprecated 参见 {@link #isBanned(Object)}
     */
    @Deprecated(since = "1.20.1")
    public boolean isBanned(@NotNull String target);

    /**
     * 从列表中移除指定目标，因此表示“无封禁”的状态(即解除封禁).
     * <p>
     * 原文:
     * Removes the specified target from this list, therefore indicating a
     * "not banned" status.
     *
     * @param target 从这个列表移除的目标(解除封禁)
     */
    public void pardon(@NotNull T target);

    /**
     * 从列表中移除指定目标，因此表示“无封禁”的状态(即解除封禁).
     * <p>
     * 原文:
     * Removes the specified target from this list, therefore indicating a
     * "not banned" status.
     *
     * @param target 从这个列表移除的目标(解除封禁)
     *
     * @deprecated 参见 {@link #pardon(Object)}
     */
    @Deprecated(since = "1.20.1")
    public void pardon(@NotNull String target);
}
