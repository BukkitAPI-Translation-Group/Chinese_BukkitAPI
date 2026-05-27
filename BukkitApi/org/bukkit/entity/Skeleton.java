package org.bukkit.entity;

/**
 * 代表骷髅.
 * <p>
 * 此接口仅代表服务器上的普通骷髅类型.
 * 其他类骷髅实体, 如 {@link WitherSkeleton} 或 {@link Stray} 与此类型无关.
 */
public interface Skeleton extends AbstractSkeleton {

    /**
     * 计算此骷髅是否正在因被细雪冻结而转化为 {@link Stray}.
     * <p>
     * 原文:
     * Computes whether or not this skeleton is currently in the process of
     * converting to a {@link Stray} due to it being frozen by powdered snow.
     *
     * @return 此骷髅是否正在转化为流浪者
     */
    boolean isConverting();

    /**
     * 获取此实体因被细雪方块冻结而转化为流浪者所需的剩余 tick 数.
     * <p>
     * 当此值降为 0 时, 该实体将被转化.
     * <p>
     * 原文:
     * Gets the amount of ticks until this entity will be converted to a stray
     * as a result of being frozen by a powdered snow block.
     * <p>
     * When this reaches 0, the entity will be converted.
     *
     * @return 以 tick 为单位的剩余转化时间
     *
     * @throws IllegalStateException 如果 {@link #isConverting()} 返回 false
     */
    int getConversionTime();

    /**
     * 设置此实体因被细雪方块冻结而转化为流浪者所需的剩余 tick 数.
     * <p>
     * 当此值降为 0 时, 该实体将被转化. 小于 0 的值将停止当前的转化过程且不会转化当前实体.
     * <p>
     * 原文:
     * Sets the amount of ticks until this entity will be converted to a stray
     * as a result of being frozen by a powdered snow block.
     * <p>
     * When this reaches 0, the entity will be converted. A value of less than 0
     * will stop the current conversion process without converting the current
     * entity.
     *
     * @param time 以 tick 为单位的新转化剩余时间
     */
    void setConversionTime(int time);

    /**
     * 一个旧版枚举, 定义了服务器上类骷髅实体的不同变体.
     *
     * @deprecated 各类骷髅已是不同的类型. 此接口仅保留在 Skeleton 接口中以保持向后兼容性.
     */
    @Deprecated(since = "1.11")
    public enum SkeletonType {

        /**
         * 标准骷髅类型.
         */
        NORMAL,
        /**
         * 凋灵骷髅. 通常出现在下界要塞中.
         */
        WITHER,
        /**
         * 流浪者骷髅. 通常出现在冰原生物群系中. 会射出药箭.
         */
        STRAY,
        /**
         * 沼骸骷髅.
         */
        BOGGED,
        /**
         * 枯骨骷髅.
         */
        PARCHED;
    }
}
