package org.bukkit.event.world;

import org.bukkit.block.Block;
import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 当传送门被创建时调用.
 */
public class PortalCreateEvent extends WorldEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final ArrayList<Block> blocks = new ArrayList<Block>();
    private CreateReason reason = CreateReason.FIRE;

    public PortalCreateEvent(final Collection<Block> blocks, final World world, CreateReason reason) {
        super(world);

        this.blocks.addAll(blocks);
        this.reason = reason;
    }

    /**
     * 获取与创建的传送门所相关连的所有区块的数组列表.
     * <p>
     * 原文:
     * Gets an array list of all the blocks associated with the created portal
     *
     * @return 与创建的门户所相关联的所有方块的数组列表
     */
    public ArrayList<Block> getBlocks() {
        return this.blocks;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 获取这个传送门的创建理由.
     * <p>
     * 原文:
     * Gets the reason for the portal's creation
     *
     * @return 传送门创建的CreateReason对象
     */
    public CreateReason getReason() {
        return reason;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * 指定传送门创建的各种原因的一个枚举
     */
    public enum CreateReason {
        /**
         * 当用'传统'的门框创建的传送门被火点燃时.
         */
        FIRE,
        /**
         * 当传送门使用自定义PortalTravelAgent时创建为现有传送门的目的地时.
         */
        OBC_DESTINATION
    }
}