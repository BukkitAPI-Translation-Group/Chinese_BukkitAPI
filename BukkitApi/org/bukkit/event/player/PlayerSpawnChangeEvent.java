package org.bukkit.event.player;

import com.google.common.base.Preconditions;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当玩家的重生点改变时触发此事件.
 */
public class PlayerSpawnChangeEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Cause cause;
    private Location newSpawn;
    private boolean forced;
    private boolean cancelled;

    public PlayerSpawnChangeEvent(@NotNull final Player player, @Nullable Location newSpawn, boolean forced, @NotNull final Cause cause) {
        super(player);
        this.newSpawn = newSpawn;
        this.cause = cause;
        this.forced = forced;
    }

    /**
     * 获取重生点改变的原因.
     * <p>
     * 原文：
     * Gets the cause of spawn change.
     *
     * @return 改变原因
     */
    @NotNull
    public Cause getCause() {
        return this.cause;
    }

    /**
     * 获取重生位置是否将被使用，无论床是否被阻挡.
     * <p>
     * 原文：
     * Gets if the spawn position will be used regardless of bed obstruction
     * rules.
     *
     * @return 如果是强制的则为 true
     */
    public boolean isForced() {
        return this.forced;
    }

    /**
     * 设置重生位置是否将被使用，无论床是否被阻挡.
     * <p>
     * 原文：
     * Sets if the spawn position will be used regardless of bed obstruction
     * rules.
     *
     * @param forced 如果是强制的则为 true
     */
    public void setForced(boolean forced) {
        this.forced = forced;
    }

    /**
     * 获取要设置的新重生点.
     * <p>
     * 原文：
     * Gets the new spawn to be set.
     *
     * @return 新重生点位置
     */
    @Nullable
    public Location getNewSpawn() {
        return this.newSpawn;
    }

    /**
     * 设置新的重生点位置.
     * <p>
     * 原文：
     * Sets the new spawn location.
     *
     * @param newSpawn 新重生点位置，世界不能为 null
     */
    public void setNewSpawn(@Nullable Location newSpawn) {
        if (newSpawn != null) {
            Preconditions.checkArgument(newSpawn.getWorld() != null, "Spawn location must have a world set");
            this.newSpawn = newSpawn.clone();
        } else {
            this.newSpawn = null;
        }
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
         * 表示重生点由命令设置.
         */
        COMMAND,
        /**
         * 表示重生点由玩家与床交互设置.
         */
        BED,
        /**
         * 表示重生点由玩家与重生锚交互设置.
         */
        RESPAWN_ANCHOR,
        /**
         * 表示重生点由插件使用设置.
         */
        PLUGIN,
        /**
         * 表示重生点因无效的床位置或空的重生锚而重置.
         */
        RESET,
        /**
         * 表示重生点因未知原因而改变.
         */
        UNKNOWN;
    }
}
