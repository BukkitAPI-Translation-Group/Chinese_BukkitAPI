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
     * 获取完成当前修复所需物品的数量.
     * <p>
     * 原文：Get the item cost (in amount) to complete the current repair.
     *
     * @return 物品数量
     * @deprecated 请使用 {@link AnvilView#getRepairItemCountCost()}.
     */
    @Deprecated(forRemoval = true, since = "1.21")
    int getRepairCostAmount();

    /**
     * 设置完成当前修复所需物品的数量.
     * <p>
     * 原文：Set the item cost (in amount) to complete the current repair.
     *
     * @param amount 物品数量
     * @deprecated 请使用 {@link AnvilView#setRepairItemCountCost(int)}.
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
     * 获取当前修复所允许的最大经验等级花费.
     * 如果 {@link #getRepairCost()} 的结果超过返回值, 修复结果将因"太贵"而变为空气.
     * <p>
     * 默认情况下, 此等级设置为 40. 创造模式的玩家忽略此最大修复花费.
     * <p>
     * 原文：Get the maximum experience cost (in levels) to be allowed by the current
     * repair. If the result of {@link #getRepairCost()} exceeds the returned
     * value, the repair result will be air to due being "too expensive".
     * <p>
     * By default, this level is set to 40. Players in creative mode ignore the
     * maximum repair cost.
     *
     * @return 最大经验花费
     * @deprecated 请使用 {@link AnvilView#getMaximumRepairCost()}.
     */
    @Deprecated(forRemoval = true, since = "1.21")
    int getMaximumRepairCost();

    /**
     * 设置当前修复所允许的最大经验等级花费.
     * 原版 Minecraft 的默认值为 40.
     * <p>
     * 原文：Set the maximum experience cost (in levels) to be allowed by the current
     * repair. The default value set by vanilla Minecraft is 40.
     *
     * @param levels 最大经验等级花费
     * @deprecated 请使用 {@link AnvilView#setMaximumRepairCost(int)}.
     */
    @Deprecated(forRemoval = true, since = "1.21")
    void setMaximumRepairCost(int levels);
}
