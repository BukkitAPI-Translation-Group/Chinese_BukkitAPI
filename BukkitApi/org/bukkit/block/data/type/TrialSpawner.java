package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

/**
 * 'trial_spawner_state' 表示试炼刷怪笼当前的运行阶段.
 * <br>
 * 'ominous' 表示方块是否具有不祥效果.
 */
public interface TrialSpawner extends BlockData {

    /**
     * 获取 'trial_spawner_state' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'trial_spawner_state' property.
     *
     * @return 'trial_spawner_state' 的值
     */
    @NotNull
    State getTrialSpawnerState();

    /**
     * 设置 'trial_spawner_state' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'trial_spawner_state' property.
     *
     * @param state 新的 'trial_spawner_state' 值
     */
    void setTrialSpawnerState(@NotNull State state);

    /**
     * 获取 'ominous' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'ominous' property.
     *
     * @return 'ominous' 的值
     */
    boolean isOminous();

    /**
     * 设置 'ominous' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'ominous' property.
     *
     * @param ominous 新的 'ominous' 值
     */
    void setOminous(boolean ominous);

    public enum State {

        INACTIVE,
        WAITING_FOR_PLAYERS,
        ACTIVE,
        WAITING_FOR_REWARD_EJECTION,
        EJECTING_REWARD,
        COOLDOWN;
    }
}
