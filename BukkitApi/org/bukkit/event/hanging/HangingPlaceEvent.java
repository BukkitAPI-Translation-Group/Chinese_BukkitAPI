package org.bukkit.event.hanging;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当一个悬挂实体被放置时触发本事件。
 */
public class HangingPlaceEvent extends HangingEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Player player;
    private final Block block;
    private final BlockFace blockFace;
    private final ItemStack itemStack;

    @Deprecated
    public HangingPlaceEvent(@NotNull final Hanging hanging, @Nullable final Player player, @NotNull final Block block, @NotNull final BlockFace blockFace) {
        this(hanging, player, block, blockFace, null);
    }

    public HangingPlaceEvent(@NotNull final Hanging hanging, @Nullable final Player player, @NotNull final Block block, @NotNull final BlockFace blockFace, @Nullable ItemStack itemStack) {
        super(hanging);
        this.player = player;
        this.block = block;
        this.blockFace = blockFace;
        this.itemStack = itemStack;
    }

    /**
     * 返回放置这个悬挂实体的玩家.
     * <p>
     * 原文：Returns the player placing the hanging entity
     *
     * @return 放置这个悬挂实体的玩家
     */
    @Nullable
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
    @NotNull
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
    @NotNull
    public BlockFace getBlockFace() {
        return blockFace;
    }

    /**
     * 获取此悬挂实体的起源物品 (即用什么物品放置的).
     * <p>
     * 原文:Gets the item from which the hanging entity originated
     *
     * @return 此悬挂实体的起源物品
     */
    @Nullable
    public ItemStack getItemStack() {
        return itemStack;
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