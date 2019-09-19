package org.bukkit.entity;

import org.bukkit.boss.BossBar;

/**
 * 代表一个Boss实体.
 * <p>
 * 原文:
 * Represents the Boss Entity.
 */
public interface Boss extends Entity {

    /**
     * 返回这个 {@link Boss} 的 {@link BossBar}.
     * <p>
     * 原文:
     * Returns the {@link BossBar} of the {@link Boss}
     *
     * @return 此实体的 {@link BossBar}. 
     */
    BossBar getBossBar();
}
