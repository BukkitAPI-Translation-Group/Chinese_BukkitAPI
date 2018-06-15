package org.bukkit.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * 这个类提供了简单的处理执行任务的方法.
 */
public abstract class BukkitRunnable implements Runnable {
    private BukkitTask task;

    /**
     * 若该任务被取消返回true.
     * <p>
     * 原文:Returns true if this task has been cancelled.
     *
     * @return 若该任务被取消返回true
     * @throws IllegalStateException 若任务还未被调度
     */
    public synchronized boolean isCancelled() throws IllegalStateException {
        checkScheduled();
        return task.isCancelled();
    }    

    /**
     * 尝试取消这个任务
     * <p>
     * 原文：Attempts to cancel this task.
     *
     * @throws IllegalStateException 如果任务还没有被执行
     */
    public synchronized void cancel() throws IllegalStateException {
        Bukkit.getScheduler().cancelTask(getTaskId());
    }

    /**
     * 让Bukkit任务调度器在下一个tick运行任务.
     * <p>
     * 原文：Schedules this in the Bukkit scheduler to run on next tick.
     *
     * @param plugin 创建任务的插件
     * @return 包含任务id的{@link BukkitTask}
     * @throws IllegalArgumentException 如果plugin为null
     * @throws IllegalStateException 如果任务已经被执行/准备执行
     * @see BukkitScheduler#runTask(Plugin, Runnable)
     */
    public synchronized BukkitTask runTask(Plugin plugin) throws IllegalArgumentException, IllegalStateException {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTask(plugin, (Runnable) this));
    }

    /**
     * 在Bukkit任务调度器异步运行这个任务.
     * <p>
     * <b>异步任务不能访问任何Bukkit里的API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 原文：<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules this in the Bukkit scheduler to run asynchronously.
     *
     * @param plugin 创建任务的插件
     * @return 包含任务id的{@link BukkitTask}
     * @throws IllegalArgumentException 如果plugin为null
     * @throws IllegalStateException 如果这个任务已经被执行/准备执行
     * @see BukkitScheduler#runTaskAsynchronously(Plugin, Runnable)
     */
    public synchronized BukkitTask runTaskAsynchronously(Plugin plugin) throws IllegalArgumentException, IllegalStateException  {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTaskAsynchronously(plugin, (Runnable) this));
    }

    /**
     * 在指定tick后执行该任务.
     * <p>
     * 原文:Schedules this to run after the specified number of server ticks.
     *
     * @param plugin 创建任务的插件
     * @param delay 在任务执行前等待的时间/tick
     * @return 包含任务id的{@link BukkitTask}
     * @throws IllegalArgumentException 如果plugin为null
     * @throws IllegalStateException 如果这个任务已经被执行/准备执行
     * @see BukkitScheduler#runTaskLater(Plugin, Runnable, long)
     */
    public synchronized BukkitTask runTaskLater(Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException  {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTaskLater(plugin, (Runnable) this, delay));
    }

    /**
     * 让Bukkit任务调度器在指定的tick后异步执行这个任务.
     * <p>
     * <b>异步任务不能访问任何Bukkit里的API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 原文：<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules this to run asynchronously after the specified number of
     * server ticks.
     *
     * @param plugin 创建任务的插件
     * @param delay 在任务执行前等待的时间/tick
     * @return 包含任务id的BukkitTask
     * @throws IllegalArgumentException 如果plugin为null
     * @throws IllegalStateException 如果这个任务已经被执行/准备执行
     * @see BukkitScheduler#runTaskLaterAsynchronously(Plugin, Runnable, long)
     */
    public synchronized BukkitTask runTaskLaterAsynchronously(Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException  {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, (Runnable) this, delay));
    }

    /**
     * 在指定时间后开始以指定的间隔不断执行任务.
     * <p>
     * 原文：Schedules this to repeatedly run until cancelled, starting after the
     * specified number of server ticks.
     *
     * @param plugin 创建任务的插件
     * @param delay 在任务执行前等待的时间/tick
     * @param period 重复执行任务之间的时间间隔/tick
     * @return 包含任务id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalStateException 如果这个任务已经被执行/准备执行
     * @see BukkitScheduler#runTaskTimer(Plugin, Runnable, long, long)
     */
    public synchronized BukkitTask runTaskTimer(Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException  {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTaskTimer(plugin, (Runnable) this, delay, period));
    }

    /**
     * 让Bukkit任务调度器在指定的tick后开始异步的以指定的间隔不断执行任务.
     * <p>
     * <b>异步任务不能访问任何Bukkit里的API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 原文：<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules this to repeatedly run asynchronously until cancelled,
     * starting after the specified number of server ticks.
     *
     * @param plugin 创建任务的插件
     * @param delay 在任务执行前等待的时间/tick
     * @param period 重复执行任务之间的时间间隔/tick
     * @return 包含任务id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalStateException 如果这个任务已经被执行/准备执行
     * @see BukkitScheduler#runTaskTimerAsynchronously(Plugin, Runnable, long,
     *     long)
     */
    public synchronized BukkitTask runTaskTimerAsynchronously(Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException  {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, (Runnable) this, delay, period));
    }

    /**
     * 获取这个已执行的任务的任务id.
     * <p>
     * 原文：Gets the task id for this runnable.
     *
     * @return 这个任务的任务id
     * @throws IllegalStateException 如果这个任务还没有被执行
     */
    public synchronized int getTaskId() throws IllegalStateException {
        checkScheduled();
        return task.getTaskId();
    }

    private void checkScheduled() {
        if (task == null) {
            throw new IllegalStateException("Not scheduled yet");
        }
    }

    private void checkNotYetScheduled() {
        if (task != null) {
            throw new IllegalStateException("Already scheduled as " + task.getTaskId());
        }
    }

    private BukkitTask setupTask(final BukkitTask task) {
        this.task = task;
        return task;
    }
}