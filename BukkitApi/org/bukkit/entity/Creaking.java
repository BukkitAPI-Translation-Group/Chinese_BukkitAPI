package org.bukkit.entity;

import org.bukkit.Location;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 咔嗒嘎.
 */
@ApiStatus.Experimental
public interface Creaking extends Monster {

    /**
     * 获取此咔嗒嘎的家位置 (即其对应的 {@link org.bukkit.block.CreakingHeart} 所在位置).
     * <p>
     * 原文：Gets the home location for this Creaking (ie where its corresponding
     * {@link org.bukkit.block.CreakingHeart} can be).
     *
     * @return 家的位置
     */
    @NotNull
    public Location getHome();

    /**
     * 设置此咔嗒嘎的家位置.
     * <p>
     * 原文：Sets the home location for this Creaking.
     *
     * @param location 家的位置
     */
    public void setHome(@NotNull Location location);

    /**
     * 激活此咔嗒嘎以追踪和跟随玩家.
     * <p>
     * 原文：Activate this Creaking to target and follow a player.
     *
     * @param player 目标玩家
     */
    public void activate(@NotNull Player player);

    /**
     * 使此咔嗒嘎从当前目标玩家处失活.
     * <p>
     * 原文：Deactivate this Creaking from the current target player.
     */
    public void deactivate();

    /**
     * 获取此咔嗒嘎是否处于激活状态.
     * <p>
     * 原文：Gets if this Creaking is active.
     *
     * @return 如果处于激活状态则为 true
     */
    public boolean isActive();
}
