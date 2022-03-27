package org.bukkit.event.entity;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当一个实体因玩家在一个方块上"放置"一物品而创建时触发本事件.
 * <br>
 * 请注意此事件目前只因这四个指定的放置场景而触发:
 * 盔甲架, 船只, 矿车和末影水晶.
 */
public class EntityPlaceEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Player player;
    private final Block block;
    private final BlockFace blockFace;

    public EntityPlaceEvent(@NotNull final Entity entity, @Nullable final Player player, @NotNull final Block block, @NotNull final BlockFace blockFace) {
        super(entity);
        this.player = player;
        this.block = block;
        this.blockFace = blockFace;
    }

    /**
     * 返回放置此实体的玩家.
     * <p>
     * 原文:
     * Returns the player placing the entity
     *
     * @return 放置此实体的玩家
     */
    @Nullable
    public Player getPlayer() {
        return player;
    }

    /**
     * 返回实体被放置在的方块.
     * <p>
     * 原文:
     * Returns the block that the entity was placed on
     *
     * @return 实体被放置在哪个方块上
     */
    @NotNull
    public Block getBlock() {
        return block;
    }

    /**
     * 返回实体被放置在的方块的朝向.
     * <p>
     * 原文:
     * Returns the face of the block that the entity was placed on
     *
     * @return 实体被放置在的方块的朝向
     */
    @NotNull
    public BlockFace getBlockFace() {
        return blockFace;
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
