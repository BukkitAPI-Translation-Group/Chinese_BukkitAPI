package org.bukkit.block;

import java.util.Set;
import java.util.UUID;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootTable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个捕获的保险库状态.
 * 
 * 原文:Represents a captured state of a vault.
 */
@ApiStatus.Experimental
public interface Vault extends TileState {

    /**
     * 获取玩家必须进入才能激活此保险库的距离.
     * 
     * 原文:Gets the distance at which a player must enter for this vault to
     * activate.
     *
     * @return 玩家必须进入才能激活此保险库的距离
     * 原文:the distance at which a player must enter for this vault
     * to activate.
     */
    double getActivationRange();

    /**
     * 设置玩家必须进入才能激活此保险库的距离.
     * 
     * 原文:Sets the distance at which a player must enter for this vault to
     * activate.
     *
     * @param range 玩家必须进入才能激活此保险库的距离
     * 原文:the distance at which a player must enter for this
     * vault to activate.
     */
    void setActivationRange(double range);

    /**
     * 获取玩家必须退出才能停用此保险库的距离.
     * 
     * 原文:Gets the distance at which a player must exit for the vault to
     * deactivate.
     *
     * @return 玩家必须退出才能停用此保险库的距离
     * 原文:the distance at which a player must exit for the vault
     * to deactivate.
     */
    double getDeactivationRange();

    /**
     * 设置玩家必须退出才能停用此保险库的距离.
     * 
     * 原文:Sets the distance at which a player must exit for the vault to
     * deactivate.
     *
     * @param range 玩家必须退出才能停用此保险库的距离
     * 原文:the distance at which a player must exit for this
     * vault to deactivate.
     */
    void setDeactivationRange(double range);

    /**
     * 获取此保险库将从中选择奖励的{@link LootTable 战利品表}.
     * 
     * 原文:Gets the {@link LootTable} this vault will pick rewards from.
     *
     * @return 战利品表
     * 原文:the loot table
     */
    @NotNull
    LootTable getLootTable();

    /**
     * 设置此保险库将从中选择奖励的{@link LootTable 战利品表}.
     * 
     * 原文:Sets the {@link LootTable} this vault will pick rewards from.
     *
     * @param table 战利品表
     * 原文:the loot table
     */
    void setLootTable(@NotNull LootTable table);

    /**
     * 获取此保险库将用于显示物品的{@link LootTable 战利品表}. <br>
     * 如果此值为null，则将使用常规战利品表来显示物品.
     * 
     * 原文:Gets the {@link LootTable} this vault will display items from. <br>
     * If this value is null the regular loot table will be used to display
     * items.
     *
     * @return 用于显示物品的战利品表
     * 原文:the loot table to display items from
     */
    @Nullable
    LootTable getDisplayLootTable();

    /**
     * 设置此保险库将用于显示物品的{@link LootTable 战利品表}. <br>
     * 如果此值设置为null，则将使用常规战利品表来显示物品.
     * 
     * 原文:Sets the {@link LootTable} this vault will display items from. <br>
     * If this value is set to null the regular loot table will be used to
     * display items.
     *
     * @param table 用于显示物品的战利品表
     * 原文:the loot table to display items from
     */
    void setDisplayLootTable(@Nullable LootTable table);

    /**
     * 获取玩家必须用来解锁此保险库的{@link ItemStack 物品堆}.
     * 
     * 原文:Gets the {@link ItemStack} players must use to unlock this vault.
     *
     * @return 钥匙物品
     * 原文:the key item
     */
    @NotNull
    ItemStack getKeyItem();

    /**
     * 设置玩家必须用来解锁此保险库的{@link ItemStack 物品堆}.
     * 
     * 原文:Sets the {@link ItemStack} players must use to unlock this vault.
     *
     * @param keyItem 钥匙物品
     * 原文:the key item
     */
    void setKeyItem(@NotNull ItemStack keyItem);

    /**
     * 获取已经从此保险库收到奖励的玩家.
     * 
     * 原文:Gets the players who have already received rewards from this vault.
     *
     * @return 玩家UUID的不可修改集合
     * 原文:unmodifiable set of player UUIDs
     * @throws IllegalStateException 如果此方块状态未被放置
     * 原文:if this block state is not placed
     */
    @NotNull
    Set<UUID> getRewardedPlayers();
}
