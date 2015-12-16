package org.bukkit.event.hanging;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个悬挂实体被放置时触发本事件。
 */
public class HangingPlaceEvent extends HangingEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Player player;
    private final Block block;
    private final BlockFace blockFace;

    public HangingPlaceEvent(final Hanging hanging, final Player player, final Block block, final BlockFace blockFace) {
        super(hanging);
        this.player = player;
        this.block = block;
        this.blockFace = blockFace;
    }

    /**
     * 返回放置这个悬挂实体的玩家.
     * <p>
     * 原文：Returns the player placing the hanging entity
     *
     * @return 放置这个悬挂实体的玩家
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 返回这个悬挂实体被放置在哪个方块上.
     * <p>
     * 原文：Returns the block that the hanging entity was placed on
     *
     * @return 这个悬挂实体被放置在哪个方块上
     */
    public Block getBlock() {
        return block;
    }

    /**
     * 返回这个悬挂实体被放置在的方块的朝向.
     * <p>
     * 原文：Returns the face of the block that the hanging entity was placed on
     *
     * @return 这个方块的朝向
     */
    public BlockFace getBlockFace() {
        return blockFace;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}