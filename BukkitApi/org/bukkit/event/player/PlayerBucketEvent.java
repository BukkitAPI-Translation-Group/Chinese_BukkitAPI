package org.bukkit.event.player;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当玩家使用桶时触发本事件.
 */
public abstract class PlayerBucketEvent extends PlayerEvent implements Cancellable {
    private ItemStack itemStack;
    private boolean cancelled = false;
    private final Block block;
    private final Block blockClicked;
    private final BlockFace blockFace;
    private final Material bucket;

    @Deprecated
    public PlayerBucketEvent(@NotNull final Player who, @NotNull final Block blockClicked, @NotNull final BlockFace blockFace, @NotNull final Material bucket, @NotNull final ItemStack itemInHand) {
        this(who, null, blockClicked.getRelative(blockFace), blockFace, bucket, itemInHand);
    }

    public PlayerBucketEvent(@NotNull final Player who, @NotNull final Block block, @NotNull final Block blockClicked, @NotNull final BlockFace blockFace, @NotNull final Material bucket, @NotNull final ItemStack itemInHand) {
        super(who);
        this.block = block;
        this.blockClicked = blockClicked;
        this.blockFace = blockFace;
        this.itemStack = itemInHand;
        this.bucket = bucket;
    }

    /**
     * 返回玩家手里的桶的类型. 
     * <p>
     * 假设玩家使用空桶装水,则会返回空桶的类型
     * <p>
     * 原文: 
     * Returns the bucket used in this event
     *
     * @return 使用中的桶
     */
    @NotNull
    public Material getBucket() {
        return bucket;
    }

    /**
     * 得到使用桶之后会得到的物品堆叠. 
     * <p>
     * 假设玩家使用空桶装水,则会返回一个装满水的桶
     * <p>
     * 原文: 
     * Get the resulting item in hand after the bucket event
     *
     * @return 返回事件结果
     */
    @Nullable
    public ItemStack getItemStack() {
        return itemStack;
    }

    /**
     * 设置使用桶之后得到的物品.
     * <p>
     * 假设玩家使用空桶装水,原来玩家会一个装满水的桶,你可以使用这个方法改变这个结果. 例如改成岩浆桶. 
     * <p>
     * 原文: 
     * Set the item in hand after the event
     *
     * @param itemStack 新的事件结果
     */
    public void setItemStack(@Nullable ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    /**
     * 获取本事件所涉及的方块 (岩浆/水方块等).
     * <p>
     * 原文:Gets the block involved in this event.
     *
     * @return 方块
     */
    @NotNull
    public final Block getBlock() {
        return block;
    }

    /**
     * 玩家正在对着哪个方块使用桶,返回那个方块. 
     * <p>
     * 原文: 
     * Return the block clicked
     *
     * @return 方块
     */
    @NotNull
    public Block getBlockClicked() {
        return blockClicked;
    }

    /**
     * 获取方块被点击的面.
     * <p>
     * 每个方块有6个面,玩家究竟是点击的哪个呢.
     * <p>
     * 原文: 
     * Get the face on the clicked block
     *
     * @return the clicked face
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
}
