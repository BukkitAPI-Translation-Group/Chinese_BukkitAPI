package org.bukkit.block.sign;

import org.bukkit.material.Colorable;
import org.jetbrains.annotations.NotNull;

/**
 * 表示告示牌的一面。
 * <p>
 * 原文:
 * Represents a side of a sign.
 */
public interface SignSide extends Colorable {

    /**
     * 获取当前在此告示牌一面上的所有文本行。
     * <p>
     * 原文:
     * Gets all the lines of text currently on this side of the sign.
     *
     * @return Array of Strings containing each line of text
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
     * @param index Line number to get the text from, starting at 0
     * @return Text on the given line
     * @throws IndexOutOfBoundsException Thrown when the line does not exist
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
     * @param index Line number to set the text at, starting from 0
     * @param line  New text to set at the specified index
     * @throws IndexOutOfBoundsException If the index is out of the range 0..3
     */
    public void setLine(int index, @NotNull String line) throws IndexOutOfBoundsException;

    /**
     * 获取此告示牌一面上的文本是否发光。
     * <p>
     * 原文:
     * Gets whether this side of the sign has glowing text.
     *
     * @return if this side of the sign has glowing text
     */
    public boolean isGlowingText();

    /**
     * 设置此告示牌一面上的文本是否发光。
     * <p>
     * 原文:
     * Sets whether this side of the sign has glowing text.
     *
     * @param glowing if this side of the sign has glowing text
     */
    public void setGlowingText(boolean glowing);
}
