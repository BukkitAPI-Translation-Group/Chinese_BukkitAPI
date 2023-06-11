package org.bukkit.event.player;

import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家通过装备上的经验修补附魔修复装备耐久时触发该事件.
 * <br>
 * 此事件在{@link PlayerExpChangeEvent}之前直接触发，此事件的结果将直接影响{@link PlayerExpChangeEvent}.
 * <p>
 * 原文:
 * Represents when a player has an item repaired via the Mending enchantment.
 * <br>
 * This event is fired directly before the {@link PlayerExpChangeEvent}, and the
 * results of this event directly affect the {@link PlayerExpChangeEvent}.
 */
public class PlayerItemMendEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private final ItemStack item;
    private final EquipmentSlot slot;
    private final ExperienceOrb experienceOrb;
    private int repairAmount;
    private boolean cancelled;

    public PlayerItemMendEvent(@NotNull Player who, @NotNull ItemStack item, @NotNull EquipmentSlot slot, @NotNull ExperienceOrb experienceOrb, int repairAmount) {
        super(who);
        this.item = item;
        this.slot = slot;
        this.experienceOrb = experienceOrb;
        this.repairAmount = repairAmount;
    }

    @Deprecated
    public PlayerItemMendEvent(@NotNull Player who, @NotNull ItemStack item, @NotNull ExperienceOrb experienceOrb, int repairAmount) {
        this(who, item, null, experienceOrb, repairAmount);
    }

    /**
     * 将要被修复的{@link ItemStack}.
     * <br>
     * 注意: 这不一定是玩家手持的ItemStack.
     * <p>
     * 原文:
     * Get the {@link ItemStack} to be repaired.
     * <p>
     * This is not necessarily the item the player is holding.
     *
     * @return 要被修复的 {@link ItemStack}
     */
    @NotNull
    public ItemStack getItem() {
        return item;
    }

    /**
     * Get the {@link EquipmentSlot} in which the repaired {@link ItemStack}
     * may be found.
     *
     * @return the repaired slot
     */
    @NotNull
    public EquipmentSlot getSlot() {
        return slot;
    }

    /**
     * 获取触发事件的经验球.
     * <p>
     * 原文: Get the experience orb triggering the event.
     *
     * @return {@link ExperienceOrb}
     */
    @NotNull
    public ExperienceOrb getExperienceOrb() {
        return experienceOrb;
    }

    /**
     * 获取物品的修理耐久的数量.
     * <br>
     * 默认值是消耗经验球的经验的两倍或物品上剩余的耐久, 则以较小者为准。
     * <p>
     * 原文:
     * Get the amount the item is to be repaired.
     * <p>
     * The default value is twice the value of the consumed experience orb
     * or the remaining damage left on the item, whichever is smaller.
     *
     * @return 经验球的经验将修复多少耐久的数量
     */
    public int getRepairAmount() {
        return repairAmount;
    }

    /**
     * 设置物品的修理耐久的数量.
     * <br>
     * 该值的一半将从发起此事件的经验球中减去.
     * <p>
     * 原文:
     * Set the amount the item will be repaired.
     * <p>
     * Half of this value will be subtracted from the experience orb which initiated this event.
     *
     * @param amount 该物品将被修复多少耐久的数量
     */
    public void setRepairAmount(int amount) {
        this.repairAmount = amount;
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
