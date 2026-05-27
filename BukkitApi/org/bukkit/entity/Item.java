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
     * 设置此掉落物是否应永久存在.
     * <p>
     * 原文：Sets if this Item should live forever
     *
     * @param unlimited 如果为true则掉落物的生存时间无限制
     */
    public void setUnlimitedLifetime(boolean unlimited);

    /**
     * 获取此掉落物是否永久存在.
     * <p>
     * 原文：Gets if this Item lives forever
     *
     * @return 如果生存时间无限制则返回true
     */
    public boolean isUnlimitedLifetime();

    /**
     * 设置此掉落物的所有者.
     * <p>
     * 设置所有者后, 其他实体将无法拾取此掉落物.
     * <p>
     * 原文：Sets the owner of this item.
     * <p>
     * Other entities will not be able to pickup this item when an owner is set.
     *
     * @param owner 新所有者的UUID
     */
    public void setOwner(@Nullable UUID owner);

    /**
     * 获取此掉落物的所有者.
     * <p>
     * 原文：Get the owner of this item.
     *
     * @return 所有者的UUID
     */
    @Nullable
    public UUID getOwner();

    /**
     * 设置此掉落物的投掷者.
     * <p>
     * 投掷者是掉落此物品的实体. 这会影响物品拾取的触发条件, 例如进度的触发.
     * <p>
     * 原文：Set the thrower of this item.
     * <p>
     * The thrower is the entity which dropped the item. This affects the
     * trigger criteria for item pickups, for things such as advancements.
     *
     * @param uuid 投掷者的UUID
     */
    public void setThrower(@Nullable UUID uuid);

    /**
     * 获取此掉落物的投掷者.
     * <p>
     * 投掷者是掉落此物品的实体.
     * <p>
     * 原文：Get the thrower of this item.
     * <p>
     * The thrower is the entity which dropped the item.
     *
     * @return 投掷者的UUID
     */
    @Nullable
    public UUID getThrower();
}
