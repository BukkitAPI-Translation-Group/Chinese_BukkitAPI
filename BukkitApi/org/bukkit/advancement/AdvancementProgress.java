package org.bukkit.advancement;

import java.util.Collection;
import java.util.Date;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 玩家达成一个进度的状态. 这个类不是指针安全的, 因为底层的进度可能会被重载.
 */
public interface AdvancementProgress {

    /**
     * 返回此进度对象所关联的进度.
     * <p>
     * 原文:
     * The advancement this progress is concerning.
     *
     * @return 相应的进度
     */
    @NotNull
    Advancement getAdvancement();

    /**
     * 检查是否已满足此进度的所有条件 (即是否完成了此进度).
     * <p>
     * 原文:
     * Check if all criteria for this advancement have been met.
     *
     * @return 是否已达成此进度
     */
    boolean isDone();

    /**
     * 在当前时间标记指定的条件为已完成.
     * <p>
     * 原文:
     * Mark the specified criteria as awarded at the current time.
     *
     * @param criteria 要标记的条件
     * @return 如果操作成功返回true, 如果条件不存在或已完成返回false
     */
    boolean awardCriteria(@NotNull String criteria);

    /**
     * 标记指定的条件为未完成.
     * <p>
     * 原文:
     * Mark the specified criteria as uncompleted.
     *
     * @param criteria 要标记的条件
     * @return 如果成功移除条件返回true, 如果条件不存在或未完成返回false
     */
    boolean revokeCriteria(@NotNull String criteria);

    /**
     * 获取指定条件被授予的日期.
     * <p>
     * 原文:
     * Get the date the specified criteria was awarded.
     *
     * @param criteria 要检查的条件
     * @return 条件被授予的时间, 如果条件不存在或未完成则为null
     */
    @Nullable
    Date getDateAwarded(@NotNull String criteria);

    /**
     * 获取达成此进度尚未满足的条件.
     * <p>
     * 原文:
     * Get the criteria which have not been awarded.
     *
     * @return 剩余条件的不可编辑副本
     */
    @NotNull
    Collection<String> getRemainingCriteria();

    /**
     * 获取达成此进度已经满足的条件.
     * <p>
     * 原文:
     * Gets the criteria which have been awarded.
     *
     * @return 已满足条件的不可编辑副本
     */
    @NotNull
    Collection<String> getAwardedCriteria();
}
