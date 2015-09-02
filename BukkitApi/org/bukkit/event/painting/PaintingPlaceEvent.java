package org.bukkit.event.painting;

import org.bukkit.Warning;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一幅画被放置时触发.
 *
 * @deprecated 用{@link org.bukkit.event.hanging.HangingBreakByEntityEvent}代替.
 */
@Deprecated
@Warning(reason="This event has been replaced by HangingPlaceEvent")
public class PaintingPlaceEvent extends PaintingEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Player player;
    private final Block block;
    private final BlockFace blockFace;

    public PaintingPlaceEvent(final Painting painting, final Player player, final Block block, final BlockFace blockFace) {
        super(painting);
        this.player = player;
        this.block = block;
        this.blockFace = blockFace;
    }

    /**
     * 获取放置这幅画的玩家.
     * <p>
     * 原文:Returns the player placing the painting
     *
     * @return 放置这幅画的玩家
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 返回画被放置在哪个方块.
     * <p>
     * 原文:Returns the block that the painting was placed on
     *
     * @return 画被放置在哪个方块
     */
    public Block getBlock() {
        return block;
    }

    /**
     * 返回被放置画的方块的朝向.
     * <p>
     * 原文:Returns the face of the block that the painting was placed on
     *
     * @return 方块的朝向
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
