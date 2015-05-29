package org.bukkit.scheduler;

import org.bukkit.plugin.Plugin;

/**
 * 代表一个被调度器执行的任务.
 */
public interface BukkitTask {

    /**
     * 返回该任务id.
     *
     * @return 任务id
     */
    public int getTaskId();

    /**
     * 返回拥有该任务的插件.
     *
     * @return 拥有该任务的插件
     */
    public Plugin getOwner();

    /**
     * 返回true如果该任务是同步执行.
     *
     * @return true 如果有主线程执行
     */
    public boolean isSync();

    /**
     * 尝试关闭该任务.
     */
    public void cancel();
}
