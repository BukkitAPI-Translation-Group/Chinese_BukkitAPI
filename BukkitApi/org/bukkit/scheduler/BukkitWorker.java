package org.bukkit.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * 

提供一简单的处理调度任务方式.
 */
public abstract class BukkitRunnable implements Runnable {
  

  private int taskId = -1;

    /**
     * 尝试关闭该任务.
     *
     * @throws 

IllegalStateException 如果任务还未被调度.
     */
    public synchronized void cancel() 

throws IllegalStateException {
        Bukkit.getScheduler().cancelTask(getTaskId());
    }

   

 /**
     * 使该任务由Bukkit调度器在下一个tick执行.
     * 
     * @param plugin 调度该任务的

插件引用
     * @return 包含任务id的BukkitTask.
     * @throws IllegalArgumentException 如果

插件为空
     * @throws IllegalStateException 如果该任务还未被调度
     * @see 

BukkitScheduler#runTask(Plugin, Runnable)
     */
    public synchronized BukkitTask runTask

(Plugin plugin) throws IllegalArgumentException, IllegalStateException {
        checkState

();
        return setupId(Bukkit.getScheduler().runTask(plugin, (Runnable) this));
    }

    

/**
     * <b>异步不应该使用任何Bukkit中的API. 着重考虑异步任务的线程安全.</b>
     * <p>
     

* 调度该任务使其在Bukkit调度器中异步执行.
     *
     * @param plugin 调度该任务的插件引用
    

 * @return 包含任务id的BukkitTask.
     * @throws IllegalArgumentException 如果插件为空
     

* @throws IllegalStateException 如果该任务还未被调度
     * @see 

BukkitScheduler#runTaskAsynchronously(Plugin, Runnable)
     */
    public synchronized 

BukkitTask runTaskAsynchronously(Plugin plugin) throws IllegalArgumentException, 

IllegalStateException  {
        checkState();
        return setupId(Bukkit.getScheduler

().runTaskAsynchronously(plugin, (Runnable) this));
    }

    /**
     * 在一定tick之后调度该

任务.
     *
     * @param plugin 调度该任务的插件引用
     * @return 包含任务id的BukkitTask.
  

   * @throws IllegalArgumentException 如果插件为空
     * @throws IllegalStateException 如果

该任务还未被调度
     * @see BukkitScheduler#runTaskLater(Plugin, Runnable, long)
     */
    

public synchronized BukkitTask runTaskLater(Plugin plugin, long delay) throws 

IllegalArgumentException, IllegalStateException  {
        checkState();
        return 

setupId(Bukkit.getScheduler().runTaskLater(plugin, (Runnable) this, delay));
    }

    /**
    

 * <b>异步不应该使用任何Bukkit中的API. 着重考虑异步任务的线程安全.</b>
     * <p>
     * 在一

定tick之后，调度该任务使其在Bukkit调度器中异步执行.
     *
     * @param plugin 调度该任务的

插件引用
     * @param delay 任务执行前的等待时间
     * @return 包含任务id的BukkitTask.
     

* @throws IllegalArgumentException 如果插件为空
     * @throws IllegalStateException 如果该

任务还未被调度
     * @see BukkitScheduler#runTaskLaterAsynchronously(Plugin, Runnable, 

long)
     */
    public synchronized BukkitTask runTaskLaterAsynchronously(Plugin plugin, 

long delay) throws IllegalArgumentException, IllegalStateException  {
        checkState();
  

      return setupId(Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, (Runnable) 

this, delay));
    }

    /**
     * 在一定tick之后,调度该任务使其周期性执行直到关闭.
     *
     

* @param plugin 调度该任务的插件引用
     * @param delay 任务执行前的等待时间
     * @param 

period 任务执行的间隔周期
     * @return 包含任务id的BukkitTask.
     * @throws 

IllegalArgumentException 如果插件为空
     * @throws IllegalStateException 如果该任务还未被

调度
     * @see BukkitScheduler#runTaskTimer(Plugin, Runnable, long, long)
     */
    public 

synchronized BukkitTask runTaskTimer(Plugin plugin, long delay, long period) throws 

IllegalArgumentException, IllegalStateException  {
        checkState();
        return 

setupId(Bukkit.getScheduler().runTaskTimer(plugin, (Runnable) this, delay, period));
    }

   

 /**
     * <b>异步不应该使用任何Bukkit中的API. 着重考虑异步任务的线程安全.</b>
     * <p>
    

 * Schedules this to repeatedly run asynchronously until cancelled,
     * starting after 

the specified number of server ticks.
     *
     * @param plugin 调度该任务的插件引用
     * 

@param delay 第一次执行任务前的等待时间
     * @param period 任务执行的间隔周期
     * 

@return 包含任务id的BukkitTask
     * @throws IllegalArgumentException 如果插件为空
     * 

@throws IllegalStateException 如果该任务还未被调度
     * @see 

BukkitScheduler#runTaskTimerAsynchronously(Plugin, Runnable, long,
     *     long)
     */
   

 public synchronized BukkitTask runTaskTimerAsynchronously(Plugin plugin, long delay, long 

period) throws IllegalArgumentException, IllegalStateException  {
        checkState();
      

  return setupId(Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, (Runnable) this, 

delay, period));
    }

    /**
     * 获取该任务id.
     *
     * @return 该任务id
     * @throws 

IllegalStateException 如果该任务还未被调度
     */
    public synchronized int getTaskId() 

throws IllegalStateException {
        final int id = taskId;
        if (id == -1) {
         

   throw new IllegalStateException("Not scheduled yet");
        }
        return id;
    }

    

private void checkState() {
        if (taskId != -1) {
            throw new 

IllegalStateException("Already scheduled as " + taskId);
        }
    }

    private 

BukkitTask setupId(final BukkitTask task) {
        this.taskId = task.getTaskId();
        

return task;
    }
}
