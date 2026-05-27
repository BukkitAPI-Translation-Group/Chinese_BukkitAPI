package org.bukkit.entity;

import org.bukkit.DyeColor;
import org.jetbrains.annotations.NotNull;

/**
 * 代表热带鱼.
 */
public interface TropicalFish extends Fish {

    /**
     * 获取热带鱼的花纹颜色.
     * <p>
     * 原文：
     * Gets the color of the fish's pattern.
     *
     * @return 花纹颜色
     */
    @NotNull
    DyeColor getPatternColor();

    /**
     * 设置热带鱼的花纹颜色.
     * <p>
     * 原文：
     * Sets the color of the fish's pattern
     *
     * @param color 花纹颜色
     */
    void setPatternColor(@NotNull DyeColor color);

    /**
     * 获取热带鱼的身体颜色.
     * <p>
     * 原文：
     * Gets the color of the fish's body.
     *
     * @return 身体颜色
     */
    @NotNull
    DyeColor getBodyColor();

    /**
     * 设置热带鱼的身体颜色.
     * <p>
     * 原文：
     * Sets the color of the fish's body
     *
     * @param color 身体颜色
     */
    void setBodyColor(@NotNull DyeColor color);

    /**
     * 获取热带鱼的花纹.
     * <p>
     * 原文：
     * Gets the fish's pattern.
     *
     * @return 花纹
     */
    @NotNull
    Pattern getPattern();

    /**
     * 设置热带鱼的花纹.
     * <p>
     * 原文：
     * Sets the fish's pattern
     *
     * @param pattern 新花纹
     */
    void setPattern(@NotNull Pattern pattern);

    /**
     * 代表所有不同热带鱼花纹的枚举。请参阅
     * <a href="https://minecraft.wiki/w/Fish">Minecraft Wiki</a>
     * 获取图片。
     */
    public static enum Pattern {

        KOB,
        SUNSTREAK,
        SNOOPER,
        DASHER,
        BRINELY,
        SPOTTY,
        FLOPPER,
        STRIPEY,
        GLITTER,
        BLOCKFISH,
        BETTY,
        CLAYFISH;
    }
}
