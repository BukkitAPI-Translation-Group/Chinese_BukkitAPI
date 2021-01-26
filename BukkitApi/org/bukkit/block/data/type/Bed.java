package org.bukkit.block.data.type;

import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.Directional;
import org.jetbrains.annotations.NotNull;

/**
 * 与 {@link Bisected} 相似, 'part' 值表示该方块对应的是床的哪一部分.
 * <br>
 * 'occupied' 值是一个用于检查当前是否有玩家睡在该床方块上的快速标识.
 */
public interface Bed extends Directional {

    /**
     * 获取 'part' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'part' property.
     *
     * @return 属性 'part' 的值
     */
    @NotNull
    Part getPart();

    /**
     * 设置 'part' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'part' property.
     *
     * @param part 新的 'part' 属性值
     */
    void setPart(@NotNull Part part);

    /**
     * 获取 'occupied' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'occupied' property.
     *
     * @return 属性 'occupied' 的值
     */
    boolean isOccupied();

    /**
     * 将床水平平分为两半.
     */
    public enum Part {

        /**
         * 床的上半部分, 包含枕头的那部分
         */
        HEAD,
        /**
         * 床的下半部分
         */
        FOOT;
    }
}
