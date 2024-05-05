package org.bukkit.entity;

import org.bukkit.World;
import org.bukkit.boss.DragonBattle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表末影龙.
 */
public interface EnderDragon extends ComplexLivingEntity, Boss, Mob, Enemy {

    /**
     * 表示末影龙可以执行的阶段或动作.
     */
    enum Phase {
        /**
         * 如果有末影水晶，末影龙会在柱子环外盘旋，否则会在柱子环内盘旋.
         */
        CIRCLING,
        /**
         * 末影龙会飞向目标玩家并在 64 格内发射火球.
         */
        STRAFING,
        /**
         * 末影龙将飞向空传送门 (从另一边接近，如果适用).
         */
        FLY_TO_PORTAL,
        /**
         * 末影龙将降落在传送门上。如果末影龙不在传送门附近，它马上飞向传送门.
         */
        LAND_ON_PORTAL,
        /**
         * 末影龙将要离开传送门.
         */
        LEAVE_PORTAL,
        /**
         * 末影龙会在当前位置使用龙息攻击.
         */
        BREATH_ATTACK,
        /**
         * 末影龙将会会寻找玩家用龙息攻击。
         * 如果 5 秒内没有玩家足够靠近末影龙，末影龙将冲向 150 格内的玩家，如果没有找到玩家，末影龙将起飞并开始盘旋.
         */
        SEARCH_FOR_BREATH_ATTACK_TARGET,
        /**
         * 末影龙将会在进行吐息攻击前咆哮.
         */
        ROAR_BEFORE_ATTACK,
        /**
         * 末影龙将会向玩家冲刺.
         */
        CHARGE_PLAYER,
        /**
         * 末影龙将会飞到传送门附近并且死去.
         */
        DYING,
        /**
         * 末影龙将悬停在当前位置，不执行任何操作.
         */
        HOVER
    }

    /**
     * 获取末影龙正在执行的阶段.
     * <p>
     * 原文:
     * Gets the current phase that the dragon is performing.
     *
     * @return 当前阶段
     */
    @NotNull
    Phase getPhase();

    /**
     * 设置末影龙的下一个阶段.
     * <p>
     * 原文:
     * Sets the next phase for the dragon to perform.
     *
     * @param phase 下一阶段
     */
    void setPhase(@NotNull Phase phase);

    /**
     * Get the {@link DragonBattle} associated with this EnderDragon.
     * <br>
     * This will return null for the following reasons:
     * <ul>
     *     <li>The EnderDragon is not in the End dimension</li>
     *     <li>The EnderDragon was summoned by command/API</li>
     * </ul>
     *
     * @return the dragon battle
     *
     * @see World#getEnderDragonBattle()
     */
    @Nullable
    DragonBattle getDragonBattle();

    /**
     * 获取这条末影龙的死亡动画开始的到当前时间（以 tick 为单位）.
     *
     * 如果这条末影龙还活着，则返回 0。这个值永远不会超过 200（动画的长度）.
     * <p>
     * 原文:
     * Get the current time in ticks relative to the start of this dragon's
     * death animation.
     *
     * If this dragon is alive, 0 will be returned. This value will never exceed
     * 200 (the length of the animation).
     *
     * @return 当前末影龙的死亡动画tick
     */
    int getDeathAnimationTicks();
}
