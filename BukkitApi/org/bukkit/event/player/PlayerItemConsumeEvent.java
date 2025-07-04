package org.bukkit.event.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当玩家消耗完物品时, 此事件将触发 例如:(食物, 药水, 牛奶桶).
 * <br>
 * 如果修改了ItemStack，服务器将使用新ItemStack的效果，而不是从玩家的背包中删除原始ItemStack。
 * <br>
 * 如果事件被取消，则不会应用效果，并且不会从玩家的背包中删除该ItemStack。
 * <p>
 * 原文:
 * This event will fire when a player is finishing consuming an item (food,
 * potion, milk bucket).
 * <br>
 * If the ItemStack is modified the server will use the effects of the new
 * item and not remove the original one from the player's inventory.
 * <br>
 * If the event is cancelled the effect will not be applied and the item will
 * not be removed from the player's inventory.
 */
public class PlayerItemConsumeEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean isCancelled = false;
    private ItemStack item;
    private final EquipmentSlot hand;

    /**
     * @param player 正在消耗物品的玩家
     * @param item   将要被消耗掉的物品
     * @param hand   使用的手
     */
    public PlayerItemConsumeEvent(@NotNull final Player player, @NotNull final ItemStack item, @NotNull final EquipmentSlot hand) {
        super(player);

        this.item = item;
        this.hand = hand;
    }

    /**
     * @param player 正在消耗物品的玩家
     * @param item   将要被消耗掉的物品
     * @deprecated 请使用 {@link #PlayerItemConsumeEvent(Player, ItemStack, EquipmentSlot)}
     */
    @Deprecated(since = "1.19.2")
    public PlayerItemConsumeEvent(@NotNull final Player player, @NotNull final ItemStack item) {
        this(player, item, EquipmentSlot.HAND);
    }

    /**
     * 获取正在被消耗掉的ItemStack.
     * 修改本方法返回的ItemStack将无效，你必须使用 {@link #setItem(org.bukkit.inventory.ItemStack)} 方法来取代.
     * <p>
     * 原文:
     * Gets the item that is being consumed. Modifying the returned item will
     * have no effect, you must use {@link
     * #setItem(org.bukkit.inventory.ItemStack)} instead.
     *
     * @return 正在被消耗掉的 {@link ItemStack} .
     */
    @NotNull
    public ItemStack getItem() {
        return item.clone();
    }

    /**
     * 设置正在被消耗掉的ItemStack
     * <p>
     * 原文:
     * Set the item being consumed
     *
     * @param item 正在被消耗掉的ItemStack
     */
    public void setItem(@Nullable ItemStack item) {
        if (item == null) {
            this.item = new ItemStack(Material.AIR);
        } else {
            this.item = item;
        }
    }

    /**
     * Get the hand used to consume the item.
     *
     * @return the hand
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
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
