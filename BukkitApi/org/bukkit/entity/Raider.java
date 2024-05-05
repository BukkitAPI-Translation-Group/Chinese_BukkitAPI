package org.bukkit.entity;

import org.bukkit.Raid;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Raider extends Monster {

    /**
     * Set the {@link Raid} that this raider is participating in.
     *
     * @param raid the raid to set
     */
    void setRaid(@Nullable Raid raid);

    /**
     * Get the {@link Raid} that this raider is participating in, if any.
     *
     * @return the raid, or null if not participating in a raid
     */
    @Nullable
    Raid getRaid();

    /**
     * Get the raid wave that this raider spawned as part of.
     *
     * @return the raid wave, or 0 if not participating in a raid
     */
    int getWave();

    /**
     * Set the raid wave that this raider was spawned as part of.
     *
     * @param wave the raid wave to set. Must be >= 0
     */
    void setWave(int wave);

    /**
     * 获取袭击者要巡逻的目标方块.
     * <p>
     * 原文:Gets the block the raider is targeting to patrol.
     *
     * @return 目标方块或null
     */
    @Nullable
    Block getPatrolTarget();

    /**
     * 设置袭击者要巡逻的目标方块.
     * <p>
     * 原文:Sets the block the raider is targeting to patrol.
     *
     * @param block 目标方块或null, 此方块所处位置必须与此生物位于同一世界
     */
    void setPatrolTarget(@Nullable Block block);

    /**
     * 判断此实体是否为灾厄巡逻队队长(袭击队长).
     * <p>
     * 原文:Gets whether this entity is a patrol leader.
     *
     * @return 此实体是否为袭击队长
     */
    boolean isPatrolLeader();

    /**
     * 设置此实体是否为袭击队长.
     * <p>
     * 原文:Sets whether this entity is a patrol leader.
     *
     * @param leader 是否为袭击队长
     */
    void setPatrolLeader(boolean leader);

    /**
     * 获取此生物能否参与一个活跃的袭击.
     * <p>
     * 原文:Gets whether this mob can join an active raid.
     *
     * @return 能否参与一个活跃的袭击
     */
    boolean isCanJoinRaid();

    /**
     * 设置此生物能否参与一个活跃的袭击.
     * <p>
     * 原文:Sets whether this mob can join an active raid.
     *
     * @param join 能否参与一个活跃的袭击
     */
    void setCanJoinRaid(boolean join);

    /**
     * Get the amount of ticks that this mob has exited the bounds of a village
     * as a raid participant.
     * <p>
     * This value is increased only when the mob has had no action for 2,400 ticks
     * (according to {@link #getNoActionTicks()}). Once both the no action ticks have
     * reached that value and the ticks outside a raid exceeds 30, the mob will be
     * expelled from the raid.
     *
     * @return the ticks outside of a raid
     */
    int getTicksOutsideRaid();

    /**
     * Set the amount of ticks that this mob has exited the bounds of a village
     * as a raid participant.
     * <p>
     * This value is considered only when the mob has had no action for 2,400 ticks
     * (according to {@link #getNoActionTicks()}). Once both the no action ticks have
     * reached that value and the ticks outside a raid exceeds 30, the mob will be
     * expelled from the raid.
     *
     * @param ticks the ticks outside of a raid
     */
    void setTicksOutsideRaid(int ticks);

    /**
     * Check whether or not this raider is celebrating a raid victory.
     *
     * @return true if celebrating, false otherwise
     */
    boolean isCelebrating();

    /**
     * Set whether or not this mob is celebrating a raid victory.
     *
     * @param celebrating whether or not to celebrate
     */
    void setCelebrating(boolean celebrating);

    /**
     * Get the {@link Sound} this entity will play when celebrating.
     *
     * @return the celebration sound
     */
    @NotNull
    Sound getCelebrationSound();
}
