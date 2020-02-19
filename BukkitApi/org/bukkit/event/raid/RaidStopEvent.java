package org.bukkit.event.raid;

import org.bukkit.Raid;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当{@link Raid 袭击}终止时触发本事件.
 */
public class RaidStopEvent extends RaidEvent {

    private static final HandlerList handlers = new HandlerList();
    //
    private final Reason reason;

    public RaidStopEvent(@NotNull Raid raid, @NotNull World world, @NotNull Reason reason) {
        super(raid, world);
        this.reason = reason;
    }

    /**
     * 返回袭击终止原因.
     * <p>
     * 原文:Returns the stop reason.
     *
     * @return 原因
     */
    @NotNull
    public Reason getReason() {
        return reason;
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

    public enum Reason {

        /**
         * 由于游戏难度被调为和平.
         */
        PEACE,
        /**
         * 此袭击耗时太长, 没有最终结果.
         */
        TIMEOUT,
        /**
         * 袭击正常结束.
         */
        FINISHED,
        /**
         * 找不到合适的地点生成袭击者.
         */
        UNSPAWNABLE,
        /**
         * 发生袭击的位置不再是一个村庄.
         */
        NOT_IN_VILLAGE
    }
}
