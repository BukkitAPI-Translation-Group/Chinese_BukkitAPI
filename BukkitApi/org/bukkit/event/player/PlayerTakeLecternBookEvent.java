package org.bukkit.event.player;

import org.bukkit.block.Lectern;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当玩家点击按钮从讲台上取走书时触发此事件。如果此事件被取消，书将保留在讲台上.
 */
public class PlayerTakeLecternBookEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private boolean cancelled;
    private final Lectern lectern;

    public PlayerTakeLecternBookEvent(@NotNull Player who, @NotNull Lectern lectern) {
        super(who);
        this.lectern = lectern;
    }

    /**
     * 获取涉及的讲台.
     * <p>
     * 原文：
     * Gets the lectern involved.
     *
     * @return 讲台
     */
    @NotNull
    public Lectern getLectern() {
        return lectern;
    }

    /**
     * 获取讲台上的当前 ItemStack.
     * <p>
     * 原文：
     * Gets the current ItemStack on the lectern.
     *
     * @return 讲台上的 ItemStack
     */
    @Nullable
    public ItemStack getBook() {
        return lectern.getInventory().getItem(0);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
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
}
