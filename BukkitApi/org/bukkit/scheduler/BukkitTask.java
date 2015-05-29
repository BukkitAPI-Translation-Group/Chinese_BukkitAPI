package org.bukkit.scheduler;

import org.bukkit.plugin.Plugin;

/**
 * 代表一个将被调度系统执行的任务/Represents a task being executed by the scheduler
 */
public interface BukkitTask {

    /**
     * 返回任务的taskID.
	 * 原文:Returns the taskId for the task.
     *
     * @return 任务的taskID
     */
    public int getTaskId();

    /**
     * 返回拥有这个任务的插件
	 * 原文:Returns the Plugin that owns this task.
     *
     * @return 返回拥有这个任务的插件
     */
    public Plugin getOwner();

    /**
     * 任务为同步执行，返回true
	 * 原文:Returns true if the Task is a sync task.
     *
     * @return true 任务在主线程被执行，返回true/if the task is run by main thread
     */
    public boolean isSync();

    /**
     * 此方法将尝试关闭这个任务.
	 * 原文:This method will attempt to cancel this task.
     */
    public void cancel();
}
