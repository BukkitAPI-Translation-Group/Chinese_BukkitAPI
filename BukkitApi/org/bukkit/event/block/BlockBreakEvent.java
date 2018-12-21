package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

/**
 * 当一个方块被玩家破坏的时候，调用本事件.
 * <p>
 * 如果你想要在方块被破坏之后掉落经验, 你必须设置经验值
 * 为0以上。 默认情况下, 如果满足以下条件，经验会被设置：
 * <ol>
 * <li>玩家不能是创造/冒险模式
 * <li>The player can loot the block (ie: does not destroy it completely, by
 *     using the correct tool)
 * <li>玩家没有精准采集
 * <li>方块在原版Minecraft中掉落经验
 * </ol>
 * <p>
 * 注意:
 * 插件要模拟一个方块掉落应该设置空气为方块，利用自己的方法确定方块被破坏后默认掉落什么，和要做什么。
 * <p>
 * 如果方块破坏事件（即本事件）被取消，这个方块将不会被破坏，并且经验不会掉落。
 */
public class BlockBreakEvent extends BlockExpEvent implements Cancellable {
    private final Player player;
    private boolean dropItems;
    private boolean cancel;

    public BlockBreakEvent(final Block theBlock, final Player player) {
        super(theBlock, 0);

        this.player = player;
        this.dropItems = true; // Defaults to dropping items as it normally would
    }

    /**
     * 获取破坏这个方块的玩家.
     * <p>
     * 原文：Gets the Player that is breaking the block involved in this event.
     *
     * @return 破坏这个方块的玩家
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 设置这个方块是否像平常那样掉落物品.
     * <p>
     * 原文:Sets whether or not the block will drop items as it normally would.
     *
     * @param dropItems 这个方块是否掉落物品
     */
    public void setDropItems(boolean dropItems) {
        this.dropItems = dropItems;
    }

    /**
     * 获取方块是否会掉落物品.
     * <p>
     * 原文:Gets whether or not the block will drop items.
     *
     * @return 这个方块是否掉落物品
     */
    public boolean isDropItems() {
        return this.dropItems;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}