package org.bukkit.event.player;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;

/**
 * 当玩家用一个桶对其他东西互交时激发
 */
public abstract class PlayerBucketEvent extends PlayerEvent implements Cancellable {
    private ItemStack itemStack;
    private boolean cancelled = false;
    private final Block blockClicked;
    private final BlockFace blockFace;
    private final Material bucket;

    public PlayerBucketEvent(final Player who, final Block blockClicked, final BlockFace blockFace, final Material bucket, final ItemStack itemInHand) {
        super(who);
        this.blockClicked = blockClicked;
        this.blockFace = blockFace;
        this.itemStack = itemInHand;
        this.bucket = bucket;
    }

    /**
     * 获得被使用的那个桶
     *
     * @return 萌萌的桶
     */
    public Material getBucket() {
        return bucket;
    }

    /**
     * 获得事件过后玩家手里的东西
     *
     * @return 手里的物品
     */
    public ItemStack getItemStack() {
        return itemStack;
    }

    /**
     * 设置事件过后玩家手里的东西
     *
     * @param itemStack 要设置的东西
     */
    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    /**
     * 获得被点击的方块
     *
     * @return 被点击的方块
     */
    public Block getBlockClicked() {
        return blockClicked;
    }

    /**
     * 获得被点击的方块的面
     *
     * @return 方块的面
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
}