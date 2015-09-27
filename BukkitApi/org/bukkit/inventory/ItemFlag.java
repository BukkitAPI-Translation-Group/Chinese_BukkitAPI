package org.bukkit.inventory;

/**
 * 隐藏ItemStacks的某些属性.
 */
public enum ItemFlag {

    /**
     * 设置显示/隐藏附魔.
     * <p>
     * 原文:Setting to show/hide enchants
     */
    HIDE_ENCHANTS,
    /**
     * 设置显示/隐藏该Item的属性,例如伤害.
     * <p>
     * 原文:Setting to show/hide Attributes like Damage
     */
    HIDE_ATTRIBUTES,
    /**
     * 设置显示/隐藏不可破坏属性.
     * <p>
     * 原文:Setting to show/hide the unbreakable State
     */
    HIDE_UNBREAKABLE,
    /**
     * 设置显示/隐藏哪些ItemStack可以被破坏.
     * <p>
     * 原文:Setting to show/hide what the ItemStack can break/destroy
     */
    HIDE_DESTROYS,
    /**
     * 设置显示/隐藏哪些ItemStack可以被放置.
     * <p>
     * 原文:Setting to show/hide where this ItemStack can be build/placed on
     */
    HIDE_PLACED_ON,
    /**
     * 设置显示/隐藏ItemStack的药水效果.
     * <p>
     * 原文:Setting to show/hide potion effects on this ItemStack
     */
    HIDE_POTION_EFFECTS;
}
