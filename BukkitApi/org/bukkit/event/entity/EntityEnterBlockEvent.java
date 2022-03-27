package org.bukkit.event.entity;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当{@link Entity 实体}进入方块, 保存到那个方块时触发本事件.
 * <p>
 * 蜜蜂进入蜂巢时会触发本事件.
 * <br>
 * 蠹虫“进入”石头方块则不会触发本事件. 对于这种情况,
 * 请监听 {@link EntityChangeBlockEvent}.
 */
public class EntityEnterBlockEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Block block;
    private boolean cancel;

    public EntityEnterBlockEvent(@NotNull final Entity entity, @NotNull final Block block) {
        super(entity);

        this.block = block;
    }

    /**
     * 获取实体将进入的方块.
     * <p>
     * 原文:
     * Get the block the entity will enter.
     *
     * @return 方块
     */
    @NotNull
    public Block getBlock() {
        return block;
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
