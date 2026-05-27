package org.bukkit.command;

import java.net.SocketAddress;
import org.jetbrains.annotations.NotNull;

public interface RemoteConsoleCommandSender extends CommandSender {

    /**
     * 获取此远程发送者的套接字地址.
     * <p>
     * 原文：
     * Gets the socket address of this remote sender.
     *
     * @return 远程发送者的地址
     */
    @NotNull
    public SocketAddress getAddress();
}
