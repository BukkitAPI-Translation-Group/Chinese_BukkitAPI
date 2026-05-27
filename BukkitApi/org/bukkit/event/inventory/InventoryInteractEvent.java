package org.bukkit.event.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

/**
 * 描述 HumanEntity 与物品栏内容之间交互的事件的抽象基类。
 */
public abstract class InventoryInteractEvent extends InventoryEvent implements Cancellable {
    private Result result = Result.DEFAULT;

    public InventoryInteractEvent(@NotNull InventoryView transaction) {
        super(transaction);
    }

    /**
     * 获取执行点击的玩家。
     *
     * @return 点击的玩家
     * <p>原文：Gets the player who performed the click.
     */
    @NotNull
    public HumanEntity getWhoClicked() {
        return getView().getPlayer();
    }

    /**
     * 设置此事件的结果。这将改变此事件是否被视为已取消。
     *
     * @param newResult 此事件的新 {@link org.bukkit.event.Event.Result}
     * @see #isCancelled()
     * <p>原文：Sets the result of this event. This will change whether or not this
     * event is considered cancelled.
     */
    public void setResult(@NotNull Result newResult) {
        result = newResult;
    }

    /**
     * 获取此事件的 {@link org.bukkit.event.Event.Result}。Result 描述了将应用于此事件相关物品栏的行为。
     *
     * @return 此事件的结果
     * <p>原文：Gets the {@link org.bukkit.event.Event.Result} of this event. The Result describes the
     * behavior that will be applied to the inventory in relation to this
     * event.
     */
    @NotNull
    public Result getResult() {
        return result;
    }

    /**
     * 获取此事件是否被取消。这基于 {@link #getResult()} 返回的 Result 值。Result.ALLOW 和 Result.DEFAULT 将导致返回值为 false，但 Result.DENY 将导致返回值为 true。
     * <p>
     * {@inheritDoc}
     *
     * @return 事件是否被取消
     * <p>原文：Gets whether or not this event is cancelled. This is based off of the
     * Result value returned by {@link #getResult()}.  Result.ALLOW and
     * Result.DEFAULT will result in a returned value of false, but
     * Result.DENY will result in a returned value of true.
     */
    @Override
    public boolean isCancelled() {
        return getResult() == Result.DENY;
    }

    /**
     * Cancellable 接口的 {@link #setResult(org.bukkit.event.Event.Result)} 代理方法。推荐使用 {@link #setResult(org.bukkit.event.Event.Result)}，因为它允许您指定超出 Result.DENY 和 Result.ALLOW 的结果。
     * <p>
     * {@inheritDoc}
     *
     * @param toCancel 如果为 true，结果变为 DENY；如果为 false，结果变为 ALLOW
     * <p>原文：Proxy method to {@link #setResult(org.bukkit.event.Event.Result)} for the Cancellable
     * interface. {@link #setResult(org.bukkit.event.Event.Result)} is preferred, as it allows
     * you to specify the Result beyond Result.DENY and Result.ALLOW.
     */
    @Override
    public void setCancelled(boolean toCancel) {
        setResult(toCancel ? Result.DENY : Result.ALLOW);
    }

}
