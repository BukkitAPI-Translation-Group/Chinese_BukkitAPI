package org.bukkit.inventory.view;

import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

/**
 * 一个提供与熔炉视图数据相关额外方法的 {@link InventoryView} 实例。
 */
public interface FurnaceView extends InventoryView {

    @NotNull
    @Override
    FurnaceInventory getTopInventory();

    /**
     * 此视图的烹饪时间。
     * <p>
     * 详见 {@link Furnace#getCookTime()}。
     *
     * @return 一个0到1之间的数字
     * <p>
     * 原文：The cook time for this view.
     * <p>
     * See {@link Furnace#getCookTime()} for more information.
     *
     * @return a number between 0 and 1
     */
    float getCookTime();

    /**
     * 此视图的总燃烧时间。
     * <p>
     * 详见 {@link Furnace#getBurnTime()}。
     *
     * @return 一个0到1之间的数字
     * <p>
     * 原文：The total burn time for this view.
     * <p>
     * See {@link Furnace#getBurnTime()} for more information.
     *
     * @return a number between 0 and 1
     */
    float getBurnTime();

    /**
     * 检查熔炉是否正在燃烧。
     *
     * @return 如果熔炉正在燃烧则返回true
     * <p>
     * 原文：Checks whether or not the furnace is burning
     *
     * @return true given that the furnace is burning
     */
    boolean isBurning();

    /**
     * 设置烹饪时间。
     * <p>
     * 设置烹饪时间需要同时操作烹饪进度和烹饪时长。此方法通过简单除法获取熔炉视觉进度条内的总进度。
     * 为获得清晰的视觉效果，(烹饪进度 / 烹饪时长) 应返回一个0到1之间的数字（包含0和1）。
     *
     * @param cookProgress 当前的烹饪进度
     * @param cookDuration 总烹饪时间
     * <p>
     * 原文：Sets the cook time
     * <p>
     * Setting cook time requires manipulation of both cookProgress and
     * cookDuration. This method does a simple division to get total progress
     * within the furnaces visual duration bar. For a clear visual effect
     * (cookProgress / cookDuration) should return a number between 0 and 1
     * inclusively.
     *
     * @param cookProgress the current of the cooking
     * @param cookDuration the total cook time
     */
    void setCookTime(int cookProgress, int cookDuration);

    /**
     * 设置燃烧时间。
     * <p>
     * 设置燃烧时间需要同时操作燃烧进度和燃烧时长。此方法通过简单除法获取熔炉视觉燃烧条内的总进度。
     * 为获得清晰的视觉效果，(燃烧进度 / 燃烧时长) 应返回一个0到1之间的数字（包含0和1）。
     *
     * @param burnProgress 燃烧时长的进度
     * @param burnDuration 视图应保持燃烧的总时长
     * <p>
     * 原文：Sets the burn time
     * <p>
     * Setting burn time requires manipulation of both burnProgress and
     * burnDuration. This method does a simple division to get total progress
     * within the furnaces visual burning bar. For a clear visual effect
     * (burnProgress / burnDuration) should return a number between 0 and 1
     * inclusively.
     *
     * @param burnProgress the progress towards the burnDuration
     * @param burnDuration the total duration the view should be lit
     */
    void setBurnTime(int burnProgress, int burnDuration);
}
