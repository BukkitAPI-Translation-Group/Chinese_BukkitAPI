package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个方块被玩家破坏的时候，调用本事件.
 * <p>
 * 如果你想要在方块被破坏之后掉落经验, 你必须设置经验值
 * 为0以上。 默认情况下, 如果满足以下条件，经验会被设置：
 * <ol>
 * <li>玩家不能是创造/冒险模式
 * <li>玩家能掠夺这个方块 - 即使用了正确的工具破坏方块, 不是完全破坏它(译注:完全破坏可理解为破坏方块不产生任何掉落物.
 * 这条情况的常见情景有开采矿石等)
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

    public BlockBreakEvent(@NotNull final Block theBlock, @NotNull final Player player) {
        super(theBlock, 0);

        this.player = player;
        this.dropItems = true; // Defaults to dropping items as it normally would
    }

    /**
     * 获取破坏这个方块的玩家.
     * <p>
     * 原文:Gets the Player that is breaking the block involved in this event.
     *
     * @return 破坏这个方块的玩家
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    // TODO:验证这个 "if and only if" 的情况.
    /**
     * 设置破坏这个方块后是否像平常那样尝试掉落物品.
     * 当且仅当设为 false 时, {@link BlockDropItemEvent} 事件将不会在本事件后触发.
     * <p>
     * 原文:Sets whether or not the block will attempt to drop items as it normally
     * would.
     *
     * If and only if this is false then {@link BlockDropItemEvent} will not be
     * called after this event.
     *
     * @param dropItems 这个方块是否尝试掉落物品 (注:设为 true 时只代表可能掉落, 而非 100% 掉落)
     */
    public void setDropItems(boolean dropItems) {
        this.dropItems = dropItems;
    }

    /**
     * 获取方块是否可能掉落物品.
     * <p>
     * 原文:Gets whether or not the block will attempt to drop items.
     *
     * If and only if this is false then {@link BlockDropItemEvent} will not be
     * called after this event.
     *
     * @return 这个方块是否掉落物品
     */
    public boolean isDropItems() {
        return this.dropItems;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}