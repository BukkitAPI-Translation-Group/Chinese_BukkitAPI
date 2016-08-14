package org.bukkit.event.entity;

import org.bukkit.entity.Slime;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当史莱姆死亡后分裂成小史莱姆时触发本事件
 */
public class SlimeSplitEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private int count;

    public SlimeSplitEvent(final Slime slime, final int count) {
        super(slime);
        this.count = count;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public Slime getEntity() {
        return (Slime) entity;
    }

    /**
     * 获取生成的小史莱姆的数量.
     * <p>
     * 原文:Gets the amount of smaller slimes to spawn
     *
     * @return 生成的小史莱姆的数量
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置分裂时将生成多少小史莱姆
     * <p>
     * 原文:Sets how many smaller slimes will spawn on the split
     *
     * @param count 生成的小史莱姆的数量
     */
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}