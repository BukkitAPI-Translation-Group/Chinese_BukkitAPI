package org.bukkit.event.player;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家在配方书中解锁新配方(合成公式)时触发本事件.
 */
public class PlayerRecipeDiscoverEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private boolean cancel = false;
    private final NamespacedKey recipe;

    public PlayerRecipeDiscoverEvent(@NotNull Player who, @NotNull NamespacedKey recipe) {
        super(who);
        this.recipe = recipe;
    }

    /**
     * 获取本次解锁的配方的 NamespacedKey.
     * <p>
     * 原文:Get the namespaced key of the discovered recipe.
     *
     * @return 解锁的配方名
     */
    @NotNull
    public NamespacedKey getRecipe() {
        return recipe;
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
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
