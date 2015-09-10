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
     */
    public Event() {
        this(false);
    }

    /**
     * This constructor is used to explicitly declare an event as synchronous
     * or asynchronous.
     *
     * @param isAsync true indicates the event will fire asynchronously, false
     *     by default from default constructor
     */
    public Event(boolean isAsync) {
        this.async = isAsync;
    }

    /**
     * 轻松获取这个事件的名字， 默认
     * 情况下, 他是事件的类的 {@linkplain Class#getSimpleName()
     * simple name}.
     *
     * @return 这个事件的名字
     */
    public String getEventName() {
        if (name == null) {
            name = getClass().getSimpleName();
        }
        return name;
    }

    public abstract HandlerList getHandlers();

    /**
     * Any custom event that should not by synchronized with other events must
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
     * @return 默认情况下返回 false , 事件触发异步了返回 true 
     */
    public final boolean isAsynchronous() {
        return async;
    }

    public enum Result {

        /**
         * 拒绝此事件. Depending on the event, the action indicated by the
         * event will either not take place or will be reverted. Some actions
         * may not be denied.
         */
        DENY,
        /**
         * 不拒绝也不允许. 服务器会按平时的情况处理它。
         */
        DEFAULT,
        /**
         * （强制）允许此事件。 The action indicated by the event will
         * take place if possible, even if the server would not normally allow
         * the action. Some actions may not be allowed.
         */
        ALLOW;
    }
}