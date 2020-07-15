package org.bukkit.entity;

import org.bukkit.block.Block;
import org.jetbrains.annotations.Nullable;

public interface Raider extends Monster {

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
}
