package org.bukkit.event.player;

import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家收获方块时触发此事件。
 * <br>
 * '收获'指的是当方块掉落物品（通常是某种作物）并改变状态，但并未被破坏以掉落物品。
 * <br>
 * 当方块被破坏时，此事件不会被触发。要处理这种情况，请监听
 * {@link org.bukkit.event.block.BlockBreakEvent}和
 * {@link org.bukkit.event.block.BlockDropItemEvent}。
 */
public class PlayerHarvestBlockEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Block harvestedBlock;
    private final EquipmentSlot hand;
    private final List<ItemStack> itemsHarvested;

    public PlayerHarvestBlockEvent(@NotNull Player player, @NotNull Block harvestedBlock, @NotNull EquipmentSlot hand, @NotNull List<ItemStack> itemsHarvested) {
        super(player);
        this.harvestedBlock = harvestedBlock;
        this.hand = hand;
        this.itemsHarvested = itemsHarvested;
    }

    @Deprecated(since = "1.19.2")
    public PlayerHarvestBlockEvent(@NotNull Player player, @NotNull Block harvestedBlock, @NotNull List<ItemStack> itemsHarvested) {
        this(player, harvestedBlock, EquipmentSlot.HAND, itemsHarvested);
    }

    /**
     * 获取被收获的方块。
     * <p>
     * 原文：
     * Gets the block that is being harvested.
     *
     * @return 被收获的方块
     */
    @NotNull
    public Block getHarvestedBlock() {
        return harvestedBlock;
    }

    /**
     * 获取用于收获方块的手。
     * <p>
     * 原文：
     * Get the hand used to harvest the block.
     *
     * @return 用于收获方块的手
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
    }

    /**
     * 获取从此方块收获的物品列表。
     * <p>
     * 原文：
     * Gets a list of items that are being harvested from this block.
     *
     * @return 从此方块收获的物品列表
     */
    @NotNull
    public List<ItemStack> getItemsHarvested() {
        return itemsHarvested;
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
