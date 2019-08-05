package org.bukkit.block;

import java.util.List;
import org.bukkit.DyeColor;
import org.bukkit.block.banner.Pattern;
import org.jetbrains.annotations.NotNull;

/**
 * 代表旗帜(快照)/Represents a captured state of a banner.
 */
public interface Banner extends TileState {

    /**
     * 返回这个旗帜的底色.
     * <p>
     * 原文:
     * Returns the base color for this banner
     *
     * @return 底色
     */
    @NotNull
    DyeColor getBaseColor();

    /**
     * 设置这个旗帜的底色.
     * <b>仅对盾牌伪旗帜有效, 否则取决于方块的类型</b>.
     * <p>
     * 原文:
     * Sets the base color for this banner.
     * <b>Only valid for shield pseudo banners, otherwise base depends on block
     * type</b>
     *
     * @param color 底色
     */
    void setBaseColor(@NotNull DyeColor color);

    /**
     * 返回这个旗帜的图案.
     * <p>
     * 原文：
     * Returns a list of patterns on this banner
     *
     * @return 图案
     */
    @NotNull
    List<Pattern> getPatterns();

    /**
     * 设置这个旗帜使用的图案.
     * <p>
     * 原文:
     * Sets the patterns used on this banner
     *
     * @param patterns 新的图案列表
     */
    void setPatterns(@NotNull List<Pattern> patterns);

    /**
     * 在现有的图案上添加一个图案.
     * <p>
     * 原文:
     * Adds a new pattern on top of the existing
     * patterns
     *
     * @param pattern 要添加的新的图案
     */
    void addPattern(@NotNull Pattern pattern);

    /**
     * 返回这个图案指定的索引处.
     * <p>
     * 原文:
     * Returns the pattern at the specified index
     *
     * @param i 索引
     * @return 图案
     */
    @NotNull
    Pattern getPattern(int i);

    /**
     * 以指定的索引处移除图案.
     * <p>
     * 原文:
     * Removes the pattern at the specified index
     *
     * @param i 索引
     * @return 移除的图案
     */
    @NotNull
    Pattern removePattern(int i);

    /**
     * 以指定的索引处设置图案.
     * <p>
     * 原文:
     * Sets the pattern at the specified index
     *
     * @param i 索引
     * @param pattern 新的图案
     */
    void setPattern(int i, @NotNull Pattern pattern);

    /**
     * 返回在这个旗帜上的图案的编号.
     * <p>
     * 原文:
     * Returns the number of patterns on this
     * banner
     *
     * @return 图案的编号
     */
    int numberOfPatterns();
}