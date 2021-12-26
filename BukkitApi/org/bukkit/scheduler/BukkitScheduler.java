package org.bukkit.scheduler;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * Bukkit的任务调度器.
 * <p>
 * Note:从注释可以看出Bukkit官方不推荐您在异步任务中调用Bukkit的API
 * , 若不得不调用, 需要注意调用的API是否线程安全.
 */
public interface BukkitScheduler {

    /**
     * 在指定延迟后执行一次任务.
     * <p>
     * 这个任务将由服务器主线程执行(同步).
     * <p>
     * 原文：Schedules a once off task to occur after a delay.
     * <p>
     * This task will be executed by the main server thread.
     *
     * @param plugin 创建这个任务的插件(拥有者)
     * @param task 要执行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @return 任务id（如果为-1则表示执行失败）
     */
    public int scheduleSyncDelayedTask(@NotNull Plugin plugin, @NotNull Runnable task, long delay);

    /**
     * @param plugin 创建这个任务的插件(拥有者)
     * @param task 要执行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @return 任务id（如果为-1则表示执行失败）
     * @deprecated 推荐使用{@link BukkitRunnable#runTaskLater(Plugin, long)}
     */
    @Deprecated
    public int scheduleSyncDelayedTask(@NotNull Plugin plugin, @NotNull BukkitRunnable task, long delay);

    /**
     * 在下一tick执行一次任务.
     * <p>
     * .这个任务将由服务器主线程执行(同步).
     * <p>
     * 原文：Schedules a once off task to occur as soon as possible.
     * <p>
     * This task will be executed by the main server thread.
     *
     * @param plugin 创建这个任务的插件(拥有者)
     * @param task 要执行的任务
     * @return 任务id（如果为-1则表示执行失败）
     */
    public int scheduleSyncDelayedTask(@NotNull Plugin plugin, @NotNull Runnable task);

    /**
     * 在下一tick执行一次任务.
     * <p>
     * 这个任务将由服务器主线程执行(同步).
     * <p>
     * 原文：Schedules a once off task to occur as soon as possible.
     * <p>
     * This task will be executed by the main server thread.
     * 
     * @param plugin 创建这个任务的插件(拥有者)
     * @param task 要执行的任务
     * @return 任务id（如果为-1则表示执行失败）
     * @deprecated 推荐使用{@link BukkitRunnable#runTask(Plugin)}
     */
    @Deprecated
    public int scheduleSyncDelayedTask(@NotNull Plugin plugin, @NotNull BukkitRunnable task);

    /**
     * 在指定延迟后开始以指定间隔重复执行任务.
     * <p>
     * 这个任务将由服务器主线程执行(同步).
     * <p>
     * 原文：Schedules a repeating task.
     * <p>
     * This task will be executed by the main server thread.
     *
     * @param plugin 创建这个任务的插件(拥有者)
     * @param task 要执行的任务
     * @param delay 开始第一次重复执行之前的延迟/tick
     * @param period 任务执行的时间
     * @return 任务id（如果为-1则表示执行失败）
     */
    public int scheduleSyncRepeatingTask(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period);

    /**
     * @param plugin 创建这个任务的插件(拥有者)
     * @param task 要执行的任务
     * @param delay 开始第一次重复执行之前的延迟/tick
     * @param period 任务执行的时间
     * @return 任务id（如果为-1则表示执行失败）
     * @deprecated 推荐使用{@link BukkitRunnable#runTaskTimer(Plugin, long, long)}
     */
    @Deprecated
    public int scheduleSyncRepeatingTask(@NotNull Plugin plugin, @NotNull BukkitRunnable task, long delay, long period);

    /**
     * <b>异步任务不应访问Bukkit里的任何API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 在指定延迟后执行一次任务.此任务将通过由执行器所管理的线程执行.
     * <p>
     * 原文：<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules a once off task to occur after a delay. This task will be
     * executed by a thread managed by the scheduler.
     *
     * @param plugin 创建这个任务的插件(拥有者)
     * @param task 要执行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @return 任务id（如果为-1则表示执行失败）
     * @deprecated 这个名称具有误导性.因为它没有执行“同步”任务.而是“异步”任务
     */
    @Deprecated
    public int scheduleAsyncDelayedTask(@NotNull Plugin plugin, @NotNull Runnable task, long delay);

