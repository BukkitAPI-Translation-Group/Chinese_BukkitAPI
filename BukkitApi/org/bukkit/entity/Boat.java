package org.bukkit.entity;

import org.bukkit.TreeSpecies;
import org.jetbrains.annotations.NotNull;

/**
 * 代表船实体
 */
public interface Boat extends Vehicle {

    /**
     * 获取船的木质种类. (例如:橡木质船/云杉木质船/白桦木质船等 ...)
     * <p>
     * 原文:
     * Gets the wood type of the boat.
     *
     * @return 船的木质种类
     */
    @NotNull
    TreeSpecies getWoodType();

    /**
     * 设置船的木质种类.
     * <p>
     * 原文:
     * Sets the wood type of the boat.
     *
     * @param species 新的木质种类
     */
    void setWoodType(@NotNull TreeSpecies species);

    /**
     * 获取船的最高速度,该速度与船的方向速度无关.
     * <p>
     * 原文:
     * Gets the maximum speed of a boat. The speed is unrelated to the
     * velocity.
     *
     * @return 最大速度.
     * @deprecated 船是复杂的,其中许多方法不能在多个版本中正常的工作.
     */
    @Deprecated
    public double getMaxSpeed();

    /**
     * 设置船的最大速度,必须是非负数. 该默认值为0.4D
     * <p>
     * 原文:
     * Sets the maximum speed of a boat. Must be nonnegative. Default is 0.4D.
     *
     * @param speed 最大速度.
     * @deprecated 船是复杂的,其中许多方法不能在多个版本中正常的工作.
     */
    @Deprecated
    public void setMaxSpeed(double speed);

    /**
     * 获取当前已被占用船的加减速度的速率,(新速度=当前速度*速率) 该默认值为0.2.
     * <p>
     * 原文:
     * Gets the deceleration rate (newSpeed = curSpeed * rate) of occupied
     * boats. The default is 0.2.
     *
     * @return 加减速率
     * @deprecated 船是复杂的,其中许多方法不能在多个版本中正常的工作.
     */
    @Deprecated
    public double getOccupiedDeceleration();

    /**
     * 设置当前已被占用船的加减速度速率(新速度=当前速度*速率). 设置为一个高的数值
     * 时将允许船有更高的加速速率. 该默认值为0.2.
     * <p>
     * 原文:
     * Sets the deceleration rate (newSpeed = curSpeed * rate) of occupied
     * boats. Setting this to a higher value allows for quicker acceleration.
     * The default is 0.2.
     *
     * @param rate 加减速率
     * @deprecated 船是复杂的,其中许多方法不能在多个版本中正常的工作.
     */
    @Deprecated
    public void setOccupiedDeceleration(double rate);

    /**
     * 获取未占用船的加减速度速率(新速度=当前速度*速率).
     * 默认值为-1. 值低于0表示没有施加额外的加减速速率.
     * <p>
     * 原文:
     * Gets the deceleration rate (newSpeed = curSpeed * rate) of unoccupied
     * boats. The default is -1. Values below 0 indicate that no additional
     * deceleration is imposed.
     *
     * @return 加减速速率
     * @deprecated 船是复杂的,其中许多方法不能在多个版本中正常的工作.
     */
    @Deprecated
    public double getUnoccupiedDeceleration();

    /**
     * 设置未占用船的加减速度速率(新速度=当前速度*速率).
     * 设置一个高的数值时,如果玩家下船将允许该船有更快的减速速率.
     * 默认值为-1. 值低于0表示没有施加额外的加减速速率.
     * <p>
     * 原文:
     * Sets the deceleration rate (newSpeed = curSpeed * rate) of unoccupied
     * boats. Setting this to a higher value allows for quicker deceleration
     * of boats when a player disembarks. The default is -1. Values below 0
     * indicate that no additional deceleration is imposed.
     *
     * @param rate 加减速速率
     * @deprecated 船是复杂的,其中许多方法不能在多个版本中正常的工作.
     */
    @Deprecated
    public void setUnoccupiedDeceleration(double rate);

    /**
     * 获取船能否在陆地上工作.
     * <p>
     * 原文:
     * Get whether boats can work on land.
     *
     * @return 能否在陆地上工作.
     * @deprecated 船是复杂的,其中许多方法不能在多个版本中正常的工作.
     */
    @Deprecated
    public boolean getWorkOnLand();

    /**
     * 设置一个船能否在陆地上工作.
     * <p>
     * 原文:
     * Set whether boats can work on land.
     *
     * @param workOnLand 能否在陆地上工作
     * @deprecated 船是复杂的,其中许多方法不能在多个版本中正常的工作.
     */
    @Deprecated
    public void setWorkOnLand(boolean workOnLand);
}