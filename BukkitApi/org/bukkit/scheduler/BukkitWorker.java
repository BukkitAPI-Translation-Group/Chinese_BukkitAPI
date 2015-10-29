package org.bukkit.scheduler;

import org.bukkit.plugin.Plugin;

/**
 * 代表调度器的worker线程。这给了任务线程对象的信息、任务的所有者和任务id。
 * <p>
 * Workers是用来执行异步任务的。
 */
public interface BukkitWorker {

    /**
     * 返回worker执行的任务的任务id。
     * <p>
     * 原文：Returns the taskId for the task being executed by this worker.
     *
     * @return 任务id
     */
    public int getTaskId();

    /**
     * 返回拥有这个任务的插件。
     * <p>
     * 原文：Returns the Plugin that owns this task.
     *
     * @return 拥有这个任务的插件
     */
    public Plugin getOwner();

    /**
     * 返回worker的线程。
     * <p>
     * 原文：Returns the thread for the worker.
     *
     * @return worker线程对象
     */
    public Thread getThread();

}