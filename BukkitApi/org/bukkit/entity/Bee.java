package org.bukkit.entity;

import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

/**
 * 代表蜜蜂.
 */
public interface Bee extends Animals {

    /**
     * 获取蜜蜂的家(蜂巢)的位置.
     * <p>
     * 原文:Get the bee's hive location.
     *
     * @return 蜂巢位置或null
     */
    @Nullable
    Location getHive();

    /**
     * 设置蜜蜂所住蜂巢的位置.
     * <p>
     * 原文:Set the bee's hive location.
     *
     * @param location 蜂巢位置或null
     */
    void setHive(@Nullable Location location);

    /**
     * 获取蜜蜂盘旋的花的位置.
     * <p>
     * 原文:Get the bee's flower location.
     *
     * @return 蜜蜂盘旋的花的位置或null
     */
    @Nullable
    Location getFlower();

    /**
     * 设置蜜蜂盘旋的花的位置.
     * <p>
     * 原文:Set the bee's flower location.
     *
     * @param location 蜜蜂盘旋的花的位置或null
     */
    void setFlower(@Nullable Location location);

    /**
     * 蜜蜂是否携带花粉.
     * <p>
     * 原文:Get if the bee has nectar.
     *
     * @return 蜜蜂是否携带花粉.
     */
    boolean hasNectar();

    /**
     * 设置蜜蜂是否携带花粉.
     * <p>
     * 原文:Set if the bee has nectar.
     *
     * @param nectar 蜜蜂是否携带花粉
     */
    void setHasNectar(boolean nectar);

    /**
     * 获取蜜蜂是否蜇过玩家或其它生物.
     * <p>
     * 原文:Get if the bee has stung.
     *
     * @return 蜜蜂是否蜇过玩家或其它生物
     */
    boolean hasStung();

    /**
     * 设置蜜蜂是否蜇过玩家或其它生物.
     * <p>
     * 原文:Set if the bee has stung.
     *
     * @param stung 蜜蜂是否蜇过玩家或其它生物
     */
    void setHasStung(boolean stung);

    /**
     * 获取蜜蜂的激怒等级.
     * <p>
     * 译注:此数值代表蜜蜂平息怒气所需时间, 为0时蜜蜂不再愤怒.
     * <p>
     * 原文:Get the bee's anger level.
     *
     * @return 激怒等级
     */
    int getAnger();

    /**
     * 设置蜜蜂的激怒等级.
     * <p>
     * 译注:此数值代表蜜蜂平息怒气所需时间, 为0时蜜蜂不再愤怒.
     * <p>
     * 原文:Set the bee's new anger level.
     *
     * @param anger 激怒等级
     */
    void setAnger(int anger);

    /**
     * 获取蜜蜂离其能再次进入蜂巢的剩余时间(以tick计数).
     * <p>
     * 原文:Get the amount of ticks the bee cannot enter the hive for.
     *
     * @return 蜜蜂离其能再次进入蜂巢的剩余时间(以tick计数)
     */
    int getCannotEnterHiveTicks();

    /**
     * 设置蜜蜂离其能再次进入蜂巢的剩余时间(以tick计数).
     * <p>
     * 原文:Set the amount of ticks the bee cannot enter a hive for.
     *
     * @param ticks 蜜蜂离其能再次进入蜂巢的剩余时间(以tick计数)
     */
    void setCannotEnterHiveTicks(int ticks);
}
