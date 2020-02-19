package org.bukkit.event.raid;

import java.util.Collections;
import java.util.List;
import org.bukkit.Raid;
import org.bukkit.World;
import org.bukkit.entity.Raider;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当新一波袭击开始时触发本事件.
 */
public class RaidSpawnWaveEvent extends RaidEvent {

    private static final HandlerList handlers = new HandlerList();
    //
    private final List<Raider> raiders;
    private final Raider leader;

    public RaidSpawnWaveEvent(@NotNull Raid raid, @NotNull World world, @Nullable Raider leader, @NotNull List<Raider> raiders) {
        super(raid, world);
        this.raiders = raiders;
        this.leader = leader;
    }

    /**
     * 返回这一波袭击中的袭击队长.
     * <p>
     * 原文:Returns the patrol leader.
     *
     * @return {@link Raider 袭击队长实体}
     */
    @Nullable
    public Raider getPatrolLeader() {
        return leader;
    }

    /**
     * 返回本波袭击中已生成的所有{@link Raider 袭击者}.
     * <p>
     * 原文:Returns all {@link Raider} that spawned in this wave.
     *
     * @return 不可变的{@link Raider 袭击者}的列表
     */
    @NotNull
    public List<Raider> getRaiders() {
        return Collections.unmodifiableList(raiders);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
