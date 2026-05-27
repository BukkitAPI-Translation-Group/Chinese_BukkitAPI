package org.bukkit.event.player;

import org.bukkit.Material;
import org.bukkit.Warning;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家尝试将鱼放入桶中时触发此事件.
 *
 * @deprecated 请使用更通用的 {@link PlayerBucketEntityEvent}
 */
@Deprecated(since = "1.16.5")
@Warning(false)
public class PlayerBucketFishEvent extends PlayerBucketEntityEvent {

    public PlayerBucketFishEvent(@NotNull Player player, @NotNull Fish fish, @NotNull ItemStack waterBucket, @NotNull ItemStack fishBucket, @NotNull EquipmentSlot hand) {
        super(player, fish, waterBucket, fishBucket, hand);
    }

    /**
     * 获取此事件涉及的鱼.
     * <p>
     * 原文：
     * Gets the fish involved with this event.
     *
     * @return 此事件涉及的鱼
     */
    @NotNull
    @Override
    public Fish getEntity() {
        return (Fish) super.getEntity();
    }

    /**
     * 获取使用的桶.
     * <p>
     * 原文：
     * Gets the bucket used.
     *
     * This refers to the bucket clicked with, ie {@link Material#WATER_BUCKET}.
     *
     * @return 使用的桶
     * @deprecated 请使用 {@link #getOriginalBucket()}
     */
    @NotNull
    @Deprecated(since = "1.16.5")
    public ItemStack getWaterBucket() {
        return getOriginalBucket();
    }

    /**
     * 获取鱼将被放入的桶.
     * <p>
     * 原文：
     * Gets the bucket that the fish will be put into.
     *
     * This refers to the bucket with the fish, ie
     * {@link Material#PUFFERFISH_BUCKET}.
     *
     * @return 鱼将被放入的桶
     * @deprecated 请使用 {@link #getEntityBucket()}
     */
    @NotNull
    @Deprecated(since = "1.16.5")
    public ItemStack getFishBucket() {
        return getEntityBucket();
    }
}