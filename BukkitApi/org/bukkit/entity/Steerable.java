package org.bukkit.entity;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个可以装鞍、骑乘并使用物品操控的实体。
 */
public interface Steerable extends Animals {

    /**
     * 检查猪是否有鞍。
     * <p>
     * 原文：Check if the pig has a saddle.
     *
     * @return 猪是否已装鞍
     */
    public boolean hasSaddle();

    /**
     * 设置猪是否有鞍。
     * <p>
     * 原文：Sets if the pig has a saddle or not
     *
     * @param saddled 设置猪是否有鞍
     */
    public void setSaddle(boolean saddled);

    /**
     * 获取此实体移动速度提升的时间（以tick为单位）。
     * <p>
     * 移动速度提升通常是由于使用 {@link #getSteerMaterial()} 导致的。
     * <p>
     * 原文：Get the time in ticks this entity's movement is being increased.
     * <p>
     * Movement speed is often increased as a result of using the
     * {@link #getSteerMaterial()}.
     *
     * @return 当前加速tick数
     */
    public int getBoostTicks();

    /**
     * 设置此实体移动速度提升的时间（以tick为单位）。
     * <p>
     * 这将把当前加速tick数重置为0（{@link #getCurrentBoostTicks()}）。
     * <p>
     * 原文：Set the time in ticks this entity's movement will be increased.
     * <p>
     * This will reset the current boost ticks to 0
     * ({@link #getCurrentBoostTicks()}).
     *
     * @param ticks 加速时间
     */
    public void setBoostTicks(int ticks);

    /**
     * 获取此实体自最近一次加速以来移动速度提升的时间（以tick为单位）。
     * <p>
     * 当前加速tick数永远不会 {@literal >} {@link #getBoostTicks()}。
     * <p>
     * 原文：Get the time in ticks this entity's movement has been increased as of the
     * most recent boost.
     * <p>
     * Current boost ticks will never be {@literal >} {@link #getBoostTicks()}.
     *
     * @return 当前加速tick数
     */
    public int getCurrentBoostTicks();

    /**
     * 设置此实体自最近一次加速以来移动速度提升的时间（以tick为单位）。
     * <p>
     * 原文：Set the time in ticks this entity's movement has been increased relative
     * to the most recent boost.
     *
     * @param ticks 当前加速tick数。必须 {@literal >=} 0 且 {@literal <=} {@link #getBoostTicks()}
     */
    public void setCurrentBoostTicks(int ticks);

    /**
     * 获取玩家骑乘此实体时用于操控的物品材料。
     * <p>
     * 原文：Get the material used to steer this entity when ridden by a player.
     *
     * @return 引诱材料
     */
    @NotNull
    public Material getSteerMaterial();
}
