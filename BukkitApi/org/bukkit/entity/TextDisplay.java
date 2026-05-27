package org.bukkit.entity;

import org.bukkit.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示文本显示实体。
 */
public interface TextDisplay extends Display {

    /**
     * 获取显示的文本。
     *
     * @return 显示的文本。
     * <p>
     * 原文：Gets the displayed text.
     *
     * @return the displayed text.
     */
    @Nullable
    String getText();

    /**
     * 设置显示的文本。
     *
     * @param text 新文本
     * <p>
     * 原文：Sets the displayed text.
     *
     * @param text the new text
     */
    void setText(@Nullable String text);

    /**
     * 获取换行前的最大行宽。
     *
     * @return 行宽
     * <p>
     * 原文：Gets the maximum line width before wrapping.
     *
     * @return the line width
     */
    int getLineWidth();

    /**
     * 设置换行前的最大行宽。
     *
     * @param width 新行宽
     * <p>
     * 原文：Sets the maximum line width before wrapping.
     *
     * @param width new line width
     */
    void setLineWidth(int width);

    /**
     * 获取文本背景颜色。
     *
     * @return 背景颜色
     * <p>
     * 原文：Gets the text background color.
     *
     * @return the background color
     */
    @Nullable
    Color getBackgroundColor();

    /**
     * 设置文本背景颜色。
     *
     * @param color 新背景颜色
     * <p>
     * 原文：Sets the text background color.
     *
     * @param color new background color
     */
    void setBackgroundColor(@Nullable Color color);

    /**
     * 获取文本不透明度。
     *
     * @return 不透明度，如果未设置则返回-1
     * <p>
     * 原文：Gets the text opacity.
     *
     * @return opacity or -1 if not set
     */
    byte getTextOpacity();

    /**
     * 设置文本不透明度。
     *
     * @param opacity 新不透明度，如果为默认值则为-1
     * <p>
     * 原文：Sets the text opacity.
     *
     * @param opacity new opacity or -1 if default
     */
    void setTextOpacity(byte opacity);

    /**
     * 获取文本是否有阴影。
     *
     * @return 阴影状态
     * <p>
     * 原文：Gets if the text is shadowed.
     *
     * @return shadow status
     */
    boolean isShadowed();

    /**
     * 设置文本是否有阴影。
     *
     * @param shadow 是否有阴影
     * <p>
     * 原文：Sets if the text is shadowed.
     *
     * @param shadow if shadowed
     */
    void setShadowed(boolean shadow);

    /**
     * 获取文本是否透明。
     *
     * @return 透明状态
     * <p>
     * 原文：Gets if the text is see through.
     *
     * @return see through status
     */
    boolean isSeeThrough();

    /**
     * 设置文本是否透明。
     *
     * @param seeThrough 是否透明
     * <p>
     * 原文：Sets if the text is see through.
     *
     * @param seeThrough if see through
     */
    void setSeeThrough(boolean seeThrough);

    /**
     * 获取文本是否有默认背景。
     *
     * @return 默认背景
     * <p>
     * 原文：Gets if the text has its default background.
     *
     * @return default background
     */
    boolean isDefaultBackground();

    /**
     * 设置文本是否有默认背景。
     *
     * @param defaultBackground 是否为默认
     * <p>
     * 原文：Sets if the text has its default background.
     *
     * @param defaultBackground if default
     */
    void setDefaultBackground(boolean defaultBackground);

    /**
     * 获取此显示的文本对齐方式。
     *
     * @return 文本对齐方式
     * <p>
     * 原文：Gets the text alignment for this display.
     *
     * @return text alignment
     */
    @NotNull
    TextAlignment getAlignment();

    /**
     * 设置此显示的文本对齐方式。
     *
     * @param alignment 新对齐方式
     * <p>
     * 原文：Sets the text alignment for this display.
     *
     * @param alignment new alignment
     */
    void setAlignment(@NotNull TextAlignment alignment);

    /**
     * 表示此显示可能的文本对齐方式。
     */
    public enum TextAlignment {

        /**
         * 居中对齐文本（默认）。
         */
        CENTER,
        /**
         * 左对齐文本。
         */
        LEFT,
        /**
         * 右对齐文本。
         */
        RIGHT;
    }
}
