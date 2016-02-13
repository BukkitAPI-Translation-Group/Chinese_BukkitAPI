package org.bukkit.event.entity;

import java.util.List;
import org.bukkit.PortalType;
import org.bukkit.block.BlockState;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个{@link LivingEntity}在世界中创建传送门时触发该事件.
 */
public class EntityCreatePortalEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final List<BlockState> blocks;
    private boolean cancelled = false;
    private PortalType type = PortalType.CUSTOM;

    public EntityCreatePortalEvent(final LivingEntity what, final List<BlockState> blocks, final PortalType type) {
        super(what);

        this.blocks = blocks;
        this.type = type;
    }

    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    /**
     * 返回与这个传送门有关的所有方块.
     * <p>
     * 原文:
     * Gets a list of all blocks associated with the portal.
     *
     * @return 将被改变的方块列表.
     */
    public List<BlockState> getBlocks() {
        return blocks;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * 返回正在尝试创建的传送门类型.
     * <p>
     * 原文:
     * Gets the type of portal that is trying to be created.
     *
     * @return 传送门类型
     */
    public PortalType getPortalType() {
        return type;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}