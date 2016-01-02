package org.bukkit.event;

import org.bukkit.plugin.PluginManager;

/**
 * 代表事件。
 *
 * @see PluginManager#callEvent(Event)
 * @see PluginManager#registerEvents(Listener,Plugin)
 */
public abstract class Event {
    private String name;
    private final boolean async;

    /**
     * 为了更简单清晰的代码而制造。这个构造器取得的是同步的事件。
     * <p>
     * 原文：The default constructor is defined for cleaner code. This constructor
     * assumes the event is synchronous.
     */
    public Event() {
        this(false);
    }

    /**
     * 这个构造器用于显示声明一个事件是同步还是异步的.
     * <p>
     * 原文：This constructor is used to explicitly declare an event as synchronous
     * or asynchronous.
     *
     * @param isAsync true则为异步事件
     */
    public Event(boolean isAsync) {
        this.async = isAsync;
    }

    /**
     * 轻松获取这个事件的名称,默认情况下,他是事件的类的{@linkplain Class#getSimpleName() 简短名称}.
     * <p>
     * 原文：Convenience method for providing a user-friendly identifier. By
     * default, it is the event's class's {@linkplain Class#getSimpleName()
     * simple name}.
     *
     * @return 这个事件的名称
     */
    public String getEventName() {
        if (name == null) {
            name = getClass().getSimpleName();
        }
        return name;
    }

    public abstract HandlerList getHandlers();

    /**
     * 任何自定义事件应该不与其他事件同步,必须使用特定的构造器.这是对使用异步事件的一些警告：Any custom event that should not by synchronized with other events must use the specific constructor. These are the caveats of using an asynchronous event:
     * <ul>
     * <li>这个事件永远不会触发内部代码触发的同步事件.尝试这么做的结果会得到{@link java.lang.IllegalStateException}.</li>
     * <li>However, asynchronous event handlers may fire synchronous or
     *     asynchronous events
     * <li>The event may be fired multiple times simultaneously and in any
     *     order.
     * <li>Any newly registered or unregistered handler is ignored after an
     *     event starts execution.
     * <li>The handlers for this event may block for any length of time.
     * <li>Some implementations may selectively declare a specific event use
     *     as asynchronous. This behavior should be clearly defined.
     * <li>Asynchronous calls are not calculated in the plugin timing system.
     * </ul>
     * <p>
     * 原文：Any custom event that should not by synchronized with other events must
     * use the specific constructor. These are the caveats of using an
     * asynchronous event:
     * <ul>
     * <li>The event is never fired from inside code triggered by a
     *     synchronous event. Attempting to do so results in an {@link
     *     java.lang.IllegalStateException}.
     * <li>However, asynchronous event handlers may fire synchronous or
     *     asynchronous events
     * <li>The event may be fired multiple times simultaneously and in any
     *     order.
     * <li>Any newly registered or unregistered handler is ignored after an
     *     event starts execution.
     * <li>The handlers for this event may block for any length of time.
     * <li>Some implementations may selectively declare a specific event use
     *     as asynchronous. This behavior should be clearly defined.
     * <li>Asynchronous calls are not calculated in the plugin timing system.
     * </ul>
     *
     * @return 默认情况下返回false, 事件触发异步了返回true 
     */
    public final boolean isAsynchronous() {
        return async;
    }

    public enum Result {

        /**
         * 拒绝这个事件.Deny the event. Depending on the event, the action indicated by the
         * event will either not take place or will be reverted. Some actions
         * may not be denied.
         */
        DENY,
        /**
         * Neither deny nor allow the event. The server will proceed with its
         * normal handling.
         */
        DEFAULT,
        /**
         * Allow / Force the event. The action indicated by the event will
         * take place if possible, even if the server would not normally allow
         * the action. Some actions may not be allowed.
         */
        ALLOW;
    }
}