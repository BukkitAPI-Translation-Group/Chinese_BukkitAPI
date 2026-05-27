package org.bukkit.event.block;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当方块从其指定的战利品表中发放战利品时触发.
 * 不要与 {@link BlockDispenseEvent} 等事件混淆，后者在从其库存容器中发放单个物品时触发.
 * <br><br>
 * 示例：玩家解锁试炼密室宝库，宝库方块发放其战利品.
 */
@ApiStatus.Experimental
public class BlockDispenseLootEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private List<ItemStack> dispensedLoot;
    private boolean cancelled;

    public BlockDispenseLootEvent(@Nullable Player player, @NotNull Block theBlock, @NotNull List<ItemStack> dispensedLoot) {
        super(theBlock);
        this.player = player;
        this.block = theBlock;
        this.dispensedLoot = dispensedLoot;
    }

    /**
     * 获取将被发放的战利品.
     *
     * 原文：
     * Gets the loot that will be dispensed.
     *
     * @return 将被发放的战利品
     */
    @NotNull
    public List<ItemStack> getDispensedLoot() {
        return dispensedLoot;
    }

    /**
     * 设置将被发放的战利品.
     *
     * 原文：
     * Sets the loot that will be dispensed.
     *
     * @param dispensedLoot 新的战利品
     */
    public void setDispensedLoot(@Nullable List<ItemStack> dispensedLoot) {
        this.dispensedLoot = (dispensedLoot == null) ? new ArrayList<>() : dispensedLoot;
    }

    /**
     * 获取与此事件关联的玩家.
     * <br>
     * <b>警告：</b> 某些事件实例，如 {@link org.bukkit.block.TrialSpawner} 发放其奖励战利品，可能没有关联的玩家，将返回 null.
     *
     * 原文：
     * Gets the player associated with this event.
     * <br>
     * <b>Warning:</b> Some event instances like a
     * {@link org.bukkit.block.TrialSpawner} dispensing its reward loot may not
     * have a player associated with them and will return null.
     *
     * @return 解锁宝库的玩家
     */
    @Nullable
    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
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
