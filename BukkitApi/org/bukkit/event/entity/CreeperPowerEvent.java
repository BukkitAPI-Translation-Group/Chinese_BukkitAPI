package org.bukkit.event.entity;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当爬行者被闪电击中时触发该事件.
 * <p>
 * 若该事件被取消,那么爬行者将不会被强化.
 * 原文:
 * Called when a Creeper is struck by lightning.
 * <p>
 * If a Creeper Power event is cancelled, the Creeper will not be powered.
 */
public class CreeperPowerEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;
    private final PowerCause cause;
    private LightningStrike bolt;

    public CreeperPowerEvent(final Creeper creeper, final LightningStrike bolt, final PowerCause cause) {
        this(creeper, cause);
        this.bolt = bolt;
    }

    public CreeperPowerEvent(final Creeper creeper, final PowerCause cause) {
        super(creeper);
        this.cause = cause;
    }

    public boolean isCancelled() {
        return canceled;
    }

    public void setCancelled(boolean cancel) {
        canceled = cancel;
    }

    @Override
    public Creeper getEntity() {
        return (Creeper) entity;
    }

    /**
     * 返回击中爬行者的闪电 (LightningStrike)类
     * @return 击中爬行者的闪电 (LightningStrike)类
     * 原文:
     * Gets the lightning bolt which is striking the Creeper.
     *
     * @return The Entity for the lightning bolt which is striking the Creeper
     */
    public LightningStrike getLightning() {
        return bolt;
    }

    /**
     * 返回爬行者被强(弱)化的原因
     * @return 爬行者被强(弱)化的原因
     * 原文:
     * Gets the cause of the creeper being (un)powered.
     *
     * @return A PowerCause value detailing the cause of change in power.
     */
    public PowerCause getCause() {
        return cause;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * 造成这次强化的原因
     * 原文:
     * An enum to specify the cause of the change in power
     */
    public enum PowerCause {

        /**
         * 由于闪电击中导致的强化
         * <p>
         * Powered state: true (强化)
         * 原文:
         * Power change caused by a lightning bolt
         * <p>
         * Powered state: true
         */
        LIGHTNING,
        /**
         * 由于其他原因造成的强化 (可能是插件)
         * <p>
         * Powered state: true (强化)
         * Power change caused by something else (probably a plugin)
         * <p>
         * Powered state: true
         */
        SET_ON,
        /**
         * 由于其他原因造成的弱化 (可能是插件)
         * <p>
         * Powered state: false (弱化)
         * 原文:
         * Power change caused by something else (probably a plugin)
         * <p>
         * Powered state: false
         */
        SET_OFF
    }
}
