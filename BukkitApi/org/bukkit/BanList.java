package org.bukkit;

import java.util.Date;
import java.util.Set;

/**
 * 一个封禁列表。包含了封禁和一些类型( {@link Type} ).
 */
public interface BanList {

    /**
     * 封禁类型。
     * <p>
     * 原文：Represents a ban-type that a {@link BanList} may track.
     * <p>
     * 译注：就是，这个封禁是根据IP封禁还是根据玩家名封禁
     */
    public enum Type {
        /**
         * 已封禁的玩家名称
         */
        NAME,
        /**
         * 已封禁的玩家ip地址
         */
        IP,
        ;
    }

    /**
     * 根据封禁目标(IP地址或玩家名)来得到对应的{@link BanEntry}
     * <p>
     * 原文：Gets {@link BanEntry} by target.
     *
     * @param target 封禁目标(IP地址或玩家名)
     * @return 这个封禁的Entry。如果没有则返回null
     */
    public BanEntry getBanEntry(String target);

    /**
     * 添加一个封禁到这个列表。如果以前的封禁存在，这将更新以前的封禁.
     * <p>
     * 原文：Adds a ban to the this list. If a previous ban exists, this will
     * update the previous entry.
     *
     * @param target 封禁目标
     * @param reason 封禁理由，null则使用默认
     * @param expires 封禁的截止日期(解除封口)，null则为永远封禁
     * @param source 封禁来源，null则使用默契
     * @return 新创建的封禁条目，或为更新之前的封禁
     */
    public BanEntry addBan(String target, String reason, Date expires, String source);

    /**
     * Gets a set containing every {@link BanEntry} in this list.
     *
     * @return an immutable set containing every entry tracked by this list
     */
    public Set<BanEntry> getBanEntries();

    /**
     * 获取如果{@link BanEntry}存在这个目标，则表示活动的封禁状态.
     * <p>
     * 译注:其实就是获取这个目标有没有封禁.
     * <p>
     * 原文:
     * Gets if a {@link BanEntry} exists for the target, indicating an active
     * ban status.
     *
     * @param target 寻找的目标
     * @return 如果{@link BanEntry}存在这个名称则表示被封禁了，否则为false
     */
    public boolean isBanned(String target);

    /**
     * 
     * <p>
     * 原文:
     * Removes the specified target from this list, therefore indicating a
     * "not banned" status.
     *
     * @param target the target to remove from this list
     */
    public void pardon(String target);
}