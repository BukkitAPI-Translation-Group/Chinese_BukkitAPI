package org.bukkit.entity;

import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * 表示载具实体。
 */
public interface Vehicle extends Entity {

    /**
     * 获取载具的速度。
     *
     * @return 速度向量
     * <p>
     * 原文：Gets the vehicle's velocity.
     *
     * @return velocity vector
     */
    @Override
    @NotNull
    public Vector getVelocity();

    /**
     * 设置载具的速度（单位：米/刻）。
     *
     * @param vel 速度向量
     * <p>
     * 原文：Sets the vehicle's velocity in meters per tick.
     *
     * @param vel velocity vector
     */
    @Override
    public void setVelocity(@NotNull Vector vel);
}
