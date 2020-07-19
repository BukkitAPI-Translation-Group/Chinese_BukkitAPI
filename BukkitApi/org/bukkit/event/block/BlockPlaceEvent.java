package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个方块被玩家放置的时候触发此事件.
 * <p>
 * 如果方块放置事件被取消，那么这个方块将不能被放置
 */
public class BlockPlaceEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    protected boolean cancel;
    protected boolean canBuild;
    protected Block placedAgainst;
    protected BlockState replacedBlockState;
    protected ItemStack itemInHand;
    protected Player player;
    protected EquipmentSlot hand;

    @Deprecated
    public BlockPlaceEvent(@NotNull final Block placedBlock, @NotNull final BlockState replacedBlockState, @NotNull final Block placedAgainst, @NotNull final ItemStack itemInHand, @NotNull final Player thePlayer, final boolean canBuild) {
        this(placedBlock, replacedBlockState, placedAgainst, itemInHand, thePlayer, canBuild, EquipmentSlot.HAND);
    }

    public BlockPlaceEvent(@NotNull final Block placedBlock, @NotNull final BlockState replacedBlockState, @NotNull final Block placedAgainst, @NotNull final ItemStack itemInHand, @NotNull final Player thePlayer, final boolean canBuild, @NotNull final EquipmentSlot hand) {
        super(placedBlock);
        this.placedAgainst = placedAgainst;
        this.itemInHand = itemInHand;
        this.player = thePlayer;
        this.replacedBlockState = replacedBlockState;
        this.canBuild = canBuild;
        this.hand = hand;
        cancel = false;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 获得放置这个方块的玩家.
     * <p>
     * 原文:Gets the player who placed the block involved in this event.
     *
     * @return 放置这个方块的玩家
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * 获得被放置的方块(还未真正被放置).
     * <p>
     * 原文:Clarity method for getting the placed block. Not really needed except
     * for reasons of clarity.
     *
     * @return 被放置后的方块
     */
    @NotNull
    public Block getBlockPlaced() {
        return getBlock();
    }

    /**
     * 获取被替换的方块的 BlockState. 通常被替换的方块是空气.
     * <p>
     * 原文:Gets the BlockState for the block which was replaced. Material type air
     * mostly.
     *
     * @return 被替换的方块的 BlockState.
     */
    @NotNull
    public BlockState getBlockReplacedState() {
        return this.replacedBlockState;
    }

    /**
     * 获取这个方块是依附在哪个方块上放置的.
     * <p>
     * 原文:Gets the block that this block was placed against
     * 
     * @return 放置时依附的方块
     */
    @NotNull
    public Block getBlockAgainst() {
        return placedAgainst;
    }

    /**
     * 获取玩家放置的方块的物品形式(在玩家手上).
     * <p>
     * 原文:Gets the item in the player's hand when they placed the block.
     * 
     * @return 这个方块的ItemStack对象
     */
    @NotNull
    public ItemStack getItemInHand() {
        return itemInHand;
    }

    /**
     * 获取放置这个方块的手.
     * <p>
     * 原文:Gets the hand which placed the block
     * @return 主手或副手，取决于放置方块所用的手
     */
    @NotNull
    public EquipmentSlot getHand() {
        return this.hand;
    }

    /**
     * 获取这个方块是否可以建造.
     * <p>
     * 默认情况下，如果玩家还在重生/生成时服务器将阻止它们. 注意，这跟BLOCK_CANBUILD是完全不同的检测.这是指玩家而不是像仙人掌一样的物理现象.
     * <p>
     * 原文：Gets the value whether the player would be allowed to build here.
     * Defaults to spawn if the server was going to stop them (such as, the
     * player is in Spawn). Note that this is an entirely different check
     * than BLOCK_CANBUILD, as this refers to a player, not universe-physics
     * rule like cactus on dirt.
     *
     * @return boolean 服务器是否允许此方块的建造
     */
    public boolean canBuild() {
        return this.canBuild;
    }

    /**
     * 设置这个方块是否可以被放置.
     * <p>
     * 原文:Sets the canBuild state of this event. Set to true if you want the
     * player to be able to build
     *
     * @param canBuild 是否允许玩家放置这个方块
     */
    public void setBuild(boolean canBuild) {
        this.canBuild = canBuild;
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