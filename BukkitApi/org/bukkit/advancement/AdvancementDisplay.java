package org.bukkit.advancement;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 保存游戏如何显示此进度的信息.
 * <p>
 * 原文:
 * Holds information about how the advancement is displayed by the game.
 */
public interface AdvancementDisplay {

    /**
     * 获取此进度的标题.
     * <p>
     * 原文:
     * Gets the title of the advancement.
     *
     * @return 不含颜色代码的进度标题
     */
    @NotNull
    String getTitle();

    /**
     * 获取此进度的可见描述.
     * <p>
     * 原文:
     * Gets the visible description of the advancement.
     *
     * @return 不含颜色代码的进度描述
     */
    @NotNull
    String getDescription();

    /**
     * 用于此进度的图标.
     * <p>
     * 原文:
     * The icon that is used for this advancement.
     *
     * @return 代表此进度的ItemStack
     */
    @NotNull
    ItemStack getIcon();

    /**
     * 当此进度完成时是否向玩家显示一个提示.
     * <p>
     * 原文:
     * Whether to show a toast to the player when this advancement has been
     * completed.
     *
     * @return 如果显示提示则返回true
     */
    boolean shouldShowToast();

    /**
     * 当此进度完成时是否在聊天中公告.
     * <p>
     * 原文:
     * Whether to announce in the chat when this advancement has been completed.
     *
     * @return 如果在聊天中公告则返回true
     */
    boolean shouldAnnounceChat();

    /**
     * 在完成此进度前是否在进度界面中隐藏此进度及其所有子进度.
     * <p>
     * 原文:
     * Whether to hide this advancement and all its children from the
     * advancement screen until this advancement have been completed.
     *
     * Has no effect on root advancements themselves, but still affects all
     * their children.
     *
     * 对根进度本身没有影响, 但仍然影响其所有子进度.
     *
     * @return 如果隐藏则返回true
     */
    boolean isHidden();

    /**
     * 此进度在进度界面中的X位置.
     * <p>
     * 原文:
     * The X position of the advancement in the advancement screen.
     *
     * @return X坐标, 浮点数形式
     */
    float getX();

    /**
     * 此进度在进度界面中的Y位置.
     * <p>
     * 原文:
     * The Y position of the advancement in the advancement screen.
     *
     * @return Y坐标, 浮点数形式
     */
    float getY();

    /**
     * 此进度的显示类型.
     * <p>
     * 原文:
     * The display type of this advancement.
     *
     * @return 表示类型的枚举
     */
    @NotNull
    AdvancementDisplayType getType();
}
