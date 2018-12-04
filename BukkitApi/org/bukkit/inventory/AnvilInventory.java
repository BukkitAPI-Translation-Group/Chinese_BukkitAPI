package org.bukkit.inventory;

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
     */
    String getRenameText();

    /**
     * 获取完成当前修复所需要的等级
     * <p>
     * 原文: Get the experience cost (in levels) to complete the current repair.
     *
     * @return 需要花费的经验
     */
    int getRepairCost();

    /**
     * 设置完成当前修复所需要的等级.
     * <p>
     * 原文:Set the experience cost (in levels) to complete the current repair.
     *
     * @param levels 给定的等级
     */
    void setRepairCost(int levels);
}
