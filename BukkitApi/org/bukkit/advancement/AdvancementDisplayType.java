package org.bukkit.advancement;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

/**
 * 进度根据其显示类型以不同方式显示.
 * <p>
 * 原文:
 * Advancements are displayed in different ways depending on their display type.
 *
 * This enum contains information about these types and how they are
 * represented.
 *
 * 此枚举包含有关这些类型及其表示方式的信息.
 */
public enum AdvancementDisplayType {

    /**
     * 任务或普通图标具有方形图标框架.
     * <p>
     * 原文:
     * Task or normal icons have a square icon frame.
     */
    TASK(ChatColor.GREEN),
    /**
     * 挑战图标具有风格化的图标框架.
     * <p>
     * 原文:
     * Challenge icons have a stylised icon frame.
     */
    CHALLENGE(ChatColor.DARK_PURPLE),
    /**
     * 目标图标具有圆形图标框架.
     * <p>
     * 原文:
     * Goal icons have a rounded icon frame.
     */
    GOAL(ChatColor.GREEN);
    private final ChatColor color;

    private AdvancementDisplayType(ChatColor color) {
        this.color = color;
    }

    /**
     * Minecraft为此进度使用的聊天颜色.
     * <p>
     * 原文:
     * The chat color used by Minecraft for this advancement.
     *
     * @return 此进度类型使用的聊天颜色
     */
    @NotNull
    public ChatColor getColor() {
        return color;
    }
}
