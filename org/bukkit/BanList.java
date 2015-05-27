package org.bukkit;

import java.util.Date;
import java.util.Set;

/**
 * 一个封禁列表。包含了封禁和一些 {@link Type}.
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
         * Banned player names
         */
        NAME,
        /**
         * Banned player IP addresses
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
     * 原文：Adds a ban to the this list. If a previous ban exists, this will
     * update the previous entry.
     *
     * @param target the target of the ban
     * @param reason reason for the ban, null indicates implementation default
     * @param expires date for the ban's expiration (unban), or null to imply
     *     forever
     * @param source source of the ban, null indicates implementation default
     * @return the entry for the newly created ban, or the entry for the
     *     (updated) previous ban
     */
    public BanEntry addBan(String target, String reason, Date expires, String source);

    /**
     * Gets a set containing every {@link BanEntry} in this list.
     *
     * @return an immutable set containing every entry tracked by this list
     */
    public Set<BanEntry> getBanEntries();

    /**
     * Gets if a {@link BanEntry} exists for the target, indicating an active
     * ban status.
     *
     * @param target the target to find
     * @return true if a {@link BanEntry} exists for the name, indicating an
     *     active ban status, false otherwise
     */
    public boolean isBanned(String target);

    /**
     * Removes the specified target from this list, therefore indicating a
     * "not banned" status.
     *
     * @param target the target to remove from this list
     */
    public void pardon(String target);
}
