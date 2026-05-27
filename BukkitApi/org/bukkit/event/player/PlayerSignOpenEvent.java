package org.bukkit.event.player;

import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家打开告示牌时触发此事件.
 */
public class PlayerSignOpenEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Sign sign;
    private final Side side;
    private final Cause cause;
    private boolean cancelled;

    public PlayerSignOpenEvent(@NotNull final Player player, @NotNull final Sign sign, @NotNull final Side side, @NotNull final Cause cause) {
        super(player);
        this.sign = sign;
        this.side = side;
        this.cause = cause;
    }

    /**
     * 获取被打开的告示牌.
     * <p>
     * 原文：
     * Gets the sign that was opened.
     *
     * @return 被打开的告示牌
     */
    @NotNull
    public Sign getSign() {
        return this.sign;
    }

    /**
     * 获取被打开的告示牌的面.
     * <p>
     * 原文：
     * Gets side of the sign opened.
     *
     * @return 被打开的告示牌的面
     */
    @NotNull
    public Side getSide() {
        return this.side;
    }

    /**
     * 获取告示牌打开的原因.
     * <p>
     * 原文：
     * Gets the cause of the sign open.
     *
     * @return 告示牌打开的原因
     */
    @NotNull
    public Cause getCause() {
        return this.cause;
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

    public enum Cause {

        /**
         * 表示告示牌因交互而被打开.
         */
        INTERACT,
        /**
         * 表示告示牌因放置而被打开.
         */
        PLACE,
        /**
         * 表示告示牌因插件而被打开.
         */
        PLUGIN,
        /**
         * 表示告示牌因未知原因而被打开.
         */
        UNKNOWN;
    }
}
