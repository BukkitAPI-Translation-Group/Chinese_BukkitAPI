package org.bukkit.event.world;

import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当世界内的世界发生快进时调用.
 * <p>
 * 如果本事件被取消, 时间将不会改变.
 */
public class TimeSkipEvent extends WorldEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private boolean cancelled;
    private final SkipReason skipReason;
    private long skipAmount;

    public TimeSkipEvent(@NotNull World world, @NotNull SkipReason skipReason, @NotNull long skipAmount) {
        super(world);
        this.skipReason = skipReason;
        this.skipAmount = skipAmount;
    }

    /**
     * 获取发生时间快进的原因.
     * <p>
     * 原文:
     * Gets the reason why the time has skipped.
     *
     * @return 时间快进的原因
     */
    @NotNull
    public SkipReason getSkipReason() {
        return skipReason;
    }

    /**
     * 获取快进了多少时间.
     * <p>
     * 原文:
     * Gets the amount of time that was skipped.
     *
     * @return 时间快进了多久
     */
    public long getSkipAmount() {
        return skipAmount;
    }

    /**
     * 设置快进的时间.
     * <p>
     * 原文:Sets the amount of time to skip.
     *
     * @param skipAmount 快进的时间
     */
    public void setSkipAmount(long skipAmount) {
        this.skipAmount = skipAmount;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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

    /**
     * 时间快进原因枚举.
     */
    public enum SkipReason {

        /**
         * 因使用"/time"命令.
         */
        COMMAND,
        /**
         * 因插件调整了时间.
         */
        CUSTOM,
        /**
         * 世界内的所有玩家在床上睡觉, 度过夜晚.
         */
        NIGHT_SKIP
    }
}
