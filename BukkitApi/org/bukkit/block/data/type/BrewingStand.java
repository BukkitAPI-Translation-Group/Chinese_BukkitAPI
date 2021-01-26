package org.bukkit.block.data.type;

import java.util.Set;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

/**
 * 酿造台的 'has_bottle_0', 'has_bottle_1', 'has_bottle_2' 标识接口表示是否在外部贴图渲染出瓶子.
 * <p>
 * 原文:
 * Interface to the 'has_bottle_0', 'has_bottle_1', 'has_bottle_2' flags on a
 * brewing stand which indicate which bottles are rendered on the outside.
 * <br>
 * 酿造台可能有 0, 1... {@link #getMaximumBottles()}-1 个瓶子.
 */
public interface BrewingStand extends BlockData {

    /**
     * 检查酿造台指定位置是否有瓶子.
     * <p>
     * 原文:
     * Checks if the stand has the following bottle
     *
     * @param bottle 要检查的位置
     * @return 是否存在瓶子
     */
    boolean hasBottle(int bottle);

    /**
     * 设置酿造台指定位置是否有瓶子.
     * <p>
     * 原文:
     * Set whether the stand has this bottle present.
     *
     * @param bottle 要设置的位置
     * @param has 是否存在瓶子
     */
    void setBottle(int bottle, boolean has);

    /**
     * 获取酿造台上所有瓶子的位置.
     * <p>
     * 原文:
     * Get the indexes of all the bottles present on this block.
     *
     * @return 代表所有瓶子的位置索引集合
     */
    @NotNull
    Set<Integer> getBottles();

    /**
     * 获取该酿造台所能容纳瓶子的最大数量.
     * <p>
     * 原文:
     * Get the maximum amount of bottles present on this stand.
     *
     * @return 瓶子的最大数量
     */
    int getMaximumBottles();
}
