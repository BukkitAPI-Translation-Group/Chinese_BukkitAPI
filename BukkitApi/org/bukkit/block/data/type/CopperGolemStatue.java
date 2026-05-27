package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Waterlogged;
import org.jetbrains.annotations.NotNull;

/**
 * 'copper_golem_pose' 表示铜傀儡雕像的姿态.
 */
public interface CopperGolemStatue extends Directional, Waterlogged {

    /**
     * 获取 'copper_golem_pose' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'copper_golem_pose' property.
     *
     * @return 'copper_golem_pose' 的值
     */
    @NotNull
    CopperGolemPose getCopperGolemPose();

    /**
     * 设置 'copper_golem_pose' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'copper_golem_pose' property.
     *
     * @param copperGolemPose 新的 'copper_golem_pose' 值
     */
    void setCopperGolemPose(@NotNull CopperGolemPose copperGolemPose);

    /**
     * 铜傀儡雕像的姿态.
     */
    public enum CopperGolemPose {
        /**
         * 站立姿态.
         */
        STANDING,
        /**
         * 坐姿姿态.
         */
        SITTING,
        /**
         * 奔跑姿态.
         */
        RUNNING,
        /**
         * 星形姿态.
         */
        STAR;
    }
}
