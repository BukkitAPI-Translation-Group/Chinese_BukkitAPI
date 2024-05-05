package org.bukkit.inventory.meta;

import java.util.List;
import org.bukkit.block.banner.Pattern;
import org.jetbrains.annotations.NotNull;

public interface BannerMeta extends ItemMeta {

    /**
     * 返回这个旗帜的图案的列表.
     * <p>
     * 原文：Returns a list of patterns on this banner
     *
     * @return 图案列表
     */
    @NotNull
    List<Pattern> getPatterns();

    /**
     * 设置这个旗帜的图案.
     * <p>
     * 原文：Sets the patterns used on this banner
     *
     * @param patterns 新的图案的列表
     */
    void setPatterns(@NotNull List<Pattern> patterns);

    /**
     * 在现有的图案顶上新增图案.
     * <p>
     * 原文：Adds a new pattern on top of the existing
     * patterns
     *
     * @param pattern 要新增的图案
     */
    void addPattern(@NotNull Pattern pattern);

    /**
     * 返回在指定索引处的图案.
     * <p>
     * 原文：Returns the pattern at the specified index
     *
     * @param i 索引
     * @return 图案
     * @throws IndexOutOfBoundsException 当索引值不在<code>"[0, numberOfPatterns())"</code>区间内
     */
    @NotNull
    Pattern getPattern(int i);

    /**
     * 在指定索引处移除图案.
     * <p>
     * 原文：Removes the pattern at the specified index
     *
     * @param i 索引
     * @return 移除的图案
     * @throws IndexOutOfBoundsException 当索引值不在<code>"[0, numberOfPatterns())"</code>区间内
     */
    @NotNull
    Pattern removePattern(int i);

    /**
     * 在指定的索引处设置图案.
     * <p>
     * 原文：Sets the pattern at the specified index
     *
     * @param i 索引
     * @param pattern 新的图案
     * @throws IndexOutOfBoundsException 当索引值不在<code>"[0, numberOfPatterns())"</code>区间内
     */
    void setPattern(int i, @NotNull Pattern pattern);

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