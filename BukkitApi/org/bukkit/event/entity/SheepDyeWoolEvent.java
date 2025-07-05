package org.bukkit.event.entity;

import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当羊身上的毛被染色时触发本事件.
 */
public class SheepDyeWoolEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private DyeColor color;
    private final Player player;

    @Deprecated(since = "1.17.1")
    public SheepDyeWoolEvent(@NotNull final Sheep sheep, @NotNull final DyeColor color) {
        this(sheep, color, null);
    }

    public SheepDyeWoolEvent(@NotNull final Sheep sheep, @NotNull final DyeColor color, @Nullable Player player) {
        super(sheep);
        this.cancel = false;
        this.color = color;
        this.player = player;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @NotNull
    @Override
    public Sheep getEntity() {
        return (Sheep) entity;
    }

    /**
     * 返回正在给这只羊染色的玩家 (若存在).
     * <p>
     * 原文:Returns the player dyeing the sheep, if available.
     *
     * @return 玩家对象, 不存在则为 null
     */
    @Nullable
    public Player getPlayer() {
        return player;
    }

    /**
     * 获取这只羊将被染上的颜色.
     * <p>
     * 原文:Gets the DyeColor the sheep is being dyed
     *
     * @return 被染上的颜色
     */
    @NotNull
    public DyeColor getColor() {
        return color;
    }

    /**
     * 设置这只羊将被染上的颜色.
     * <p>
     * 原文:Sets the DyeColor the sheep is being dyed
     *
     * @param color 被染上的颜色
     */
    public void setColor(@NotNull DyeColor color) {
        this.color = color;
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
