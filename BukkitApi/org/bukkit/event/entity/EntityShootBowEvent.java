package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当生物实体射出箭矢时调用。
 */
public class EntityShootBowEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final ItemStack bow;
    private final ItemStack consumable;
    private Entity projectile;
    private final EquipmentSlot hand;
    private final float force;
    private boolean consumeItem;
    private boolean cancelled;

    public EntityShootBowEvent(@NotNull final LivingEntity shooter, @Nullable final ItemStack bow, @Nullable final ItemStack consumable, @NotNull final Entity projectile, @NotNull final EquipmentSlot hand, final float force, final boolean consumeItem) {
        super(shooter);
        this.bow = bow;
        this.consumable = consumable;
        this.projectile = projectile;
        this.hand = hand;
        this.force = force;
        this.consumeItem = consumeItem;
    }

    @NotNull
    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    /**
     * 获取用于发射箭矢的弓 ItemStack。
     * <p>
     * 原文：
     * Gets the bow ItemStack used to fire the arrow.
     *
     * @return 此事件中涉及的弓
     */
    @Nullable
    public ItemStack getBow() {
        return bow;
    }

    /**
     * 获取此事件中将被消耗的 ItemStack（如果有）。
     * <p>
     * 例如，弓会消耗玩家背包中的箭矢 ItemStack。
     * <p>
     * 原文：
     * Get the ItemStack to be consumed in this event (if any).
     *
     * For instance, bows will consume an arrow ItemStack in a player's
     * inventory.
     *
     * @return 消耗品物品
     */
    @Nullable
    public ItemStack getConsumable() {
        return consumable;
    }

    /**
     * 获取此事件将发射的弹射物。
     * <p>
     * 原文：
     * Gets the projectile which will be launched by this event
     *
     * @return 发射的弹射物
     */
    @NotNull
    public Entity getProjectile() {
        return projectile;
    }

    /**
     * 替换将被发射的弹射物。
     * <p>
     * 原文：
     * Replaces the projectile which will be launched
     *
     * @param projectile 新的弹射物
     */
    public void setProjectile(@NotNull Entity projectile) {
        this.projectile = projectile;
    }

    /**
     * 获取射出弓的手。
     * <p>
     * 原文：
     * Get the hand from which the bow was shot.
     *
     * @return 手
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
    }

    /**
     * 获取箭矢发射的力度。
     * <p>
     * 原文：
     * Gets the force the arrow was launched with
     *
     * @return 弓的射击力度，最大为 1.0
     */
    public float getForce() {
        return force;
    }

    /**
     * 设置此事件中是否应消耗消耗品物品。
     * <p>
     * 如果设置为 false，建议调用 {@link Player#updateInventory()}，因为客户端可能不同意服务器不消耗消耗品物品的决定。
     * <p>
     * 对于不需要物品的实体（骷髅、掠夺者等）或使用弩时（因为没有物品被消耗），此值将被忽略。
     * <p>
     * 原文：
     * Set whether or not the consumable item should be consumed in this event.
     *
     * If set to false, it is recommended that a call to
     * {@link Player#updateInventory()} is made as the client may disagree with
     * the server's decision to not consume a consumable item.
     * <p>
     * This value is ignored for entities where items are not required
     * (skeletons, pillagers, etc.) or with crossbows (as no item is being
     * consumed).
     *
     * @param consumeItem 是否消耗物品
     * @deprecated 目前不起作用
     */
    @Deprecated(since = "1.20.5")
    public void setConsumeItem(boolean consumeItem) {
        this.consumeItem = consumeItem;
    }

    /**
     * 获取此事件中是否应消耗消耗品物品。
     * <p>
     * 原文：
     * Get whether or not the consumable item should be consumed in this event.
     *
     * @return 如果消耗则返回 true，否则返回 false
     */
    public boolean shouldConsumeItem() {
        return consumeItem;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
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