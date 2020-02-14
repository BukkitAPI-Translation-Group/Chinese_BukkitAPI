package org.bukkit.event.entity;

import org.bukkit.entity.Item;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ItemMergeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Item target;

    public ItemMergeEvent(@NotNull Item item, @NotNull Item target) {
        super(item);
        this.target = target;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @NotNull
    @Override
    public Item getEntity() {
        return (Item) entity;
    }

    /**
     * 获取主物品正在合并的物品实体.
     * <p>
     * 原文:Gets the Item entity the main Item is being merged into.
     *
     * @return 被合并的物品
     */
    @NotNull
    public Item getTarget() {
        return target;
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