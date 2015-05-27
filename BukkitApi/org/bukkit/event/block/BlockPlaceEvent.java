package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * 当一个方块被玩家放置的时候调用本事件
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

    public BlockPlaceEvent(final Block placedBlock, final BlockState replacedBlockState, final Block placedAgainst, final ItemStack itemInHand, final Player thePlayer, final boolean canBuild) {
        super(placedBlock);
        this.placedAgainst = placedAgainst;
        this.itemInHand = itemInHand;
        this.player = thePlayer;
        this.replacedBlockState = replacedBlockState;
        this.canBuild = canBuild;
        cancel = false;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 看看是谁放置的这个方块
     *
     * @return 谁放置的这个方块(Player对象)
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 更明确地获取被放置的方块，如果你要让Block对象清楚，可以
     * 用这个方法哦~
     *
     * @return 被放置后的方块
     */
    public Block getBlockPlaced() {
        return getBlock();
    }

    /**
     * 获取方块被放置后的 BlockState(方块状态。). Material type air
     * mostly.例：牌子拿在手里，放在墙上后，这个牌子的方块状态就是墙上的牌子。
     *
     * @return 被放置后的方块的方块状态
     */
    public BlockState getBlockReplacedState() {
        return this.replacedBlockState;
    }

    /**
     * 原：Gets the block that this block was placed against
     * 获取“反对”这个方块的方块
     * @return Block “反对”这个方块的方块
     */
    public Block getBlockAgainst() {
        return placedAgainst;
    }

    /**
     * 获取玩家放置的方块的物品形式（在玩家手上）
     * @return 这个方块的物品形式的 ItemStack(物品格/物品栈)
     */
    public ItemStack getItemInHand() {
        return itemInHand;
    }

    /**
     * 获取这个方块是否可以建造。
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
     * 设置这个方块是否可以建造. 想让玩家可以建造
     * 请设为true
     *
     * @param canBuild 想让玩家可以建造,请设为true
     */
    public void setBuild(boolean canBuild) {
        this.canBuild = canBuild;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
