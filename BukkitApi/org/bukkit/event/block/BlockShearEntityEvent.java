package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当发射器剪掉附近的羊的羊毛时触发本事件 (发射器内含剪刀时有机会触发本事件).
 * <p>
 * 译注:不仅是羊会有这种行为, 修剪哞菇/雪傀儡时也可触发本事件. 详见 Minecraft Wiki 中对发射器和剪刀行为的描述.
 */
public class BlockShearEntityEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private final Entity sheared;
    private final ItemStack tool;
    private boolean cancelled;

    public BlockShearEntityEvent(@NotNull Block dispenser, @NotNull Entity sheared, @NotNull ItemStack tool) {
        super(dispenser);
        this.sheared = sheared;
        this.tool = tool;
    }

    /**
     * 获取被剪的实体.
     * <p>
     * 原文:Gets the entity that was sheared.
     *
     * @return 被剪的实体
     */
    @NotNull
    public Entity getEntity() {
        return sheared;
    }

    /**
     * 获取剪这只羊(实体)的工具.
     * <p>
     * 原文:Gets the item used to shear this sheep.
     *
     * @return 剪这只羊(实体)的工具
     */
    @NotNull
    public ItemStack getTool() {
        return tool.clone();
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
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
