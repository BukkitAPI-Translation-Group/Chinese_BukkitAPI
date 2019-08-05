package org.bukkit.advancement;

import java.util.Collection;
import java.util.Date;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 玩家达成一个进度的状态. 这个类不是指针安全的，因为底层的进度可能会被重载.
 */
public interface AdvancementProgress {

    /**
     * 返回这个进度关于的进度 (前者指达成进度，后者指游戏中的进度，是不是搞混了？).
     * <p>
     * 原文:
     * The advancement this progress is concerning.
     *
     * @return 相应的进度
     */
    @NotNull
    Advancement getAdvancement();

    /**
     * 检查是否达到了完成该进度的所有要求 (即是否达成了该进度).
     * <p>
     * 原文:Check if all criteria for this advancement have been met.
     *
     * @return 是否达成了该进度
     */
    boolean isDone();

    /**
     * 标记指定的条件为已授予的条件.
     * <p>
     * 原文:Mark the specified criteria as awarded at the current time.
     *
     * @param criteria 要标记的条件
     * @return 若操作成功返回true，若条件不存在或已经达到返回false
     */
    boolean awardCriteria(@NotNull String criteria);

    /**
     * 标记指定的条件为未完成的条件.
     * <p>
     * 原文:Mark the specified criteria as uncompleted.
     *
     * @param criteria 要标记的条件
     * @return 若移除条件成功返回true，若条件不存在或还未达到返回false
     */
    boolean revokeCriteria(@NotNull String criteria);

    /**
     * 获取指定条件被授予的日期.
     * <p>
     * 原文:Get the date the specified criteria was awarded.
     *
     * @param criteria 要检查的条件
     * @return 条件被授予的时间，如果条件不存在或还未达到则为null
     */
    @Nullable
    Date getDateAwarded(@NotNull String criteria);

    /**
     * 获取达成某一进度还未达到的条件(剩余的条件).
     * <p>
     * 原文:Get the criteria which have not been awarded.
     *
     * @return 剩余的条件的不可编辑的副本
     */
    @NotNull
    Collection<String> getRemainingCriteria();

    /**
     * 获取达成某一进度已经达到的条件.
     * <p>
     * 原文:Gets the criteria which have been awarded.
     *
     * @return 已达到的条件的不可编辑的副本
     */
    @NotNull
    Collection<String> getAwardedCriteria();
}
