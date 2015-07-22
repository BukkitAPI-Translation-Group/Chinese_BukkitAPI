package org.bukkit.block;

import org.bukkit.DyeColor;
import org.bukkit.block.banner.Pattern;

import java.util.List;

public interface Banner extends BlockState {

    /**
     * 返回这个旗帜的基本颜色.
     * <p>
     * 原文:
     * Returns the base color for this banner
     *
     * @return 基本颜色
     */
    DyeColor getBaseColor();

    /**
     * 设置这个旗帜的基本颜色.
     * <p>
     * 原文:
     * Sets the base color for this banner
     *
     * @param color the base color
     */
    void setBaseColor(DyeColor color);

    /**
     * 返回这个旗帜的正则表达式.
     * <p>
     * 原文
     * Returns a list of patterns on this banner
     *
     * @return 正则表达式
     */
    List<Pattern> getPatterns();

    /**
     * 设置这个旗帜使用的正则表达式
     * <p>
     * 原文:
     * Sets the patterns used on this banner
     *
     * @param patterns 新的正则表达式列表
     */
    void setPatterns(List<Pattern> patterns);

    /**
     * 在现有的正则表达式上添加一个新的正则表达式.
     * <p>
     * 原文:
     * Adds a new pattern on top of the existing
     * patterns
     *
     * @param pattern 要添加的新的正则表达式
     */
    void addPattern(Pattern pattern);

    /**
     * 返回这个正则表达式指定的索引处.
     * <p>
     * 原文:
     * Returns the pattern at the specified index
     *
     * @param i 索引
     * @return 正则表达式
     */
    Pattern getPattern(int i);

    /**
     * 以指定的索引处移除正则表达式
     * <p>
     * 原文:
     * Removes the pattern at the specified index
     *
     * @param i 索引
     * @return 移除的正则表达式
     */
    Pattern removePattern(int i);

    /**
     * 以指定的索引处设置正则表达式.
     * <p>
     * 原文:
     * Sets the pattern at the specified index
     *
     * @param i       索引
     * @param pattern 新的正则表达式
     */
    void setPattern(int i, Pattern pattern);

    /**
     * 返回在这个旗帜上的正则表达式的编号.
     * <p>
     * 原文:
     * Returns the number of patterns on this
     * banner
     *
     * @return 正则表达式的编号
     */
    int numberOfPatterns();
}