package org.bukkit.event.weather;

import org.bukkit.World;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 雷击事件
 */
public class LightningStrikeEvent extends WeatherEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;
    private final LightningStrike bolt;
    private final Cause cause;

    @Deprecated
    public LightningStrikeEvent(@NotNull final World world, @NotNull final LightningStrike bolt) {
        this(world, bolt, Cause.UNKNOWN);
    }

    public LightningStrikeEvent(@NotNull final World world, @NotNull final LightningStrike bolt, @NotNull final Cause cause) {
        super(world);
        this.bolt = bolt;
        this.cause = cause;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        canceled = cancel;
    }

    /**
     * 获取从天空中打下的雷电.
     * <p>
     * 原文:
     * Gets the bolt which is striking the earth.
     *
     * @return 雷电的实体
     */
    @NotNull
    public LightningStrike getLightning() {
        return bolt;
    }

    /**
     * 获取发生此次雷击的原因.
     * <p>
     * 原文:
     * Gets the cause of this lightning strike.
     *
     * @return 雷击发生原因
     */
    @NotNull
    public Cause getCause() {
        return cause;
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

    public enum Cause {
        /**
         * 由"/summon"命令触发.
         */
        COMMAND,
        /**
         * 由插件触发.
         */
        CUSTOM,
        /**
         * 由刷怪笼触发.
         */
        SPAWNER,
        /**
         * 由附魔的三叉戟触发.
         */
        TRIDENT,
        /**
         * 由骷髅马陷阱触发.
         */
        TRAP,
        /**
         * 在雷暴天气中产生.
         */
        WEATHER,
        /**
         * 未知触发原因.
         */
        UNKNOWN;
    }
}