    /**
     * <b>异步任务不应访问Bukkit里的任何API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 执行一次任务.此任务将通过由执行器所管理的线程执行.
     * <p>
     * 原文：<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules a once off task to occur as soon as possible. This task will
     * be executed by a thread managed by the scheduler.
     *
     * @param plugin 创建这个任务的插件(拥有者)
     * @param task 要执行的任务
     * @return 任务id（如果为-1则表示执行失败）
     * @deprecated 这个名称具有误导性.因为它没有执行“同步”任务.而是“异步”任务
     */
    @Deprecated
    public int scheduleAsyncDelayedTask(@NotNull Plugin plugin, @NotNull Runnable task);

    /**
     * <b>异步任务不应访问Bukkit里的任何API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 执行一次重复执行的任务.此任务将通过由执行器所管理的线程执行.
     * <p>
     * 原文：<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules a repeating task. This task will be executed by a thread
     * managed by the scheduler.
     *
     * @param plugin 创建这个任务的插件(拥有者)
     * @param task 要执行的任务
     * @param delay 开始第一次重复执行之前的延迟/tick
     * @param period 每次任务执行之间的间隔
     * @return 任务id（如果为-1则表示执行失败）
     * @deprecated 这个名称具有误导性.因为它没有执行“同步”任务.而是“异步”任务
     */
    @Deprecated
    public int scheduleAsyncRepeatingTask(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period);

    /**
     * 调用主线程的一个方法并返回Future对象.这个任务将被服务器主线程执行.
     * <ul>
     * <li>注意①：Future.get()方法绝对不能从主线程调用.
     * <li>注意②：isDone()方法返回true时的延迟平均至少10ms.
     * </ul>
     * <p>
     * 原文：Calls a method on the main thread and returns a Future object. This
     * task will be executed by the main server thread.
     * <ul>
     * <li>Note: The Future.get() methods must NOT be called from the main
     *     thread.
     * <li>Note2: There is at least an average of 10ms latency until the
     *     isDone() method returns true.
     * </ul>
     * @param <T> callable的返回类型
     * @param plugin 创建这个任务的插件(拥有者)
     * @param task 要执行的任务
     * @return 与任务相关的Future对象
     */
    @NotNull
    public <T> Future<T> callSyncMethod(@NotNull Plugin plugin, @NotNull Callable<T> task);

    /**
     * 从执行器中取消执行一个任务.
     * <p>
     * 原文：Removes task from scheduler.
     *
     * @param taskId 要移除的任务的id
     */
    public void cancelTask(int taskId);

    /**
     * 取消执行特定的插件所请求的所有任务.
     * <p>
     * 原文：Removes all tasks associated with a particular plugin from the
     * scheduler.
     *
     * @param plugin 要取消所有任务的插件
     */
    public void cancelTasks(@NotNull Plugin plugin);

    /**
     * 检测任务是否正在运行.
     * <p>
     * 一个重复执行的任务可能不是正在运行的.但将在之后运行.一个已完成并且不重复执行的任务将不再运行.
     * <p>
     * 直白地说就是,一个存在的线程在执行一个任务,并且这个线程没有死亡.
     * <p>
     * 原文：Check if the task currently running.
     * <p>
     * A repeating task might not be running currently, but will be running in
     * the future. A task that has finished, and does not repeat, will not be
     * running ever again.
     * <p>
     * Explicitly, a task is running if there exists a thread for it, and that
     * thread is alive.
     *
     * @param taskId 要检测的任务的id
     * <p>
     * @return 任务是否在运行
     */
    public boolean isCurrentlyRunning(int taskId);

