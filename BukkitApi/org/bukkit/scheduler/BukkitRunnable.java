package org.bukkit.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * This class is provided as an easy way to handle scheduling tasks.该类提供了一个简单的方式处理调度任务.
 */
public abstract class BukkitRunnable implements Runnable {
    private int taskId = -1;

    /**
     * 该方法尝试关闭该任务.
     *
     * @throws IllegalStateException 如果该任务尚未被调度.
     */
    public synchronized void cancel() throws IllegalStateException {
        Bukkit.getScheduler().cancelTask(getTaskId());
    }

    /**
     * 调度该任务使其下一次tick执行该任务.
     *
     * @param plugin 调度该任务的插件引用
     * @return 返回一个包含任务id的BukkitTask
     * @throws IllegalArgumentException 如果插件引用为空
     * @throws IllegalStateException 如果该任务已经被调度
     * @see BukkitScheduler#runTask(Plugin, Runnable)
     */
    public synchronized BukkitTask runTask(Plugin plugin) throws IllegalArgumentException, IllegalStateException {
        checkState();
        return setupId(Bukkit.getScheduler().runTask(plugin, (Runnable) this));
    }

    /**
     * <b>异步任务不应该访问任何Bukkit API. 程序调用需要非常谨慎，以保证异步任务的线程安全性</b>
     * <p>
     * 调度该任务，使其在Bukkit调度器中异步执行.
     *
     * @param plugin 调度该任务的插件引用
     * @return 返回一个包含任务id的BukkitTask
     * @throws IllegalArgumentException 如果插件引用为空
     * @throws IllegalStateException 如果该任务尚未被调度
     * @see BukkitScheduler#runTaskAsynchronously(Plugin, Runnable)
     */
    public synchronized BukkitTask runTaskAsynchronously(Plugin plugin) throws IllegalArgumentException, IllegalStateException  {
        checkState();
        return setupId(Bukkit.getScheduler().runTaskAsynchronously(plugin, (Runnable) this));
    }

    /**
     * 调度该任务，使其在一定服务器tick之后执行.
     *
     * @param plugin 调度该任务的插件引用
     * @param delay 任务执行前的等待tick
     * @return 返回一个包含任务id的BukkitTask
     * @throws IllegalArgumentException 如果插件引用为空
     * @throws IllegalStateException 如果该任务已经被调度
     * @see BukkitScheduler#runTaskLater(Plugin, Runnable, long)
     */
    public synchronized BukkitTask runTaskLater(Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException  {
        checkState();
        return setupId(Bukkit.getScheduler().runTaskLater(plugin, (Runnable) this, delay));
    }

    /**
     * <b>异步任务不应该访问任何Bukkit API. 程序调用需要非常谨慎，以保证异步任务的线程安全性</b>
     * <p>
     * 调度该任务，使其在一定服务器tick之后异步执行.
     *
     * @param plugin 调度该任务的插件引用
     * @param delay 任务执行前的等待tick
     * @return 返回一个包含任务id的BukkitTask
     * @throws IllegalArgumentException 如果插件引用为空
     * @throws IllegalStateException 如果该任务已经被调度
     * @see BukkitScheduler#runTaskLaterAsynchronously(Plugin, Runnable, long)
     */
    public synchronized BukkitTask runTaskLaterAsynchronously(Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException  {
        checkState();
        return setupId(Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, (Runnable) this, delay));
    }

    /**
     * 调度该任务，使其在一定延迟之后重复地执行直到该任务被关闭.
     *
     * @param plugin 调度该任务的插件引用
     * @param delay 任务执行前的等待tick
     * @param period 任务执行的间隔tick
     * @return 返回一个包含任务id的BukkitTask
     * @throws IllegalArgumentException 如果插件引用为空
     * @throws IllegalStateException 如果该任务已经被调度
     * @see BukkitScheduler#runTaskTimer(Plugin, Runnable, long, long)
     */
    public synchronized BukkitTask runTaskTimer(Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException  {
        checkState();
        return setupId(Bukkit.getScheduler().runTaskTimer(plugin, (Runnable) this, delay, period));
    }

    /**
     * <b>异步任务不应该访问任何Bukkit API. 程序调用需要非常谨慎，以保证异步任务的线程安全性</b>
     * <p>
     * 调度该任务，使其在一定服务器tick延迟之后重复地异步执行直到该任务被关闭.
     *
     * @param plugin 调度该任务的插件引用
     * @param delay 第一次执行该任务前的等待时间
     * @param period 任务执行的间隔tick
     * @return 返回一个包含任务id的BukkitTask
     * @throws IllegalArgumentException 如果插件引用为空
     * @throws IllegalStateException 如果该任务已经被调度
     * @see BukkitScheduler#runTaskTimerAsynchronously(Plugin, Runnable, long,
     *     long)
     */
    public synchronized BukkitTask runTaskTimerAsynchronously(Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException  {
        checkState();
        return setupId(Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, (Runnable) this, delay, period));
    }

    /**
     * 获取该任务的id.
     *
     * @return 返回该任务的id
     * @throws IllegalStateException 如果该任务尚未被调度
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
