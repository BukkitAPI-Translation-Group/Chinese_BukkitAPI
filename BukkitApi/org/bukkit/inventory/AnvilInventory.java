package org.bukkit.inventory;

import org.bukkit.inventory.view.AnvilView;
import org.jetbrains.annotations.Nullable;

/**
 * 铁毡的背包界面接口
 */
public interface AnvilInventory extends Inventory {

    /**
     * 获取要对于重命名的物品的字符串, 当返回空字符串时则表示是物品的默认名称
     * <p>
     * 原文: Get the name to be applied to the repaired item. An empty string denotes
     * the default item name.
     *
     * @return 重命名的字符串
     * @deprecated 请使用 {@link AnvilView#getRenameText()}.
     */
    @Deprecated(forRemoval = true, since = "1.21")
    @Nullable
    String getRenameText();

    /**
     * Get the item cost (in amount) to complete the current repair.
     *
     * @return the amount
     * @deprecated use {@link AnvilView#getRepairItemCountCost()}.
     */
    @Deprecated(forRemoval = true, since = "1.21")
    int getRepairCostAmount();

    /**
     * Set the item cost (in amount) to complete the current repair.
     *
     * @param amount the amount
     * @deprecated use {@link AnvilView#setRepairItemCountCost(int)}.
     */
    @Deprecated(forRemoval = true, since = "1.21")
    void setRepairCostAmount(int amount);

    /**
     * 获取完成当前修复所需要的等级
     * <p>
     * 原文: Get the experience cost (in levels) to complete the current repair.
     *
     * @return 需要花费的经验
     * @deprecated 请使用 {@link AnvilView#getRepairCost()}.
     */
    @Deprecated(forRemoval = true, since = "1.21")
    int getRepairCost();

    /**
     * 设置完成当前修复所需要的等级.
     * <p>
     * 原文:Set the experience cost (in levels) to complete the current repair.
     *
     * @param levels 给定的等级
     * @deprecated 请使用 {@link AnvilView#setRepairCost(int)}.
     */
    @Deprecated(forRemoval = true, since = "1.21")
    void setRepairCost(int levels);

    /**
     * Get the maximum experience cost (in levels) to be allowed by the current
     * repair. If the result of {@link #getRepairCost()} exceeds the returned
     * value, the repair result will be air to due being "too expensive".
     * <p>
     * By default, this level is set to 40. Players in creative mode ignore the
     * maximum repair cost.
     *
     * @return the maximum experience cost
     * @deprecated use {@link AnvilView#getMaximumRepairCost()}.
     */
    @Deprecated(forRemoval = true, since = "1.21")
    int getMaximumRepairCost();

    /**
     * Set the maximum experience cost (in levels) to be allowed by the current
     * repair. The default value set by vanilla Minecraft is 40.
     *
     * @param levels the maximum experience cost
     * @deprecated use {@link AnvilView#setMaximumRepairCost(int)}.
     */
    @Deprecated(forRemoval = true, since = "1.21")
    void setMaximumRepairCost(int levels);
}
