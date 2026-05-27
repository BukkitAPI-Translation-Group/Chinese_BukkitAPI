package org.bukkit.event.player;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 玩家准备躺到床上时触发此事件.
 */
public class PlayerBedEnterEvent extends PlayerEvent implements Cancellable {

    /**
     * 表示此事件的默认可能结果.
     */
    public enum BedEnterResult {
        /**
         * 玩家将进入床.
         */
        OK,
        /**
         * 世界不允许睡觉或保存重生点（例如下界、末地或自定义世界）.
         * 这基于 {@link World#isBedWorks()} 和 {@link World#isNatural()}.
         *
         * 进入床被阻止，如果 {@link World#isBedWorks()} 为 false 则床会爆炸.
         */
        NOT_POSSIBLE_HERE,
        /**
         * 由于当前不是夜晚也不是雷暴天气，进入床被阻止.
         * <p>
         * 如果在白天强制允许此事件，玩家将进入床（并设置其床位置），但可能会立即被弹出.
         */
        NOT_POSSIBLE_NOW,
        /**
         * 由于玩家距离太远，进入床被阻止.
         */
        TOO_FAR_AWAY,
        /**
         * 由于附近有怪物，进入床被阻止.
         */
        NOT_SAFE,
        /**
         * 由于存在其他问题，进入床被阻止.
         */
        OTHER_PROBLEM;
    }

    private static final HandlerList handlers = new HandlerList();
    private final Block bed;
    private final BedEnterResult bedEnterResult;
    private Result useBed = Result.DEFAULT;

    public PlayerBedEnterEvent(@NotNull Player who, @NotNull Block bed, @NotNull BedEnterResult bedEnterResult) {
        super(who);
        this.bed = bed;
        this.bedEnterResult = bedEnterResult;
    }

    @Deprecated(since = "1.13.2")
    public PlayerBedEnterEvent(@NotNull Player who, @NotNull Block bed) {
        this(who, bed, BedEnterResult.OK);
    }

    /**
     * 描述此事件的默认结果.
     * <p>
     * 原文：
     * This describes the default outcome of this event.
     *
     * @return 表示此事件默认结果的床进入结果
     */
    @NotNull
    public BedEnterResult getBedEnterResult() {
        return bedEnterResult;
    }

    /**
     * 控制对点击的床采取的操作.
     * <p>
     * 原文：
     * This controls the action to take with the bed that was clicked on.
     * <p>
     * In case of {@link org.bukkit.event.Event.Result#DEFAULT}, the default outcome is described by
     * {@link #getBedEnterResult()}.
     *
     * @return 对交互的床采取的操作
     * @see #setUseBed(org.bukkit.event.Event.Result)
     */
    @NotNull
    public Result useBed() {
        return useBed;
    }
    /**
     * 设置对交互的床采取的操作.
     * <p>
     * 原文：
     * Sets the action to take with the interacted bed.
     * <p>
     * {@link org.bukkit.event.Event.Result#ALLOW} will result in the player sleeping, regardless of
     * the default outcome described by {@link #getBedEnterResult()}.
     * <br>
     * {@link org.bukkit.event.Event.Result#DENY} will prevent the player from sleeping. This has the
     * same effect as canceling the event via {@link #setCancelled(boolean)}.
     * <br>
     * {@link org.bukkit.event.Event.Result#DEFAULT} will result in the outcome described by
     * {@link #getBedEnterResult()}.
     *
     * @param useBed 对交互的床采取的操作
     * @see #useBed()
     */
    public void setUseBed(@NotNull Result useBed) {
        this.useBed = useBed;
    }

    /**
     * 获取此事件的取消状态。设置为 true 以阻止玩家睡觉.
     * <p>
     * 原文：
     * Gets the cancellation state of this event. Set to true if you want to
     * prevent the player from sleeping.
     * <p>
     * Canceling the event has the same effect as setting {@link #useBed()} to
     * {@link org.bukkit.event.Event.Result#DENY}.
     * <p>
     * For backwards compatibility reasons this also returns true if
     * {@link #useBed()} is {@link org.bukkit.event.Event.Result#DEFAULT} and the
     * {@link #getBedEnterResult() default action} is to prevent bed entering.
     *
     * @return 布尔值取消状态
     */
    @Override
    public boolean isCancelled() {
        return (useBed == Result.DENY || useBed == Result.DEFAULT && bedEnterResult != BedEnterResult.OK);
    }

    /**
     * 设置此事件的取消状态。取消的事件不会在服务器中执行，但仍会传递给其他插件.
     * <p>
     * 原文：
     * Sets the cancellation state of this event. A canceled event will not be
     * executed in the server, but will still pass to other plugins.
     * <p>
     * Canceling this event will prevent use of the bed.
     *
     * @param cancel 如果希望取消此事件则为 true
     */
    @Override
    public void setCancelled(boolean cancel) {
        setUseBed(cancel ? Result.DENY : useBed() == Result.DENY ? Result.DEFAULT : useBed());
    }

    /**
     * 返回此事件涉及的床.
     * <p>
     * 原文:Returns the bed block involved in this event.
     *
     * @return 床
     */
    @NotNull
    public Block getBed() {
        return bed;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}