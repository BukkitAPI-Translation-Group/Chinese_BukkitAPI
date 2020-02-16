package org.bukkit.event.server;

import org.bukkit.event.Event;

/**
 * 各种服务器事件.
 */
public abstract class ServerEvent extends Event {

    public ServerEvent() {
        super();
    }

    public ServerEvent(boolean isAsync) {
        super(isAsync);
    }
}
