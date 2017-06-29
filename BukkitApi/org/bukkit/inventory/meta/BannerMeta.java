package org.bukkit.inventory.meta;

import java.util.List;
import org.bukkit.DyeColor;
import org.bukkit.block.banner.Pattern;

public interface BannerMeta extends ItemMeta {

    /**
     * 返回这个旗帜的底色.
     * <p>
     * 原文：Returns the base color for this banner
     *
     * @return 底色
     * @deprecated 旗帜底色现以数据值的形式存储，而不是元数据.
     */
    @Deprecated
    DyeColor getBaseColor();

    /**
     * 设置这个旗帜的底色.
     * <p>
     * 原文：Sets the base color for this banner
     *
     * @param color 底色
     * @deprecated 旗帜底色现以数据值的形式存储，而不是元数据.
     */
    @Deprecated
    void setBaseColor(DyeColor color);

    /**
     * 返回这个旗帜的图案的列表.
     * <p>
     * 原文：Returns a list of patterns on this banner
     *
     * @return 图案列表
     */
    List<Pattern> getPatterns();

    /**
     * 设置这个旗帜的图案.
     * <p>
     * 原文：Sets the patterns used on this banner
     *
     * @param patterns 新的图案的列表
     */
    void setPatterns(List<Pattern> patterns);

    /**
     * 在现有的图案顶上新增图案.
     * <p>
     * 原文：Adds a new pattern on top of the existing
     * patterns
     *
     * @param pattern 要新增的图案
     */
    void addPattern(Pattern pattern);

    /**
     * 返回在指定索引处的图案.
     * <p>
     * 原文：Returns the pattern at the specified index
     *
     * @param i 索引
     * @return 图案
     */
    Pattern getPattern(int i);

    /**
     * 在指定索引处移除图案.
     * <p>
     * 原文：Removes the pattern at the specified index
     *
     * @param i 索引
     * @return 移除的图案
     */
    Pattern removePattern(int i);

    /**
     * 在指定的索引处设置图案.
     * <p>
     * 原文：Sets the pattern at the specified index
     *
     * @param i 索引
     * @param pattern 新的图案
     */
    void setPattern(int i, Pattern pattern);

    /**
     * 返回在这个旗帜的图案数量.
     * <p>
     * 原文：Returns the number of patterns on this
     * banner
     *
     * @return 图案数量
     */
    int numberOfPatterns();
}