package org.bukkit.ban;

import java.util.Date;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.profile.PlayerProfile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 针对玩家配置文件封禁的 {@link BanList}.
 * <p>
 * 原文:
 * A {@link BanList} targeting player profile bans.
 */
public interface ProfileBanList extends BanList<PlayerProfile> {

    /**
     * {@inheritDoc}
     *
     * @param target 封禁的目标
     * @param reason 封禁原因, null表示使用实现默认值
     * @param expires 封禁的过期日期(解封日期), null表示永久封禁
     * @param source 封禁的来源, null表示使用实现默认值
     * @return 新创建的封禁条目, 或(更新后的)先前封禁条目
     * @throws IllegalArgumentException 如果PlayerProfile具有无效的UUID
     */
    @Nullable
    public BanEntry<PlayerProfile> addBan(@NotNull PlayerProfile target, @Nullable String reason, @Nullable Date expires, @Nullable String source);

}