    /**
     * 检测这个任务是否正在排队等待执行.
     * <p>
     * 如果一个重复执行的任务正在运行,它现在可能不会被置于列队,但是可能会在之后发生.一个任务如果不在队列、不在运行.那么将不再排队.
     * <p>
     * 原文：Check if the task queued to be run later.
     * <p>
     * If a repeating task is currently running, it might not be queued now
     * but could be in the future. A task that is not queued, and not running,
     * will not be queued again.
     *
     * @param taskId 要检测的任务id
     * <p>
     * @return 这个任务是否排队等待执行
     */
    public boolean isQueued(int taskId);

    /**
     * 返回所有激活的worker.
     * <p>
     * 这个列表包含了独立线程执行的异步任务.
     * <p>
     * 原文：Returns a list of all active workers.
     * <p>
     * This list contains asynch tasks that are being executed by separate
     * threads.
     *
     * @return 激活的worker
     */
    @NotNull
    public List<BukkitWorker> getActiveWorkers();

    /**
     * 返回所有挂起(就绪/阻塞等)的任务.任务的顺序与它们的执行顺序无关.
     * <p>
     * 原文：Returns a list of all pending tasks. The ordering of the tasks is not
     * related to their order of execution.
     *
     * @return 待执行/挂起的任务
     */
    @NotNull
    public List<BukkitTask> getPendingTasks();

    /**
     * 返回下一个tick服务器将运行的任务(即于下一tick执行指定任务).
     * <p>
     * 原文：Returns a task that will run on the next server tick.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    @NotNull
    public BukkitTask runTask(@NotNull Plugin plugin, @NotNull Runnable task) throws IllegalArgumentException;

    /**
     * 返回下一个tick服务器将运行的任务(即于下一tick执行指定任务).
     * <p>
     * 原文:Returns a task that will run on the next server tick.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    public void runTask(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> task) throws IllegalArgumentException;

    /**
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     * @deprecated 建议使用{@link BukkitRunnable#runTask(Plugin)}
     */
    @Deprecated
    @NotNull
    public BukkitTask runTask(@NotNull Plugin plugin, @NotNull BukkitRunnable task) throws IllegalArgumentException;

    /**
     * <b>异步任务不应访问Bukkit里的任何API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 返回异步执行的任务.
     * <p>
     * 原文：<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Returns a task that will run asynchronously.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    @NotNull
    public BukkitTask runTaskAsynchronously(@NotNull Plugin plugin, @NotNull Runnable task) throws IllegalArgumentException;

    /**
     * <b>异步任务不应访问Bukkit里的任何API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 返回异步执行的任务.
     * <p>
     * 原文:<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Returns a task that will run asynchronously.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    public void runTaskAsynchronously(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> task) throws IllegalArgumentException;

    /**
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     * @deprecated 建议使用{@link BukkitRunnable#runTaskAsynchronously(Plugin)}
     */
    @Deprecated
    @NotNull
    public BukkitTask runTaskAsynchronously(@NotNull Plugin plugin, @NotNull BukkitRunnable task) throws IllegalArgumentException;

    /**
     * 返回指定tick过后运行的任务(即延迟执行).
     * <p>
     * 原文：Returns a task that will run after the specified number of server
     * ticks.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    @NotNull
    public BukkitTask runTaskLater(@NotNull Plugin plugin, @NotNull Runnable task, long delay) throws IllegalArgumentException;

    /**
     * 返回指定tick过后运行的任务(即延迟执行).
     * <p>
     * 原文:Returns a task that will run after the specified number of server
     * ticks.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    public void runTaskLater(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> task, long delay) throws IllegalArgumentException;

    /**
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     * @deprecated 建议使用{@link BukkitRunnable#runTaskLater(Plugin, long)}
     */
    @Deprecated
    @NotNull
    public BukkitTask runTaskLater(@NotNull Plugin plugin, @NotNull BukkitRunnable task, long delay) throws IllegalArgumentException;

