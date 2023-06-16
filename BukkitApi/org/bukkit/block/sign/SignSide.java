package org.bukkit.block.sign;

import org.bukkit.material.Colorable;
import org.jetbrains.annotations.NotNull;

/**
 * 表示告示牌的一面。
 */
public interface SignSide extends Colorable {

    /**
     * 获取当前在此告示牌一面上的所有文本行。
     * <p>
     * 原文:
     * Gets all the lines of text currently on this side of the sign.
     *
     * @return 包含所有文本行的字符串数组
     */
    @NotNull
    public String[] getLines();

    /**
     * 获取此告示牌一面上指定索引处的文本行。
     * <p>
     * 例如，getLine(0) 将返回第一行文本。
     * <p>
     * 原文:
     * Gets the line of text at the specified index on this side of the sign.
     * <p>
     * For example, getLine(0) will return the first line of text.
     *
     * @param index 获取哪一行的文本, 从0开始数
     * @return 指定行的文本
     * @throws IndexOutOfBoundsException 如果这一行不存在(范围0-3)
     */
    @NotNull
    public String getLine(int index) throws IndexOutOfBoundsException;

    /**
     * 设置此告示牌一面上指定索引处的文本行。
     * <p>
     * 例如，setLine(0, "第一行") 将把第一行文本设置为 "第一行"。
     * <p>
     * 原文:
     * Sets the line of text at the specified index on this side of the sign.
     * <p>
     * For example, setLine(0, "Line One") will set the first line of text to
     * "Line One".
     *
     * @param index 设置哪一行的文本, 从0开始数
     * @param line 指定行的新文本
     * @throws IndexOutOfBoundsException 如果index值不在[0-3]内
     */
    public void setLine(int index, @NotNull String line) throws IndexOutOfBoundsException;

    /**
     * 获取此告示牌一面上的文本是否发光。
     * <p>
     * 原文:
     * Gets whether this side of the sign has glowing text.
     *
     * @return 此告示牌一面上的文本是否发光
     */
    public boolean isGlowingText();

    /**
     * 设置此告示牌一面上的文本是否发光。
     * <p>
     * 原文:
     * Sets whether this side of the sign has glowing text.
     *
     * @param glowing 此告示牌一面上的文本是否发光
     */
    public void setGlowingText(boolean glowing);
}
