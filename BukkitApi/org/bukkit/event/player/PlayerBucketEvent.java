package org.bukkit.event.player;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;

/**
 * 当玩家使用桶时触发本事件.
 * <p>原文: 
 * Called when a player interacts with a Bucket
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
     * 返回玩家手里的桶的类型. 
     * <p>
     * 假设玩家使用空桶装水,则会返回空桶的类型
     * <p>原文: 
     * Returns the bucket used in this event
     *
     * @return 使用中的桶
     */
    public Material getBucket() {
        return bucket;
    }

    /**
     * 得到使用桶之后会得到的物品堆叠. 
     * <p>
     * 假设玩家使用空桶装水,则会返回一个装满水的桶
     * <p>原文: 
     * Get the resulting item in hand after the bucket event
     *
     * @return 返回事件结果
     */
    public ItemStack getItemStack() {
        return itemStack;
    }

    /**
     * 设置使用桶之后得到的物品.
     * <p>
     * 假设玩家使用空桶装水,原来玩家会一个装满水的桶,你可以使用这个方法改变这个结果. 例如改成岩浆桶. 
     * <p>原文: 
     * Set the item in hand after the event
     *
     * @param itemStack 新的事件结果
     */
    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    /**
     * 玩家正在对着哪个方块使用桶,返回那个方块. 
     * <p>原文: 
     * Return the block clicked
     *
     * @return 方块
     */
    public Block getBlockClicked() {
        return blockClicked;
    }

    /**
     * 获取方块被点击的面.
     * 每个方块有6个面,玩家究竟是点击的哪个呢.
     * <p>原文: 
     * Get the face on the clicked block
     *
     * @return the clicked face
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