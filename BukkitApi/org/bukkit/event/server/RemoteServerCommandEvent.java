package org.bukkit.event.server;

import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;

/**
 * 这个事件当RCON收到指令时调用.
 * {@link ServerCommandEvent查看更多信息.
 * <p>
 * 原文:This event is called when a command is recieved over RCON. See the javadocs
 * of {@link ServerCommandEvent} for more information.
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
