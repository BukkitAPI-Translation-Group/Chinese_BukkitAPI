package org.bukkit.event.player;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 水桶装满水事件.
 */
public class PlayerBucketFillEvent extends PlayerBucketEvent {
    private static final HandlerList handlers = new HandlerList();

    @Deprecated(since = "1.14.4")
    public PlayerBucketFillEvent(@NotNull final Player who, @NotNull final Block blockClicked, @NotNull final BlockFace blockFace, @NotNull final Material bucket, @NotNull final ItemStack itemInHand) {
        super(who, blockClicked, blockFace, bucket, itemInHand);
    }

    @Deprecated(since = "1.19.2")
    public PlayerBucketFillEvent(@NotNull final Player who, @NotNull final Block block, @NotNull final Block blockClicked, @NotNull final BlockFace blockFace, @NotNull final Material bucket, @NotNull final ItemStack itemInHand) {
        super(who, block, blockClicked, blockFace, bucket, itemInHand);
    }

    public PlayerBucketFillEvent(@NotNull final Player who, @NotNull final Block block, @NotNull final Block blockClicked, @NotNull final BlockFace blockFace, @NotNull final Material bucket, @NotNull final ItemStack itemInHand, @NotNull final EquipmentSlot hand) {
        super(who, block, blockClicked, blockFace, bucket, itemInHand, hand);
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