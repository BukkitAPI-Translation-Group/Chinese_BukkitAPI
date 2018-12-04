package org.bukkit.scheduler;

import org.bukkit.plugin.Plugin;

/**
 * 代表由调度器执行的任务.
 */
public interface BukkitTask {

    /**
     * 返回这个任务的任务id.
     * <p>
     * 原文：Returns the taskId for the task.
     *
     * @return 任务id编号
     */
    public int getTaskId();

    /**
     * 返回拥有这个任务的插件.
     * <p>
     * 原文：Returns the Plugin that owns this task.
     *
     * @return 拥有这个任务的插件
     */
    public Plugin getOwner();

    /**
     * 如果这个任务是同步任务则返回true.
     * <p>
     * 原文：Returns true if the Task is a sync task.
     *
     * @return 如果这个任务由主线程运行，则为true
     */
    public boolean isSync();

    /**
     * 若该任务已被取消则返回true.
     * <p>
     * 原文:Returns true if this task has been cancelled.
     *
     * @return 若该任务已被取消则返回true
     */
    public boolean isCancelled();

    /**
     * 尝试取消该任务.
     * <p>
     * 原文：Will attempt to cancel this task.
     */
    public void cancel();
}