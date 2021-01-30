package org.bukkit.inventory.meta;

import org.bukkit.DyeColor;
import org.bukkit.entity.TropicalFish;
import org.jetbrains.annotations.NotNull;

/**
 * 代表热带鱼桶.
 */
public interface TropicalFishBucketMeta extends ItemMeta {

    /**
     * 获取热带鱼花纹的颜色.
     * <p>
     * 插件应该在调用这个方法之前检查 hasVariant() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the color of the fish's pattern.
     * <p>
     * Plugins should check that hasVariant() returns <code>true</code> before
     * calling this method.
     *
     * @return 花纹颜色
     */
    @NotNull
    DyeColor getPatternColor();

    /**
     * 设置热带鱼花纹的颜色.
     * <p>
     * 当 hasVariant() 返回 <code>false</code> 时设置, 将初始化其它值为未指定的默认值.
     * <p>
     * 原文:
     * Sets the color of the fish's pattern.
     * <p>
     * Setting this when hasVariant() returns <code>false</code> will initialize
     * all other values to unspecified defaults.
     *
     * @param color 花纹颜色
     */
    void setPatternColor(@NotNull DyeColor color);

    /**
     * 获取热带鱼身体的颜色.
     * <p>
     * 插件应该在调用这个方法之前检查 hasVariant() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the color of the fish's body.
     * <p>
     * Plugins should check that hasVariant() returns <code>true</code> before
     * calling this method.
     *
     * @return 热带鱼身体的颜色
     */
    @NotNull
    DyeColor getBodyColor();

    /**
     * 设置热带鱼身体的颜色.
     * <p>
     * 当 hasVariant() 返回 <code>false</code> 时设置, 将初始化其它值为未指定的默认值.
     * <p>
     * 原文:
     * Sets the color of the fish's body.
     * <p>
     * Setting this when hasVariant() returns <code>false</code> will initialize
     * all other values to unspecified defaults.
     *
     * @param color 热带鱼身体的颜色
     */
    void setBodyColor(@NotNull DyeColor color);

    /**
     * 获取热带鱼的花纹.
     * <p>
     * 插件应该在调用这个方法之前检查 hasVariant() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the fish's pattern.
     * <p>
     * Plugins should check that hasVariant() returns <code>true</code> before
     * calling this method.
     *
     * @return 热带鱼的花纹
     */
    @NotNull
    TropicalFish.Pattern getPattern();

    /**
     * 设置热带鱼的花纹.
     * <p>
     * 当 hasVariant() 返回 <code>false</code> 时设置, 将初始化其它值为未指定的默认值.
     * <p>
     * 原文:
     * Sets the fish's pattern.
     * <p>
     * Setting this when hasVariant() returns <code>false</code> will initialize
     * all other values to unspecified defaults.
     *
     * @param pattern 新花纹
     */
    void setPattern(@NotNull TropicalFish.Pattern pattern);

    /**
     * 检查是否存在 variant 标签, 此标签指示会生成何种热带鱼.
     * <p>
     * 原文:
     * Checks for existence of a variant tag indicating a specific fish will be
     * spawned.
     *
     * @return 是否存在 variant 标签
     */
    boolean hasVariant();

    @Override
    @NotNull
    TropicalFishBucketMeta clone();
}
