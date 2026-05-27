package org.bukkit.event.block;

import com.google.common.base.Preconditions;
import org.bukkit.block.Block;
import org.bukkit.block.SculkCatalyst;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDeathEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 表示当 {@link SculkCatalyst} 创建新游标时触发的事件.
 * <p>
 * <strong>游标定义：</strong>
 * 此上下文中的游标是 SculkCatalyst 生成的动态标记或指针.
 * 它占据一个方块并在移动时传播幽匿块.
 * 它类似于实体，但不是实体.
 * 游标由方块实体 tick.
 * <p>
 * <strong>游标创建的触发条件：</strong>
 * <ul>
 *   <li>实体在 {@link SculkCatalyst} 8 格范围内被杀死并掉落经验时.</li>
 *   <li>插件使用 {@link SculkCatalyst#bloom(Block, int)} 显式调用.</li>
 * </ul>
 *
 * {@link #getBlock()} 的结果是游标生成的位置.
 */
public class SculkBloomEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;

    private int charge;

    public SculkBloomEvent(@NotNull Block theBlock, int charge) {
        super(theBlock);
        this.charge = charge;
    }

    /**
     * 返回游标的能量，默认小于 1000.
     *
     * 原文：
     * Returns the charge of the cursor, &lt; 1000 by default.
     *
     * @return 游标的能量
     */
    public int getCharge() {
        return charge;
    }

    /**
     * 设置游标的能量.
     * <p>
     * 增加游标的能量可以使游标持续更长时间，给予它更多时间在更大范围内传播幽匿块.
     * <p>
     * 通常，能量应设置为生物的经验奖励 ({@link EntityDeathEvent#getDroppedExp()})，动物通常为 3-5，普通生物为 5-10（凋灵骷髅最高可达 50）.
     * 粗略来说，每增加 1 点能量，将多放置 1 个幽匿块.
     *
     * 原文：
     * Sets the charge of the cursor.
     * <p>
     * Increasing the charge of a cursor makes the cursor last longer, giving
     * it more time to spread sculk blocks across a larger range.
     * <p>
     * Typically, charges should be set to the exp reward of a mob
     * ({@link EntityDeathEvent#getDroppedExp()}), which is usually
     * 3-5 for animals, and 5-10 for the average mob (up to 50 for
     * wither skeletons). Roughly speaking, for each charge, 1 more
     * sculk block will be placed.
     *
     * @param charge 游标的能量
     */
    public void setCharge(int charge) {
        Preconditions.checkArgument(charge >= 0 && charge <= 1000, charge + " is not in range [0, 1000]");
        this.charge = charge;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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
