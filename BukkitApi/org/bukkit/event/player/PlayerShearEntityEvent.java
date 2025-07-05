package org.bukkit.event.player;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 玩家对某实体使用剪刀采集物品时调用此事件.
 * <p>
 * 译注:截止 Minecraft 1.15版本, 本事件发生的场景如下:
 * <ul>
 * <li>对羊使用, 采集羊毛.</li>
 * <li>对哞菇使用, 采集蘑菇, 并使哞菇变成牛.</li>
 * <li>对雪傀儡使用, 摘掉雪傀儡戴着的南瓜头, 但不会掉落南瓜物品.</li>
 * </ul>
 * <br>
 * 注意:如果玩家与实体交互被拒, 将不会触发本事件(譬如{@link PlayerInteractEntityEvent}被取消).
 */
public class PlayerShearEntityEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final Entity what;
    private final ItemStack item;
    private final EquipmentSlot hand;

    public PlayerShearEntityEvent(@NotNull Player who, @NotNull Entity what, @NotNull ItemStack item, @NotNull EquipmentSlot hand) {
        super(who);
        this.what = what;
        this.item = item;
        this.hand = hand;
    }

    @Deprecated(since = "1.15.2")
    public PlayerShearEntityEvent(@NotNull final Player who, @NotNull final Entity what) {
        this(who, what, new ItemStack(Material.SHEARS), EquipmentSlot.HAND);
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
     * 获取玩家正在剪切的实体.
     * <p>
     * 原文:Gets the entity the player is shearing
     *
     * @return 被剪实体
     */
    @NotNull
    public Entity getEntity() {
        return what;
    }

    /**
     * 获取用于剪切实体的物品.
     * <p>
     * 原文:Gets the item used to shear the entity.
     *
     * @return 剪刀
     */
    @NotNull
    public ItemStack getItem() {
        return item.clone();
    }

    /**
     * 获取用于剪切实体的手.
     * <p>
     * 原文:Gets the hand used to shear the entity.
     *
     * @return 手
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
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
