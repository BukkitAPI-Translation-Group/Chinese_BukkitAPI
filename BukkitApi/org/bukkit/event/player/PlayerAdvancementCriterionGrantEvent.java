package org.bukkit.event.player;

import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerAdvancementCriterionGrantEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private final Advancement advancement;
    private final String criterion;
    private boolean cancelled;

    public PlayerAdvancementCriterionGrantEvent(@NotNull Player who, @NotNull Advancement advancement, @NotNull String criterion) {
        super(who);
        this.advancement = advancement;
        this.criterion = criterion;
    }

    /**
     * Gets the granted criterion.
     *
     * @return criterion
     */
    @NotNull
    public String getCriterion() {
        return this.criterion;
    }

    /**
     * Gets the affected advancement.
     *
     * @return affected {@link Advancement}
     */
    @NotNull
    public Advancement getAdvancement() {
        return this.advancement;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlersLists() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
