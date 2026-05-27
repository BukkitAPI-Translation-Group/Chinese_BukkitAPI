package org.bukkit.entity.model;

import org.jetbrains.annotations.ApiStatus;

/**
 * 表示玩家模型/纹理的一部分。
 */
@ApiStatus.Experimental
public enum PlayerModelPart {

    /**
     * 玩家披风。
     */
    CAPE,
    /**
     * 玩家躯干覆盖物。
     */
    JACKET,
    /**
     * 玩家左臂覆盖物。
     */
    LEFT_SLEEVE,
    /**
     * 玩家右臂覆盖物。
     */
    RIGHT_SLEEVE,
    /**
     * 玩家左腿覆盖物。
     */
    LEFT_PANTS_LEG,
    /**
     * 玩家右腿覆盖物。
     */
    RIGHT_PANTS_LEG,
    /**
     * 玩家帽子/头盔。
     */
    HAT;
}
