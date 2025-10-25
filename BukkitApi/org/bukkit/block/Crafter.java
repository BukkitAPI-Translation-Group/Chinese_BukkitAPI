package org.bukkit.block;

import org.bukkit.loot.Lootable;
import org.jetbrains.annotations.ApiStatus;

/**
 * 代表合成器的捕获状态.
 */
@ApiStatus.Experimental
public interface Crafter extends Container, Lootable {

    /**
     * 获取此方块将保持在合成状态的剩余刻数.
     * <p>
     * 原文:
     * Gets the number of ticks which this block will remain in the crafting
     * state for.
     *
     * @return 剩余刻数
     * @see org.bukkit.block.data.type.Crafter#isCrafting()
     */
    int getCraftingTicks();

    /**
     * 设置此方块将保持在合成状态的剩余刻数.
     * <p>
     * 原文:
     * Sets the number of ticks which this block will remain in the crafting
     * state for.
     *
     * @param ticks 剩余刻数
     * @see org.bukkit.block.data.type.Crafter#isCrafting()
     */
    void setCraftingTicks(int ticks);

    /**
     * 获取指定索引处的槽位是否被禁用, 不会将物品放入其中.
     * <p>
     * 原文:
     * Gets whether the slot at the specified index is disabled and will not
     * have items placed in it.
     *
     * @param slot 槽位索引
     * @return 禁用状态
     */
    boolean isSlotDisabled(int slot);

    /**
     * 设置指定索引处的槽位是否被禁用, 不会将物品放入其中.
     * <p>
     * 原文:
     * Sets whether the slot at the specified index is disabled and will not
     * have items placed in it.
     *
     * @param slot 槽位索引
     * @param disabled 禁用状态
     */
    void setSlotDisabled(int slot, boolean disabled);

    /**
     * 获取此合成器是否被激活.
     * <p>
     * 原文:
     * Gets whether this Crafter is powered.
     *
     * @return 激活状态
     */
    boolean isTriggered();

    /**
     * 设置此合成器是否被激活.
     * <p>
     * 原文:
     * Sets whether this Crafter is powered.
     *
     * @param triggered 激活状态
     */
    void setTriggered(boolean triggered);
}