    /**
     * <b>异步任务不应访问Bukkit里的任何API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 返回指定tick过后运行的异步任务(即延迟执行).
     * <p>
     * 原文：<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Returns a task that will run asynchronously after the specified number
     * of server ticks.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    @NotNull
    public BukkitTask runTaskLaterAsynchronously(@NotNull Plugin plugin, @NotNull Runnable task, long delay) throws IllegalArgumentException;

    /**
     * <b>异步任务不应访问Bukkit里的任何API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 返回指定tick过后运行的异步任务(即延迟执行).
     * <p>
     * 原文:<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Returns a task that will run asynchronously after the specified number
     * of server ticks.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    public void runTaskLaterAsynchronously(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> task, long delay) throws IllegalArgumentException;

    /**
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     * @deprecated 建议使用{@link BukkitRunnable#runTaskLaterAsynchronously(Plugin, long)}
     */
    @Deprecated
    @NotNull
    public BukkitTask runTaskLaterAsynchronously(@NotNull Plugin plugin, @NotNull BukkitRunnable task, long delay) throws IllegalArgumentException;

    /**
     * 返回一个任务.此任务将在指定tick数值后运行.任务将重复运行直至取消.
     * <p>
     * 原文：Returns a task that will repeatedly run until cancelled, starting after
     * the specified number of server ticks.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @param period 重复执行任务之间的时间间隔
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    @NotNull
    public BukkitTask runTaskTimer(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period) throws IllegalArgumentException;

    /**
     * 返回一个任务.此任务将在指定tick数值后运行.任务将重复运行直至取消.
     * <p>
     * 原文:Returns a task that will repeatedly run until cancelled, starting after
     * the specified number of server ticks.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @param period 重复执行任务之间的时间间隔
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    public void runTaskTimer(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> task, long delay, long period) throws IllegalArgumentException;

    /**
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 服务器执行任务之前的延迟/tick
     * @param period 重复执行任务之间的时间间隔
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     * @deprecated 建议使用{@link BukkitRunnable#runTaskTimer(Plugin, long, long)}
     */
    @Deprecated
    @NotNull
    public BukkitTask runTaskTimer(@NotNull Plugin plugin, @NotNull BukkitRunnable task, long delay, long period) throws IllegalArgumentException;

    /**
     * <b>异步任务不应访问Bukkit里的任何API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 返回一个异步任务.此任务将在指定tick数值后运行.任务将重复运行直至取消.
     * <p>
     * 原文：<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Returns a task that will repeatedly run asynchronously until cancelled,
     * starting after the specified number of server ticks.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 在任务首次执行前等待的时间
     * @param period 重复执行任务之间的时间间隔
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    @NotNull
    public BukkitTask runTaskTimerAsynchronously(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period) throws IllegalArgumentException;

    /**
     * <b>异步任务不应访问Bukkit里的任何API.应着重保证异步任务的线程安全.</b>
     * <p>
     * 返回一个异步任务.此任务将在指定tick数值后运行.任务将重复运行直至取消.
     * <p>
     * 原文:<b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Returns a task that will repeatedly run asynchronously until cancelled,
     * starting after the specified number of server ticks.
     *
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 在任务首次执行前等待的时间
     * @param period 重复执行任务之间的时间间隔
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     */
    public void runTaskTimerAsynchronously(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> task, long delay, long period) throws IllegalArgumentException;

    /**
     * @param plugin 执行任务的插件
     * @param task 要运行的任务
     * @param delay 在任务首次执行前等待的时间
     * @param period 重复执行任务之间的时间间隔
     * @return 包含id的BukkitTask
     * @throws IllegalArgumentException 如果插件为null
     * @throws IllegalArgumentException 如果任务为null
     * @deprecated 建议使用 {@link BukkitRunnable#runTaskTimerAsynchronously(Plugin, long, long)}
     */
    @Deprecated
    @NotNull
    public BukkitTask runTaskTimerAsynchronously(@NotNull Plugin plugin, @NotNull BukkitRunnable task, long delay, long period) throws IllegalArgumentException;
}
