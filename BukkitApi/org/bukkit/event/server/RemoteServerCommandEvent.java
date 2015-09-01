package org.bukkit.event.server;

import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;

/**
 * 这个事件当服务器RCON收到指令时调用. <p>
 * {@link ServerCommandEvent} 查看更多信息.
 */
public class RemoteServerCommandEvent extends ServerCommandEvent {
    private static final HandlerList handlers = new HandlerList();

    public RemoteServerCommandEvent(final CommandSender sender, final String command) {
        super(sender, command);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
