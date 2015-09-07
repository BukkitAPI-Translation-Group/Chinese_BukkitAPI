package org.bukkit.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * 这个类提供了简单的处理调度任务的方法。
 */
public abstract class BukkitRunnable implements Runnable {
    private int taskId = -1;

    /**
     * 尝试取消这个任务。
     * <p>
     * 原文：Attempts to cancel this task.
     *
     * @throws IllegalStateException 如果任务还没有调度
     */
    public synchronized void cancel() throws IllegalStateException {
        Bukkit.getScheduler().cancelTask(getTaskId());
    }

    /**
     * Schedules this in the Bukkit scheduler to run on next tick.
     *
     * @param plugin the reference to the plugin scheduling task
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalStateException 如果任务已经调度
     * @see BukkitScheduler#runTask(Plugin, Runnable)
     */
    public synchronized BukkitTask runTask(Plugin plugin) throws IllegalArgumentException, IllegalStateException {
        checkState();
        return setupId(Bukkit.getScheduler().runTask(plugin, (Runnable) this));
    }

    /**
     * <b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules this in the Bukkit scheduler to run asynchronously.
     *
     * @param plugin the reference to the plugin scheduling task
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalStateException 如果这已经调度
     * @see BukkitScheduler#runTaskAsynchronously(Plugin, Runnable)
     */
    public synchronized BukkitTask runTaskAsynchronously(Plugin plugin) throws IllegalArgumentException, IllegalStateException  {
        checkState();
        return setupId(Bukkit.getScheduler().runTaskAsynchronously(plugin, (Runnable) this));
    }

    /**
     * Schedules this to run after the specified number of server ticks.
     *
     * @param plugin the reference to the plugin scheduling task
     * @param delay the ticks to wait before running the task
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalStateException 如果这已经调度
     * @see BukkitScheduler#runTaskLater(Plugin, Runnable, long)
     */
    public synchronized BukkitTask runTaskLater(Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException  {
        checkState();
        return setupId(Bukkit.getScheduler().runTaskLater(plugin, (Runnable) this, delay));
    }

    /**
     * <b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules this to run asynchronously after the specified number of
     * server ticks.
     *
     * @param plugin the reference to the plugin scheduling task
     * @param delay the ticks to wait before running the task
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalStateException 如果这已经调度
     * @see BukkitScheduler#runTaskLaterAsynchronously(Plugin, Runnable, long)
     */
    public synchronized BukkitTask runTaskLaterAsynchronously(Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException  {
        checkState();
        return setupId(Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, (Runnable) this, delay));
    }

    /**
     * Schedules this to repeatedly run until cancelled, starting after the
     * specified number of server ticks.
     *
     * @param plugin the reference to the plugin scheduling task
     * @param delay the ticks to wait before running the task
     * @param period the ticks to wait between runs
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalStateException 如果这已经调度
     * @see BukkitScheduler#runTaskTimer(Plugin, Runnable, long, long)
     */
    public synchronized BukkitTask runTaskTimer(Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException  {
        checkState();
        return setupId(Bukkit.getScheduler().runTaskTimer(plugin, (Runnable) this, delay, period));
    }

    /**
     * <b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules this to repeatedly run asynchronously until cancelled,
     * starting after the specified number of server ticks.
     *
     * @param plugin the reference to the plugin scheduling task
     * @param delay the ticks to wait before running the task for the first
     *     time
     * @param period the ticks to wait between runs
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalStateException 如果这已经调度
     * @see BukkitScheduler#runTaskTimerAsynchronously(Plugin, Runnable, long,
     *     long)
     */
    public synchronized BukkitTask runTaskTimerAsynchronously(Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException  {
        checkState();
        return setupId(Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, (Runnable) this, delay, period));
    }

    /**
     * Gets the task id for this runnable.
     *
     * @return the task id that this runnable was scheduled as
     * @throws IllegalStateException 如果任务还没有调度
     */
    public synchronized int getTaskId() throws IllegalStateException {
        final int id = taskId;
        if (id == -1) {
            throw new IllegalStateException("Not scheduled yet");
        }
        return id;
    }

    private void checkState() {
        if (taskId != -1) {
            throw new IllegalStateException("Already scheduled as " + taskId);
        }
    }

    private BukkitTask setupId(final BukkitTask task) {
        this.taskId = task.getTaskId();
        return task;
    }
}