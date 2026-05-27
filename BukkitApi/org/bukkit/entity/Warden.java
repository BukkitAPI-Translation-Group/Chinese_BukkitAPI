package org.bukkit.entity;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 监守者.
 */
public interface Warden extends Monster {

    /**
     * 获取此监守者的愤怒等级。
     * <p>
     * 愤怒值为0到150的整数。当监守者对某个目标的愤怒值达到80时，它会主动追击该目标。
     * <p>
     * 原文：Gets the anger level of this warden.
     *
     * @return 愤怒等级
     */
    int getAnger();

    /**
     * 获取此监守者对指定实体的愤怒等级。
     * <p>
     * 愤怒值为0到150的整数。当监守者对某个目标的愤怒值达到80时，它会主动追击该目标。
     * <p>
     * 原文：Gets the anger level of this warden.
     *
     * @param entity 目标实体
     * @return 愤怒等级
     */
    int getAnger(@NotNull Entity entity);

    /**
     * 增加此监守者的愤怒等级。
     * <p>
     * 愤怒值为0到150的整数。当监守者对某个目标的愤怒值达到80时，它会主动追击该目标。
     * <p>
     * 原文：Increases the anger level of this warden.
     *
     * @param entity 目标实体
     * @param increase 要增加的数量
     * @see #getAnger(org.bukkit.entity.Entity)
     */
    void increaseAnger(@NotNull Entity entity, int increase);

    /**
     * 设置此监守者的愤怒等级。
     * <p>
     * 愤怒值为0到150的整数。当监守者对某个目标的愤怒值达到80时，它会主动追击该目标。
     * <p>
     * 原文：Sets the anger level of this warden.
     *
     * @param entity 目标实体
     * @param anger 新的愤怒等级
     * @see #getAnger(org.bukkit.entity.Entity)
     */
    void setAnger(@NotNull Entity entity, int anger);

    /**
     * 清除此监守者对指定实体的愤怒等级。
     * <p>
     * 原文：Clears the anger level of this warden.
     *
     * @param entity 目标实体
     */
    void clearAnger(@NotNull Entity entity);

    /**
     * 获取此监守者最为愤怒的 {@link LivingEntity}。
     * <p>
     * 原文：Gets the {@link LivingEntity} at which this warden is most angry.
     *
     * @return 目标 {@link LivingEntity}，若无则为null
     */
    @Nullable
    LivingEntity getEntityAngryAt();

    /**
     * 让监守者感知到指定位置的扰动。
     * <p>
     * 原文：Make the warden sense a disturbance in the force at the location given.
     *
     * @param location 扰动的位置
     */
    void setDisturbanceLocation(@NotNull Location location);

    /**
     * 获取此监守者的愤怒等级。
     * <p>
     * 原文：Get the level of anger of this warden.
     *
     * @return 愤怒等级
     */
    @NotNull
    AngerLevel getAngerLevel();

    public enum AngerLevel {

        /**
         * 愤怒等级 0-39.
         */
        CALM,
        /**
         * 愤怒等级 40-79.
         */
        AGITATED,
        /**
         * 愤怒等级 80 或以上.
         */
        ANGRY;
    }
}
