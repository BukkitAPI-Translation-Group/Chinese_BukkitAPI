package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 方块物理事件(例如是沙子掉落、流水).
 * <br>
 * 这是一个高频率事件, 在一个繁忙的服务器上, 一秒内本事件可能会触发上千次.
 * 建议插件小心监听此事件, 当使用本事件时仅执行一些轻量级的检查.
 * <br>
 * 另外, 取消此事件可能会使事件陷入一个不合常理的状态(看起来就像世界末日,丝毫不夸张,译者注).
 * 例如, 如果你使用此事件在当该方块需要附着到某个东西上时其使悬浮在半空中, 那么无法保证在服务器重启后或地图更新后
 * 此悬浮的方块能保持不变 (就是当方块发生物理变化时尝试改变它们会出现一些未知后果的意思, 具体自己测一下啦).
 * <br>
 * 插件也应当注意, 在可能的情况下, 该事件可能只会因"根源"方块的物理(状态)更新而被调用以限制事件的频繁调用.
 * 导致其它方块状态改变的物理更新可能不会引起其它方块(通常是相邻的方块)的事件.
 * 如果你担忧监听这些改变(可能会产生较大开销), 那么你应该自己检查相邻的方块.
 * <p>
 * 原文:
 * Thrown when a block physics check is called.
 * <br>
 * This event is a high frequency event, it may be called thousands of times per
 * a second on a busy server. Plugins are advised to listen to the event with
 * caution and only perform lightweight checks when using it.
 * <br>
 * In addition to this, cancelling the event is liable to leave the world in an
 * inconsistent state. For example if you use the event to leave a block
 * floating in mid air when that block has a requirement to be attached to
 * something, there is no guarantee that the floating block will persist across
 * server restarts or map upgrades.
 * <br>
 * Plugins should also note that where possible this event may only called for
 * the "root" block of physics updates in order to limit event spam. Physics
 * updates that cause other blocks to change their state may not result in an
 * event for each of those blocks (usually adjacent). If you are concerned about
 * monitoring these changes then you should check adjacent blocks yourself.
 */
public class BlockPhysicsEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final BlockData changed;
    private boolean cancel = false;

    public BlockPhysicsEvent(final Block block, final BlockData changed) {
        super(block);
        this.changed = changed;
    }

    /**
     * 获取事件中被改变的方块.
     * <p>
     * 原文：Gets the type of block that changed, causing this event
     *
     * @return 事件中被改变的方块的种类
     */
    public Material getChangedType() {
        return changed.getMaterial();
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}