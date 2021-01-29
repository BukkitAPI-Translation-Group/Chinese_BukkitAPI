package org.bukkit.entity;

import java.util.UUID;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表掉落物实体.
 */
public interface Item extends Entity {

    /**
     * 获取与此掉落物相关的物品堆.
     * <p>
     * 原文:Gets the item stack associated with this item drop.
     *
     * @return 物品堆
     */
    @NotNull
    public ItemStack getItemStack();

    /**
     * 设置与此掉落物相关的物品堆.
     * <p>
     * 原文:Sets the item stack associated with this item drop.
     *
     * @param stack 物品堆
     */
    public void setItemStack(@NotNull ItemStack stack);

    /**
     * 获取此掉落物剩余的不可被捡起的时间.
     * <p>
     * 原文:Gets the delay before this Item is available to be picked up by players
     *
     * @return 掉落物剩余的不可被捡起的时间
     */
    public int getPickupDelay();

    /**
     * 设置掉落物剩余的不可被捡起的时间.
     * <p>
     * 原文:Sets the delay before this Item is available to be picked up by players
     *
     * @param delay 掉落物剩余的不可被捡起的时间
     */
    public void setPickupDelay(int delay);

    /**
     * Sets the owner of this item.
     *
     * Other entities will not be able to pickup this item when an owner is set.
     *
     * @param owner UUID of new owner
     */
    public void setOwner(@Nullable UUID owner);

    /**
     * Get the owner of this item.
     *
     * @return UUID of owner
     */
    @Nullable
    public UUID getOwner();

    /**
     * Set the thrower of this item.
     *
     * The thrower is the entity which dropped the item. This affects the
     * trigger criteria for item pickups, for things such as advancements.
     *
     * @param uuid UUID of thrower
     */
    public void setThrower(@Nullable UUID uuid);

    /**
     * Get the thrower of this item.
     *
     * The thrower is the entity which dropped the item.
     *
     * @return UUID of thrower
     */
    @Nullable
    public UUID getThrower();
}
