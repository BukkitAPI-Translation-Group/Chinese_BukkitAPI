package org.bukkit.event.raid;

import java.util.Collections;
import java.util.List;
import org.bukkit.Raid;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当{@link Raid 袭击}以一个清晰的结果结束时触发本事件.
 */
public class RaidFinishEvent extends RaidEvent {

    private static final HandlerList handlers = new HandlerList();
    //
    private final List<Player> winners;

    public RaidFinishEvent(@NotNull Raid raid, @NotNull World world, @NotNull List<Player> winners) {
        super(raid, world);
        this.winners = winners;
    }

    /**
     * 返回包含了所有赢家的不可变列表.
     * <br>
     * 注意:被认定为英雄的玩家最终不在线的话将不会包括在此列表内.
     * <p>
     * 原文:Returns an immutable list contains all winners.
     * <br>
     * <b>Note: Players who are considered as heroes but were not online at the
     * end would not be included in this list.</b>
     *
     * @return 所有赢家
     */
    @NotNull
    public List<Player> getWinners() {
        return Collections.unmodifiableList(winners);
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
